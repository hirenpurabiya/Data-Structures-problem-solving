import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DuplicateCharacters {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		
		System.out.println("Enter any string to check for duplicates: ");
		
		try {
			str = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("String before removing duplicates: "+str);
		char stringWithoutDuplicates[] = isDuplicate(str);
		int i=0;
		System.out.print("String after removing duplicates: ");
		
		if(stringWithoutDuplicates==null) {
			System.out.print("null");
		}
		else if(stringWithoutDuplicates.length==0) {
			System.out.println("This is an empty string!");
		} 
		else {
			while(stringWithoutDuplicates[i]!=0) {
				System.out.print(stringWithoutDuplicates[i]);
				if(i+1==stringWithoutDuplicates.length)
					break;
				else 
					i++;
			}
		}
	}
	private static char[] isDuplicate(String str) {
		if(str==null)
			return null;
		if(str.length()==1)
			return str.toCharArray();
		
		char ch[] = str.toCharArray();
		int tail=1;
		
		for(int i=1;i<ch.length;++i) {
			int j;
			for(j=0;j<tail;++j) {
				if(ch[i]==ch[j])
					break;
			}
			if(j==tail) {
				ch[tail]=ch[i];
				++tail;
			}
		}
		
		if(tail<ch.length)
			ch[tail] = 0;
		
		return ch;
	}
}
