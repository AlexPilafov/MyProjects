public class Main {

    public static void main(String[] args) {
        //making new goods with constructor
        Goods sandwich = new Goods(15, "Sandwich", 3);
        Goods pizza = new Goods(4, "Pizza", 12);
        Goods icecream = new Goods(10, "IceCream", 2);
        System.out.println("----------------------------List of Goods in the Market----------------------------------");
        //making new cashier with constructor
        Cashier Malcolm = new Cashier("Malcolm Watson");
        Cashier Nora = new Cashier("Nora Ming");
        //making a lists with constructor
        Market myshop = new Market();
        //adding goods & cashiers
        myshop.addGoods(sandwich);
        myshop.addGoods(pizza);
        myshop.addGoods(icecream);
        myshop.addCashier(Malcolm);
        myshop.addCashier(Nora);
        //displaying lists of cashiers and goods
        myshop.display_ListGoods();
        System.out.println("--------------------------displaying the list of cashiers--------------------------------");
        myshop.display_ListCashiers();
        System.out.println("---------------------------displaying Cash_registers-------------------------------------");
        //making new register number 1
        Cash_Register register1 = new Cash_Register(Malcolm);
        //making new register number 2
        Cash_Register register2 = new Cash_Register(Nora);
        //making new receipt
        Receipt receipt1 = new Receipt(register1.getCurrent_cashier(), register1.getSelling_List());
        Receipt receipt2 = new Receipt(register2.getCurrent_cashier(), register2.getSelling_List());
        System.out.println(register1);
        System.out.println(register2);
        System.out.println("----------------------------displaying my Market-----------------------------------------");
        System.out.println(myshop);
        System.out.println("---------------------Receipts before adding goods----------------------------------------");
        System.out.println(receipt1);
        System.out.println(receipt2);
        System.out.println("--------------------------------Selling_List---------------------------------------------");
        register1.sell_Goods(pizza, 3);
        register1.sell_Goods(icecream,2);
        register1.sell_Goods(sandwich,1);
        register2.sell_Goods(pizza,1);
        System.out.println(register1.getSelling_List());
        System.out.println(register2.getSelling_List());
        System.out.println("--------------------------List_Goods in myshop after transfer----------------------------");
        myshop.display_ListGoods();
        System.out.println("---------------------Receipts after adding goods-----------------------------------------");
        System.out.println(receipt1);
        System.out.println(receipt2);
        System.out.println("-------------------------------------Total receipts--------------------------------------");
        System.out.println("Total receipts: " + Receipt.getTotal_receipts());
        System.out.println("------------------------------Saving to file---------------------------------------------");
        receipt1.saveToFile();
        receipt2.saveToFile();
        System.out.println("-------------------------Opening and reading from files----------------------------------");
        receipt1.openFile("receipt1.txt");
        receipt2.openFile("receipt2.txt");
        System.out.println("-------------------------clean_Inventory function----------------------------------------");
        myshop.clean_Inventory();
        System.out.println(myshop);
        System.out.println("------------------------------Multithreading---------------------------------------------");
        Thread t1 = new Thread(new Cash_Register(Malcolm));
        Thread t2 = new Thread(new Cash_Register(Nora));
        t1.start();
        t2.start();
    }
}