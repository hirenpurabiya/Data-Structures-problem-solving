import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReverse {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		System.out.println("Enter a string to reverse: ");
		
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String reverseStr = reverseString(str);
		System.out.println(reverseStr);
	}

	private static String reverseString(String str) {
		char ch[] = str.toCharArray();
		char temp;
		int end = ch.length;
		int i=0;
		while(i<end) {
			temp = ch[i];
			ch[i]=ch[end-1];
			ch[end-1]=temp;
			i++;
			end--;
		}
		
		return new String(ch);
	}
}
