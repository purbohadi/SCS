import java.util.Scanner;

public class ZeroStatistica {

    private static int[] Answer;
    private static int MAX = 100001;
    private static int MAXSOLD = 1000001;
    private static long inv;
    
    private static int[] Weight,Frequency,Aux,Copied,F;

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
	int T = sc.nextInt();
	
	Weight= new int[MAX];
	Frequency= new int[MAXSOLD];
	Aux= new int[MAX];
	Copied= new int[MAX];
	F= new int[MAXSOLD];
	
	for (int test_case = 0; test_case < T; test_case++) {
	    int N = sc.nextInt();
	    
	    inv=0;
	    for (int i = 0; i < MAXSOLD; i++) {
		Frequency[i]=0;
		for (int j = 0; j < N; j++) {
		    Weight[j]=sc.nextInt();
		    Copied[j]=Weight[j];
		}
		
		mergeSort(0, N-1);
		long sum = 0;
		
		for (int j = 0; j < N; j++) {
		    if(j!=N-1)
			System.out.print(Frequency[Copied[j]]);
		    else
			System.out.println(Frequency[Copied[j]]);
		}
		
	    }
//	    Answer = new int[N];
//	    for (int i = 0; i < N; i++) {
//		Answer[i] = sc.nextInt();
//
//	    }
//	    for (int j = 0; j < N; j++) {
//		int count = 0;
//		for (int k = j + 1; k < N; k++) {
//		    if (Answer[k] < Answer[j])
//			count++;
//		}
//		Answer[j] = count;
//	    }
//
//	    for (int i = 0; i < N; i++) {
//		System.out.print(Answer[i] + " ");
//	    }
	}

    }
    
    
    private static void mergeSort(int left, int right){
	if(left<right){
	    int mid=(left+right)/2;
	    mergeSort(left, mid);
	    mergeSort(mid+1, right);
	}
    }

    private static void merge(int left, int mid, int right){
	int p=left,q=mid+1,k=0,count=0;
	for (int i = left; i <= right; i++) {
	    
	    if(p>mid){
		Aux[k++]= Weight[q++];
	    }else if(q>right){
		Aux[k++]=Weight[p];
		Frequency[Weight[p]]+=count;
		p++;
	    }else if(Weight[p]<= Weight[q]){
		Aux[k++]=Weight[p];
		Frequency[Weight[p]]+=count;
		p++;
	    }else{
		Aux[k++]=Weight[q++];
		inv+=mid-p+1;
		count++;
	    }
	    
	}
	for (int i = 0; i < k; i++) {
	    Weight[left++]=Aux[i];
	}
    }
    
    
}
