import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<EmptyBottle> emptyBottleList;
    private List<BottleOfWater> bottleOfWaterList;
    private List<Invoice> invoiceList;
    private BigDecimal bottleWithWaterPrice;

    public Company(String name, BigDecimal bottleWithWaterPrice) {
        this.name = name;
        this.bottleWithWaterPrice = bottleWithWaterPrice;
        this.emptyBottleList = new ArrayList<EmptyBottle>();
        this.bottleOfWaterList = new ArrayList<BottleOfWater>();
        this.invoiceList = new ArrayList<Invoice>();
    }

    public String getName() {
        return name;
    }

    public void addBottle(EmptyBottle emptyBottle) {
        this.emptyBottleList.add(emptyBottle);
    }

    public void addBottleOfWater(BottleOfWater bottleOfWater) {
        this.bottleOfWaterList.add(bottleOfWater);
    }

    public void removeBottle(EmptyBottle emptyBottle) {
        this.emptyBottleList.remove(emptyBottle);
    }

    public void removeBottleOfWater(BottleOfWater bottleOfWater) {
        this.bottleOfWaterList.remove(bottleOfWater);
    }

    public void addInvoice(Invoice invoice) {
        this.invoiceList.add(invoice);
    }

    // Add watter to the empty bottles
    public void addWatterIntoBottles(int numberOfBottles) throws InsufficientNumberOfBottlesException {
        if (this.emptyBottleList.size() < numberOfBottles) {
            throw new InsufficientNumberOfBottlesException(this.emptyBottleList.size());
        } else {
            for (int i = numberOfBottles - 1; i >= 0; i--) {
                this.bottleOfWaterList.add(new BottleOfWater(bottleWithWaterPrice));
                this.emptyBottleList.remove(i);
            }
        }
    }

    // Return invoice when selling the bottles with watter
    public Invoice sellBottledWater(int numberOfBottles, Company buyer) throws InsufficientNumberOfBottlesException {
        Invoice invoice = new Invoice(this, buyer);
        if (this.bottleOfWaterList.size() < numberOfBottles) {
            throw new InsufficientNumberOfBottlesException(this.bottleOfWaterList.size());
        } else {
            for (int i = numberOfBottles - 1; i >= 0; i--) {
                invoice.addBottlesToInvoice(this.bottleOfWaterList.remove(i));
            }
        }
        return invoice;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
