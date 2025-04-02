package com.tus.localisation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

public class LangReader {

	PrintWriter pw = new PrintWriter(System.out, true);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Locale deLocale = new Locale("de", "DE");
	
	Locale irlLocale = new Locale("ie", "IE");
	
	
	Locale currentLocale = irlLocale;  // start with en_IE
	ResourceBundle messages = ResourceBundle.getBundle("com.tus.localisation.MessageBundle", currentLocale);
	
	public static void main(String[] args) {
		LangReader lr = new LangReader();
		//lr.run();
		lr.setFrench();
		lr.pw.println("Test");
//		lr.pw.println(lr.messages.getString("potato"));
		System.out.println(lr.messages.getString("potato"));
		
		lr.setEnglish();
		lr.pw.println(lr.messages.getString("potato"));
		
		lr.setGerman();
		lr.pw.println(lr.messages.getString("potato"));
	}
	
//	public void run() {
//		pw.println("Test");
//		pw.println(messages.getString("menu1"));
//		String line = "";
//		
//		try {
//			line = this.br.readLine();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public void setEnglish() {
		currentLocale = irlLocale;
		messages = ResourceBundle.getBundle("com.tus.localisation.MessageBundle", currentLocale);
	}
	
	public void setFrench() {
		currentLocale = Locale.FRANCE;
		messages = ResourceBundle.getBundle("MessageBundle", currentLocale); // put the properties file in 'src' or prepend package name
	}
	
	public void setGerman() {
		currentLocale = Locale.GERMANY;
		messages = ResourceBundle.getBundle("com.tus.localisation.germanBundle", currentLocale);
	}
}
