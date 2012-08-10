import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReplaceSpaceWithMultipleCharacters {
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
		System.out.print("String after replacing spaces with '%20': ");
		for(char ch1: ch) {
			System.out.print(ch1);
		}
	}

	private static char[] removeSpaces(String str) {
		char ch[] = str.toCharArray();
		int spaceCount=0, newLength=0;
		
		for(char ch1: ch) {
			if(ch1 == ' ')
				spaceCount++;
		}
		
		newLength = ch.length + spaceCount*3;
		char []ch1 = new char[newLength];
		int length = ch1.length;		
		
		for(int i=ch.length-1; i>=0;i--) {
			if(ch[i] == ' ') {
				ch1[length-1] = '0';
				ch1[length-2] = '2';
				ch1[length-3] = '%';
				length = length-3;
			} else {
				ch1[length-1] = ch[i];
				length = length-1;
			}
		}
		
		return ch1;		
	}
}
