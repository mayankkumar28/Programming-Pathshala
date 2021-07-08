import java.util.ArrayList;
import java.util.List;

//Watch video on Tower of Hanoi for understanding
//Recursive function,for 4 plates we solve firsts for 3 plates,then 2 and 1
//Storing all moves in a List of List answer

public class GFG_TowerOfHanoi {
    public static void main(String[] args){
        System.out.println(shiftPile(3,4));
    }
     static List<Integer> shiftPile(int N, int n){
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        recurse(N,1,3,2,answer,temp);
        return answer.get(n-1); //Finding the required move in List of List
     }

     public static void recurse(int N,int from,int to,int aux,ArrayList<ArrayList<Integer>> answer,ArrayList<Integer> temp){
         temp.clear();

         if (N==1){

             temp.add(from);
             temp.add(to);
             answer.add(new ArrayList<>(temp));

             return;
         }
         //First solving where we first all N-1 plates in the auxiliary place
         recurse(N-1,from,aux,to,answer,temp);

         temp.clear();
         temp.add(from);
         temp.add(to);
         answer.add(new ArrayList<>(temp));
         //Now we put all plates from aux to final place
         recurse(N-1,aux,to,from,answer,temp);
     }
}
