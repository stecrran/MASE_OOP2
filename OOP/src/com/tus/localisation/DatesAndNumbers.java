package com.tus.localisation;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DatesAndNumbers {

	public static void main(String[] args) {
//		formatNumbers();
//		formatCurrencies();
		//dateFormats();
		
		LocalDate date = LocalDate.of(2022, Month.AUGUST, 10);
		System.out.println(date);
		
		DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MMM-dd E d"); // 2022-Aug-10 Wed 10
		DateTimeFormatter formatDateTime2 = DateTimeFormatter.ofPattern("yyyy-MMM-dd EEEE d"); // 2022-Aug-10 Wednesday 10
		System.out.println(date.format(formatDateTime));
		System.out.println(date.format(formatDateTime2));
	}
	
	public static void formatNumbers() {
		double n = 77_000.11;
		
		System.out.println(NumberFormat.getInstance().format(n));
		System.out.println(NumberFormat.getNumberInstance(Locale.US).format(n));
		System.out.println(NumberFormat.getNumberInstance(Locale.GERMANY).format(n));
	}
	
	public static void formatCurrencies() {
		double n = 23.22;
		System.out.println(NumberFormat.getCurrencyInstance().format(n));
		System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));
		System.out.println(NumberFormat.getCurrencyInstance(Locale.GERMANY).format(n));
	}
	
	public static void dateFormats() {
		Locale locUS = Locale.US;
		Locale locFrench = new Locale("fr", "FR");
		Locale locGerman = Locale.GERMANY;
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("Current DateTime: " + ldt);

		DateTimeFormatter dateShortStyle = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(dateShortStyle.withLocale(locUS).format(ldt));
		System.out.println(dateShortStyle.withLocale(locFrench).format(ldt));
		System.out.println(dateShortStyle.withLocale(locGerman).format(ldt));

		DateTimeFormatter dateMediumStyle = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		System.out.println(dateMediumStyle.withLocale(locUS).format(ldt));
		System.out.println(dateMediumStyle.withLocale(locFrench).format(ldt));
		System.out.println(dateMediumStyle.withLocale(locGerman).format(ldt));

		DateTimeFormatter dateLongStyle = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println(dateLongStyle.withLocale(locUS).format(ldt));
		System.out.println(dateLongStyle.withLocale(locFrench).format(ldt));
		System.out.println(dateLongStyle.withLocale(locGerman).format(ldt));
		
		DateTimeFormatter timeShortStyle = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		System.out.println(timeShortStyle.withLocale(locUS).format(ldt));
		System.out.println(timeShortStyle.withLocale(locGerman).format(ldt));
		
		DateTimeFormatter timeMediumStyle = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		System.out.println(timeMediumStyle.withLocale(locUS).format(ldt));
		System.out.println(timeMediumStyle.withLocale(locGerman).format(ldt));
		
		DateTimeFormatter timeLongStyle = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG); // LONG needs ZonedTimeZone
//		System.out.println(timeLongStyle.withLocale(locUS).format(ldt));
//		System.out.println(timeLongStyle.withLocale(locGerman).format(ldt));
		
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(timeLongStyle.withLocale(locUS).format(zdt));
		
		DateTimeFormatter datetimeShortStyle = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT); // DateTime
		System.out.println(datetimeShortStyle.withLocale(locUS).format(ldt));
		System.out.println(datetimeShortStyle.withLocale(locGerman).format(ldt));
		
		DateTimeFormatter datetimeMediumStyle = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM); // DateTime
		System.out.println(datetimeMediumStyle.withLocale(locUS).format(ldt));
		System.out.println(datetimeMediumStyle.withLocale(locGerman).format(ldt));
		
		DateTimeFormatter datetimeLongStyle = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG); // DateTime
		System.out.println(datetimeLongStyle.withLocale(locUS).format(zdt)); // 'zdt' - Use a Zoned Time Zone
		System.out.println(datetimeLongStyle.withLocale(locGerman).format(zdt));
	}
	
}
