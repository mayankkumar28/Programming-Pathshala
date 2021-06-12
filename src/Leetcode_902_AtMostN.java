

//Incomplete


import java.util.ArrayList;

public class Leetcode_902_AtMostN {
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        int length = digits.length;
        int[] nums =new int[length];

        for(int i=0; i<length; i++) {
            nums[i] = Integer.parseInt(digits[i]);
            System.out.print(nums[i]+" ");
        }
        System.out.println();

        int temp=n;
        ArrayList<Integer> target = new ArrayList<>();

        while (temp!=0) {
            target.add(temp%10);
            temp=temp/10;
        }
        System.out.println(target);

        int ans1 =0;
        for (int i =0;i<target.size();i++){
            int count=0;
            for(int j=0;j<length;j++){
                System.out.println(target.get(i) +" " +nums[j]);
                if (target.get(i)>nums[j]) {
                    System.out.println("yes");
                    count++;
                    ans1+= count*i*length;
                }
            }
            System.out.println("ans1= " +ans1);
        }

        for (int i =1;i<target.size();i++) {
            ans1+= Math.pow(length,i);
            System.out.println("power ans= "+ans1);
        }

        return ans1;

    }
    public static void main(String[] args){
//        String[] digits= {"3","5"};
//        int n =4;
//        String[] digits= {"1","3","5","7"};
//        int n =100;
//        String[] digits= {"1","3","5","7"};
//        int n =150;
        String[] digits= {"3","4","8"};
        int n =400;
        System.out.println(atMostNGivenDigitSet(digits,n));
    }
}
