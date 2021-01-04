import java.util.HashMap;

public class AdvertisementImplement {

    HashMap<String, Advertisement> list = new HashMap<>();

    public AdvertisementImplement() {
    }

    public void printMyAllAds(String phone) {

        for (String s : list.keySet()) {
            if(s.contains(phone)){
                System.out.println(list.get(s));
            }
        }
    }

    public void printAllAds() {
        System.out.println(list.values());
    }

    public void printAdByCategory(String category){

        for (Advertisement value : list.values()) {
            if (value.getCategory().contains(category)) {
                String s = value.getIdNumber();
                System.out.println(list.get(s));
            }
        }
    }

    public void deleteMyAllAds(String phone){

            for (String s : list.keySet()) {
                if (s.contains(phone)) {
                    list.remove(s);
                    return;
                }
            }
        }

    public void deleteAdByTitle(String title) {
        for (Advertisement value : list.values()) {
            if (value.getTitle().contains(title)) {
                String s = value.getIdNumber();
                list.remove(s);
            }
        }
    }

    @Override
    public String toString() {
        return "AdvertisementImplement{" +
                "list=" + list +
                '}';
    }
}
