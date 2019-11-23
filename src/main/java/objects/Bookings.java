package objects;

import java.util.List;

/**
 * Created by Rinat on 22.11.2019.
 */
public class Bookings {
    private List<Booking> bookings;

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookings=" + bookings +
                '}';
    }
}
