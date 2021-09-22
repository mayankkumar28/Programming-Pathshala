import java.util.Stack;

/*
Recursive program to reverse a stack, it can also be done by using 2 other stack and coping 3 times onto one another
for reverse, we keep popping out nums till we reach the end of the array, then num is placed at the bottom of the stack
for placing at bottom, we empty the stack, place the num and fill the stack again again recursively
 */

public class Stacks_GFG_ReverseAStack {
    static Stack<Integer> st = new Stack<>();

    static void reverse (){
        if (st.empty()) return;
        int y = st.peek();
        st.pop();
        reverse();
        push_bottom(y);
    }

    static void push_bottom(int y){
        if (st.empty()){
            st.push(y);
            return;
        }
        int x = st.peek();
        st.pop();
        push_bottom(y);
        st.push(x);
    }

    public static void main(String[] args) {
        st.add(1);st.add(2);st.add(3);st.add(4);
        reverse();
        System.out.println(st);
    }
}
