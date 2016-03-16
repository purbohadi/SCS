import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Palindrome {

	static int AnswerN;
	static String parent, pattern;
	static int test_case;
	
	public static void main(String args[]) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileInputStream("palindrome.txt"));
		
		test_case = sc.nextInt();

		int parentLength,patternLength;
		
		for (int i = 0; i < test_case; i++) {
			pattern=sc.next();
			parent=sc.next();
			patternLength=pattern.length();
			parentLength=parent.length();
			
			for (int j = patternLength; j < parentLength-1;) {
				for (int k = 0; k < ((parentLength-k)-(patternLength-1)); k++) {
					String check=parent.substring(k,k+j);
					System.out.println(check);
				}
				j++;
			} 
			
			
		}
	}
}
