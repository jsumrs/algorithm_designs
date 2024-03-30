import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int size = 100;
        double[] array = makeArray(100);

        System.out.println(Arrays.toString(array));
        InsertionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static double[] makeArray(int size){
        double[] arr = new double[size];

        for (int i = 0; i < arr.length; i++){
            arr[i] = Math.round(((Math.random() * size) * 100)) / 100.0;
        }
        return arr;
    }

    static class InsertionSort {
        public static void sort(double[] arr) {
            if (arr.length < 2) {
                return;
            }

            long start = System.nanoTime();
            for (int i = 1; i < arr.length; i++){
                if (arr[i] < arr[i-1]) {
                    int j = i;
                    while(j > 0 && arr[j] < arr[j - 1]) {
                        double temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j - 1] = temp;
                        j--;
                    }
                }
            }
            long end = System.nanoTime();
            System.out.println(end - start);
        }

    }

    /***
     * This class holds all the logic for a variation of mergesort that merges using a linked list.
     */
    static class LinkedMergeSort {

        public static void sort(double[] arr) {
            Node head = linkedSplit(arr, 0, arr.length - 1);

            rearrangeArray(arr, head);
        }

        public static void rearrangeArray(double[] arr, Node head) {
            for (int i = 0; i < arr.length; i++){
                if (head != null) {
                    arr[i] = head.value;
                    System.out.print(head + " ");
                    head = head.next;
                }
            }
        }

        public static Node linkedSplit(double[] arr, int start, int end) {
            System.out.println("start: " + start + " end: " + end);
            if (end - start <= 0){
                return null;
            }
            if (end - start == 1) {
                System.out.println("if ");
                return new Node(arr, start);
            }
            Node firstHalf = linkedSplit(arr, start, end / 2);
            System.out.println("first half complete. " + "start: " + start + " end: " + end);
            Node secondHalf = linkedSplit(arr, (end / 2) + 1, end);
            System.out.println("second half complete. " + "start: " + start + " end: " + end);

            return linkedMerge(firstHalf, secondHalf);
        }

        public static Node linkedMerge(Node x, Node y){
            Node head = null;
            Node tail = null;

            while (x != null && y != null) {
                if (x.compareTo(y) <= 0){
                    if (head == null){
                        head = x;
                        tail = x;
                    } else {
                        tail.next = x;
                        x.prev = tail;
                        tail = x;
                    }
                    x = x.next;
                } else {
                    if (head == null) {
                        head = y;
                        tail = y;
                    } else {
                        tail.next = y;
                        y.prev = tail;
                        tail = y;
                    }
                    y = y.next;
                }
            }
            if (x != null) {
                tail.next = x;
                x.prev = tail;
            } else if (y != null) {
                tail.next = y;
                y.prev = tail;
            }
            return head;
        }
    }




}

class Node implements Comparable<Node>{

    Node prev;
    Node next;

    double[] array; // reference to the array that is being sorted.
    int index;
    double value;

    /***
     *
     * @param index The index to this node's value in {@code array}.
     * @param array The array that is being sorted.
     */
    public Node (double[] array, int index) {
        next = null;
        this.array = array;
        this.index = index;
        value = array[index];
    }

    /***
     * Travel to the end of the linked list and append the node to it.
     * @param node The node to append the to the end of the list.
     */
    public void append(Node node) {
        if (next != null) {
            next.append(node);
        } else {
            next = node;
            node.prev = this;
        }
    }

    /***
     * Insert the node right before this node.
     * @param node The node to be inserted.
     */
    public void insertBefore(Node node) {
        if (node != null) {
            if (prev != null) {
                prev.next = node;
                node.next = this;
            }
            else {
                node.next = this;
            }
        }
    }

    @Override
    public int compareTo(Node n) {
        return Double.compare(this.value, n.value);
    }

    @Override
    public String toString() {
        return value + "@[" + index + "]";
    }
}
