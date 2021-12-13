public class Element extends Material {
    public static double kg;
    public int quantity;

    public Element(double kg, int quantity) {
        this.kg = kg;
        this.quantity = quantity;
    }

    public static double elementWeight() {
        double weight = kg;
        return weight;
    }

    public boolean isFragile() {
        if (fragile = true) {
            System.out.println("This material is fragile. Be careful!");
            return true;
        } else {
            System.out.println("This material is NOT fragile.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Element{" +
                "quantity=" + quantity +
                ", kg=" + kg +
                '}';
    }
}

