package datepickerpractice;

import java.time.Duration;
import java.time.LocalDate;

public class DatePractice {
	public static void main(String[] args) {
		// Find how many months are between today and the below date
		
		String date = "03/15/2023";
		
		String[] dateParts = date.split("/"); // {"03", "15", "2023"}
		
		int day = Integer.valueOf(dateParts[1]);
		int month = Integer.valueOf(dateParts[0]);
		int year = Integer.valueOf(dateParts[2]);
		
		LocalDate targetDate = LocalDate.of(year, month, day);
		LocalDate todaysDate = LocalDate.now();
		
		long dayDiff = todaysDate.toEpochDay() - targetDate.toEpochDay();
		long diffMonths = dayDiff / 30L;
		
		System.out.println(diffMonths);
		
	}
}
