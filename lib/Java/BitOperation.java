package lib;

public class BitOperation {
	public int countBits(int a){
		int res = 0;
		while (a != 0){
			a = a & (a - 1);
			++res;
		}
		return res;
	}
	
	public static void main(String[] args){
		BitOperation test = new BitOperation();
		System.out.print(test.countBits(6));
	}
}
