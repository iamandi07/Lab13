package Repository;

import Domain.Hotel;
import Domain.HotelValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelRepository {

    private Map<Integer, Hotel> storage = new HashMap<>();

    private HotelValidator validator;

    /**
     * Instantiates a repository for hotel.
     * @param validator the validator used.
     */
    public HotelRepository(HotelValidator validator) {
        this.validator = validator;
        // low coupling, high cohesion
        this.validator = new HotelValidator();
    }

    // metode CRUD: Create, Read, Update, Delete

    /**
     * ...
     * @param hotel
     */
    public void add(Hotel hotel) {
        if (storage.containsKey(hotel.getId())) {
            throw new RuntimeException("A car with that id already exists!");
        }

        validator.validate(hotel);
        storage.put(hotel.getId(), hotel);
    }

    /**
     * ...
     * @param hotel
     */
    public void update(Hotel hotel) {
        if (!storage.containsKey(hotel.getId())) {
            throw new RuntimeException("There is no room with the given id to update!");
        }

        validator.validate(hotel);
        storage.put(hotel.getId(), hotel);
    }

    /**
     * @return a list of all hotel.
     */
    public List<Hotel> getAll() {

        return new ArrayList<>(storage.values());
//        return (List<Car>)storage.values();
        //return storage.values().toArray();
    }
}
