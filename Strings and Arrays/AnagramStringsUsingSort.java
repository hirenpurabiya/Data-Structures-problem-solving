import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AnagramStringsUsingSort {
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
		else {
			char[] ch1 = str1.toCharArray();
			java.util.Arrays.sort(ch1);
			char[] ch2 = str2.toCharArray();
			java.util.Arrays.sort(ch2);

			int i=0;
		
			while(i<ch1.length) {
				if(ch1[i]!=ch2[i])
					return false;
				else 
					i++;
			}
			return true;
		}
	}
}
