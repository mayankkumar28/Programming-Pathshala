//Tree =>
//
//           root                   start from abc... first loop is =>
//      'A'       'B'               add a, dec count of a, one a,one b left
//     /   \        \
//   A'A'  A'B'      B'A'           add a, dec count of a, one b left
//    /     \          \
// AA'B'    AB'A'      BA'A'        add b,backtrack and restore count of b,


public class Backtracking_Leetcode_1079_LetterTilePossibilities {
    public static int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) count[c - 'A']++;  //Storing counts of each char
        return backtrack(count);
    }
    public static int backtrack(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;  //char not present in tiles
            sum++;
            arr[i]--;
            sum += backtrack(arr);
            arr[i]++;
        }
        return sum;
    }

    public static void main(String[] args){
        String tiles="AAB";
        System.out.println(numTilePossibilities(tiles));
    }
}
