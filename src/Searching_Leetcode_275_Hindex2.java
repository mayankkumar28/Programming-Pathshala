/*
A bit tricky to understand the question
H index of value 5 will mean that out of total papers, at-least 5 papers are having citations greater or equal than 5
for arr [0,1,4,5,6] 3 is the optimal answer because there are exactly 3 papers having citations more than 3.
4 is not an answer as 4 papers don't have 4 citations.
for this 1 can also be the answer as there are at-least 1 paper having citations greater or equal than 1.
Similarly, 2 is also an answer. so all values less than equal 3 are answers but h-index will be the max i.e. 3
If we are not able to find an exact value where arr[i] at-least have arr[i] papers, we return values less than that
which will be low-n, which means number of elements present in array after low. Which element after 1 : 4,5,6, total 3
 */

public class Searching_Leetcode_275_Hindex2 {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int low =0,high=n-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if (citations[mid] == (n-mid)) return citations[mid];  //h-index found in array
            else if (citations[mid] > (n-mid)) high = mid-1; //more citations than papers to right
            else low = mid+1; //less citations than papers to right
        }
        return n-low;  //no h-index found, return number of elements to the right
    }

    public static void main(String[] args){
        int[] citations= {0,1,3,5,6};
        System.out.println(hIndex(citations));
    }
}
