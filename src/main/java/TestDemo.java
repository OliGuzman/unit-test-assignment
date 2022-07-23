import java.util.Random;

import com.google.common.annotations.VisibleForTesting;

public class TestDemo {
	
	private Random random = new Random(); 

	//takes two numbers and returns the sum if both numbers are positive
	public int addPositive(int a, int b) {
				
		if(a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		} 
		
		return a + b; 		
	}	
	
	//method that takes a random number between 1 and 10 and returns the square of the number
	//will use the getRandomInt method to obtain the random number
	//since we don't know what the random number will return, we will mock the randomNumberSquared method 
	//and supply the parameter so that it can be tested	
	public int randomNumberSquared() {
		
		int randomNum = getRandomInt(); 

		return randomNum * randomNum; 					
	}
	
	//using @VisibleForTesting annotation because getRandomInt method has been made package scope (not private)
	@VisibleForTesting
	int getRandomInt() {	
		
		return random.nextInt(10) + 1; 
	}		
	
}
