import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DuplicateCharactersWithAdditionalSpace {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		
		System.out.println("Enter string to remove duplicates: ");
		try {
			str = br.readLine();
			//str = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		char[] str2 = isNonContiguousDuplicate(str);
		
		int i=0;
		System.out.print("String after removing duplicates: ");
		
		if(str2==null) {
			System.out.print("null");
		}
		else if(str2.length==0) {
			System.out.println("This is an empty string!");
		} else {
			while(str2[i]!=0) {
				System.out.print(str2[i]);
				if(i+1==str2.length)
					break;
				else 
					i++;
			}
		}
	}

	private static char[] isNonContiguousDuplicate(String charArray) {
		
		if(charArray==null) 
			return null;
		
		if(charArray.length()<2)
			return charArray.toCharArray();
		
		char[] ch = charArray.toCharArray();
		boolean[] has = new boolean[256];
		
		for(int i=0; i<256; i++)
			has[i]=false;
		
		int len = ch.length;
		int tail = 1;
		has[ch[0]] = true;
		
		for(int i = 0; i < len; i++) {
			if(!has[ch[i]]) {
				ch[tail] = ch[i];
				tail++;
				has[ch[i]] = true;
			}
		}
		if(tail<ch.length)
			ch[tail] = 0;
		
		return ch;
	}
}
