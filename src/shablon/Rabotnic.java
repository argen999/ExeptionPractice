package shablon;

public class Rabotnic {
    private String name;
    private String Lastname;
    private int year;
    private int startWorking;

    public Rabotnic(String name, String lastname, int year, int startWorking) {
        this.name = name;
        Lastname = lastname;
        this.year = year;
        this.startWorking = startWorking;
    }

    public Rabotnic() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getStartWorking() {
        return startWorking;
    }

    public void setStartWorking(int startWorking) {
        this.startWorking = startWorking;
    }

}
