package lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerOperation {
	public String reverse(String input){
		StringBuilder sb = new StringBuilder();
		for (int i = input.length() - 1; i >= 0; --i) {
			sb.append(input.charAt(i));
		}
		return sb.toString();
	}
	public boolean isPalindrom(int input) {
		String inputString = String.valueOf(input); 
	    if (inputString.equals( reverse(inputString)) ){ 
	        return true; 
	      }else{ 
	        return false; 
	    }
	}
	
	public List<Integer> generatePrime(int upperLimit){
		boolean [] isPrime = new boolean[upperLimit+1];
		Arrays.fill(isPrime, false);
		for (int i = 1; i <= upperLimit; i += 2){
			isPrime[i] = true;
		}
		isPrime[2] = true;
		for (int i = 3; i < Math.sqrt(upperLimit); i += 2) {
			if (isPrime[i]){
				for (int j = i * 2; j <= upperLimit; j += i){
					isPrime[j] = false;
				}
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]){
				res.add(i);
			}
		}
		return res;
	}
	
	
	public static void main(String[] args){
		List<Integer> test = new ArrayList<Integer>();
		IntegerOperation io = new IntegerOperation();
		test = io.generatePrime(100);
		for (int i: test){
			System.out.println(i);
		}
	}
}
