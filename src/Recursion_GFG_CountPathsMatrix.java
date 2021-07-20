
//The idea is to count the number of paths given by i-1,j and i,j-1 i.e. the positions adjacent to them
//We recurse this idea till we reach the end of matrix, as there will be only one path available after it
//We add the add results. In this we are starting from down to up to avoid additional i and j ints

public class Recursion_GFG_CountPathsMatrix {
    public static void main(String[] args) {
        int m = 2, n = 8;
        System.out.println(numberOfPaths(m, n));
    }

    public static long numberOfPaths(int m, int n) {
        if (m == 1 || n ==1) {
            return 1;
        }
        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
    }
}

//    =====Method 2==============
// Instead of going up and down we use global count and count++ each time we hit dead end(only one path possible)

//    static int count=0;
//    public static void main(String[] args){
//        int m=2,n=8;
//        System.out.println(numberOfPaths(m,n,0,0));
//    }
//
//    public static long numberOfPaths(int m, int n,int i,int j) {
//        if (i==m-1 || j==n-1){
//            return count++;
//        }
//        numberOfPaths(m,n,i+1,j);
//        numberOfPaths(m,n,i,j+1);
//        return count;
//    }

