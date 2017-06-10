import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 Created by Saego on 10.06.2017.
 */
class SortUser {

    Set<User> sort(List<User> users){
        Set<User> sortUs = new TreeSet<User>();
        sortUs.addAll(users);
        return sortUs;
    }
}
