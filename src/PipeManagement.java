import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PipeManagement {

    static int[][] board;
    static int[][] mark;

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
	Scanner sc = new Scanner(new FileInputStream("inputPipeManagement.txt"));

	int T = sc.nextInt();

	for (int test_case = 1; test_case <= T; test_case++) {
	    int M = sc.nextInt();
	    int N = sc.nextInt();
	    int R = sc.nextInt();
	    int C = sc.nextInt();
	    int L = sc.nextInt();

	    board = new int[M][N];
	    mark = new int[M][N];
	    for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[i].length; j++) {
		    board[i][j] = sc.nextInt();
		}
	    }

	    // printArr(board);
	    flag(R, C, L, 0); // start to mark the qualified node
	    // System.out.println("- - -");
	    // printArr(mark);

	    int Answer = countMark(mark); // count the marked pipe
	    // // Print the answer to standard output(screen).
	    System.out.println("#" + (test_case) + " " + Answer);
	}

    }

    // after all pipe node has been mark count the pipes
    private static int countMark(int[][] arr2d) {
	int count = 0;
	for (int i = 0; i < arr2d.length; i++) {
	    for (int j = 0; j < arr2d[i].length; j++) {
		if (arr2d[i][j] == 1)
		    count++;
	    }
	}
	return count;
    }

    /* mark the qualified node
     * 
     * @params : r = rowidx , c = columnidx, length = limit, dir = next direction
     * 
     */
    private static void flag(int r, int c, int length, int dir) {

	// base case
	if (length == 0)
	    return;

	// base boundary
	if (r < 0 || c < 0 || r >= board.length || c >= board[0].length)
	    return;

	// set pipe type
	int shape = board[r][c];

	// no pipe
	if (shape == 0)
	    return;

	// dir ke atas=1, kanan=2, bawah=3, kiri=4
	boolean atas = true;
	boolean kanan = true;
	boolean bawah = true;
	boolean kiri = true;

	// shape 1 = + , 2 = | , 3 = - , 4 = L , 5 = |- , 6 = -| , 7 = _|
	if (dir == 1) {
	    bawah = false;
	    if (shape == 3 || shape == 4 || shape == 7)
		return;
	} else if (dir == 2) {
	    kiri = false;
	    if (shape == 2 || shape == 4 || shape == 5)
		return;
	} else if (dir == 3) {
	    atas = false;
	    if (shape == 3 || shape == 5 || shape == 6)
		return;
	} else if (dir == 4) {
	    kanan = false;
	    if (shape == 2 || shape == 6 || shape == 7)
		return;
	}

	// mark current node visited
	mark[r][c] = 1;

	// check is the next path is available
	if (shape == 1) {
	    if (atas)
		flag(r - 1, c, length - 1, 1);
	    if (kanan)
		flag(r, c + 1, length - 1, 2);
	    if (bawah)
		flag(r + 1, c, length - 1, 3);
	    if (kiri)
		flag(r, c - 1, length - 1, 4);
	} else if (shape == 2) {
	    if (atas)
		flag(r - 1, c, length - 1, 1);
	    if (bawah)
		flag(r + 1, c, length - 1, 3);
	} else if (shape == 3) {
	    if (kanan)
		flag(r, c + 1, length - 1, 2);
	    if (kiri)
		flag(r, c - 1, length - 1, 4);
	} else if (shape == 4) {
	    if (atas)
		flag(r - 1, c, length - 1, 1);
	    if (kanan)
		flag(r, c + 1, length - 1, 2);
	} else if (shape == 5) {
	    if (kanan)
		flag(r, c + 1, length - 1, 2);
	    if (bawah)
		flag(r + 1, c, length - 1, 3);
	} else if (shape == 6) {
	    if (bawah)
		flag(r + 1, c, length - 1, 3);
	    if (kiri)
		flag(r, c - 1, length - 1, 4);
	} else if (shape == 7) {
	    if (atas)
		flag(r - 1, c, length - 1, 1);
	    if (kiri)
		flag(r, c - 1, length - 1, 4);
	}
    }
    
    // print the array
    private static void printArr(int[][] arr2d) {
	for (int i = 0; i < arr2d.length; i++) {
	    for (int j = 0; j < arr2d[i].length; j++) {
		System.out.print(arr2d[i][j]);
	    }
	    System.out.println();
	}
    }

}
