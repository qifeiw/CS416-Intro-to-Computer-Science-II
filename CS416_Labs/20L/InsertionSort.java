public class InsertionSort extends Sort {
    public InsertionSort(String fileName) {
        super(fileName);
    }

    @Override
    public void sort() {
        int n = samples.size();
        for (int i = 1; i < n; i++) {
            Sample curr = samples.get(i);
            int j = i - 1;
            while (j >= 0 && samples.get(j).measurement < curr.measurement) {
                samples.set(j + 1, samples.get(j));
                j = j - 1;
            }
            samples.set(j + 1, curr);
        }
    }
}
