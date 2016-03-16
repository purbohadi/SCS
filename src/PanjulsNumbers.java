import java.util.Arrays;
import java.util.Scanner;

public class PanjulsNumbers {

    private static int Answer, N, P, K;
    private static int[] arr, remainings;

    public static void main(String[] args) {
	/*
	 * Enter your code here. Read input from STDIN. Print output to STDOUT.
	 * Your class should be named Solution.
	 */
	Scanner sc = new Scanner(System.in);

	int T = sc.nextInt();
	sc.nextLine();
	for (int test_case = 0; test_case < T; test_case++) {
	    N = sc.nextInt();
	    K = sc.nextInt();
	    P = sc.nextInt();
	    arr = new int[K];
	    sc.nextLine();
	    
	    Arrays.sort(arr);

	    if (P > (N - K)) {
		System.out.println("-1");
	    } else {
		for (int i = 0; i < K; i++) {
		    arr[i] = sc.nextInt();
		    if (arr[i] <= P)
			P++;
		}
		System.out.println(P);
	    }
	}
    }

}
