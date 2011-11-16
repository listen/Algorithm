package lib;

public class Permutation {
	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private void reverse(int[] a, int from, int to) {
		while (from < to)
			swap(a, from++, to--);
	}
	
	public boolean nextPermutation(int[] a) {
		// find the first inversion
		int i = a.length - 2;
		while (i >= 0 && a[i] >= a[i + 1])
			--i;
		if (i < 0)
			return false;
		// find the smallest number after i that is larger than a[i]
		int j = a.length - 1;
		while (a[j] <= a[i])
			--j;
		swap(a, i, j);
		reverse(a, i + 1, a.length - 1);
		return true;
	}
	
	public static void main(String[] args) {
		Permutation p = new Permutation();
		int[] a = {1, 2, 3, 4};
		int cnt = 0;
		do {
			for (int i = 0; i < a.length; ++i)
				System.out.print(a[i] + " ");
			System.out.println();
			++cnt;
		} while (p.nextPermutation(a));
		System.out.println(cnt);
	}	
}
