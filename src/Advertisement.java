public class Advertisement extends User {

    private String title;
    private String text;
    private double price;
    private String date;
    private String category;
    private String idNumber;
    private User user;

    public Advertisement(){

    }

    public Advertisement(String title, String text, double price, String date, String category, String idNumber, User user) {
        this.title = title;
        this.text = text;
        this.price = price;
        this.date = date;
        this.category = category;
        this.idNumber = idNumber;
        this.user = user;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", category='" + category + '\'' +
                ", idNumber=" + idNumber +
                ", user=" + user +
                '}';
    }
}
