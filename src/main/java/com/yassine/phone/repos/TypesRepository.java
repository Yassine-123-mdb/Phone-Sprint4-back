package com.yassine.phone.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yassine.phone.entities.Type;
@RepositoryRestResource(path = "typ")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface TypesRepository extends JpaRepository<Type, Long> {
}

