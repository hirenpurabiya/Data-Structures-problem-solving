import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UniqueCharacters {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		String string="";
		System.out.println("Enter a string: ");
		try {
			string = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isUnique(string))
			System.out.println("String has unique characters!");
		else
			System.out.println("String has duplicate characters!");
		
	}
	
	public static boolean isUnique(String string) {
		boolean chars[] = new boolean[256];

		for(int i=0;i<string.length();i++) {
			int ch = string.charAt(i);
			System.out.println(ch);
			if(chars[ch])
				return false;
			chars[ch] = true;
		}		
		return true;
	}

}
