package com.yassine.phone.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yassine.phone.entities.Type;
import com.yassine.phone.repos.TypesRepository;

@RestController
@RequestMapping("/api/typ")
@CrossOrigin("*")
public class TypeRESTController {
@Autowired
TypesRepository typeRepository;
@RequestMapping(method=RequestMethod.GET)
public List<Type> getAllCategories()
{
return typeRepository.findAll();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Type getCategorieById(@PathVariable("id") Long id) {
return typeRepository.findById(id).get();
}
}