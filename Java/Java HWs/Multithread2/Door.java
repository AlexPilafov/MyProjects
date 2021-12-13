/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kostadinova
 */
public class Door implements Serializable{

    private Stadium stadium;
    private int number;
    private List<Person> persons;

    public Door(Stadium stadium, int number) {
        this.stadium = stadium;
        this.number = number;
        persons = new ArrayList();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void enterDoor() {
        for (Person person : persons) {
            try {
                stadium.enterStadium();
                System.out.println(person + " is entering through door number " + this);
            } catch (NotEnoughSeatsException ex) {
                Logger.getLogger(Door.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String toString() {
        return "Door{" + "number=" + number + '}';
    }

}
