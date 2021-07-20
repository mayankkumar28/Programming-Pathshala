class Arrays_Leetcode_769_maxChunks {
    public static int maxChunksToSorted(int[] arr){
        int cmax = Integer.MIN_VALUE;
        int chunks = 0;
        if (arr.length==0) return 0;
        for (int i =0; i<arr.length;i++){
            cmax = Math.max(cmax,arr[i]);
            if (cmax == i){
                chunks++;
            }
        }
        return chunks;
    }
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1,0};
        System.out.println(maxChunksToSorted(arr));
    }
}
