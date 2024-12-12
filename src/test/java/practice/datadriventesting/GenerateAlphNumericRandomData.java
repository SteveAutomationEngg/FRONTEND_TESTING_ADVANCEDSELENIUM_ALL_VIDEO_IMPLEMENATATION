package practice.datadriventesting;

import java.util.Random;

public class GenerateAlphNumericRandomData {

	public static void main(String[] args) {
		
		int n=20;
		String AlphaNumeric = "ABCDEFGHIJKLMNOPORSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		
		StringBuilder sb= new StringBuilder(n);
		
		for(int i=0;i<n;i++) {
			
			int index = (int) (AlphaNumeric.length()*Math.random());
			sb.append(AlphaNumeric.charAt(index));
			
			//int index = new Random().nextInt(AlphaNumeric.length());
			//sb.append(AlphaNumeric.charAt(index));
		}
      System.out.println(sb);
	}

}
