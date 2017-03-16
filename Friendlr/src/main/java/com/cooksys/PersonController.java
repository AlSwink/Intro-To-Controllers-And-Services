package com.cooksys;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("person")
@RestController
public class PersonController {
	
	private PersonService personService;
	
	public PersonController(PersonService personService){
		super();
		this.personService = personService;
	}
	
	@GetMapping
	public Collection<Person> get() {
		return personService.getElements();
	}
	
	@GetMapping("{id}")
	public Person getbyId(@PathVariable Long id,HttpServletResponse response){
		//map
		Person person = personService.get(id);
		if(person == null)
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return person;
	}
	
	//mapped input
	@PostMapping
	public Long add(@RequestBody @Validated Person person, HttpServletResponse response){
		Long result = personService.add(person);
		if(result > 0)
			response.setStatus(HttpServletResponse.SC_CREATED);
		return result;
	}
	
	//mapped input
	@PutMapping("{id}")
	public void put(@PathVariable Long id, @RequestBody @Validated Person person, HttpServletResponse response) {
		personService.put(id, person);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		personService.delete(id);
	}
}
