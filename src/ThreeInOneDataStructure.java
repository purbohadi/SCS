import java.io.FileInputStream;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ThreeInOneDataStructure {

    private static Stack mStack = new Stack<Integer>();
    private static Queue mQueue = new LinkedList<Integer>();
    private static PriorityQueue<Integer> mPQueue = new PriorityQueue<Integer>();

    public static void main(String[] args) {
	/*
	 * Enter your code here. Read input from STDIN. Print output to STDOUT.
	 * Your class should be named Solution.
	 */

	Scanner sc = new Scanner(System.in);

	int N = sc.nextInt();
	for (int j = 0; j < N; j++) {
	    int query = sc.nextInt();
	    switch (query) {
	    case 1:
		addNumber(sc.nextInt());
		break;
	    case 2:
		removeTop();
		break;
	    case 3:
		printTop();
		break;
	    default:
		break;
	    }
	}
    }

    private static void addNumber(int num) {
	pushStack(num);
	addQueue(num);
	addPriorityQueue(num);
    }

    private static void removeTop() {

	try {
	    mStack.pop();
	    mQueue.remove();
	    mPQueue.remove();
	} catch (EmptyStackException e) {
	    System.out.println("impossible");
	}

	// if(false)
	// System.out.println("impossible");
    }

    private static void printTop() {

	try {
	    System.out.println(mStack.peek() + " " + mQueue.peek() + " "
		    + mPQueue.peek());
	} catch (EmptyStackException e) {
	    System.out.println("empty");
	}

	// if(false)
	// System.out.println("empty");
    }

    private static void pushStack(int num) {
	mStack.push(num);
    }

    private static void addQueue(int num) {
	mQueue.add(num);
    }

    private static void addPriorityQueue(int num) {
	mPQueue.add(num);
    }
}
