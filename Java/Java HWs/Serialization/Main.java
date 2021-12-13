import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Company company1 = new Company("Devin", BigDecimal.valueOf(.5));
        Company company2 = new Company("Baldaran", BigDecimal.valueOf(.4));

        for (int i = 1; i <= 20; i++) {
            company1.addBottle(new EmptyBottle(BottleType.PLASTIC, BigDecimal.valueOf(.05)));
        }

        try {
            company1.addWatterIntoBottles(20);
        } catch (InsufficientNumberOfBottlesException e) {
            e.printStackTrace();
        }

        try {
            Invoice invoice1 = company1.sellBottledWater(10, company2);
            invoice1.writeInvoice();

            Invoice invoice2 = company1.sellBottledWater(10, company2);
            invoice2.writeInvoice();

            List<String> invoice1Content = invoice1.readInvoice("files/Invoice 1.txt");
            List<String> invoice2Content = invoice2.readInvoice("files/Invoice 2.txt");

            for (String line : invoice1Content) {
                System.out.println(line);
            }

            for (String line : invoice2Content) {
                System.out.println(line);
            }
        } catch (InsufficientNumberOfBottlesException e) {
            e.printStackTrace();
        }

        EmptyBottle emptyBottle = new EmptyBottle(BottleType.PLASTIC, BigDecimal.valueOf(0.07));

        String fileName = "emptyBottle.ser";

        // Serializing empty bottle
        emptyBottle.serialize(fileName);

        // Deserializing empty bottle
        System.out.println(emptyBottle.deserialize(fileName));
    }
}
