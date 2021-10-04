import java.util.HashMap;

public class LinkedList_Leetcode_146_LRUCache {
    HashMap<Integer,Node> keyToAddress = new HashMap<>();
    int currSize, maxSize;
    Node head, tail;

    public LinkedList_Leetcode_146_LRUCache(int capacity) {
        maxSize = capacity;
        currSize = 0;
        head = null; tail = null;
    }

    public int get(int key) {
        int ans;
        if (!keyToAddress.containsKey(key)) ans = -1;
        else {
            Node n = keyToAddress.get(key);
            ans = n.value;
            moveToTail(n,n.value);
        }
        return ans;
    }

    public void put(int key, int value) {
        if (keyToAddress.containsKey(key)){
            moveToTail(keyToAddress.get(key), value);
            return;
        }
        if (currSize<maxSize){
            keyToAddress.put(key,addToTail(key,value));
        }
        else {
            keyToAddress.remove(head.key);
            deleteAtHead();
            keyToAddress.put(key,addToTail(key,value));
        }
    }

    public Node addToTail(int key,int value){
        Node temp = new Node(key,value);
        if (tail == null) {
            head = temp;
            tail = temp;
        }
        else {
            tail.next = temp;
            temp.prev =tail;
            tail = temp;
        }
        currSize++;
        return tail;
    }

    public void moveToTail (Node temp, int value){
        temp.value = value;
        if (temp == tail) return;
        if (temp == head){
            head = head.next;
            head.prev = null;
        }
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        temp.prev = tail;
        temp.next = null;
        tail.next = temp;
        tail = temp;
    }

    public void deleteAtHead (){
        Node temp = head;
        head = head.next;
        if (head != null) head.prev = null;
        else tail = head;
        temp.next = null;
        temp.prev = null;
        currSize--;
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node (int key, int value){ this.key = key;this.value = value;}
    }
}
