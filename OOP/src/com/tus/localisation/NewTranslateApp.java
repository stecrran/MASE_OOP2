package com.tus.localisation;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class NewTranslateApp {
	
	private static final Map<Locale, Map<String, String>> translations = new HashMap<>();
	
	private static final Locale ARABIC_KUWAIT = new Locale.Builder()
			.setLanguage("ar")
			.setRegion("KW")
			.build();
	
	private static final Locale SPANISH = new Locale.Builder()
			.setLanguage("es")
			.setRegion("ES")
			.build();
	
	public static void main(String[] args) {
//		Locale locArabicKuwait = new Locale.Builder()
//		.setRegion("KW")
//		.setLanguage("ar")
//		.build();

//		
//		System.out.println(locArabicKuwait);
//		System.out.println(locArabicKuwait.getCountry());
//		System.out.println(locArabicKuwait.getDisplayLanguage());
//		System.out.println(locArabicKuwait.getDisplayLanguage(locArabicKuwait));
		
		// English translation
		Map<String, String> en = new HashMap<>();
		en.put("greeting", "Hello");
		translations.put(Locale.ENGLISH, en);
		
		// Arabic (Kuwait) translation
		//Locale arabicKuwait = new Locale.Builder().setLanguage("ar").setRegion("KW").build();
		Map<String, String> arKW = new HashMap<>();
		arKW.put("greeting", "مرحبا");
		translations.put(ARABIC_KUWAIT, arKW);
		
		// Spanish translation
		Map<String, String> es = new HashMap<>();
		es.put("greeting", "Hola");
		translations.put(SPANISH, es);
		
		System.out.println("Greeting (ar_KW): " + translate("greeting", ARABIC_KUWAIT));
		System.out.println("Greeting (English): " + translate("greeting", Locale.ENGLISH));
		System.out.println("Greeting (Spanish): " + translate("greeting", SPANISH));
		
		Locale de = new Locale("de");
		System.out.println("Greeting (German) - Fallback to 'en': " + translate("greeting", de));

	}
	
	public static String translate(String key, Locale locale) {
		return translations
				.getOrDefault(locale, translations.get(Locale.ENGLISH)) // fallback to English
				.getOrDefault(key, "[" + key + "]");
	}
	
	
	
}
