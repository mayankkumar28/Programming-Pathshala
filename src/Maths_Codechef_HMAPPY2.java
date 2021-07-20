import java.util.Scanner;

class Maths_Codechef_HMAPPY2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t !=0){
            long n = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();
            long k = sc.nextLong();
            long they_solve = (n/a)+(n/b)-2*(n/lcm(a,b));
            if (they_solve>=k) System.out.println("Win"+they_solve);
            else System.out.println("Lose" +they_solve);
            t--;
        }
    }

    public static long lcm(long a,long b){
        long maxm = Math.max(a,b);
        long minm = Math.min(a,b);
        if (minm == 0) return 0;
        while (maxm%minm != 0){
            long temp = maxm;
            maxm=minm;
            minm = temp%minm;
        }
        System.out.println("lcm =" +(a/minm)*b);
        return (a/minm)*b;
    }
}

