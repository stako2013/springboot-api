package com.paloit;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.paloit.service.PersonService;
import static org.junit.Assert.assertEquals;
import com.paloit.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;

@RunWith(SpringRunner.class)
public class PersonServiceTest {
	
	@TestConfiguration
    static class PersonServiceTestContextConfiguration {
  
        @Bean
        public PersonService personService() {
            return new PersonService();
        }
    }
 
    @Autowired
    private PersonService personService;
 
    @MockBean
    private PersonRepository personRepository;
 
    @Test
    public void max_consecutive_zeros_of_given_example(){
    	System.out.println("Max consecutive zeros of given example");
    	/*
    	A: 65
		n: 110
		n: 110
		 : 32
		O: 79
		t: 116
		h: 104
		e: 101
		r: 114
		Sum: 831
		Binary of 831: 1100111111
		The largest number of consecutive zeros: 2 
    	*/
		try {
			assertEquals(2, personService.getMaxConsecutiveZeros("Ann Other"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    @Test
    public void max_consecutive_zeros_of_single_character(){
    	System.out.println("Max consecutive zeros of single character");
    	/*
    	a: 97
    	Sum: 97
    	Binary of 97: 1100001
    	The largest number of consecutive zeros: 4
    	*/
		try {
			assertEquals(4, personService.getMaxConsecutiveZeros("a"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    

    @Test
    public void max_consecutive_zeros_of_only_symbols(){
    	System.out.println("Max consecutive zeros of only symbols");
    	/*
	    !: 33
	    #: 35
	    @: 64
	    Sum: 132
	    Binary of 132: 10000100
	    The largest number of consecutive zeros: 4
    	*/
		try {
			assertEquals(4, personService.getMaxConsecutiveZeros("!#@"));
		} catch (Exception e) {	
			e.printStackTrace();
		}
    }
    
    
    @Test
    public void max_consecutive_zeros_of_only_first_name(){
    	System.out.println("Max consecutive zeros of given example");
    	/*
    	A: 65
    	u: 117
    	s: 115
    	t: 116
    	r: 114
    	a: 97
    	l: 108
    	i: 105
    	a: 97
    	Sum: 934
    	Binary of 934: 1110100110
    	The largest number of consecutive zeros: 2
    	*/
		try {
			assertEquals(2, personService.getMaxConsecutiveZeros("Australia"));
		} catch (Exception e) {	
			e.printStackTrace();
		}
    }
    
    @Test
    public void max_consecutive_zeros_of_space_and_last_name(){
    	System.out.println("Calculate consecutive zeros of space last name");
		try {
			assertEquals(3, personService.getMaxConsecutiveZeros(" Smith"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void max_consecutive_Zeros_of_empty_name(){
    	System.out.println("Max consecutive zeros of empty");
    	/*
    	Sum: 0
		Binary of 0: 0
		The largest number of consecutive zeros: 1
    	*/
		try {
			assertEquals(1, personService.getMaxConsecutiveZeros(""));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void max_consecutive_zeros_of_space_character(){
    	System.out.println("Max consecutive zeros of given example");
    	/*
    	  : 32
		Sum: 32
		Binary of 32: 100000
		The largest number of consecutive zeros: 5
    	 */
		try {
			assertEquals(5, personService.getMaxConsecutiveZeros(" "));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void max_consecutive_zeros_of_only_numbers(){
    	System.out.println("Max consecutive zeros of given example");
    	/*
    	1: 49
		8: 56
		5: 53
		6: 54
		9: 57
		5: 53
		2: 50
		Sum: 372
		Binary of 372: 101110100
		The largest number of consecutive zeros: 2
    	 */
		try {
			assertEquals(2, personService.getMaxConsecutiveZeros("1856952"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void max_consecutive_zeros_of_null() throws Exception{
    	System.out.println("Max consecutive zeros of given example");
    	/*
    	expect null pointer exception error
    	 */
		assertEquals("error", personService.getMaxConsecutiveZeros(null));
    }
}