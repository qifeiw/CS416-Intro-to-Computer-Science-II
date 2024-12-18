public class Counter implements Freezable {
    private int count;
    private int amount;
    private boolean frozen;
    public Counter(int count, int amount) {
        this.count = count;
        this.amount = amount;
        this.frozen = false;
    }
    public void increment() {
        if (!frozen) {
            count += amount;
        }

    }
    public void freeze() {
        frozen = true;
    }
    public void unfreeze() {
        frozen = false;
    }
    public int getCount() {
        return count;
    }
}
