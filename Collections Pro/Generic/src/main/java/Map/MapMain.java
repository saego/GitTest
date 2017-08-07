package Map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Saego on 01.08.2017.
 */

public class MapMain {
    public static void main(String[] args) {
        User user1 = new User("Johnathan", new GregorianCalendar(2015, Calendar.MARCH, 15), 0);
        User user2 = new User("Johnathan", new GregorianCalendar(2015, Calendar.MARCH, 15), 0);
        Map<User, Object> map = new HashMap<User, Object>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
        Integer i = 488888;
        System.out.println(user1.hashCode());
        System.out.println(i.hashCode());
        i = user1.hashCode();
        System.out.println((i^(i>>>16)) + " user1");
        System.out.println((i & 15) + " basket");
        i = user2.hashCode();
        System.out.println((i^(i>>>16)) + " user2");
        System.out.println((i & 15) + " basket");
    }
}
