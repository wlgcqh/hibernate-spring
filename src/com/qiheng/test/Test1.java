package com.qiheng.test;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiheng.DAO.PersonDAO;
import com.qiheng.model.Person;
import com.qiheng.service.PersonService;

public class Test1 {
	public static void main(String[] args) {
		
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		PersonService service= (PersonService) context.getBean("personService");
		System.out.println(service);
		Person person = new Person();
		person.setName("zhangsan");
		person.setAge(43);
		
		service.createPerson(person);
	

	}
}
