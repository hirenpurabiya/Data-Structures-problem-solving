import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StringRotation {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = "", str2 ="";
		try {
			System.out.println("Enter string 1: ");
			str1 = br.readLine();
			System.out.println("Enter string 2: ");
			str2 = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean isRotation = isSubstring(str1, str2);
		if(isRotation)
			System.out.print("String "+str2+"is a rotation of string "+str1+"!");
		else
			System.out.print("String "+str2+"is not a rotation of string "+str1+"!");
	}

	private static boolean isSubstring(String str1, String str2) {
		String concat = str1+str1;
		boolean isSubstring = concat.toUpperCase().indexOf(str2.toUpperCase()) != -1;
		return isSubstring;
	}

}
