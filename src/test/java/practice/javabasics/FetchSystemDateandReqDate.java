package practice.javabasics;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FetchSystemDateandReqDate {

	public static void main(String[] args) {
		
	
	        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");

	        // Use Calendar.getInstance() to fetch the system date and time
	        Calendar cal = Calendar.getInstance();
	        System.out.println("System Date : " + sim.format(cal.getTime()));
	        
	        
	        // Add the specified number of days to the current date
	        cal.add(Calendar.DAY_OF_MONTH, 30);
	        // Format the resulting date
	        String reqDate = sim.format(cal.getTime());

	        System.out.println("req Date :"+ reqDate);
	      

	}


}
