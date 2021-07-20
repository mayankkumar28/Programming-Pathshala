public class Maths_GFG_LcmGcd {
    static Long[] lcmAndGcd(Long A , Long B) {
        Long[] ans = new Long[2];
        //GCF
        long maxm= Math.max(A,B);
        long minm= Math.min(A,B);
        if (minm==0) {
            ans[1]=maxm;
            return ans;
        }
        while(maxm%minm!=0){
            long temp=maxm;
            maxm=minm;
            minm=temp%minm;
        }
        ans[1]=minm;

        //LCM
//        for(long i = Math.max(A,B); i<=A*B;i++){
//            if (i%A==0 && i%B==0){
//                ans[0]=i;
//                break;
//            }
//        }
        ans[0]=(A/minm)*B;
        System.out.println(ans[0] +" " +ans[1]);
        return ans;
    }
    public static void main(String[] args){
        long A = 44;
        long B = 4;
        lcmAndGcd(A,B);
    }
}
