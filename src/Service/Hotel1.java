package Service;

import Domain.Hotel;
import java.util.List;

public class Hotel1 {

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

    public void exitHotel(int room, String feedback) {
        Hotel hotelOnRoom = null;
        List<Hotel> hotels = repository.getAll();
        for (Hotel c : hotels) {
            if (c.getRoom() == room && !c.isLeftRoom()) {
                hotelOnRoom = c;
            }
        }

        if (hotelOnRoom != null) {
            hotelOnRoom.setFeedback(feedback);
            hotelOnRoom.setLeftRoom(true);
            repository.update(hotelOnRoom);
        } else {
            throw new RuntimeException("There is nobody in the given room!");
        }
    }
}
