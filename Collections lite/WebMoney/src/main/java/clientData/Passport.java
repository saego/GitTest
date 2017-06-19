package clientData;

/**
 Created by Saego on 12.06.2017.
 */
public class Passport {
   private String serial;
   private Integer number;

    public Passport(String serial, Integer number) {
        this.serial = serial;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "serial='" + serial + '\'' +
                ", number=" + number +
                '}';
    }

    public String getSerial() {
        return serial;
    }

    public Integer getNumber() {
        return number;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passport passport = (Passport) o;

        return (serial != null ? serial.equals(passport.serial) : passport.serial == null) && (number != null ? number.equals(passport.number) : passport.number == null);
    }

    @Override
    public int hashCode() {
        int result = serial != null ? serial.hashCode() : 0;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}
