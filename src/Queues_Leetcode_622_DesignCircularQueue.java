/*
We use % to take the mod with the size of the array to fully utilize the space
if back is at the last index of array,and if first index of array is empty, an element can be add to 1st index back can point to it
we can maintain an int count to count the numbers of elements present in the array (queue)
as long as count doesn't exceed the length of the array, we are ok to push new elements
 */

public class Queues_Leetcode_622_DesignCircularQueue {
    int[] arr = new int[3];
    int front = 0, back = -1,count=0;

    public boolean enQueue(int value) {
        if (!isFull()){   //checking if count == len of array
            back = (back+1)%arr.length;  //inc. back index
            arr[back] = value;
            count++;
            return true;
        }
        else return false;
    }

    public boolean deQueue() {
        if (!isEmpty()){  //checking if count == 0
            front = (front+1)% arr.length;   //inc. front index
            count--;
            return true;
        }
        else return false;
    }

    public int Front() {
        return isEmpty() ? -1 : arr[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : arr[back];
    }

    public boolean isEmpty() {
        return count==0;
    }

    public boolean isFull() {
        return count==arr.length;
    }
}
