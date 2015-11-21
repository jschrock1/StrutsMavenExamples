package com.tutorialspoint.struts2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.koushik.javabrains.action.BaseAction;
import org.koushik.javabrains.model.User;

import com.opensymphony.xwork2.ActionSupport;

/**
 * This class is our first action class that will retrieve persistent (Database)
 * data. This will use Java JDBC to select the data, typically in enterprise
 * models, one would use a Database Framework like Hibernate and use PoJo's. We
 * will be using Hibernate eventually.
 * 
 * @author jay
 *
 */
public class LoginAction extends BaseAction {

	private String userId;
	private String password;
	private String name;

	
	public void validate() {
		log("In validate userId is: " + userId);
		log("In validate password is: " + password);
	}

	public String execute() {
		String ret = ERROR;
		Connection conn = null;

		try {

			// The configuration lines of code below typically would come
			// from a configuration's file. When we use Hibernate they
			// will be coming from a configurations file.

			String URL = "jdbc:mysql://localhost/struts_tutorial";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "root");
			String sql = "SELECT name FROM login WHERE";
			sql += " user_id = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);

			// ResultSet is java's way of returning you the data. When using
			// hibernate you get data and put them in PoJo objects, or java beans as they
			// used to be called. The java beans have its member variables the same as
			// all the columns in the database. But as are all frameworks takes some
			// setting up to do and hibernate requires HBM configuration files or
			// annotations, etc.

			ResultSet rs = ps.executeQuery();
			System.out.println("In Execute of LoginAction rs is: " + rs);

			while (rs.next()) {
				name = rs.getString(1);
				System.out.println("In Execute of LoginAction name is: " + name);
				ret = SUCCESS;
			}
			System.out.println("returning: " + ret);

		} catch (Exception e) {
			log("ERROR:  " + e.getMessage() );
			message = e.getMessage();
			ret = ERROR;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}
		return ret;
	}

	public String getUserId() {
		System.out.println("In getUserId of LoginAction: " + userId);
		return userId;
	}

	public void setUserId(String user) {
		System.out.println("In setUserId of LoginAction: " + user);
		this.userId = user;
	}

	public String getPassword() {
		System.out.println("In getPassword of LoginAction: " + password);
		return password;
	}

	public void setPassword(String password) {
		System.out.println("In setPassword of LoginAction: " + password);
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;
}