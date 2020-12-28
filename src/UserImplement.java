import java.util.HashMap;

public class UserImplement extends HashMap {

    HashMap <String, User> map = new HashMap();

    public void addUser(User user) {

            String key = user.getPhoneNumber();
            map.put(key, user);

    }

}
