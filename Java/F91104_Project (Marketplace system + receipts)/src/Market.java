import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<Goods> list_Goods;
    private List<Cashier> list_Cashiers;
    public String currency = "лв."; // the Market's currency

    public Market() {
        this.list_Goods = new ArrayList();
        this.list_Cashiers = new ArrayList();
    }

    public List<Cashier> getList_Cashiers() {
        return list_Cashiers;
    }

    public void addCashier(Cashier cashier) {
        if (!this.list_Cashiers.contains(cashier)) {
            this.list_Cashiers.add(cashier);
        } else {
            throw new IllegalArgumentException("This Cashier is already in the list.");
        }
    }

    public void removeCashiers(Cashier cashier) {
        this.list_Cashiers.remove(cashier);
    }

    public void removeGoods(Goods goods) {
        if(list_Goods.contains(goods)){
        this.list_Goods.remove(goods);
        } else throw new IllegalArgumentException("No " + goods.getName() + " in your inventory for removing.");
    }

    public void display_ListCashiers() {
        for (Cashier cashier: list_Cashiers) {
            System.out.println(cashier);
        }
    }

    public List<Goods> getList_Goods() {
        return list_Goods;
    }

    public void addGoods(Goods goods) {
        if (!this.list_Goods.contains(goods) && goods.is_Enough()) {
            this.list_Goods.add(goods);
        }
    }

    public void display_ListGoods() {
        for (Goods goods : list_Goods) {
            System.out.println(goods);
        }
    }

    public void clean_Inventory(){
        for(Goods goods : list_Goods){
            if(goods.getQuantity() == 0){
                list_Goods.remove(goods);
                System.out.println(goods + " removed from the list_Goods.");
            }
        }
    } // Cleans the goods in list_Goods that have quantity = 0


    @Override
    public String toString() {
        return "Market{" +
                "list_Goods=" + list_Goods +
                ", list_Cashiers=" + list_Cashiers +
                '}';
    }
}
