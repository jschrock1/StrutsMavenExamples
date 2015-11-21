package org.koushik.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.koushik.javabrains.dto.UserDetails;
import org.koushik.javabrains.dto.UserDetails2;

/**
 * This class is another java only class and should be run as a java application, not a web application.
 * It is here to test the various ways to save persistent objects.  See the testingType member variable
 * for information on what type of test to run.  This class uses UserDetails2  as I didn't want to 
 * corrupt UserDetails.
 * 
 * @author jay
 *
 */
public class HibernateTest2 {

	static SessionFactory sessisonFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {

		// String testingType = "Init setup";
		// String testingType = "No Create";
		// String testingType = "Transient, Persistent";
		// String testingType = "Persisteing Detached Objects";
		// String testingType = "Parameter Binding";
		// String testingType = "Named Queries";
		// String testingType = "HQL Examples";
		// String testingType = "Criteria API";
		// String testingType = "Projections";
		String testingType = "Cache";

		if (testingType.equals("Init setup")) {

			Session session = getSessionTrans();

			for (int i = 0; i < 10; i++) {
				UserDetails2 user = new UserDetails2();
				user.setUserName("User" + i);
				session.save(user);
			}

			commitCloseSession(session);

		} else if (testingType.equals("No Create")) {

			Session session = getSessionTrans();

			UserDetails2 user2 = (UserDetails2) session.get(UserDetails2.class, 5);
			System.out.println("User name pulled up is: " + user2.getUserName());
			user2.setUserName("Updated Name");
			// session.delete(user2);
			session.update(user2);

			commitCloseSession(session);

		} else if (testingType.equals("Transient, Persistent")) {

			UserDetails user = new UserDetails();
			user.setUserName("Test User");
			Session session = getSessionTrans();
			session.save(user);
			user.setUserName("chg name"); // hibernate will update this in DB!!
											// with now session.save required
			user.setUserName("chg name again");
			commitCloseSession(session);

		} else if (testingType.equals("Persisteing Detached Objects")) {

			// chanege hibernate.cfg.xml to update

			Session session = getSessionTrans();
			UserDetails2 user = (UserDetails2) session.get(UserDetails2.class, 1);
			commitCloseSession(session);
			user.setUserName("update after session close");
			session = getSessionTrans();
			session.update(user);
			commitCloseSession(session);

		} else if (testingType.equals("HQL Examples")) {

			// chanege hibernate.cfg.xml to update
			// Comment out the various code blocks to test the various HQL examples

			Session session = getSessionTrans();

			// get Query from org.hibernate....
			// Query query = session.createQuery("from UserDetails2"); // not
			// table name, object name...
			// List<UserDetails2> users = (List<UserDetails2>) query.list();
			// System.out.println("Size of users: " + users.size());

			// query = session.createQuery("from UserDetails2 where userId >
			// 5");
			// users = query.list();
			// System.out.println("Size of users: " + users.size());

			// for (UserDetails2 u : users) {
			// System.out.println("User name: " + u.getUserName());
			// }

			// Pagination strategy

			/*
			 * Query query = session.createQuery("from UserDetails2"); // not
			 * table name, object name... query.setFirstResult(5);
			 * query.setMaxResults(4); List<UserDetails2> users =
			 * (List<UserDetails2>) query.list();
			 * 
			 * for (UserDetails2 u : users) { System.out.println("User name: " +
			 * u.getUserName()); }
			 */

			/*
			 * Query query = session.createQuery(
			 * "select userName from UserDetails2");
			 * 
			 * // The list returned is not going to be UserDetails2, rather it
			 * will be a list of stirngs // since we are asking for userName,
			 * not the entire object.
			 * 
			 * List<String> userNames = (List<String>) query.list();
			 * 
			 * for (String u : userNames) { System.out.println("User name: " +
			 * u); }
			 */

			// Can't get the below code to work with selecting more than one
			// member.
			/*
			 * Query query = session.createQuery(
			 * "select userId, userName from UserDetails2");
			 * 
			 * List resultList = (List) query.list();
			 * System.out.println(resultList.getClass().getName());
			 * System.out.println(resultList.get(0).getClass().getName());
			 * System.out.println("ResultList size is: " + resultList.size());
			 * System.out.println("Object is: " + resultList);
			 * System.out.println("Name of object is : " +
			 * (String)resultList.get(0)); //System.out.println(
			 * "size of myList is: " + myList.size());
			 * 
			 * //for (ArrayList myList : resultList) { // System.out.println(
			 * "User userid/name: " + myList.get(0) + ", " + myList.get(1)); //}
			 * 
			 * commitCloseSession(session);
			 */

		} else if (testingType.equals("Parameter Binding")) {

			Session session = getSessionTrans();

			// String minUserId = " 5 or 1 = 1"; // sql injection hack!
			// Query query = session.createQuery("from UserDetails2 where userId
			// > " + minUserId);

			// parameter substitution prevents sql injection.

			String minUserId = "5";
			String userName = "user9";
			Query query = session.createQuery("from UserDetails2 where userId > ? and userName = ?");
			query.setInteger(0, Integer.parseInt(minUserId));
			query.setString(1, userName);
			List<UserDetails2> users = query.list();
			System.out.println("User size: " + users.size());

			for (UserDetails2 user : users) {
				System.out.println("User name: " + user.getUserName());
			}

			// Or user paramet substitution by giving a name rather than a ?
			query = session.createQuery("from UserDetails2 where userId > :userId and userName = :userName");
			query.setInteger("userId", Integer.parseInt(minUserId));
			query.setString("userName", userName);
			users = query.list();
			System.out.println("User size: " + users.size());

			for (UserDetails2 user : users) {
				System.out.println("User name: " + user.getUserName());
			}

			commitCloseSession(session);

		} else if (testingType.equals("Named Queries")) {

			// Consolidate all your queries

			Session session = getSessionTrans();

			Query query = session.getNamedQuery("UserDetails2.byId");
			query.setInteger(0, 1);
			List<UserDetails2> users = query.list();
			System.out.println("User name: " + users.get(0).getUserName());

			query = session.getNamedQuery("UserDetails.byName");
			query.setString(0, "user1");
			users = query.list();
			System.out.println("User name: " + users.get(0).getUserName());

			commitCloseSession(session);

		} else if (testingType.equals("Criteria API")) {

			Session session = getSessionTrans();

			Criteria criteria = session.createCriteria(UserDetails2.class);
			// criteria.add(Restrictions.eq("userName",
			// "User9")).add(Restrictions.gt("userId", 5));
			criteria.add(Restrictions.eq("userName", "User9"));
			List<UserDetails2> users = (List<UserDetails2>) criteria.list();

			for (UserDetails2 user : users) {
				System.out.println("User name: " + user.getUserName() + " UserId is: " + user.getUserId());
			}

			criteria = session.createCriteria(UserDetails2.class);
			// criteria.add(Restrictions.eq("userName",
			// "User9")).add(Restrictions.gt("userId", 5));
			criteria.add(Restrictions.like("userName", "User%")).add(Restrictions.between("userId", 4, 8));
			users = (List<UserDetails2>) criteria.list();

			for (UserDetails2 user : users) {
				System.out.println("User name: " + user.getUserName() + " UserId is: " + user.getUserId());
			}

			System.out.println("");

			// What if you want to do an OR restriction?

			criteria = session.createCriteria(UserDetails2.class);
			criteria.add(Restrictions.or(Restrictions.like("userName", "Us%"), Restrictions.between("userId", 4, 8)));

			for (UserDetails2 user : users) {
				System.out.println("User name: " + user.getUserName() + " UserId is: " + user.getUserId());
			}

			commitCloseSession(session);

		} else if (testingType.equals("Projections")) {

			Session session = getSessionTrans();

			// Criteria criteria = session.createCriteria(UserDetails2.class)
			// .setProjection(Projections.property("userId"));

			Criteria criteria = session.createCriteria(UserDetails2.class).setProjection(Projections.max("userId"));

			List<Integer> userIds2 = (List<Integer>) criteria.list();
			for (Integer userId : userIds2) {
				System.out.println(" UserId is: " + userId);
			}

			System.out.println("");

			// sort the results

			criteria = session.createCriteria(UserDetails2.class).addOrder(Order.desc("userId"));

			List<UserDetails2> userIds = (List<UserDetails2>) criteria.list();

			for (UserDetails2 users : userIds) {
				System.out.println(" UserId is: " + users.getUserName() + ", " + users.getUserId());
			}

			// Query By Example if you have lots of restrictions in your query

			System.out.println("");

			UserDetails2 exampleUser = new UserDetails2();
			exampleUser.setUserId(5);
			exampleUser.setUserName("User4");
			Example example = Example.create(exampleUser);

			criteria = session.createCriteria(UserDetails2.class).add(example);

			userIds = (List<UserDetails2>) criteria.list();

			for (UserDetails2 users : userIds) {
				System.out.println(" UserId is: " + users.getUserName() + ", " + users.getUserId());
			}

			commitCloseSession(session);

		} else if (testingType.equals("Cache")) {

			Session session = getSessionTrans();
			UserDetails2 user = (UserDetails2) session.get(UserDetails2.class, 1);
			user.setUserName("Updated User Name");

			// Hibernate will not actually select this next line from the DB,
			// its cached already and it knows there are no changes to the
			// object
			// UserDetails2 user2 =
			// (UserDetails2)session.get(UserDetails2.class, 1);

			System.out.println(" UserId is: " + user.getUserName());
			commitCloseSession(session);

			// ok, ill Jen new session and retrieve the same object as in the
			// previous session. Notice with a new session hibernate does re-select the object as
			// its in a different session. But if we have second level cache,
			// hibernate will not retrieve the object.

			Session session2 = getSessionTrans(); // start new session
			UserDetails2 user2 = (UserDetails2) session2.get(UserDetails2.class, 1);
			commitCloseSession(session2);

			// To configure second level cache, update the hibernate.cfg.xml 4
			// and
			// tell what object needs to be cachable by annotating the object.h
			// This failed for me, could not get second level cache working,
			// Caused by: org.hibernate.service.spi.ServiceException: Unable to
			// create requested service [org.hibernate.cache.spi.RegionFactory]
			// Not sure we will use this cache anyway, if so, we will investigate it

		}

	}

	private static Session getSessionTrans() {

		Session session = sessisonFactory.openSession();
		// Session mySession = sessisonFactory.getCurrentSession();
		session.beginTransaction(); // defines single unit of work.
		System.out.println("Session is open");
		return session;

	}

	private static void commitCloseSession(Session session) {
		session.getTransaction().commit();
		session.close();
		System.out.println("Session Closed");
	}

}
