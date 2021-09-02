/*
Using a class pair to create tuples of element and frequency
We want larger freq first and if same freq, then smaller value
We assign freq and nums array to our pair array and then sort them using the comparator function
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class pair{
    int element;
    int freq;
    public pair(int num, int i) {   //Constructor
        this.element=num;
        this.freq = i;
    }
}

public class Sorting_GFG_SortingArrayFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t!=0){
            int n = sc.nextInt();
            int[] nums = new int[n];
            int[] freq = new int[61];
            for (int i =0;i<n;i++){
                nums[i]=sc.nextInt();
                freq[nums[i]]++;
            }
            pair[] pairs = new pair[n];
            for (int i =0;i<n;i++){
                pairs[i] = new pair(nums[i],freq[nums[i]]);
            }

            Arrays.sort(pairs, new Comparator<pair>() {
                @Override public int compare(pair pair1, pair pair2)  //returns 1 if first > second
                {
                    if (pair1.freq != pair2.freq){
                        return pair2.freq-pair1.freq;   //Sorting in descending order
                    }
                    if (pair1.element != pair2.element){
                        return pair1.element-pair2.element;   //Sorting in ascending order
                    }
                    return 0;  //equal
                }
            });

            for (int i = 0; i<pairs.length;i++){
                System.out.print(pairs[i].element +" ");
            }
            System.out.println();
            t--;
        }
    }
}


