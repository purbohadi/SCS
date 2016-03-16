import java.util.Scanner;

public class MaximumPlacement {

    private static int N, count;
    private static boolean[][] square;
    private static int[] x;

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	count = 0;
	x= new int[N];

	placeNqueens(0);
	
	System.out.println(count*getNumber(N));
	
//	square = new boolean[N][N];
//
//	for (int row = 0; row < N; row++) {
//	    for (int col = 0; col < N; col++) {
//		square[row][col] = false;
//	    }
//	}
//
//	boolean success = solve();
//	if (!success) {
//	    System.out.println('0');
//	}

    }

    private static void placeNqueens(int r){
	
	for (int c = 0; c < N; c++) {
	    if(canPlaceQueen(r, c)){
		x[r]=c;
		if (r==N-1) {
		    count++;
		}else{
		    placeNqueens(r+1);
		}
	    }
	}
	
    }
    
    public static boolean canPlaceQueen(int r, int c) {
        /**
         * Returns TRUE if a queen can be placed in row r and column c.
         * Otherwise it returns FALSE. x[] is a global array whose first (r-1)
         * values have been set.
         */
        for (int i = 0; i < r; i++) {
            if (x[i] == c || (i - r) == (x[i] - c) ||(i - r) == (c - x[i])) 
            {
                return false;
            }
        }
        return true;
    }    
    
    private static boolean solve() {

	if (isSolved()) {
	    print();
	    int factorial = getNumber(N);
	    System.out.println(2 * getNumber(N));
	    return true;
	} else {
	    for (int col = 0; col < N; col++) {
		if (moreThanOne(col)) {
		    insert(col);
		    boolean success = solve();
		    remove(col);
		    if (success)
			return true;
		}
	    }
	    return false;
	}
    }

    private static boolean isSolved() {
	if (count == N) {
	    return true;
	} else {
	    return false;
	}
    }

    private static boolean moreThanOne(int col) {
	boolean ok = true;
	for (int i = 0; i < count && ok; i++)
	    ok = !square[i][col];

	for (int i = 1; count - i >= 0 && col - i >= 0 && ok; i++) {
	    ok = !square[count - i][col - i];
	}

	for (int i = 0; count - i >= 0 && col + i < N && ok; i++) {
	    ok = !square[count - i][col + i];
	}

	return ok;
    }

    private static void insert(int col) {
	square[count++][col] = true;
    }

    private static void remove(int col) {
	square[--count][col] = false;
    }

    private static void print() {
	for (int col = 0; col < N; col++) {
	    System.out.print("--");
	}
	System.out.println();

	for (int row = 0; row < N; row++) {
	    for (int col = 0; col < N; col++) {
		if (square[row][col]) {
		    System.out.print(" X");
		} else {
		    System.out.print(" .");
		}
	    }
	    System.out.println();
	}
    }

    public static int getNumber(int n) {
	int f = 1;
	for (int i = 1; i <= n; i++) {
	    f *= i;
	}
	return f;
    }

}
