import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IntimacyValue {

	static String tree;
	static int k;
	static int AnswerN;

	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));

		int test_case = sc.nextInt();

		for (int i = 0; i < test_case; i++) {
			k = sc.nextInt();
			tree = sc.next();
			countValueAt(k, tree.toCharArray());
			System.out.println("#" + test_case +" " +AnswerN);
		}

	}

	public static void countValueAt(int levelVal, char[] tree) {
		int level = -1;
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] == '(') {
				level++;
			} else if (tree[i] == ')') {
				level--;
			} else if(level==levelVal) {
				AnswerN += Integer.parseInt("" + tree[i]);
			}
		}
	}
}
