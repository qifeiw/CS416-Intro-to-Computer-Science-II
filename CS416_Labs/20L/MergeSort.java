public class MergeSort extends Sort {
    public MergeSort(String fileName) {
        super(fileName);
    }

    @Override
    public void sort() {
        if (samples.size() > 1) {
            mergeSort(0, samples.size() - 1);
        }
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(left, middle);
            mergeSort(middle + 1, right);
            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        Sample[] leftArray = new Sample[n1];
        Sample[] rightArray = new Sample[n2];
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = samples.get(left + i);
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = samples.get(middle + 1 + j);
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].measurement >= rightArray[j].measurement) {
                samples.set(k, leftArray[i]);
                i++;
            } else {
                samples.set(k, rightArray[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            samples.set(k, leftArray[i]);
            i++;
            k++;
        }

        while (j < n2) {
            samples.set(k, rightArray[j]);
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Sort b = new MergeSort("data.csv");
        b.sort();
        System.out.println(b);
    }
}