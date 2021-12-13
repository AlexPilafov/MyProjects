public class Box extends Item {
    public double height;
    public double width;
    public double lenght;
    public double volume;

    public Box(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.lenght = length;
    }

    public double boxVolume() {
        volume = height*width*lenght;
        return volume;
    }
}
