package practice.datadriventesting;

import java.util.*;

public class GenerateRandomNumTest {
	public static void main(String[] args) {
		
	
	Random ran=new Random();
      int randomNumber = ran.nextInt(1000);
      
      System.out.println(randomNumber);
	}
}
