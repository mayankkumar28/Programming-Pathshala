/*
Very complicated maths problem
The maximum term count can be 63 because 2^63 is ~= 10^18. We check for largest first because it will give smallest base first
we binary search as limiting number of terms is monotonic
if value for mid is less that means all terms lesser than id will also be less and vice-versa
 */

public class Searching_Leetcode_483_SmallestGoodBase {
    public static String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        for (int i =63; i>=1; i--){
            long low =2, high = num-1;
            while ( low <= high){
                long mid = low+(high-low)/2;
                long val =0,x =1, flag= 0;
                for (int j =0; j<=i;j++){
                    val += x;
                    if (val>=num) break;
                    if (j < i && (num-val)/x < mid){  //prevents overflow
                        flag =1;
                        break;
                    }
                    if (j<i) x*=mid;
                }
                if (val>num || flag==1) high=mid-1;  //flag indicates overflow so value was larger
                else if (val<num) low =mid+1;
                else return String.valueOf(mid);
            }
        }
        return String.valueOf(0);
    }



    public static void main(String[] args) {
        System.out.println(smallestGoodBase("13"));
    }
}
