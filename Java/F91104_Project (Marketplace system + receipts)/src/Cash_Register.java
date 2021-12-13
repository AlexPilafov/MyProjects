import java.util.ArrayList;
import java.util.List;

public class Cash_Register extends Market implements Runnable {
    private int register_number;
    private static int numberOfRegisters = 0;
    public Cashier current_cashier;
    public List<Goods> Selling_List;

    public Cash_Register(Cashier current_cashier) {
        numberOfRegisters++;
        this.register_number = numberOfRegisters;
        this.current_cashier = current_cashier;
        this.Selling_List = new ArrayList<Goods>();
    }

    public List<Goods> getSelling_List() {
        return Selling_List;
    }

    public void addGoodsToSellingList(Goods goods) {
            Selling_List.add(goods);
    }

    public void sell_Goods(Goods goods, int youwant) {
        if(goods.is_Enough() && youwant <= goods.getQuantity()) {
            Goods tempGood = new Goods();
            int tempQuantity = goods.getQuantity() - youwant;
            goods.setQuantity(tempQuantity);
            tempGood.setQuantity(youwant);
            tempGood.setName(goods.getName());
            tempGood.setPrice(goods.getPrice());
            tempGood.setId(goods.getId());
            tempGood.setTotal(goods.getTotal());
            addGoodsToSellingList(tempGood);
        } else {throw new IllegalArgumentException("ERROR - Not enough " + goods.getName() + " quantity available.");}
    }

    public void clearSelling_List(){
        if(Selling_List.size() > 0) {
            for (Goods goods : Selling_List) {
                Selling_List.remove(goods);
            }
        }
    }

    public void setCurrent_cashier(Cashier current_cashier) {
        this.current_cashier = current_cashier;
    }

    public Cashier getCurrent_cashier() {
        return current_cashier;
    }

    public double total(){
        double total = 0;
        for(Goods goods : Selling_List)
            total += goods.total();
            return total;
    }

    @Override
    public String toString() {
        return "Cash_Register{" +
                "register_number=" + register_number +
                ", current_cashier=" + current_cashier +
                '}';
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " is running");
        }
        catch (Exception e)
        {
            System.out.println ("Thread interrupted.");
        }
    }
}
