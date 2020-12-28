import java.util.HashMap;

public class AdvertisementImplement extends HashMap {

    HashMap<String, Advertisement> list = new HashMap();
    User user = new User();
    Advertisement advertisement = new Advertisement();

    public AdvertisementImplement() {
    }

    public void addAd(Advertisement ad){

        list.put(advertisement.getIdNumber(), ad);
    }

    public void printMyAllAds(String phone) {

        for (int i = 0; i < list.size(); i++){
            if (list.get(advertisement.getIdNumber()).toString().contains(phone))
                System.out.println(list.get(advertisement.getPhoneNumber()));
        }
    }

    public void printAllAds() {
        System.out.println(list.values());
    }

    public void printAdByCategory(String category){

        for (int i = 0; i < list.size(); i++){
            if (list.get(user.getPhoneNumber()).getCategory().equals(category)){
                System.out.println(list.get(user.getPhoneNumber()));
            }
        }
    }

    public void deleteMyAllAds(String phone){
        for (int i = 0; i < list.size(); i++){
            if (list.get(advertisement.getIdNumber()).toString().contains(phone)){
                list.clear();
            }
        }
    }

    public void deleteAdByTitle(String title){
        for (int i = 0; i < list.size(); i++){
            if (list.containsValue(title)){
                list.remove(title);
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
