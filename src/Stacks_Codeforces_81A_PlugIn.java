import java.util.Scanner;
import java.util.Stack;

//simply keep checking the top element and popping it in case of duplicates

public class Stacks_Codeforces_81A_PlugIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> st =  new Stack<>();
        for (int i =0; i<s.length();i++){
            if (st.empty()) st.push(s.charAt(i));
            else if (s.charAt(i) == st.peek()) st.pop();
            else st.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (char i : st) sb.append(i);
        System.out.println(sb);
    }
}
