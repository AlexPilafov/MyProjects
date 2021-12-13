import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Receipt extends Cash_Register {
    private int receipt_id;
    private static int numberOfReceipts = 0;

    public Receipt(Cashier current_cashier, List<Goods> Selling_List) {
        super(current_cashier);
        numberOfReceipts++;
        this.receipt_id = numberOfReceipts;
        this.current_cashier = current_cashier;
        this.Selling_List = Selling_List;
    }

    public String getDate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
        String date = myDateObj.format(myFormatObj);
        return date;
    }

    public int getReceipt_id() {
        return receipt_id;
    }

    public static int getTotal_receipts() {
        return numberOfReceipts;
    }

    public void saveToFile() {
        try {
            String filename = String.valueOf("receipt"+ getReceipt_id() + ".txt");
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write("Receipt "+ getReceipt_id() + "\n" + String.valueOf(getSelling_List()) + "\nTotal= " + total() + currency);
            myWriter.close();
            System.out.println("Successfully wrote to " + filename + " file.");
        } catch (IOException e) {
            System.out.println("ERROR - IOException (Input/Output).");
            e.printStackTrace();
        }
    }

    public void openFile(String fileName) {
        try (var scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }catch (IOException e) {
            System.out.println("ERROR - File not found.");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "Receipt number=" + receipt_id +
                ", current time and date ='" + getDate() + '\'' +
                ", current_cashier=" + current_cashier +
                ",\nSelling_List=" + Selling_List +
                "\nTotal= " + total() + currency;
    }
}


