import java.util.ArrayList;

public abstract class CourierCompany extends Item {
        ArrayList<String> transported = new ArrayList<String>();

        public String addItem() {
            transported.add("");
            return null;
        }

        public double totalEarnings() {
            double totalEarnings = deliverypriceforkg * (transported.size() - 1);
            return totalEarnings;
        }

        public double totalVolume() {
            double totalVolume = totalWeight(); // тук не знам как да го изчисля това
            return totalVolume;
        }

    @Override
    public String toString() {
        return "CourierCompany{" +
                "transported=" + transported +
                ", deliverypriceforkg=" + deliverypriceforkg +
                ", itemsList=" + itemsList +
                ", kg=" + kg +
                '}';
    }
}