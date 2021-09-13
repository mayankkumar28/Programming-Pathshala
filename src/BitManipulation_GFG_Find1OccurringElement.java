//Taking XOR^ returns 0 if number is same, otherwise the number (if taken with 0) if number is different

public class BitManipulation_GFG_Find1OccurringElement {
    public static int search(int[] A, int N) {
        int ans=0;
        for (int i : A){
            ans = ans^i;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {1, 1, 2, 5, 5};
        System.out.println(search(A,A.length));
    }
}
