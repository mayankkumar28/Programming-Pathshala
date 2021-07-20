//My logic is to first find the first letter of word required in the board by using two for-loops
//When found, we get our starting point. Here we call search to find other letters in the board.
//We use count to update our length of string
//We return when string we are searching is not more than the length of the word
//We check the boundary conditions and if the next char in our string is equal to that of word or not
//If found it, we return true, else search for the next starting point and so on.. till we reach end

public class Backtracking_Leetcode_79_WordSearch {
    public static boolean exist(char[][] board, String word){

        //Seraching for starting point
        for (int i = 0;i< board.length;i++){
            for (int j = 0; j< board[0].length;j++){
                if (board[i][j]==word.charAt(0)){  //Found and searching next through backtracking
                    if (search(board,i,j,word,0)) return true;  //Found the word
                }
            }
        }
        return false;
    }

    public static boolean search(char[][] board,int i,int j,String word,int count){
        if (count==word.length()){   //Length of word reached and found the word
            return true;
        }

        //checking boundary conditions and next char in word is equal to the next char in that direction or not
        if (i== -1 || j== -1 || i==board.length || j== board[0].length || board[i][j] != word.charAt(count)) {
            return false;
        }

        char org = board[i][j];  //to mark as visited
        board[i][j]='1';  //marking visited

        //If search in any direction is found true, we return true
        boolean found = search(board,i,j+1,word,count+1) ||   //search right
                        search(board,i+1,j,word,count+1) ||   //search down
                        search(board,i,j-1,word,count+1) ||   //search left
                        search(board,i-1,j,word,count+1);     //search up

        board[i][j]=org;   //un-marking visited
        return found;
    }


    public static void main(String[] args){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word= "ABCCED";
        System.out.println(exist(board,word));
    }
}
