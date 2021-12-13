/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kostadinova
 */
public class Stadium implements Serializable {

    private int maxNumberOfSeats;
    private int currentNumberOfPeople;
    private List<Door> doors;

    public Stadium(int maxNumberOfSeats) {
        this.maxNumberOfSeats = maxNumberOfSeats;
        this.currentNumberOfPeople = 0;
        doors = new ArrayList();
    }

    public int getMaxNumberOfSeats() {
        return maxNumberOfSeats;
    }

    public void setMaxNumberOfSeats(int maxNumberOfSeats) {
        this.maxNumberOfSeats = maxNumberOfSeats;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public void addDoor(Door door) {
        doors.add(door);
    }


    public synchronized void enterStadium() throws NotEnoughSeatsException {
        if (this.currentNumberOfPeople < this.maxNumberOfSeats) {
            this.currentNumberOfPeople++;
        } else {
            throw new NotEnoughSeatsException(this.maxNumberOfSeats);
        }
    }

    public void enteringStadiumDoors() {
        for (Door door : doors) {
            Runnable runnable = () -> door.enterDoor();

            Thread thread = new Thread(runnable);

            System.out.println("Starting Thread..." + door);
            thread.start();
        }
    }

    @Override
    public String toString() {
        return "Stadium{" + "maxNumberOfSeats=" + maxNumberOfSeats +
                ", currentNumberOfPeople=" + currentNumberOfPeople +
                ", doors=" + doors + '}';
    }


}
