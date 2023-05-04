import java.time.LocalDate;
import java.util.Random;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;
import org.jetbrains.annotations.Contract;

/**
 * @see "https://www.baeldung.com/jetbrains-contract-annotation"
 */
@Invariant({
        "startDate != null",
        "endDate != null",
        "startDate.isBefore(endDate)" })
public class CarBooking {
    private LocalDate startDate;
    private LocalDate endDate;
    private int expectedKilometers;

    @Contract("null, null, _ -> fail")
    @Requires("startDate != null && endDate != null && expectedKilometers > 0 && startDate.isBefore(endDate)")
    public CarBooking(LocalDate startDate, LocalDate endDate, int expectedKilometers) {
        // Vorbedingung: Das Startdatum muss vor oder gleich dem Enddatum liegen
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Startdatum muss vor oder gleich dem Enddatum liegen.");
        }

        // Vorbedingung: Die angestrebte Kilometerzahl muss positiv sein
        if (expectedKilometers <= 0) {
            throw new IllegalArgumentException("Die angestrebte Kilometerzahl muss positiv sein.");
        }

        this.startDate = startDate;
        this.endDate = endDate;
        this.expectedKilometers = expectedKilometers;
    }

    // Nachbedingung: Die zurückgegebene Kilometerzahl muss größer als 0 sein
    @Contract(pure = true, value = "-> _")
    @Ensures("result > 0")
    public int bookCar() {
        int actualKilometers = simulateCarRental(); // eine Methode, die eine tatsächliche Kilometerzahl zurückgibt

        // Nachbedingung: Die tatsächliche Kilometerzahl muss mindestens der angestrebten Kilometerzahl entsprechen
        if (actualKilometers < expectedKilometers) {
            throw new RuntimeException("Die tatsächliche Kilometerzahl ist niedriger als die angestrebte Kilometerzahl.");
        }

        return actualKilometers;
    }

    @Contract(pure = true)
    @Ensures("result > 0")
    private int simulateCarRental() {
        // Diese Methode simuliert das Mieten eines Autos und gibt eine zufällige Kilometerzahl zurück
        Random random = new Random();

        return random.nextInt(2000) + 500;
    }
}

