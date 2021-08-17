/*
Doubt = why can't i return -1 instead of low
We have to minimize the number of pages each student gets, and each students gets at least one book
The range will lie between the highest pages in a book and sum of all pages of the book (all books given to one student)
We can check for a specific pages between in this range, if the pages are possible, we shift left to search for min. pages
else we shift to right because if a no. of pages can't be assigned (we ran out of students) , all pages less than that will also be not possible
Due to this monotonicity we can use binary search
For checking pages possibility we keep adding pages till it is less than our desired mid(pages)
if it gets more than that we assign that to next student and inc. student count
if at end of loop, our student count is less than students, we were able to assign each student a book and return true
 */


public class Searching_GFG_AllocateTheBooks {
    public static int findPages(int[]a,int n,int m){
        if (m>n) return -1; //no. of students > books, not possible
        int low = a[0], high = 0;
        for (int i : a) {
            low = Math.max(low,i); //max pages assigned to one student
            high += i; //all pages assigned to one student
        }

        while(low <= high){
            int mid = low+(high-low)/2;
            if (!isPos(a,mid,m)) low = mid+1;  //checking if current pages are possible
            else {
                if (!isPos(a,mid-1,m)) return mid;  //checking if less pages are possible
                else high = mid-1;
            }
        }
        return low;  //?? WHY LOW
    }

    public static boolean isPos (int[] a, int mid,int m){
        int count = 1, sum=0;
        for (int i =0; i < a.length; i++){
            if (sum+a[i] > mid){   //assigning this to next student
                count++;
                sum = a[i];
            }
            else sum += a[i];  //assigning to next student
        }
        return count <= m;  //student count less than equal to  actual student = possible
    }

    public static void main(String[] args) {
        int[] a = {12,34,67,90};
        int n = a.length, m = 2;
        System.out.println(findPages(a,n,m));
    }
}
