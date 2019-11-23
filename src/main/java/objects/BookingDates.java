package objects;

import java.util.Date;

/**
 * Created by Rinat on 22.11.2019.
 */
public class BookingDates {
    private Date checkin,checkout;

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookingDates that = (BookingDates) o;

        if (!getCheckin().equals(that.getCheckin())) return false;
        return getCheckout().equals(that.getCheckout());
    }

    @Override
    public int hashCode() {
        int result = getCheckin().hashCode();
        result = 31 * result + getCheckout().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BookingDates{" +
                "checkin=" + checkin +
                ", checkout=" + checkout +
                '}';
    }
}
