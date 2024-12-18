/**
 * @author Qifei Wang
 * @version 1
 */

public class BubbleSort extends Sort {
    public BubbleSort(String fileName) {
        super(fileName);
    }

    @Override
    public void sort() {
        int n = samples.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (samples.get(j).measurement < samples.get(j + 1).measurement) {
                    Sample temp = samples.get(j);
                    samples.set(j, samples.get(j + 1));
                    samples.set(j + 1, temp);
                }
            }
        }

    }

    public static void main(String[] args) {
        Sort b = new BubbleSort("data.csv");
        b.sort();
        System.out.println(b);
    }
}