package objects;

/**
 * Created by Rinat on 22.11.2019.
 */
public class BookingCreation {

    private BookingDates bookingDates;
    private int bookingid;
    private boolean depositpaid;
    private String firstname, lastname;
    private int roomid;
    private String email, phone;

    public BookingDates getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingCreation that = (BookingCreation) o;

        if (getBookingid() != that.getBookingid()) return false;
        if (isDepositpaid() != that.isDepositpaid()) return false;
        if (getRoomid() != that.getRoomid()) return false;
        if (!getBookingDates().equals(that.getBookingDates())) return false;
        if (!getFirstname().equals(that.getFirstname())) return false;
        if (!getLastname().equals(that.getLastname())) return false;
        if (!getEmail().equals(that.getEmail())) return false;
        return getPhone().equals(that.getPhone());
    }

    @Override
    public int hashCode() {
        int result = getBookingDates().hashCode();
        result = 31 * result + getBookingid();
        result = 31 * result + (isDepositpaid() ? 1 : 0);
        result = 31 * result + getFirstname().hashCode();
        result = 31 * result + getLastname().hashCode();
        result = 31 * result + getRoomid();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPhone().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BookingCreation{" +
                "bookingDates=" + bookingDates +
                ", bookingid=" + bookingid +
                ", depositpaid=" + depositpaid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", roomid=" + roomid +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
