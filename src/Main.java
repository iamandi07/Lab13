import Domain.HotelValidator;
import Repository.HotelRepository;
import Service.Hotel1;
import UI.Console;

public class Main {

    public static void main(String[] args) {
        HotelValidator validator = new HotelValidator();
        HotelRepository repository = new HotelRepository(validator);
        Hotel1 service = new Hotel1(repository);
        service.enterHotel(1, 1, 5, 2);
        service.enterHotel(2, 2, 10, 2);
        service.exitHotel(1, 5, "good");
        service.enterHotel(3, 1, 10, 2);
        service.exitHotel(2, 4, "good");
        service.enterHotel(4, 2, 1, 2);
        service.exitHotel(1, 3, "good");
        service.enterHotel(5, 3, 4, 2);
        service.exitHotel(2, 4, "good");
        service.enterHotel(6, 2, 4, 2);
        service.enterHotel(9, 12, 4, 2);
        Console console = new Console(service);
        console.run();
    }
}
