import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Formatter;
import java.util.Locale;


public class MatrixRotation90Degrees {
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
	
		matrix = rotateMatrixBy90Degree(matrix);
		System.out.print("Matrix after rotating 90 degrees: ");
		
		for(int i=0;i<n; i++) {
			for(int j=0;j<n;j++) {
				System.out.println("Element["+i+"]["+j+"]: ["+matrix[i][j]+"]");
			}
		}
	}


	private static int[][] rotateMatrixBy90Degree(int[][] matrix) {
		int n = matrix.length;
		for(int layer=0;layer<n/2;layer++) {
			int first = layer;
			int last = n-layer-1;
			for(int i=first;i<last;i++) {
				int offset = i-first;
				// save top
				int top = matrix[first][i];
				
				// left -> top
				matrix[first][i] = matrix[last-offset][first];
				
				// bottom -> left
				matrix[last-offset][first] = matrix[last][last-offset];
				
				// right -> bottom
				matrix[last][last-offset] = matrix[i][last];
				
				// top -> right
				matrix[i][last] = top;
			}
		}
		return matrix;
	}
}