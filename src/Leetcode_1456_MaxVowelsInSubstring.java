public class Leetcode_1456_MaxVowelsInSubstring {
    public static int maxVowels(String s, int k) {
        int n = s.length();
        if (n<=0) return 0;
        int count=0;
        int answer;
        for (int i=0;i<k;i++){
            char temp = s.charAt(i);
            if (temp== 'a'|| temp == 'e' || temp== 'i'|| temp == 'o'||temp== 'u' ){
                count++;
            }
        }
        answer=count;

        for (int i=k;i<n;i++){
            char temp = s.charAt(i-k);
            if (temp== 'a'|| temp == 'e' || temp== 'i'|| temp == 'o'||temp== 'u' ){
                count--;
            }
            temp=s.charAt(i);
            if (temp== 'a'|| temp == 'e' || temp== 'i'|| temp == 'o'||temp== 'u' ){
                count++;
            }
            answer=Math.max(answer,count);
        }
        return answer;
    }
    public static void main(String[] args){
        String s = "aeiou";
        int k = 4;
        System.out.println(maxVowels(s,k));
    }
}
