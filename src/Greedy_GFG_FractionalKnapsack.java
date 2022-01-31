import java.util.Arrays;

//simply take the items with highest value/weight first and then fill the remaining fraction with next highest

public class Greedy_GFG_FractionalKnapsack {
    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.value*a.weight - a.value*b.weight);
        int weight = 0;
        double value =0;
        for (int i =0; i<n; i++){
            if (weight + arr[i].weight  <= W){
                weight += arr[i].weight;
                value += arr[i].value;
            }
            else {
                int remaining_weight = W-weight;
                double fraction = (arr[i].value * 1.0 * remaining_weight)/arr[i].weight;
                value += fraction;
                break;
            }
        }
        return value;
    }

    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
}
