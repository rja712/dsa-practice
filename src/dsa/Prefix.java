package dsa;

public class Prefix {

    private int[] prefix;

    public Prefix(int[] array) {
        prefix = new int[array.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < array.length; i++) {
            prefix[i + 1] = prefix[i] + array[i];
        }
    }

    public int rangeSum(int left, int right) {

        return prefix[right + 1] - prefix[left];

    }
}
