package Domain;


public class Hotel  {

    private int id, room, days, persons, rating;
    private boolean leftRoom;
    private String feedback;

    @Override
    public String toString() {
        return "Hotel{" +
                        "id=" + id +
                        ", room=" + room +
                        ", persons='" + persons + '\'' +
                        ", days=" + days +
                        ", leftRoom=" + leftRoom +
                        ", feedback='" + feedback + '\'' +
                        ", rating=" + rating +
                        '}';
    }

    public Hotel(int id, int room, int days, int persons) {
        this.id = id;
        this.room = room;
        this.days = days;
        this.persons = persons;
        leftRoom = false;

    }

    public Hotel(int id, int room, int days, int persons, int rating, boolean leftRoom, String feedback) {
        this.id = id;
        this.room = room;
        this.days = days;
        this.persons = persons;
        this.leftRoom = leftRoom;
        this.rating = rating;
        this.feedback = feedback;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isLeftRoom() {
        return leftRoom;
    }

    public void setLeftRoom(boolean leftRoom) {
        this.leftRoom = leftRoom;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}

