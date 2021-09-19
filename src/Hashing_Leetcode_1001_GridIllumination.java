import java.util.HashMap;

public class Hashing_Leetcode_1001_GridIllumination {
    public static int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> m1 = new HashMap<>();       // row number to count of lamps
        HashMap<Integer, Integer> m2 = new HashMap<>();       // col number to count of lamps
        HashMap<Integer, Integer> m3 = new HashMap<>();       // diagonal x-y to count of lamps
        HashMap<Integer, Integer> m4 = new HashMap<>();       // diagonal x+y to count of lamps
        HashMap<Integer, Integer> m5 = new HashMap<>();       // whether lamp is  ON|OFF

        // increment counters while adding lamps
        for(int i=0; i<lamps.length; i++){
            int x = lamps[i][0];
            int y = lamps[i][1];
            m1.put(x, m1.getOrDefault(x, 0) + 1);
            m2.put(y, m2.getOrDefault(y, 0) + 1);
            m3.put(x-y, m3.getOrDefault(x-y, 0) + 1);
            m4.put(x+y, m4.getOrDefault(x+y, 0) + 1);
            m5.put(N*x + y, m5.getOrDefault(N*x + y, 0) + 1);
        }

        int[] ans = new int[queries.length];
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}, {0,0}};
        // address queries
        for(int i=0; i<queries.length; i++){
            int x = queries[i][0];
            int y = queries[i][1];
            ans[i] = (m1.getOrDefault(x, 0) > 0 || m2.getOrDefault(y, 0) > 0 || m3.getOrDefault(x-y, 0) > 0 || m4.getOrDefault(x+y, 0) > 0) ? 1 : 0;
            // switch off the lamps, if any
            for(int d=0; d<dirs.length; d++){
                int x1 = x + dirs[d][0];   //checking adjacent cells one by one and marking them off
                int y1 = y + dirs[d][1];
                if(x1 >= 0 && y1 >= 0 && x1 < N && y1 < N && m5.containsKey(N*x1 + y1)){
                    int times = m5.get(N*x1 + y1);
                    m1.put(x1, m1.getOrDefault(x1, 1) - times);
                    m2.put(y1, m2.getOrDefault(y1, 1) - times);
                    m3.put(x1 - y1, m3.getOrDefault(x1 - y1, 1) - times);
                    m4.put(x1 + y1, m4.getOrDefault(x1 + y1, 1) - times);
                    m5.remove(N*x1+y1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] lamps = {{0,0},{4,4}};
        int[][] queries = {{1,1},{1,0}};
        int[] temp = gridIllumination(n,lamps,queries);
        for (int i :temp) System.out.print(i+" ");
    }
}
