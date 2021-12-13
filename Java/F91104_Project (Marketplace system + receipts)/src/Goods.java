public class Goods extends Market implements Calculate {
    private int id;
    private String name;
    private double price;
    private static int numberOfGoods = 0;
    private int quantity;
    private double total;

    public Goods() {

    }

    public Goods(int quantity, String name, double price) {
        numberOfGoods++;
        this.quantity = quantity;
        this.id = numberOfGoods;
        this.name = name;
        this.price = price;
        this.total = total();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity(int youwant) {
        return quantity - youwant;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double total() { return price*quantity; }

    public boolean is_Enough() {
        if(this.quantity > 0) {
            return true;
        } else {
            return false;}
    } //returns boolean false if not enough

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", price=" + price + currency +
                ", total=" + total() + currency +
                '}';
    }
}
