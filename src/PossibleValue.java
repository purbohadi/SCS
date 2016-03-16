import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class PossibleValue {

    private static final char[] ops = { '+', '-', '*' };
    private static final int TARGET = 23;
    private static int[] numbers = new int[5];
    private static final int N = 5;
    private static String Answer;

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
	List<Character> operands = new Vector<Character>();
	

	for (int i = 0; i < N; i++) {
	    numbers[i] = sc.nextInt();
	}

	int number = 0;
	Answer="Impossible";
	for (int i = 0; i < N; i++) {
	    number = numbers[i];
	    set.add(number);
	    countResult(number, set, operands);
	    set.remove(number);
	}
	
	System.out.println(Answer);
    }

    private static void countResult(int total, LinkedHashSet<Integer> set,
	    List<Character> operands) {
	for (int i = 0; i < N; i++) {
	    if (set.add(numbers[i])) {
		for (char op : ops) {
		    operands.add(op);
		    int pair = countPair(total, numbers[i], op);
		    if (set.size()==N && pair==TARGET) {
			Answer="Possible";
			return;
		    }

		    countResult(pair, set, operands);
		    operands.remove(operands.size()-1);
		}
		set.remove(numbers[i]);
	    }
	}

    }

    private static int countPair(int n1, int n2, char op) {
	switch (op) {
	case '+':
	    return n1 + n2;
	case '-':
	    return n1 - n2;
	case '*':
	    return n1 * n2;
	}
	throw new java.lang.IllegalArgumentException();
    }

//    private static String opAlgoFormat(java.util.LinkedHashSet<Integer> set,
//	    java.util.List<Character> values) {
//
//	java.util.Iterator<Integer> iter = set.iterator();
//	String toString = new String(Integer.toString(iter.next()));
//	int t = 0;
//	char prev = ' ';
//	while (iter.hasNext()) {
//	    int v = iter.next();
//	    if ((values.get(t) == '/' || values.get(t) == '*')
//		    && (prev == '+' || prev == '-')) {
//		toString = "(" + toString + ")";
//	    }
//
//	    toString += " " + Character.toString(values.get(t)) + " "
//		    + Integer.toString(v);
//	    prev = values.get(t++);
//	}
//	return toString;
//    }
//
}
