package com.uisrael.project.controller;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.project.modelo.entity.Diagnostico;
import com.uisrael.project.modelo.entity.Mascota;
import com.uisrael.project.services.IDiagnosticoServicio;

import io.github.flashvayne.chatgpt.dto.ChatRequest;
import io.github.flashvayne.chatgpt.dto.ChatResponse;
import io.github.flashvayne.chatgpt.service.ChatgptService;

@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController implements InitializingBean{

	@Autowired
    private ChatgptService chatgptService;

	@Autowired
	private IDiagnosticoServicio diagnosticoServicio;
	
    @Override
    public void afterPropertiesSet() {
        System.out.println(" ===== Starting Chat GPT Boot ==== ");
    }

    
    @PostMapping("crearDiagnostico")
	public ResponseEntity<String> crearDiagnostico(@RequestBody Diagnostico request) {
		System.out.println("Mascota: "+request);
		
		String requestChatGpt = "Tengo la siguiente mascota con las siguientes caracteristicas"
				+ "Es de la especie: "
				+ request.getMascota().getEspecieMascota().getNombre() + "su raza es: "
				+ request.getMascota().getRazaMascota().getNombre()+ " , y tiene los siguientes sintomas: "
				+ String.join(",", request.getSintomasDiagnostico().stream().map(sintoma->sintoma.getNombreSintoma()).toList())
				+ " Cual es la posible enfermedad que padece y cual es su cura?";
		
		System.out.println("request"+requestChatGpt);
		String tratamiento = chatgptService.sendMessage(requestChatGpt);
		request.setTratamiento(tratamiento);
		this.diagnosticoServicio.guardarNuevoDiagnostico(request);
		return ResponseEntity.ok(tratamiento);
		
	}
    
    @GetMapping("obtenerDiagnosticoPorMascota/{idMascota}")
    public ResponseEntity<List<Diagnostico>> obtenerDiagnosticoPorMascota(@PathVariable("idMascota") int idMascota) {
        return ResponseEntity.ok(this.diagnosticoServicio.obtenerDiagnosticoPorMascota(idMascota));
    }
    
    @GetMapping("/chat")
    public String chatWith(@RequestParam String message) {
        System.out.println(message);
        return chatgptService.sendMessage(message);
    }
    
    @GetMapping("/chatDefault")
    public String chatWith() {
        //return "HOLA TEST";
        return chatgptService.sendMessage("Que logros ha conseguido LDU de Quito");
    }
    

    @GetMapping("/prompt")
    public ChatResponse prompt(@RequestParam String message) {

        //The maximum number of tokens to generate in the completion.The token count of your prompt plus max_tokens cannot exceed the model's context length. Most models have a context length of 2048 tokens (except for the newest models, which support 4096).
        Integer maxTokens = 300;

        // GPT-3 models can understand and generate natural language. We offer four main models with different levels of power suitable for different tasks. Davinci is the most capable model, and Ada is the fastest.
        String model = "text-davinci-003";

        // What sampling temperature to use. Higher values means the model will take more risks. Try 0.9 for more creative applications, and 0 (argmax sampling) for ones with a well-defined answer.We generally recommend altering this or top_p but not both.
        Double temperature = 0.5;

        //An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens comprising the top 10% probability mass are considered.We generally recommend altering this or temperature but not both.
        Double topP = 1.0;

        ChatRequest chatRequest = new ChatRequest(model, message, maxTokens,temperature,topP);
        ChatResponse res =  chatgptService.sendChatRequest(chatRequest);
        System.out.println("Response was: " + res.toString());
        return res;

    }
	
}
