package net.egork.string;

/**
 * @author Egor Kulikov (kulikov@devexperts.com)
 */
public class StringUtils {
	public static String reverse(String sample) {
		StringBuilder result = new StringBuilder(sample);
		result.reverse();
		return result.toString();
	}

	public static int count(String string, char c) {
		int count = 0;
		for (int i = string.length() - 1; i >= 0; i--) {
			if (string.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}

	public static String unite(String[] array) {
		StringBuilder result = new StringBuilder();
		for (String s : array) {
			result.append(s);
		}
		return result.toString();
	}

	public static int differs(String first, String second) {
		int result = 0;
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != second.charAt(i)) {
				result++;
			}
		}
		return result;
	}

	public static int[] zAlgorithm(CharSequence s) {
		int length = s.length();
		int[] z = new int[length];
		z[0] = 0;

		int left = 0, right = 0;
		for (int i = 1; i < length; i++) {
			if (i > right) {
				int j;
				//noinspection StatementWithEmptyBody
				for (j = 0; i + j < length && s.charAt(i + j) == s.charAt(j); j++) ;
				z[i] = j;
				left = i;
				right = i + j - 1;
			} else if (z[i - left] < right - i + 1)
				z[i] = z[i - left];
			else {
				int j;
				//noinspection StatementWithEmptyBody
				for (j = 1; right + j < length && s.charAt(right + j) == s.charAt(right - i + j); j++) ;
				z[i] = right - i + j;
				left = i;
				right = right + j - 1;
			}
		}
		return z;
	}

	public static int[] prefixFunction(CharSequence s) {
		int l = s.length();
		int[] p = new int[l];
		p[0] = 0;
		int k = 0;
		for (int i = 1; i < l; i++) {
			while ((k > 0) && (s.charAt(k) != s.charAt(i)))
				k = p[k - 1];
			if (s.charAt(k) == s.charAt(i))
				k++;
			p[i] = k;
		}
		return p;
	}
	public static int kmp(String text, String pattern){
		int[] fail = prefixFunction(pattern);
		int i = 0, j = 0;
		while (i < text.length() && j < pattern.length() ){
			if (pattern.charAt(j) == text.charAt(i)){
				++i;++j;
			}else if (j == 0){//如果第一个字符匹配失败，从str的下一个字符开始
				++i;
			}else{
				j = fail[j - 1];
			}
		}
		if (j == pattern.length() ){
			return i - j;
		}else{
			return -1;
		}
	}
}
