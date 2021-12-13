import java.math.BigDecimal;

public class BottleOfWater {
    private BigDecimal price;

    public BottleOfWater(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "BottleOfWater{" +
                "price=" + price +
                '}';
    }
}
