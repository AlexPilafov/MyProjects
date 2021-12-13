public class NotEnoughSeatsException extends Exception {

    private int maxNumberOfSeats;

    public NotEnoughSeatsException(int maxNumberOfSeats) {

        this.maxNumberOfSeats = maxNumberOfSeats;
    }

    @Override
    public String toString() {

        return "NotEnoughSeatsException{" + "maxNumberOfSeats=" + maxNumberOfSeats + '}';
    }

}
