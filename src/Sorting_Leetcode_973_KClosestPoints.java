/*
We use custom sort to sort the square of the co-ordinates, compare them and sort in ascending order
 */

import java.util.Arrays;
import java.util.Comparator;

class tuple{
    int x;
    int y;
    public tuple(int x,int y){
        this.x=x;
        this.y=y;
    }
}

public class Sorting_Leetcode_973_KClosestPoints {
    public static int[][] kClosest(int[][] points, int k) {
        tuple[] coordinate = new tuple[points.length];
        for (int i = 0;i<points.length;i++){
            coordinate[i]= new tuple(points[i][0],points[i][1]);
        }
        Arrays.sort(coordinate, new Comparator<tuple>() {
            @Override
            public int compare(tuple o1, tuple o2) {
                int d1 = o1.x*o1.x + o1.y*o1.y;   //distance 1
                int d2 = o2.x*o2.x + o2.y*o2.y;   //distance 2
                if (d1!=d2) return d1-d2;         //sort in ascending
                return 0;
            }
        });
        int[][] ans = new int[k][2];
        for (int i =0;i<k;i++){
            ans[i][0]=coordinate[i].x;
            ans[i][1]=coordinate[i].y;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        int[][] temp = kClosest(points,k);
        //Printing
        for (int i=0;i<temp.length;i++){
            for (int j=0;j<2;j++){
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }
    }
}


