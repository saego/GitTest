public class Main {

    public static void main(String[] args) {

        int[][] array = new int[][]{{1, 3}, {4, 5, 6}, {7, 9, 10}, {1}, {2}};

        IteratorDoubleArray it = new IteratorDoubleArray(array);

        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
