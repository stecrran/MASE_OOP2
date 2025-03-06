package com.tus.localisation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Locale;
import java.util.ResourceBundle;

public class DateApplication {

    PrintWriter pw = new PrintWriter(System.out, true);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Locale ruLocale = new Locale("ru", "RU");
//    Locale currentLocale = Locale.US;
    Locale irlLocale = new Locale("en", "IE");   
    Locale currentLocale = irlLocale;           // start out with en_IE (i.e. English in Ireland) menu
    ResourceBundle messages = ResourceBundle.getBundle("MessageBundle", currentLocale);

    public static void main(String[] args) {
        DateApplication dateApp = new DateApplication();
        dateApp.run();
        
        //dateApp.java8();
    }
    
    public void java8(){
        LocalDate startWW2 = LocalDate.of(1939, Month.SEPTEMBER, 1);
        LocalDate endWW2 = LocalDate.of(1945, Month.SEPTEMBER, 2);

        System.out.println("WW2 started on a " + startWW2.getDayOfWeek());
        System.out.println("WW2 ended on a " + endWW2.getDayOfWeek());
    }

    public void run() {
        String line = "";

        while (!(line.equals("q"))) {
            this.printMenu();
            try {
                line = this.br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }

            switch (line) {
                case "1": setEnglish(); break;
                case "2": setFrench(); break;
                case "3": setChinese(); break;
                case "4": setRussian(); break;
            }
        }
    }

    public void printMenu() {
        pw.println("=== Date App ===");
        // As opposed to lots of formatting (as in the Java 7 lab), I am focusing on 
        // the new Java 8 material (java.time packages). There are some format q's 
        // still in this lab; plus formatting in also the Notes (slide 13).
        pw.println("\n--- Choose Language Option ---");
        pw.println("1. " + messages.getString("menu1"));
        pw.println("2. " + messages.getString("menu2"));
        pw.println("3. " + messages.getString("menu3"));
        pw.println("4. " + messages.getString("menu4"));
        pw.println("q. " + messages.getString("menuq"));
        System.out.print(messages.getString("menucommand") + " ");
    }

    public void setEnglish() {
    	currentLocale = irlLocale;
    	messages = ResourceBundle.getBundle("MessageBundle", currentLocale);
    }

    public void setFrench() {
    	currentLocale = Locale.FRANCE;
    	/* A French properties file is in /src directory so there is no additional 
    	 * specification for file location */
    	messages = ResourceBundle.getBundle("MessageBundle", currentLocale);
    }

    public void setChinese() {
    	currentLocale = Locale.CHINA;
    	messages = ResourceBundle.getBundle("MessageBundle", currentLocale);
    }

    public void setRussian() {
    	currentLocale = ruLocale;
    	this.messages = ResourceBundle.getBundle("MessageBundle", currentLocale);
    }
}

