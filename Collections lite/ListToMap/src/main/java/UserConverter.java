import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Created by Saego on 09.06.2017.
 */
class UserConverter {
    /**
     *
     * @param list - input list of Users.
     * @return - map with id keys.
     */
    HashMap<Integer, User> process(List<User> list){
        Map<Integer, User> userMap = new HashMap<Integer, User>();
        for (User us:
             list) {
            userMap.put(us.getId(), us);
        }
        return (HashMap<Integer, User>) userMap;
    }
}
