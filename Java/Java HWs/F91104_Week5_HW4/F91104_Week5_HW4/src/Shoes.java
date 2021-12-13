public class Shoes extends Item {
    public boolean testshoes;
    public double shoestransportprice;

    public double shippingPrice(){
        shoestransportprice = deliverypriceforkg * kg;
        return shoestransportprice;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "testshoes=" + testshoes +
                ", shoestransportprice=" + shoestransportprice +
                ", deliverypriceforkg=" + deliverypriceforkg +
                ", kg=" + kg +
                '}';
    }
}
