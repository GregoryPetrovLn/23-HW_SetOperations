package telran.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static telran.numbers.SetOperations.*;
class SetOperationsTests {
	Integer expected[]= {10,20,30,40,50};
	Integer array[] = {10,20,30,20,20,40,50,40,50};
	int repeated[] = {10,20,30,40,10};
	int non_repeated[] = {10,20,30,40};
	int ar1[] = {10,20,30,40};
	int ar2[] = {10,20,8,9};
	@Test
	void testRemoveRepeated() {
		
		assertArrayEquals(expected, removeRepeated(array));
	}

	@Test
	void testIntersection() {
		//ar1 -> {10,20,30,40}, ar2 -> {10,20,8,9} => result -> {10,20} 
		
		
		int expected[] = {10,20};
		assertArrayEquals(expected, intersection(ar1, ar2));
		try {
			intersection(repeated,ar1);
			fail("IllegalArgumentException is expected ");
		}catch(IllegalArgumentException e) {
			
		}
	}

	@Test
	void testHasRepeated() {
		assertTrue(hasRepeated(repeated));
		assertFalse(hasRepeated(non_repeated));
	}

	@Test
	void testUnion() {
		//ar1 -> {10,20,30,40}, ar2 -> {10,20,8,9} => result -> {10,20,30,40,8,9} 
				
				
				int expected[] = {10,20,30,40,8,9} ;
				assertArrayEquals(expected, union(ar1, ar2));
				try {
					union(repeated,ar1);
					fail("IllegalArgumentException is expected ");
				}catch(IllegalArgumentException e) {
					
				}
	}

	@Test
	void testSubtraction() {
		//ar1 -> {10,20,30,40}, ar2 -> {10,20,8,9} => result -> {30,40} 
		
		
		int expected[] = {30,40} ;
		assertArrayEquals(expected, subtraction(ar1, ar2));
		try {
			subtraction(ar1, repeated);
			fail("IllegalArgumentException is expected ");
		}catch(IllegalArgumentException e) {
			
		}
	}

}
