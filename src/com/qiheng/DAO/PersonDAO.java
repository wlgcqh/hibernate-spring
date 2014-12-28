package com.qiheng.DAO;

import java.util.List;

import com.qiheng.model.Person;

public interface PersonDAO {
	
	void createPerson(Person person);
	
	Person queryPersonById(String id);
	
	List<Person> queryPersonByName(String name);
	
	void deletePerson(String id);
	
	void updatePerson(Person person);
}
