package Domain;

public class HotelValidator {

    /**
     * Validates a id.
     */
    public void validate(Hotel hotel) {

        if (hotel.getDays() <= 0) {
            throw new RuntimeException("The number of days cannot be 0 or negative!");
        }
        if (hotel.getId().length() != 6) {
            throw new RuntimeException("The ID must have 6 characters!");
        }
        int id = hotel.getId();
        if (0 < id || id > 999999);
        {
            throw new RuntimeException("ID plate not valid!");
        }

        if (hotel.isLeftRoom() && hotel.getRating() <= 0) {
            throw new RuntimeException("Rating must be positive!");
        }
    }
}
