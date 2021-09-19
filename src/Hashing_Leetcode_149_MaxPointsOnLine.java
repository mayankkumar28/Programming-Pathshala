import java.util.HashMap;
/*
we have to determine max points that fall on a straight line from given list of points
so we can fix a given point and determine all other points that have a same slope
so we can run two for loops, fix a point one by one and find slopes for all other points
we store the slopes in a map to find out how many are equal and inc. the count of slope. we clear our map at the end of loop
as the slope should be exactly equal, we can't use float or double because java checks decimal up to a certain point only
there are few edge cases that should be taken care of
 */

public class Hashing_Leetcode_149_MaxPointsOnLine {
    public static int maxPoints(int[][] points) {
        if (points.length==0) return 0;
        int ans = 1;
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for (int i =0;i<points.length;i++){
            int overlap =0,max =0;
            for (int j =i+1;j<points.length;j++){
                if (points[i][0]==points[j][0] && points[i][1]==points[j][1]) overlap++;  //same point
                else {
                    int x_diff = points[j][0]-points[i][0];
                    int y_diff = points[j][1]-points[i][1];
                    int g = gcd(Math.abs(x_diff),Math.abs(y_diff));
                    int f = x_diff/g;   //removing common num from the diff x and diff y
                    int s = y_diff/g;
                    //standardise to avoid same negatives but seems different, f= num,s=dem
                    if (f==0) s=1;
                    else if (s==0) f=1;
                    else if (s < 0){
                        f *= -1; s *= -1;
                    }
                    if (map.containsKey(f)){
                        if (map.get(f).containsKey(s)){
                            map.get(f).put(s,map.get(f).get(s)+1);
                        }
                        else map.get(f).put(s,1);
                    }
                    else {
                        HashMap<Integer,Integer> m = new HashMap<>();
                        m.put(s, 1);
                        map.put(f, m);
                    }
                    max = Math.max(max,map.get(f).get(s));
                }
            }
            ans = Math.max(ans,max+overlap+1);
            map.clear();
        }
        return ans;
    }

    public static int gcd (int val1,int val2){
        if (val1==0) return val2;
        if (val2==0) return val1;
        int m1 = Math.max(val1,val2);
        int m2 = Math.min(val1,val2);
        if (m1%m2==0) return m2;
        return gcd(m1%m2,m2);
    }

    public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{3,3}};
        System.out.println(maxPoints(points));
    }
}
