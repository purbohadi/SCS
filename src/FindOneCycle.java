import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindOneCycle {

    private static int N, M;
    private static DirectionalGraph graph;

    /**
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

	Scanner sc = new Scanner(new FileInputStream("inputFindOneCycle.txt"));

	N=sc.nextInt();
	M=sc.nextInt();
	
	graph = new DirectionalGraph(N);
	
	for (int i = 0; i < N; i++) {
	    graph.addEdge(sc.nextInt()-1, sc.nextInt()-1);
	}

	if (isCyclic()) {
	    System.out.println("Yes");
	}else{
	    System.out.println("No");
	}
	

    }
    
    private static boolean isCyclic(){
	boolean[] visited = new boolean[N];
	
	for (int i = 0; i < N; i++) {
	    if (isCyclicUtil(i, visited)) {
		return true;
	    }
	}
	
	return false;
    }
    
    private static boolean isCyclicUtil(int v, boolean[] visited){
	
	if (!visited[v]) {
	    visited[v]=true;
	    
	    for (int i = 0; i < N; i++) {
		if (graph.isEdge(v, i)) {
		    if (!visited[i]&&isCyclicUtil(i, visited)) {
			return true;
		    }else if(visited[i]){
			return true;
		    }
		}
	    }
	}
	
	//visited[v]=false;
	return false;
    }
    

}

class DirectionalGraph {
    private boolean adjacencyMatrix[][];
    private int vertexCount;

    public DirectionalGraph(int vCount) {
	this.vertexCount = vCount;
	this.adjacencyMatrix = new boolean[vertexCount][vertexCount];
    }

    public void addEdge(int i, int j) {
	if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
	    this.adjacencyMatrix[i][j] = true;
	}
    }

    public boolean isEdge(int i, int j) {
	if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount)
	    return adjacencyMatrix[i][j];
	else
	    return false;
    }

}
