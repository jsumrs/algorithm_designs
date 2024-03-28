
public class Main {

    public static void main(String[] args) {
        int size = 100;
        double[] arrayOfDoubles = makeArray(100);

    }

    public static double[] makeArray(int size){
        double[] arr = new double[size];

        for (int i = 0; i < arr.length; i++){
            arr[i] = Math.random() * size;
        }
        return arr;
    }
}

class Node{
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
    public Node (int index, double[] array) {
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
        }
    }

    /***
     * Insert the node right before this node.
     * @param node The node to be inserted.
     */
    public void insertBefore(Node node) {
        if (prev != null){

        }
    }


}
