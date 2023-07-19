package com.uisrael.project.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.uisrael.project.modelo.entity.Sintoma;

@Repository
@Component
public interface ISintomasRepositorio  extends JpaRepository<Sintoma, Integer>{


}
