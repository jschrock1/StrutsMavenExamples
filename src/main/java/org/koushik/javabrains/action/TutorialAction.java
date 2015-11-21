package org.koushik.javabrains.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.PrintStream;
import org.koushik.javabrains.service.TutorialFinderService;

/**
 * Here is the tutorials TutorialAction class.  Pretty basic
 * and demonstrates the validate method which is called automatically
 * by Struts 2.
 * @author jay
 *
 */
public class TutorialAction extends ActionSupport {
	
	private String bestTutorialSite;
	private String language;
	
	
	public TutorialAction() {
	}

	/**
	 * Default method that Struts 2 calls to perform the action.  Note that 
	 * we can call other methods when configured properly in the struts.xml file, 
	 * we have examples of that somewhere.
	 */
	public String execute() {
		TutorialFinderService tutorialFinderService = new TutorialFinderService();
		setBestTutorialSite(tutorialFinderService.getBestTutorialSite(getLanguage()));
		System.out.println("End execute of TutorialAction, language is: " + language);
		System.out.println("End execute of TutorialAction, bestTutorialSite is: " + bestTutorialSite);
		return "success";
	}

	/**
	 * This is called automatically before the execute method.
	 */
	public void validate() {
		if (language == null || language.equals(""))
			addFieldError("language", "Language must be supplied");
	}

	public String addTutorial() {
		System.out.println("Adding a Tutorial");
		return "success";
	}

	public String deleteTutorial() {
		System.out.println("Deleting a Tutorial");
		return "success";
	}

	public String publishTutorial() {
		System.out.println("Publishing a Tutorial");
		return "success";
	}

	public String getBestTutorialSite() {
		return bestTutorialSite;
	}

	public void setBestTutorialSite(String bestTutorialSite) {
		this.bestTutorialSite = bestTutorialSite;
	}

	public String getLanguage() {
		System.out.println("getLanguage: " + language);
		return language;
	}

	public void setLanguage(String language) {
		System.out.println("setLanguage: " + language);
		this.language = language;
	}

	private void log(String str, String mth) {
		System.out.println((new StringBuilder(String.valueOf(str))).append(", ").append(mth).append(", class: ")
				.append(getClass().getName()).toString());
	}

	private void log(String str) {
		System.out.println(str);
	}

}
