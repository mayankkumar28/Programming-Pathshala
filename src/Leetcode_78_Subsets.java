import java.util.ArrayList;
import java.util.List;

//Total number of subsets will be equal to 2^N
//Each integer in the array will have two outcomes: yes and no
//
public class Leetcode_78_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        recurse(nums,output, new ArrayList<>(),n,0);
        return output;
    }

    public static void recurse(int[] arr,List<List<Integer>> output,ArrayList<Integer> temp,int n,int index){
        //adding the list to the main output list of list
        output.add(new ArrayList<>(temp));
        //System.out.println(output);

        //Running loop for each nums in array
        for (int i = index;i<n;i++){
            //System.out.println("adding " +arr[i]);

            //adding the element to the temp arraylist starting with empty temp arraylist
            temp.add(arr[i]);
            //calling recursive function to indicate yes
            recurse(arr,output,temp,n,i+1);

            //System.out.println("removing " +temp.get(temp.size()-1));

            //Removing the last element from the array to indicate no
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args){
        int[] nums  = {1,2,3};
        System.out.println(subsets(nums));
    }
}
