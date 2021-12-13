public class Material extends Item {
    private String name;
    public boolean fragile;

    public Material() {
        this.name = null;
        this.fragile = false;
    }
    public Material(String name,boolean fragile) {
       this.name = name;
       this.fragile = fragile;
    }

    @Override
    public String toString() {
        return "Material{" +
                "name='" + name + '\'' +
                ", fragile=" + fragile +
                '}';
    }
}
