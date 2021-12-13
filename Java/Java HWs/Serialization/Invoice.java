
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private int number;
    private Company seller;
    private Company buyer;
    private LocalDate deliveryDate;
    private List<BottleOfWater> bottleOfWaterList;
    private static int numberOfInvoices = 0;

    public Invoice(Company seller, Company buyer) {
        numberOfInvoices++;
        this.number = numberOfInvoices;
        this.seller = seller;
        this.buyer = buyer;
        this.deliveryDate = LocalDate.now();
        this.bottleOfWaterList = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public Company getSeller() {
        return seller;
    }

    public Company getBuyer() {
        return buyer;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public static int getNumberOfInvoices() {
        return numberOfInvoices;
    }

    public void addBottlesToInvoice(BottleOfWater bottleOfWater) {
        this.bottleOfWaterList.add(bottleOfWater);
    }

    // Return the total value of the invoice
    public BigDecimal totalValue() {
        BigDecimal totalValue = BigDecimal.valueOf(0);
        for (BottleOfWater bottleOfWater : bottleOfWaterList) {
            totalValue = totalValue.add(bottleOfWater.getPrice());
        }
        return totalValue;
    }

    // Write invoice to file
    public void writeInvoice() {
        File file = new File("files");
        file.mkdir();
        try (FileWriter fileWriter = new FileWriter(file.getName() + "/Invoice " + this.number + ".txt")) {
            fileWriter.write("Invoice " + this.number + System.lineSeparator());
            fileWriter.write("Seller " + this.seller + System.lineSeparator());
            fileWriter.write("Buyer " + this.buyer + System.lineSeparator());
            fileWriter.write("Date " + this.deliveryDate + System.lineSeparator());
            fileWriter.write("Bottles of Watter:");
            for (BottleOfWater bottleOfWater : this.bottleOfWaterList) {
                fileWriter.write(bottleOfWater + " * " + bottleOfWater.getPrice()
                        + System.lineSeparator());
            }
            fileWriter.write("Total Value " + this.totalValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read invoice from file
    public List<String> readInvoice(String fileName) {
        List<String> invoiceLines = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileName)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                invoiceLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return invoiceLines;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "number=" + number +
                ", seller=" + seller +
                ", buyer=" + buyer +
                ", deliveryDate='" + deliveryDate + '\'' +
                '}';
    }
}
