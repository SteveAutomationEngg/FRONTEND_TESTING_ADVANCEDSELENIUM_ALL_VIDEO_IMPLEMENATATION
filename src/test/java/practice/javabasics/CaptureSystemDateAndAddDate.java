package practice.javabasics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CaptureSystemDateAndAddDate {

	public static void main(String[] args) {

		// here we r capture the system date
		Date dateObj = new Date();

		                                                   // System.out.println(dateObj.toString());

		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sim.format(dateObj);
		System.out.println("Actual Date : " + actDate);

		// here we are adding 30 days ( as per requirement we can change to the system
		// date +30 for after and -30 for before)
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String dateRequires = sim.format(cal.getTime());
		System.out.println("Required Date : " + dateRequires);

	
	}

}
 