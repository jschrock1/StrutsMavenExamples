package org.koushik.hibernate;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.Account;
import org.koushik.javabrains.dto.Address;
import org.koushik.javabrains.dto.Department;
import org.koushik.javabrains.dto.Email;
import org.koushik.javabrains.dto.FourWheeler;
import org.koushik.javabrains.dto.FourWheeler3;
import org.koushik.javabrains.dto.Login;
import org.koushik.javabrains.dto.Person;
import org.koushik.javabrains.dto.RentalCar;
import org.koushik.javabrains.dto.TwoWheeler;
import org.koushik.javabrains.dto.TwoWheeler3;
import org.koushik.javabrains.dto.UserDetails;
import org.koushik.javabrains.dto.Vehicle;
import org.koushik.javabrains.dto.Vehicle2;
import org.koushik.javabrains.dto.Vehicle3;

/**
 * This java "main" testing class should be run as a stand alone java application, hence the main method in this class.
 * It's purpose is to test out the different Inheritance strategies when saving objects that may or may not
 * inherit from other objects.
 * 
 * I doubt we will be utilizing this type of database storage ideas, its good stuff, but our application may 
 * not require tables that have inheritance in them.  Most applications don't do this, not saying its bad, 
 * just adds complexities that typically you don't need.
 * 
 * To run the various tests, change the testType below for your parrticular types of tests.
 * 
 * @author jay
 *
 */
public class HibernateTest {

	static SessionFactory sessisonFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {

		String testType = "Initial Set Up";
		//String testType = "Inheratance Single Table Strategy";
		//String testType = "NotFound";
		//String testType = "Inheratance Multi Table Strategy";

		if (testType.equals("Initial Set Up")) {

			UserDetails user = new UserDetails();
			user.setUserName("first User");
			user.setDescription("My Desc");
			user.setJoinedDate(new Date());

			Vehicle vehicle = new Vehicle("Car");
			Vehicle vehicle2 = new Vehicle("Jeep");
			user.getVehicle().add(vehicle);
			user.getVehicle().add(vehicle2);
			vehicle.getUserList().add(user);
			vehicle2.getUserList().add(user);

			Address addr1 = new Address("First State", "First City", "First Street", "100001");
			Address addr2 = new Address("Second State", "Second City", "Second Street", "200002");
			user.getListOfAddresses().add(addr1);
			user.getListOfAddresses().add(addr2);

			Department dept = new Department("IL");
			user.setDepartment(dept);
			Email email = new Email("jay.schrock@gmail.com", "12345");
			user.setEmail(email);

			Account account1 = new Account("IBM", 1500.00);
			Account account2 = new Account("Amazon", 20.59);
			user.getAccounts().add(account1);
			user.getAccounts().add(account2);

			account1.setUser(user);
			account2.setUser(user);
			
			Vehicle3 vehicle3 = new Vehicle3();
			vehicle3.setVehicalName("Car");

			TwoWheeler3 bike = new TwoWheeler3();
			bike.setVehicalName("bike");
			bike.setSteeringHandle("Bike Steering Handle");

			FourWheeler3 car = new FourWheeler3();
			car.setVehicalName("Porsche");
			car.setSteeringWheel("Porsche Steering Handle");
			
			Login login = new Login("My Name", "scott", "navy");


			try {
				Session session = getSessionTrans();
				session.persist(user);
				session.save(vehicle3);
				session.save(bike);
				session.save(car);
				commitCloseSession(session);
				user = null;
				session = getSessionTrans();
				user = session.get(UserDetails.class, 3);
				printSummary(user, vehicle);
				commitCloseSession(session);
				System.out.println("Test Complete");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
				System.out.println(e.getLocalizedMessage());
				e.printStackTrace();
				sessisonFactory.close();
			}

		} else if (testType.equals("Inheratance Single Table Strategy")) {

			Vehicle2 vehicle2 = new Vehicle2();
			vehicle2.setVehicalName("Car");

			TwoWheeler bike = new TwoWheeler();
			bike.setVehicalName("bike");
			bike.setSteeringHandle("Bike Steering Handle");

			FourWheeler car = new FourWheeler();
			car.setVehicalName("Porsche");
			car.setSteeringWheel("Porsche Steering Handle");

			Session session = getSessionTrans();

			session.save(vehicle2);
			session.save(bike);
			session.save(car);

			commitCloseSession(session);

		} else if (testType.equals("Inheratance Multi Table Strategy")) {
			
			Vehicle3 vehicle3 = new Vehicle3();
			vehicle3.setVehicalName("Car");

			TwoWheeler3 bike = new TwoWheeler3();
			bike.setVehicalName("bike");
			bike.setSteeringHandle("Bike Steering Handle");

			FourWheeler3 car = new FourWheeler3();
			car.setVehicalName("Porsche");
			car.setSteeringWheel("Porsche Steering Handle");

			Session session = getSessionTrans();

			session.save(vehicle3);
			session.save(bike);
			session.save(car);

			commitCloseSession(session);
			
		} else if (testType.equals("NotFound")) {

			try {
				Session session = getSessionTrans();

				RentalCar rentalCar = new RentalCar("Avis", "Porsche");
				session.save(rentalCar);
				UserDetails user2 = rentalCar.getUser();
				if (user2 == null) {
					System.out.println("user2 is null");
				}

				commitCloseSession(session);

				System.out.println("Test Complete");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
				System.out.println(e.getLocalizedMessage());
				e.printStackTrace();
				sessisonFactory.close();
			}
		}
	}

	private static Session getSessionTrans() {
		Session session = sessisonFactory.openSession();
		session.beginTransaction(); // defines single unit of work.
		return session;

	}

	private static void commitCloseSession(Session session) {
		session.getTransaction().commit();
		session.close();
		System.out.println("Session Closed");
	}

	private static void printSummary(UserDetails user, Vehicle vehicle) {
		if (user != null) {
			System.out.println("User Name: " + user.getUserName());
			System.out.println("Num of Addresses: " + user.getListOfAddresses().size());
			System.out.println("Num of Vehicles: " + user.getVehicle().size());
			System.out.println("User email: " + user.getEmail().getEmailName());
			ArrayList myAccounts = new ArrayList();
			myAccounts.addAll(user.getAccounts());
			System.out.println("User account: " + ((Account) myAccounts.get(0)).getAccountName());
			System.out.println("account User: " + ((Account) myAccounts.get(0)).getUser().getUserName());
			ArrayList myVehicleUserList = new ArrayList();
			myVehicleUserList.addAll(vehicle.getUserList());
			UserDetails myUser = (UserDetails) myVehicleUserList.get(0);
			System.out.println("Vehical User: " + myUser.getUserName());
		}

	}

}
