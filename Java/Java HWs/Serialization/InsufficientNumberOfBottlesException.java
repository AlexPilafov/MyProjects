public class InsufficientNumberOfBottlesException extends Exception {
    private int maxNumberOfBottles;

    public InsufficientNumberOfBottlesException(int maxNumberOfBottles) {
        this.maxNumberOfBottles = maxNumberOfBottles;
    }

    public int getMaxNumberOfBottles() {
        return maxNumberOfBottles;
    }

    @Override
    public String toString() {
        return "InsufficientNumberOfBottlesException{" +
                "maxNumberOfBottles=" + maxNumberOfBottles +
                '}';
    }
}
