public class Pemutation {

    private static int X = 3;
    private static char[] items = { 'A', 'B', 'C', 'D', 'E' };
    private static char[] result = new char[X];
    static int Total, count;

    public static void main(String[] args) {
	long startTime= System.currentTimeMillis();
	mutate(0);
	long endTime = System.currentTimeMillis();
	long runningTime = endTime-startTime;
	System.out.println("Running Time : "+runningTime);

	System.out.println(Total);
	System.out.println(count);
    }

    private static void mutate(int index) {
	count++;
	

	if (index < X) {

	    for (int i = 0; i < items.length; i++) {

		if (!isExist(index, items[i], result)) {
		    result[index] = items[i];
		    if (index == X - 1) {
			Total++;
			for (int j = 0; j < result.length; j++) {
			    System.out.print(result[j]);
			}
			System.out.println();
		    }

		    mutate(index + 1);

		}

	    }

	}

    }

    private static boolean isExist(int index, char item, char[] temp) {

	for (int i = 0; i < index; i++) {
	    if (temp[i] == item)
		return true;
	}

	return false;

    }
}
