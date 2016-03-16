import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	static int N, test_case;
	static int AnswerN;
	static char[][] map;

	public static void main(String args[]) throws FileNotFoundException {
		System.out
				.println("Software Certification Test - BTS Coverage Problem");

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		test_case = sc.nextInt();// get number of test case
		// for getting data from input file and convert it into 2 dimensional
		// array
		N = sc.nextInt();
		System.out.println(N);
		for (int i = 0; i < test_case; i++) {
			System.out.println(i);
			map = new char[N][N]; // initialize array using N value
			for (int j = 0; j < N; j++) {// iterate until N for i down
				for (int k = 0; k < N; k++) {// iterate until N for j right
					char point = sc.next().charAt(0);
					map[j][k] = point;
//					 System.out.print(map[j][k]);
				}
//				 System.out.println();
			}
			// put your algorithm here
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if(map[x][y]=='H'){
						scan(x, y, map);
					}
				}
			}

			AnswerN=0;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (map[x][y] == 'H') {
						AnswerN++;
					}
				}
			}
			System.out.println("#" + i + " " + AnswerN);

		}

	}

	static char[][] scan(int x, int y, char[][] data) {

		for (int i = 1; i < 4; i++) {
			// scan up set the boundary
			if (y - i >= 0) {
				char point = data[x][y - i];
				if ((point == 'A' && i == 1) || (point == 'B' && (i==1 || i == 2)
						|| (point == 'C' && (i==1 || i == 2||i == 3)))) {
					map[x][y-i] = 'X';
					return data;
				}
			}
			// right
			if (x + i < N) {
				char point = data[x + i][y];
				if ((point == 'A' && i == 1) || (point == 'B' && (i==1 || i == 2)
						|| (point == 'C' && (i==1 || i == 2||i == 3)))) {
					map[x+i][y] = 'X';
					return data;
				}
			}
			// down
			if (y + i < N) {
				char point = data[x][y + i];
				if ((point == 'A' && i == 1) || (point == 'B' && (i==1 || i == 2)
						|| (point == 'C' && (i==1 || i == 2||i == 3)))) {
					map[x][y+i] = 'X';
					return data;
				}
			}
			// left
			if (x - i >= 0) {
				char point = data[x - i][y];
				if ((point == 'A' && i == 1) || (point == 'B' && (i==1 || i == 2)
						|| (point == 'C' && (i==1 || i == 2||i == 3)))) {
					map[x-i][y] = 'X';
					return data;
				}
			}
		}
		
		return data;

	}

}
