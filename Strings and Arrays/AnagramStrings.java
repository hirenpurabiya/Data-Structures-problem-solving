import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AnagramStrings {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = "";
		String str2 = "";

		try {
			System.out.println("Please enter string 1: ");
			str1 = br.readLine();
			System.out.println("Please enter string 2: ");
			str2 = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isAnagram(str1, str2)) {
			System.out.println("The two entered strings are anagrams of eachother!");
		} else {
			System.out.println("The two entered string are not anagrams of eachother!");
		}
		
		
	}

	private static boolean isAnagram(String str1, String str2) {
		if(str1.length()!=str2.length())
			return false;
		
		int[] letters = new int[256];
		int num_unique_char = 0;
		int num_total_chars = 0;
		
		char[] ch1 = str1.toCharArray();
		
		for(char ch: ch1) {
			if(letters[ch]==0)
				num_unique_char++;
			letters[ch]++;
		}
		
		for(int i=0;i<str2.length();i++) {
			int ch = (int) str2.charAt(i);
			
			if(letters[ch]==0)
				return false;
			
			letters[ch]--;
			
			if(letters[ch]==0) {
				num_total_chars++;
				if(num_total_chars == num_unique_char)
					return i == str2.length()-1;
			}
		}
		return false;
	}
}
