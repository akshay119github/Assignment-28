package com.assignment;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertMain {

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
		Employee employee = new Employee();
		System.out.println("Enter the Employee Strength");
		Scanner scanner = new Scanner(System.in);
		int empstrength = scanner.nextInt();
		for (int i = 1; i <= empstrength; i++) {
			System.out.println("Enter First Name:");
			String fName = scanner.next();
			System.out.println("Enter Last Name:");
			String lName = scanner.next();
			System.out.println("Enter City:");
			String city = scanner.next();
			System.out.println("Enter Salary:");
			String sal = scanner.next();

			employee.setFirstName(fName);
			employee.setLastName(lName);
			employee.setCity(city);
			employee.setSalary(sal);

			// Step 6
			session.save(employee);
			
			System.out.println("Record Inserted Successfully");
			
		}
		transaction.commit();
		session.close();
	}

}
