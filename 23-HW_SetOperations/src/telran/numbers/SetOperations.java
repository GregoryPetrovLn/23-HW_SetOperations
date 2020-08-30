package telran.numbers;

import java.util.*;

public class SetOperations {
/**
 * 
 * @param array
 * @return array with no repeated numbers
 * additional requirement: one code line
 */
	public static Integer[] removeRepeated(Integer array[]) {

	return new LinkedHashSet<Integer>(Arrays.asList(array)).toArray(new Integer[0]);
}
	/**
	 * 
	 * @param ar1
	 * @param ar2
	 * @return array of common integers from two received arrays
	 * throws IllegalArgumentException if at least one array from the received has the repeated numbers
	 * ar1 -> {1,2,3,4}, ar2 -> {1,2,8,9} => result -> {1,2} 
	 */
	public static int[] intersection(int ar1[], int ar2[]) {
		if (hasRepeated(ar1) || hasRepeated(ar2)) {
			throw new IllegalArgumentException("repeated numbers are disallowed");
		}
		Set<Integer> helper = getSetFromArray(ar2);
		
		ArrayList<Integer> listRes = new ArrayList<>();
		for(int num: ar1) {
			if(helper.contains(num)) {
				listRes.add(num);
			}
		}
		
		return getArrayFromCollection(listRes);
	}
	
	private static int[] getArrayFromCollection(Collection<Integer> collection) {
		int res[] = new int[collection.size()];
		int ind = 0;
		for(int num: collection) {
			res[ind++] = num;
		}
		return res;
	}
	private static Set<Integer> getSetFromArray(int[] ar) {
		HashSet<Integer> res = new HashSet<>();
		fillCollection(res, ar);
		return res;
	}
	private static void fillCollection(Collection<Integer> res, int[] ar) {
		for(int num: ar) {
			res.add(num);
		}
		
		
	}
	/**
	 * 
	 * @param array
	 * @return true if the array has the repeated numbers
	 */
	public static boolean hasRepeated(int array[]) {
		
		return getSetFromArray(array).size() < array.length;
	}
	/**
	 * 
	 * @param ar1
	 * @param ar2
	 * @return union of ar1 and ar2 (all elements of ar1 + elements of ar2 that don't exist in ar1)
	 * throws IllegalArgumentException if at least one array from the received has the repeated numbers
	 * ar1 -> {1,2,3,4}, ar2 -> {1,2,8,9} => result -> {1,2,3,4,8,9} 
	 */
	public static int[] union(int ar1[], int ar2[]) {
		if (hasRepeated(ar1) || hasRepeated(ar2)) {
			throw new IllegalArgumentException("repeated numbers are disallowed");
		}
		LinkedHashSet<Integer> setRes = new LinkedHashSet<>();
		fillCollection(setRes, ar1);
		for(int num: ar2) {
			if(!setRes.contains(num)) {
				setRes.add(num);
			}
		}
		
		return getArrayFromCollection(setRes);
	}
	
	/**
	 * 
	 * @param ar1
	 * @param ar2
	 * @return array of elements from ar1 that don't exist in ar2
	 * throws IllegalArgumentException if at least one array from the received has the repeated numbers
	 * ar1 -> {1,2,3,4}, ar2 -> {1,2,8,9} => result -> {3,4} 
	 */
	public static int[] subtraction(int ar1[], int ar2[]) {
		if (hasRepeated(ar1) || hasRepeated(ar2)) {
			throw new IllegalArgumentException("repeated numbers are disallowed");
		}
		Set<Integer> helper = getSetFromArray(ar2);
		ArrayList<Integer> listRes = new ArrayList<>();
		for(int num: ar1) {
			if(!helper.contains(num)) {
				listRes.add(num);
			}
		}
		
		return getArrayFromCollection(listRes);
	}
}
