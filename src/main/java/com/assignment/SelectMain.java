package com.assignment;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SelectMain {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// Step 1
		Configuration configuration = new Configuration();
		configuration.configure();

		// Step 2
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Step 3
		Session session = sessionFactory.openSession();

		// Step 4: no need of transaction

		// Step 5
		Query query = session.createQuery("from Employee");

		// Step 6
		List<Employee> employees = query.list();

		// Step 7: for each loop
		for (Employee emp : employees) {
			System.out.println("Id:" + emp.getId());
			System.out.println("First Name:" + emp.getFirstName());
			System.out.println("Last Name:" + emp.getLastName());
			System.out.println("City:" + emp.getCity());
			System.out.println("Salary:" + emp.getSalary());
		}
	}

}
