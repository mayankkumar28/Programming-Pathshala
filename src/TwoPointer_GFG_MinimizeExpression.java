//Taking three pointers, inc. the minimum first, till any one of the pointer reaches end of it's array

public class TwoPointer_GFG_MinimizeExpression {
    public static int min_expression(int[] a,int[] b, int[] c){
        int i =0,j=0,k=0;
        int ans = Integer.MAX_VALUE;
        while(i < a.length && j<b.length && k< c.length){
            int val = Math.max(a[i],Math.max(b[j],c[k])) - Math.min(a[i], Math.min(b[j],c[k]));  //Expression
            ans = Math.min(ans,val);  //Minimize the expression
            int minm = Math.min(a[i], Math.min(b[j],c[k]));  //deciding which one is least
            //inc. all least
            if (a[i] == minm) i++;
            else if (b[j] == minm ) j++;
            else k++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = { 5, 8, 10, 15 };
        int[] b = { 6, 9, 15, 78, 89 };
        int[] c = { 2, 3, 6, 6, 8, 8, 10 };
        System.out.println(min_expression(a,b,c));
    }
}
