package org.koushik.javabrains.service;

import java.io.PrintStream;

public class TutorialFinderService {
	public TutorialFinderService() {
	}

	public String getBestTutorialSite(String language) {
		System.out.println(
				(new StringBuilder("In TutorialFinderService, Start of getBestTutorialSite, language is: ")).append(language).toString());
		if (language.equals("java"))
			return "Java Brains";
		if (language.equals("dotnet"))
			return "dotnet";
		else
			return (new StringBuilder("TutorialFinderService noticed, ")).append(language).append(" is not supported")
					.toString();
	}
}
