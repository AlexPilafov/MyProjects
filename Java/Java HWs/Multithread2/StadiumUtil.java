import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StadiumUtil {

    public static void serializeStadium(String fileName, Stadium stadium) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(stadium);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StadiumUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StadiumUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Stadium deserializeStadium(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            return (Stadium) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StadiumUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(StadiumUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
