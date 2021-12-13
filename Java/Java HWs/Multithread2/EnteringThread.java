/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class EnteringThread implements Runnable {

    private Door door;
    private Stadium stadium;

    public EnteringThread(Door door, Stadium stadium) {
        this.door = door;
        this.stadium = stadium;
    }

    @Override
    public void run() {
        door.enterDoor();
    }

    @Override
    public String toString() {
        return "EnteringThread{" + "door=" + door + ", stadium=" + stadium + '}';
    }

}
