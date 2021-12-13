import java.util.ArrayList;
import java.util.List;

public class Item {
    private String address;
    public double deliverypriceforkg;
    public List<Element> itemsList;
    public boolean fragile;
    public double kg;

    public Item() {
        itemsList = new ArrayList<Element>();
    }

    public List<Element> getItemsList() {
        return itemsList;
    }

    public void addElement(Element element) {
        itemsList.add(element);
    }

    public double totalWeight() {
        double totalWeight = Element.elementWeight();
        return totalWeight;
    }

    public double shippingPrice() {
        double shipment = totalWeight() * deliverypriceforkg;
        return shipment;
    }

    public List printElementsList() {
        System.out.println(itemsList);
        return null;
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
        return "Item{" +
                "address='" + address + '\'' +
                ", deliverypriceforkg=" + deliverypriceforkg +
                ", itemsList=" + itemsList +
                ", fragile=" + fragile +
                '}';
    }
}

