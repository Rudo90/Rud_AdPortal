import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class Test implements MyCommands_1, MyCommands_2, MyCommands_3 {

    static Scanner scanner = new Scanner(System.in);
    static UserImplement userImplement = new UserImplement();
    static User user = new User();
    static Advertisement advertisement = new Advertisement();
    static AdvertisementImplement advertisementImplement = new AdvertisementImplement();

    static void printCommands() {
        System.out.println("Input 0 to EXIT");
        System.out.println("Input 1 to LOGIN");
        System.out.println("Input 2 to REGISTER");
    }

    static void printCommandsForUser(){
        System.out.println("Input 0 to LOGOUT");
        System.out.println("Input 1 to ADD a NEW ADD");
        System.out.println("Input 2 to PRINT YOUR ALL ADS");
        System.out.println("Input 3 to PRINT ALL ADS");
        System.out.println("Input 4 to PRINT ADD BY CATEGORY");
        System.out.println("Input 5 to DELETE YOUR ALL ADS");
        System.out.println("Input 6 to DELETE AD BY TITLE");
    }

    public static void main(String[] args) throws MyException {

        boolean isRun = true;

        while (isRun){
            printCommands();
            String command = scanner.nextLine();
            switch (command){
                case EXIT:
                    isRun = false;
                    System.exit(0);
                    break;
                case LOGIN:
                    login();
                    break;
                case REGISTER:
                    register();
                    break;
                default:
                    break;
            }
        }
    }

    public static void login() {
        if (userImplement.map.size() == 0) {
            System.out.println("Please register");
            register();
        } else {
            System.out.println("Input your phone number");
            try {
                String phone = scanner.nextLine();
                System.out.println("Input your password");
                String password = scanner.nextLine();
                if (!userImplement.map.containsKey(phone) || !userImplement.map.get(phone).getPassword().equals(password)) {
                    throw new MyException("Wrong phone number or password, or User has not been registered yet!");
                }
                System.out.println("Welcome to your account " + userImplement.map.get(phone).getName() + " " +
                        userImplement.map.get(phone).getSurname() + " !");
                System.out.println("Choose one of the following commands");
                for (int i = 0; i < 25; i++) {
                    printCommandsForUser();
                    String command1 = scanner.nextLine();
                    switch (command1) {
                        case LOGOUT:
                            return;
                        case ADD_NEW_AD:
                            addAd();
                            break;
                        case PRINT_MY_ALL_ADS:
                            printMyAllAds();
                            break;
                        case PRINT_ALL_ADS:
                            printAllAds();
                            break;
                        case PRINT_AD_BY_CATEGORY:
                            printAdByCategory();
                            break;
                        case DELETE_MY_ALL_ADS:
                            deleteMyAllAds();
                            break;
                        case DELETE_AD_BY_TITLE:
                            deleteAdByTitle();
                            break;
                        default:
                            System.err.println("Wrong command!");
                            printCommandsForUser();
                            break;
                    }

                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
                login();
            }
        }
    }

    public static void register() {
        System.out.println("Input user name");
        String name = scanner.nextLine();
        System.out.println("Input user surname");
        String surname = scanner.nextLine();
        System.out.println("Choose user gender, input 0 if Male, input 1 if Female");
        String gender = scanner.nextLine();
        switch (gender) {
            case Male:
                gender = "Male";
                break;
            case Female:
                gender = "Female";
                break;
            default:
                System.err.println("Register failed! Try again!");
                register();
                break;
        }
        System.out.println("Input user age");
        try {
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Input user phone number");
            String phone = scanner.nextLine();
            System.out.println("Create user password");
            String password = scanner.nextLine();
            if (userImplement.map.containsKey(phone)) {
                throw new MyException("Account already exist!");
            }
            User user = new User(name, surname, gender, age, phone, password);
            System.out.println(user.toString());
            userImplement.addUser(user);
            System.out.println("User account was created successfully!");
        } catch (MyException e) {
            System.out.println(e.getMessage());
            register();
        }
    }

    public static void addAd(){
        System.out.println("Input Ad title");
        String title = scanner.nextLine();
        System.out.println("Input Ad text");
        String text = scanner.nextLine();
        System.out.println("Input Ad price");
        double price = Double.parseDouble(scanner.nextLine());
        DateTimeFormatter mediumDate = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String dateTime = LocalDateTime.now().format(mediumDate);
        System.out.println("Input Ad category");
        String category = scanner.nextLine();
        System.out.println("Please input IDNumber for your ad");
        String idNumber = scanner.nextLine();
        System.out.println("Please confirm by your phone number");
        String phone = scanner.nextLine();
        String idNumber1 = idNumber + phone + dateTime;
        Advertisement ad = new Advertisement(title, text, price, dateTime, category, idNumber1, userImplement.map.get(phone));
        advertisementImplement.addAd(ad);
        System.out.println("Ad was added successfully");
        System.out.println(ad);
    }

    public static void printMyAllAds(){

        System.out.println("Input your phone to see the ads list");
        String phone = scanner.nextLine();
        advertisementImplement.printMyAllAds(phone);
    }

    public static void printAllAds(){

        advertisementImplement.printAllAds();
    }

    public static void printAdByCategory(){
        System.out.println("Please input category");
        String category = scanner.nextLine();
        advertisementImplement.printAdByCategory(category);
    }

    public static void deleteMyAllAds(){
        System.out.println("Please input your phone number to delete your ads");
        String phone = scanner.nextLine();
        advertisementImplement.deleteMyAllAds(phone);

    }

    public static void deleteAdByTitle (){
        System.out.println("Input ad title to delete");
        String title = scanner.nextLine();
        advertisementImplement.deleteAdByTitle(title);
    }

}



