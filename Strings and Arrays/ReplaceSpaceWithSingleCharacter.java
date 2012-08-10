import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReplaceSpaceWithSingleCharacter {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		System.out.println("Enter a string with spaces: ");
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		char []ch = removeSpaces(str);
		System.out.print("String after replacing spaces with '2': ");
		for(char ch1: ch) {
			System.out.print(ch1);
		}
	}

	private static char[] removeSpaces(String str) {
		char[] ch = str.toCharArray();
		char temp;
		for(int i=0;i<ch.length;i++) {
			if(ch[i] == ' ') {
				ch[i] = '2';
			}
		}
		return ch;
	}
}
