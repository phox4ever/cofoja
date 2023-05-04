public class CarBooking {
    private LocalDate startDate;
    private LocalDate endDate;
    private int expectedKilometers;

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
