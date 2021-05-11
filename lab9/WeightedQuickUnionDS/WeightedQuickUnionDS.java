package lab9.WeightedQuickUnionDS;

public class WeightedQuickUnionDS {

    private int[] parent;

    /*
     * Returns the parent of element p.
     * If p is the root of a tree, returns the negative size
     * of the tree for which p is the root.
     */
    public int parent(int p) {
        return parent[p];
    }

    /* Prints the parents of the elements, separated by a space */
    public void printParent() {
        for (int element : parent) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /*
     ***************************
     * DO NOT MODIFY CODE ABOVE
     ***************************
     */


    /*
     ***** HELPER METHODS START *****
     */

    // Add your own helper methods here
	// INCLUDE your helper methods in your submission !
	private int find(int p) {
	    validate(p);
	    int root = p;
	    while (parent[root] > -1) {
	        root = parent[root];
        }
	    return root;
    }
	
	

    /*
     ***** HELPER METHODS END *****
     */


    // LAB EXERCISE 9.3  CONSTRUCTOR

    /**
     * Creates a Disjoint Sets data structure with n elements,
     * 0 through n-1.
     * Initially, each element is in its own set.
     * @param N the number of elements
     */
    public WeightedQuickUnionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }
		
		
    }


    // LAB EXERCISE 9.4 VALIDATE

    /**
     * Validates that p is a valid element/index.
     * @throws IllegalArgumentException if p is not a valid index.
     */
    public void validate(int p) {
        if (p < 0 || p > parent.length) {
            throw new IllegalArgumentException();
        }
		
		
    }


    // EXERCISE 9.1  SIZE OF

    /**
     * Returns the size of the set element p belongs to.
     * @param p an element
     * @return the size of the set containing p
     */
    public int sizeOf(int p) {
        int root = find(p);
        return Math.abs(parent[root]);
    }


    // EXERCISE 9.2  IS CONNECTED


    /**
     * Returns true iff elements p and q are connected.
     * @param p an element
     * @param q the other element
     * @return true if p and q are in the same set
     *         false otherwise
     * @throws IllegalArgumentException if p or q is not a valid index.
     */
    public boolean isConnected(int p, int q) {
        int root_p = find(p);
        int root_q = find(q);
		return root_p == root_q;
    }


    // EXERCISE 9.3  CONNECT

    /**
     * Connects two elements p and q together,
     * by combining the sets containing them.
     * @param p an element
     * @param q the other element
     * @throws IllegalArgumentException if p or q is not a valid index.
     */
    public void connect(int p, int q) {//p=a=3,q=b=9,使用lab上的数据
        validate(p);
        validate(q);
        if (find(p) != find(q)) {
            int a = p;//a=3
            int b = q;//b=9
            while (parent[a] > -1 ) {
                a = parent[a];//a=0
            }
            while (parent[b] > -1) {
                b = parent[b];//b=6
            }
            if (parent[a] < parent[b]) {
                parent[a] += parent[b];
                parent[b] = a;
            } else if (parent[a] > parent[b]) {
                parent[b] += parent[a];
                parent[a] = b;
            } else {
                parent[b] += parent[a];
                parent[a] = b;
            }
        }
    }


    public static void main(String[] args) {
        WeightedQuickUnionDS ds = new WeightedQuickUnionDS(4);
//        ds.connect(1, 0);
//        ds.connect(3, 2);
//        ds.connect(3, 1);
//        ds.printParent();
        ds.connect(1, 0);
        ds.printParent();//-2 0 -1 -1

        System.out.println(ds.isConnected(1, 0));//true
        System.out.println(ds.parent(1));//0
        System.out.println(ds.parent(0));//-2
        ds.connect(3, 2);
        ds.printParent();//-2 0 -2 2

        System.out.println(ds.isConnected(2, 1));//false
        ds.connect(3, 1);
        System.out.println(ds.isConnected(2, 1));//true
        System.out.println("-------------------------------- ");
        ds.printParent();
        System.out.println("-------------------------------- ");
        System.out.println(ds.parent(2));//0
        System.out.println(ds.sizeOf(0));//4
        System.out.println(ds.sizeOf(3));//4
        System.out.println(ds.sizeOf(2));//4
        System.out.println(ds.sizeOf(1));//4
        System.out.println("-------------------------------- ");
        ds.printParent();//-4 0 0 2
    }

}
