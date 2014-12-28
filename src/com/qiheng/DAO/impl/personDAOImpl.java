package com.qiheng.DAO.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.qiheng.DAO.PersonDAO;
import com.qiheng.model.Person;

public class personDAOImpl implements PersonDAO {

	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.openSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createPerson(Person person) {

		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(person);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}

	}

	@Override
	public Person queryPersonById(String id) {
		Session session = getSession();
		Transaction tx = null;
		Person person = null;
		try {
			tx = session.beginTransaction();
			person = (Person) session.get(Person.class, id);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}
		return person;
	}

	@Override
	public List<Person> queryPersonByName(String name) {
		Session session = getSession();
		Transaction tx = null;
		List<Person> list = null;
		try {
			tx = session.beginTransaction();
			list = (List<Person>) session
					.createQuery("from Person as p where p.name=:name")
					.setString("name", name).list();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void deletePerson(String id) {

		Session session = getSession();
		Transaction tx = null;
		Person person = null;
		try {
			tx = session.beginTransaction();
			person = (Person) session.get(Person.class, id);
			session.delete(person);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}

	}

	@Override
	public void updatePerson(Person person) {

		Session session = getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(person);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}
	}

}
