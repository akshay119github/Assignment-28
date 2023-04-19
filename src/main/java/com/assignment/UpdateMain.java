package com.assignment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateMain {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// Step 1
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// Step 2
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// Step 3
		Session session = sessionFactory.openSession();

		// Step 4
		Transaction transaction = session.beginTransaction();

		// Step 5
		Employee employee = (Employee) session.get(Employee.class, 3);

		// Step 6
		employee.setFirstName("rushi");
		employee.setSalary("150000");

		// Step 7
		session.update(employee);
		transaction.commit();
		session.close();
		System.out.println("Record Updated Successfully");

	}

}
