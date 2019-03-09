package UI;

import Domain.Hotel;
import Domain.RoomAverageRatingViewModel;
import Service.Hotel1;

import java.util.Scanner;

public class Console {

    private Hotel1 service;
    private Scanner scanner;

    public Console(Hotel1 service) {
        this.service = service;
        scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Intrare in hotel");
        System.out.println("2. Iesire din hotel");
        System.out.println("3. Raport rating camere");
        System.out.println("a. Afisare toate camere");
        System.out.println("x. Iesire");
    }

    public void run() {

        while (true) {
            showMenu();
            String option = scanner.nextLine();
            if (option.equals("1")) {
                handleRoomEntry();
            } else if (option.equals("2")) {
                handleRoomExit();
            } else if (option.equals("3")) {
                handleRoomReport();
            } else if (option.equals("a")) {
                handleShowAll();
            } else if (option.equals("x")) {
                break;
            }
        }
    }

    private void handleRoomReport() {
        for (RoomAverageRatingViewModel roomAverage : service.getRoomRatingAverages())
            System.out.println(roomAverage);
    }

    private void handleRoomExit() {
        try {
            System.out.println("Dati Camera:");
            int room = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati rating:");
            double rating = Double.parseDouble(scanner.nextLine());
            System.out.println("Dati feedback de service:");
            String feedback = scanner.nextLine();

            service.exitHotel(room, (int) rating, feedback);
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }

    private void handleShowAll() {
        for (Hotel c : service.getAll())
            System.out.println(c);
    }

    private void handleRoomEntry() {

        try {
            System.out.println("Dati id-ul:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati camera:");
            int room = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul zile:");
            int days = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul de persoane:");
            int persons = Integer.parseInt(scanner.nextLine());

            service.enterHotel(id, room, days, persons);
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }
}
