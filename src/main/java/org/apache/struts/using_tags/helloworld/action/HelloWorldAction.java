package org.apache.struts.using_tags.helloworld.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.using_tags.helloworld.model.MessageStore;

/**
 * Acts as a Struts 2 controller that responds
 * to a user action by setting the value
 * of the Message model class, and returns a String 
 * result.
 * @author Bruce Phillips
 *
 */
public class HelloWorldAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * The model class that stores the message
	 * to display in the view.
	 */
	private MessageStore messageStore;

	private String userName;
	
	private static int helloCount = 0;
	
	/*
	 * Creates the MessageStore model object, 
	 * increase helloCount by 1 and 
	 * returns success.  The MessageStore model
	 * object will be available to the view.
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		
		messageStore = new MessageStore() ;
		
		if (userName != null) {
            
		    messageStore.setMessage( messageStore.getMessage() + " " + userName);
		}
		    
		
		helloCount++;
		
		return SUCCESS;
	}

	public MessageStore getMessageStore() {
		System.out.println("In getMessageStore: " + messageStore);
		return messageStore;
	}

	public void setMessageStore(MessageStore messageStore) {
		System.out.println("In setMessageStore: " + messageStore);
		this.messageStore = messageStore;
	}
	
	public int getHelloCount() {
		System.out.println("In getHelloCount: " + helloCount);
		return helloCount;
	}

	public void setHelloCount(int helloCount) {
		System.out.println("In setHelloCount: " + helloCount);
		HelloWorldAction.helloCount = helloCount;
	}
	
	public String getUserName() {
		System.out.println("In getUserName: " + userName);
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("In setUserName: " + userName);
		this.userName = userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
