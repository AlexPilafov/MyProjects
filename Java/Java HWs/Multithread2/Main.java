public class Main {

    public static void main(String[] args) {
        Person maria = new Person("Maria");
        Person milena = new Person("Milena");
        Person maia = new Person("Maia");
        Person ivanna = new Person("Ivanna");
        Person iliana = new Person("Iliana");

        Stadium stadium = new Stadium(3);

        System.out.println(stadium);

        Door door1 = new Door(stadium, 1);
        Door door2 = new Door(stadium, 2);

        door1.addPerson(ivanna);
        door1.addPerson(iliana);

        door2.addPerson(maria);
        door2.addPerson(maia);
        door2.addPerson(milena);

        stadium.addDoor(door1);
        stadium.addDoor(door2);

        stadium.enteringStadiumDoors();

        String fileName = "stadium.ser";
        StadiumUtil.serializeStadium(fileName, stadium);

        Stadium stadiumState = StadiumUtil.deserializeStadium(fileName);
        System.out.println(stadiumState);
    }
}
