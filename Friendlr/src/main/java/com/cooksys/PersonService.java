package com.cooksys;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	
	//private final PersonMapper PersonMapper;
	private AtomicLong idGenerator = new AtomicLong(0);
	private HashMap<Long, Person> idToPersonMap = new HashMap<>();
	
	public PersonService(/*PersonMapper PersonMapper*/){
		//this.PersonMapper = PersonMapper;
	}
	
	public boolean has(Long id) {
		return id != null && id > 0 && idToPersonMap.containsKey(id);
	}
	
	public Collection<Person> getElements() {
		return idToPersonMap.values();
	}
	//map
	public Person get(Long id) {
		return idToPersonMap.get(id);
	}
	//map
	public Long add(Person person) {
		person.setID(idGenerator.incrementAndGet());
		if(person.getFriends() != null || !person.getFriends().isEmpty()){
			for(Person friend : person.getFriends()){
				if(!has(friend.getID())){
					return (long) HttpStatus.NOT_FOUND.value();
				}
			}
		}
		idToPersonMap.put(person.getID(), person);
		return person.getID();
	}
	//map
	public void put(Long id, Person person) {
		BeanUtils.copyProperties(person.getID(), person);
		
	}

	public void delete(Long id) {
		idToPersonMap.remove(id);
		
	}

}
