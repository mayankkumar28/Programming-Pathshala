class Arrays_Leetcode_768_maxChunks2 {
    public static int maxChunksToSorted(int[] arr){
        int chunk=1;
        int pmax = Integer.MIN_VALUE;
        int[] smin = new int[arr.length];
        if (arr.length==0) return 0;

        smin[arr.length-1]=arr[arr.length-1];
        for (int i = arr.length-2;i>=0;i--){
            smin[i]=Math.min(smin[i+1],arr[i]);
        }
        for (int i =0;i< arr.length-1;i++){
            pmax = Math.max(pmax,arr[i]);
            if(pmax<=smin[i+1]) chunk++;
        }
        return chunk;
    }
    public static void main(String[] args){
        int[] arr = {2,1,3,4,4};
        System.out.println(maxChunksToSorted(arr));
    }
}
