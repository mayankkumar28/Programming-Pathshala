import java.util.Arrays;

public class Arrays_Leetcode_567_PermutationInString {
    public static boolean checkInclusion(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1<=0 || n2<=0 || n1>n2) return false;
        int[] array1 = new int[26];
        int[] array2 = new int[26];

        //First window
        for (int i=0; i<n1; i++){
            array1[s1.charAt(i)-'a']++;
            array2[s2.charAt(i)-'a']++;
        }

        //Comparing first window
        if (Arrays.equals(array1,array2)){
            System.out.println("here1");
            return true;
        }
        //sliding windows and comparing
        for (int i=n1; i<n2; i++){
            array2[s2.charAt(i-n1)-'a']--;
            array2[s2.charAt(i)-'a']++;
            if (Arrays.equals(array1,array2)){
                System.out.println("here2");
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        String s1 = "axc";
        String s2 = "abczzxc";
        System.out.println(checkInclusion(s1,s2));
    }
}
