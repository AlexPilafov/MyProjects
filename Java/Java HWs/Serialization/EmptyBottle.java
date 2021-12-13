import java.io.*;
import java.math.BigDecimal;

public class EmptyBottle implements Serializable {
    private BottleType bottleType;
    private BigDecimal price;

    public EmptyBottle(BottleType bottleType, BigDecimal price) {
        this.bottleType = bottleType;
        this.price = price;
    }

    public BottleType getBottleType() {
        return bottleType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    // Serializing empty bottle
    public void serialize(String fileName) {
        File file = new File("files");
        file.mkdir();
        try (FileOutputStream fileOutputStream = new FileOutputStream(file.getName() + "/" + fileName);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
            outputStream.writeObject(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserializing empty bottle
    public EmptyBottle deserialize(String fileName) {
        EmptyBottle emptyBottle = null;
        try (FileInputStream fileInputStream = new FileInputStream("files/" + fileName);
             ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);) {

            emptyBottle = (EmptyBottle) inputStream.readObject();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emptyBottle;
    }


    @Override
    public String toString() {
        return "EmptyBottle{" +
                "bottleType=" + bottleType +
                ", price=" + price +
                '}';
    }
}
