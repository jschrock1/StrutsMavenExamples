package org.koushik.javabrains.interceptor;

import java.util.*;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * interceptors is as you know Struts 2 framework to call some code before the
 * action class is called, then call some code after the action class finishes.
 * This is our own interceptor class to test with. Im not sure how often we will
 * be creating interceptor classes, hopefully not that often, but worth knowing
 * what they are. Probably used often for logging, but even then logging can be
 * done in the controller logic or business logic. Logging is always extremely
 * important! If something goes wrong, we will need and want good and accurate
 * logging to determine what went wrong.
 * 
 * @author jay
 *
 */
public class MyInterceptor extends AbstractInterceptor {

	public String intercept(ActionInvocation invocation) throws Exception {

		/* let us do some pre-processing */
		String output = "In intercept method Pre-Processing";
		System.out.println(output);

		/* let us call action or next interceptor */
		String result = invocation.invoke();

		/* let us do some post-processing */
		output = "In intercept method Post-Processing";
		System.out.println(output);

		return result;
	}
}