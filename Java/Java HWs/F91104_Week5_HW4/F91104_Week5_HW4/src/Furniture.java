public class Furniture extends Item {
    public String manufacturer;
    private static final int maxkg = 50;

    private double bigitems;

    public double shippingPrice() {
        if (isFragile() == true && kg > maxkg) {
            bigitems = shippingPrice() + shippingPrice() * 1.5 / 100;
            return bigitems;
        } else {
            return shippingPrice();
        }
    }
}
