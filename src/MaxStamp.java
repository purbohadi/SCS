import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxStamp {

    private static int N, M;
    private static int[][] paintMap;
    private static int[][] checkMap;

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
	// TODO Auto-generated method stub

	Scanner sc = new Scanner(new FileInputStream("inputStampTheMap.txt"));

	N = sc.nextInt();
	M = sc.nextInt();
	paintMap = new int[N][M];
	checkMap = new int[N][M];

	for (int i = 0; i < N; i++) {
	    String line =sc.next();
	    for (int j = 0; j < M; j++) {
		if(line.charAt(j)=='#')
		    paintMap[i][j]=1;
		else
		    paintMap[i][j]=0;
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

//	for (int i = 0; i < N; i++) {
//	    for (int j = 0; j < M; j++) {
//		System.out.print(paintMap[i][j]);
//	    }
//	    System.out.println();
//	}
	
    }

    private static boolean isPossibleToColor(int width) {
	for (int i = N; i > 0; i--) {
	    for (int j = M; j > 0; j--) {
		if (i - width > 0 && j - width > 0) {
		    if(isPossibleToStamp(i, j, i-width, j-width))
			paintMap[i][j]=2;
		    
		}else{
		    continue;
		}
	    }
	}

	return true;
    }
    
    
    private static boolean isPossibleToStamp(int x1, int y1, int x2, int y2){
	int count=0;
	for (int i = x1; i < x2; i++) {
	    for (int j = y1; j < y2; j++) {
		if(paintMap[i][j]==1)
		    count++;
		else
		    count--;
	    }
	}
	if(count>=0)
	    return true;
	return false;
    }

}
