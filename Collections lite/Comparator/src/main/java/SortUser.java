import java.util.*;

/**
 *Created by Saego on 12.06.2017.
 */
class SortUser{
    /**
     * Sorting users by name length.
     * @param users - input list of users.
     * @return - sorted list.
     */
    List<User> sortByNameLength(List<User> users){
        List<User> usr  = new ArrayList<User>(users);
        usr.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                    return o1.getName().length() - o2.getName().length();
                }
            }
        );
        return usr;
    }

    List<User> sortByAllFields(List<User> users){
        List<User> usr = new ArrayList<User>(users);
        usr.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int result = o1.getName().compareTo(o2.getName());
                        if (result != 0) return result;
                        result = o1.getAge().compareTo(o2.getAge());
                        return result;
                    }
                }
        );

     return usr;
    }
}
