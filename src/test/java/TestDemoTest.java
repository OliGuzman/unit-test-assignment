import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

class TestDemoTest {
	
	//new TestDemo object to be used before each test
	private TestDemo testDemo; 
	
	//this will be used to ensure new TestDemo object is created before each test	
	@BeforeEach
	void setUp() {		
		testDemo = new TestDemo(); 
	}

	//Using parameterized test to test multiple times using different parameters 
	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
			
		//Given: two  numbers to add
		if(!expectException) {
		//When: the numbers are added		
		//Then: the response is what I expect		
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected); 
		} else {
		//When: the numbers are added		
		//Then: the response is what I expect
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}		
	}
	
	//method that supplies the parameters for the test
	static Stream<Arguments> argumentsForAddPositive() {
		// @formatter:off
		return Stream.of(
				arguments(2, 4, 6, false), 
				arguments(-2, 4, 0, true),  
				arguments(2, -4, 0, true),
				arguments(10, 10, 20, false), 
				arguments(45, 1, 46, false), 
				arguments(45, -1, 44, true), 
				arguments(100, 25, 125, false)					
		);  
		// @Formatter:on		
	}
	
	//test for randomNumberSquared
	//Mockito spy method will be used to mock the random number being generated
	@Test
	void assertThatNumberSquaredIsCorrect() {
		
		//Given
		TestDemo mockDemo = spy(testDemo); 
		doReturn(5).when(mockDemo).getRandomInt(); 
		
		//when
		int fiveSquared = mockDemo.randomNumberSquared(); 
		
		//Then
		assertThat(fiveSquared).isEqualTo(25); 
	}
}
