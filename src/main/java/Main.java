import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // Korrekte Aufrufe
        CarBooking booking1 = new CarBooking(LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 10), 800);
        int actualKilometers1 = booking1.bookCar(); // Rückgabe: eine tatsächliche Kilometerzahl größer als 800
        System.out.println("actualKilometers1: " + actualKilometers1);

        CarBooking booking2 = new CarBooking(LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 6), 300);
        try {
            int actualKilometers2 = booking2.bookCar(); // Rückgabe: eine tatsächliche Kilometerzahl größer als 300
            System.out.println("actualKilometers2: " + actualKilometers2);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            // Inkorrekte Aufrufe
            CarBooking booking3 = new CarBooking(LocalDate.of(2023, 5, 10), LocalDate.of(2023, 5, 5), 800); // Vorbedingung verletzt
            int actualKilometers3 = booking3.bookCar(); // nicht erreicht, da eine Ausnahme ausgelöst wird
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            // Inkorrekter Aufruf
            CarBooking booking4 = new CarBooking(LocalDate.of(2023, 5, 5), LocalDate.of(2023, 5, 6), -100); // Vorbedingung verletzt
            int actualKilometers4 = booking4.bookCar(); // nicht erreicht, da eine Ausnahme ausgelöst wird // Versuch, ein Auto zu buchen, aber die Vorbedingung wurde verletzt
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
