public class eItems {
    public String manufacturer;
    public double price;
    int min_guarantee = 12;

    public class Furnace extends eItems {
        String Furnace_name;
    }

    public class washingMachine extends eItems {
        String washingMachine_name;
        double rpm;
    }

    public boolean Budget implements Buyers {
        if (client_budget <= 0) {
            return false;
        }else{
            return true;
        }
    }

    public class Buyers {
        double client_budget;
        String client_name;
        if (Budget = false) {
            System.out.printf("Sorry, insufficient funds.");
        }
    }

    public int guaranteePeriod(String manufacturer, double price) {
        int extended_guarantee = min_guarantee + 12;
        int gas_guarantee;
        int dryer_guarantee;
        boolean gas;
        boolean dryer;
        if (gas = true) {
            gas_guarantee = extended_guarantee + 12;
            return gas_guarantee;
        } else if(dryer = true) {
            dryer_guarantee = extended_guarantee + 6;
            return dryer_guarantee;
        } else {
            return extended_guarantee;
        }
    }

    @Override
    public String toString() {
        return "eItems{" +
                "manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", min_guarantee=" + min_guarantee +
                ", client_budget=" + client_budget +
                '}';
    }
}

