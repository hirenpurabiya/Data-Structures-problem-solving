import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;
import java.util.Locale;


public class MatrixWithZeroValue {
	public static void main(String args[]) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		int n = 4;
		int[][] matrix = new int[n][n];
		
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.US);

		System.out.println("Enter elements for NxN matrix: ");
		try {
			for(int i=0;i<n; i++) {
				for(int j=0;j<n;j++) {
					System.out.println("Enter element["+i+"]["+j+"]: ");
					matrix[i][j] = Integer.parseInt(br.readLine());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		matrix = setZeroValueRowAndColumn(matrix);
		System.out.print("Matrix after rotating 90 degrees: ");
		
		for(int i=0;i<n; i++) {
			for(int j=0;j<n;j++) {
				System.out.println("Element["+i+"]["+j+"]: ["+matrix[i][j]+"]");
			}
		}
	}

	private static int[][] setZeroValueRowAndColumn(int[][] matrix) {
		int row[] = new int[matrix.length];
		int column[] = new int[matrix[0].length];
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j]==0) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(row[i] == 1 || column[j] == 1) {
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}
}
