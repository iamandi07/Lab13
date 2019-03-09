package Service;

import Domain.Hotel;
import Domain.RoomAverageRatingViewModel;
import Repository.HotelRepository;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hotel1 {

    private HotelRepository repository;

    /**
     * ...
     * @param repository
     */
    public Hotel1(HotelRepository repository) {
        
        this.repository = repository;
    }

    public void enterHotel(int id, int room, int days, int persons) {

        Hotel hotel = new Hotel(id, room, days, persons);
        List<Hotel> hotels = repository.getAll();
        for (Hotel c : hotels) {
            if (c.getRoom() == room && !c.isLeftRoom()) {
                throw new RuntimeException("That room is already taken!");
            }
        }
        repository.add(hotel);
    }

    public void exitHotel(int room, int rating, String feedback) {
        Hotel hotelOnRoom = null;
        List<Hotel> hotels = repository.getAll();
        for (Hotel c : hotels) {
            if (c.getRoom() == room && !c.isLeftRoom()) {
                hotelOnRoom = c;
            }
        }

        if (hotelOnRoom != null) {
            hotelOnRoom.setFeedback(feedback);
            hotelOnRoom.setRating(rating);
            hotelOnRoom.setLeftRoom(true);
            repository.update(hotelOnRoom);
        } else {
            throw new RuntimeException("There is nobody in the given room!");
        }
    }

    public List<RoomAverageRatingViewModel> getRoomRatingAverages() {
        List<RoomAverageRatingViewModel> results = new ArrayList<>();
        Map<Integer, List<Double>> ratingForRoom = new HashMap<>();

        for (Hotel c : repository.getAll()) {
            if (c.isLeftRoom()) {
                int room = c.getRoom();
                double rating = c.getRating();

                if (!ratingForRoom.containsKey(room)) {
                    ratingForRoom.put(room, new ArrayList<>());
                }
                ratingForRoom.get(room).add(rating);
            }
        }

        for (int room : ratingForRoom.keySet()) {
            List<Double> rating = ratingForRoom.get(room);
            double average = 0;
            for (double p : rating) {
                average += p;
            }
            average /= rating.size();
            results.add(new RoomAverageRatingViewModel(room, average));
        }

//        results.sort((r1, r2) -> r1.getAverageRating() > r2.getAverageRating() ? -1 : 1);
        results.sort((r1, r2) -> {
            if (r1.getAverageRating() > r2.getAverageRating())
                return -1;
            else if (r1.getAverageRating() == r2.getAverageRating())
                return 0;
            else
                return 1;
        });
        return results;
    }

    public List<Hotel> getAll() {
        return repository.getAll();
    }
}
