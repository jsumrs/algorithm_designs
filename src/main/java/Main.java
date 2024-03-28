
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
