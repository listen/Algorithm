package lib;

public class StringOperation {
	public String reverse(String input){
		StringBuilder sb = new StringBuilder();
		for (int i = input.length() - 1; i >= 0; --i) {
			sb.append(input.charAt(i));
		}
		return sb.toString();
	}
	
	public boolean isPalindrom(String input) {
		if (input.equals( reverse(input)) ){ 
		      return true; 
		    }else{ 
		      return false; 
		} 
	}
	
	public void format(){
		int hour = 1, minute = 2;
		//@按照24小时进制，前面补零
	      String.format("%02d:%02d", hour, minute);
	}
}
