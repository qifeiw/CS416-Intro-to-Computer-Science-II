public class SelectionSort extends Sort {
    public SelectionSort(String fileName) {
        super(fileName);
    }

    @Override
    public void sort() {
        int n = samples.size();
        for (int i = 0; i < n - 1; i++) {
            int max_index = i;
            for (int j = i + 1; j < n; j++) {
                if (samples.get(j).measurement > samples.get(max_index).measurement) {
                    max_index = j;
                }
            }
            Sample temp = samples.get(max_index);
            samples.set(max_index, samples.get(i));
            samples.set(i, temp);
        }
    }
}
