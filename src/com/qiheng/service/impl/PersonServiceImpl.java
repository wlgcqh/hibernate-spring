package com.qiheng.service.impl;

import java.util.List;

import com.qiheng.DAO.PersonDAO;
import com.qiheng.model.Person;
import com.qiheng.service.PersonService;

public class PersonServiceImpl implements PersonService {

	private PersonDAO dao;
	
	
	
	public PersonDAO getDao() {
		return dao;
	}

	public void setDao(PersonDAO dao) {
		this.dao = dao;
	}

	@Override
	public void createPerson(Person person) {
		dao.createPerson(person);

	}

	@Override
	public Person queryPersonById(String id) {
		Person person= dao.queryPersonById(id);
		return person;
	}

	@Override
	public List<Person> queryPersonByName(String name) {
		List<Person> list = dao.queryPersonByName(name);
		return list;
	}

	@Override
	public void deletePerson(String id) {
		dao.deletePerson(id);

	}

	@Override
	public void updatePerson(Person person) {
		dao.updatePerson(person);
	}

}
