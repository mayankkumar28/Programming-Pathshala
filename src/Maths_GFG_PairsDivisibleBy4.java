public class Maths_GFG_PairsDivisibleBy4 {
    public static int count4Divisibiles(int[] arr, int n ){

        //storing remainder of each element in array in count[] when divided by n
        int[] count = new int[n];
        for (int i=0;i<n;i++){
            count[i]=0;
        }
        for (int i=0;i<arr.length;i++){
            count[arr[i]%n]++;
        }
        
        //for pairs having remainder zero. Pick pair from this bucket only. Using P&C, total pairs=n*(n-1)/2
        int ans=0;
        ans += (count[0]*(count[0]-1))/2;

        //for non-zero paris
        for (int i =1;i<=(n/2)-1;i++){
            ans += count[i]*count[n-i];
        }


        //for even numbers k/2 will not match will other remainder buckets.So we have to pick a pair from here itself.
        if (n%2==0) ans +=(count[n/2]*(count[n/2]-1))/2;

        //for odd number the usual
        else ans+=count[n/2]*count[(n/2)+1];
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {20,16,11,16,14};
        System.out.println(count4Divisibiles(arr,4));
    }
}
