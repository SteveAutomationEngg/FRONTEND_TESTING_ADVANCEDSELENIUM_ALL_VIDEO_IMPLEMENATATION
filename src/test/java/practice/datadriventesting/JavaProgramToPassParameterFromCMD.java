package practice.datadriventesting;

public class JavaProgramToPassParameterFromCMD {
	
	public static void main(String[] args) {
		
		System.out.println(args.length);
	
		for(String var: args) {
			
			System.out.println(var);
		}
	}

}

/* in this normal java program i have pass argument during run time using cmd line but in 
eclipse right click on the program --> go to run as ---> run congiguration --> arguments 
write all the value u want to pass and click on apply and ok 
*/