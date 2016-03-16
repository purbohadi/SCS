import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StampTheMap {

    private static int N, M;
    private static char[][] data;
    private static boolean[][] stamped;

    /**
     * min(N,M) by A
     * 
     * use binary search with simple solution O(A^2 N M Log A)
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
	// Scanner sc = new Scanner(System.in);
	Scanner sc = new Scanner(new FileInputStream("inputStampTheMap.txt"));

	N = sc.nextInt();
	M = sc.nextInt();
	data = new char[N][M];
//	stamped = new boolean[N][M];

	for (int i = 0; i < N; i++) {
	    String line = sc.next();
	    for (int j = 0; j < M; j++) {
		data[i][j] = line.charAt(j);
	    }
	}

	int left = 1;
	int right = Math.min(N, M) + 1;
	System.out.println(isPossibleToColor(3));
	while (right - left > 1) {
	    int middle = (left + right) / 2;
	    if (isPossibleToColor(middle)) {
		left = middle;
	    } else {
		right = middle;
	    }
	}

	System.out.println(left);
	// System.out.println(isPossibleToColor(3));

    }

    private static boolean isPossibleToColor(int width){
	
	stamped = new boolean[N][M];
	
	if(width==0)
	    return false;
	
	for (int row = 0; row < N-width+1; row++) {
	    for (int col = 0; col < M-width+1; col++) {
		if (isStampAble(col, row, width)) {
		    markCell(col, row, width);
		}
	    }
	}
	
	if(isAllStamped())
	    return true;
	
	return false;
    }

    private static boolean isStampAble(int x, int y, int w) {

	for (int i = y; i < w + y; i++) {
	    for (int j = x; j < w + x; j++) {
		if (data[i][j] == '#')
		    return false;
	    }
	}
	return true;
    }
    
    private static boolean isAllStamped(){
	for (int i = 0; i < N; i++) {
	    for (int j = 0; j < M; j++) {
		if (!stamped[i][j]&&data[i][j]=='_') {
		    return false;
		}
	    }
	}
	return true;
    }
    
    private static void markCell(int startX, int startY, int w){
	for (int i = startY; i < startY+w; i++) {
	    for (int j = startX; j < startX+w; j++) {
		stamped[i][j]=true;
	    }
	}
    }

    // private static boolean isPossibleToColor(int width) {
    // for (int i = N; i > 0; i--) {
    // for (int j = M; j > 0; j--) {
    // if (i - width > 0 && j - width > 0) {
    // checkPosition(i, j, i-width, j-width);
    // }else{
    // continue;
    // }
    // }
    // }
    //
    // return true;
    // }
    //
    // private static boolean checkPosition(int x1, int y1, int x2, int y2) {
    //
    // for (int i = x1; i < x2; i++) {
    // for (int j = y1; j < y2; j++) {
    // if (map[i][j] == '#') {
    // return false;
    // }else{
    // map[i][j]='c';
    // }
    // }
    // }
    //
    // return true;
    // }

}
