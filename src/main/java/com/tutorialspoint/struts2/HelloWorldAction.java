package com.tutorialspoint.struts2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.Session;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.PrincipalAware;
import org.apache.struts2.interceptor.PrincipalProxy;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 * This class tests a number of things from the tutorial. we extend
 * ActionSupport as we normally would, and implement a bunch of other classes,
 * the important one is SessionAware so that we can begin to look at whats in
 * the Session environment which is really typically very important, where
 * cookies are stored and where things can be placed if one wants to save things
 * for a user, state-full environment. Typically web transactions are stateless
 * or at least we aim for them to be stateless.
 * 
 * @author jay
 *
 */
public class HelloWorldAction extends ActionSupport implements SessionAware, ApplicationAware, CookiesAware,
		RequestAware, ServletRequestAware, ServletResponseAware, PrincipalAware {

	private String name;
	private String type;
	private String vsStr = null;
	private SessionMap mySession = null;

	// variables for *Aware interfaces
	private PrincipalProxy principalProxy = null;
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	private Map<String, Object> requestAttributes = null;
	private Map<String, Object> sessionAttributes = null;
	private Map<String, Object> contextAttributes = null;
	private Map<String, String> requestCookies = null;

	
	public void validate() {
		System.out.println("In validatae of HelloWorldAction");
	}
	/**
	 * execute always return SUCCESS just for testing. dumping valueStacke and
	 * Serlet information just to see what's in it or how to add and take things
	 * from it.
	 */
	public String execute() throws Exception {

		System.out.println("in execute() of HelloWorldAction, name is " + name);
		System.out.println("in execute() of HelloWorldAction, type is " + type);
		
		if (!type.equals("basic")) {
			dumpValueStackAndSession();
		}

		return SUCCESS;

	}

	public String doNothingMethod() throws Exception {
		return SUCCESS;
	}


	/**
	 * play around with the ValueStack. Althought the tutorials talk a bit about
	 * the ValueStack and how it holds data from the action class, but since the
	 * valuestack goes a way and is recreated for each action call, I don't see
	 * its usefulness that much as its stateless in nature. Of course it will be
	 * used to hold member values from actions classes to be placed in JSP forms
	 * sent back the user, that appears to be its true purpose.
	 */
	private void dumpValueStackAndSession() {
		
		ValueStack vs = ActionContext.getContext().getValueStack();
		System.out.println("num of VS elements: " + vs.size());

		vsStr = vs.toString();

		String mySessionStr = ActionContext.SESSION;
		System.out.println(mySessionStr);

		mySession = (SessionMap) ActionContext.getContext().getSession();
		HttpSession mySession2 = request.getSession();
		// session aattributes can be added various ways as shown below
		mySession2.setAttribute("user", name);
		sessionAttributes.put("test", type);
		System.out.println("Session is: " + mySession.toString());


	}

	/**
	 * This method is here to test a redirect of sorts, rather than the action
	 * calling the default method execute, we in our struts.xml to call this
	 * method instead. This allows us to have many methods in an action class
	 * that may be part of the same application, for example we may have
	 * getTutorial, addTutorial, deleteTutorial etc and all these methods can be
	 * placed in one action class rather than separate action classees.
	 * 
	 * @return
	 * @throws Exception
	 */
	public String someOtherMethod() throws Exception {
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map<String, Object> context = new HashMap<String, Object>();

		context.put("key1", new String("This is key1"));
		context.put("key2", new String("This is key2"));
		stack.push(context);

		System.out.println("Size of the valueStack: " + stack.size());
		return "success";
	}

	public String getName() {
		System.out.println("in getName() of HelloWorldAction, name is " + name);
		return name;
	}

	public void setName(String name) {
		System.out.println("in setName() of HelloWorldAction, name is " + name);
		this.name = name;
	}

	public String getType() {
		System.out.println("in getType() of HelloWorldAction, type is " + type);
		return type;
	}

	public void setType(String type) {
		System.out.println("in setType() of HelloWorldAction, type is " + type);
		this.type = type;
	}
	
	
	public String getVsStr() {
		System.out.println("in getVsStr() of HelloWorldAction, vs is " + vsStr);
		return vsStr;
	}
	
	public void setVsStr(String vsStr) {
		this.vsStr = vsStr;
	}

	public SessionMap getMySession() {
		System.out.println("in getMySession() of HelloWorldAction, mySession is " + mySession);
		return mySession;
	}

	public void setMySession(SessionMap mySession) {
		this.mySession = mySession;
		
	}
	

	public void setPrincipalProxy(PrincipalProxy principalProxy) {
		this.principalProxy = principalProxy;
	}

	public void setServletResponse(HttpServletResponse httpServletResponse) {
		this.response = httpServletResponse;
	}

	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;
	}

	public void setRequest(Map<String, Object> requestAttr) {
		this.requestAttributes = requestAttr;
	}

	public void setCookiesMap(Map<String, String> cookies) {
		this.requestCookies = cookies;
	}

	public void setApplication(Map<String, Object> applicationAttributes) {
		this.contextAttributes = applicationAttributes;
	}

	public void setSession(Map<String, Object> sessionAttr) {
		this.sessionAttributes = sessionAttr;
	}

}
