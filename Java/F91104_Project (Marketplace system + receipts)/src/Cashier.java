public class Cashier {
    private int id;
    private static int employee_number = 0;
    private String name;


    public Cashier(String name) {
        employee_number++;
        this.id = employee_number;
        this.name = name;
    }

    public int getEmployee_number() {
        return employee_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "employee_number=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
