package objects;

/**
 * Created by Rinat on 22.11.2019.
 */
public class Booking {
    private BookingDates bookingdates;
    private int bookingid;
    private boolean depositpaid;
    private String firstname, lastname;
    private int roomid;

    public BookingDates getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDates bookingdates) {
        this.bookingdates = bookingdates;
    }

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (getBookingid() != booking.getBookingid()) return false;
        if (isDepositpaid() != booking.isDepositpaid()) return false;
        if (getRoomid() != booking.getRoomid()) return false;
        if (!getBookingdates().equals(booking.getBookingdates())) return false;
        if (!getFirstname().equals(booking.getFirstname())) return false;
        return getLastname().equals(booking.getLastname());
    }

    @Override
    public int hashCode() {
        int result = getBookingdates().hashCode();
        result = 31 * result + getBookingid();
        result = 31 * result + (isDepositpaid() ? 1 : 0);
        result = 31 * result + getFirstname().hashCode();
        result = 31 * result + getLastname().hashCode();
        result = 31 * result + getRoomid();
        return result;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingdates=" + bookingdates +
                ", bookingid=" + bookingid +
                ", depositpaid=" + depositpaid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", roomid=" + roomid +
                '}';
    }
}
