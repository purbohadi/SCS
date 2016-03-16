import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CompareMatrix {

    private static int[][] matrix1, matrix2;
    
    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
	// TODO Auto-generated method stub
	
	Scanner sc1 = new Scanner(new FileInputStream("inputPakNizam.txt"));
	Scanner sc2 = new Scanner(new FileInputStream("inputSaya.txt"));
	
	
	matrix1 = new int[20][20];
	matrix2 = new int[20][20];
	
	int countDiff=0;
	for (int i = 0; i < matrix1.length; i++) {
	    String line1 = sc1.next();
	    String line2 = sc2.next();
	    for (int j = 0; j < line1.length(); j++) {
		matrix1[i][j]=line1.charAt(j)-'0';
		matrix2[i][j]=line2.charAt(j)-'0';
		
		if (matrix1[i][j]!=matrix2[i][j]) {
		    System.out.println("Found : "+ ++countDiff+ " - "+i+" , "+j);
		    return;
		}
	    }
	}
	
	System.out.println("AllSame");

    }

}
