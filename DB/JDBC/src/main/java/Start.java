import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Saego on 25/10/2017.
 */

public class Start {
    private static final Logger LOGGER = LoggerFactory.getLogger(Start.class);
    public static void main(String[] args){
        loadDriver();
    }

    private static void loadDriver() {
        try {
            LOGGER.info("Loading JDBC DRIVER: org.postgresql.Driver");
            Class.forName("org.postgresql.Driver");
            LOGGER.info("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Can't find driver: org.postgresql.Driver");
            throw new RuntimeException(e);
        }
    }


}
