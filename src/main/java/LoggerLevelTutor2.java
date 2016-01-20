/**
 * Created by KAdamczyk on 2016-01-20.
 */
import org.junit.Test;

import java.util.logging.*;

public class LoggerLevelTutor2 {

    @Test
    public void logLevels() {
        Logger logger = Logger.getLogger(LoggerLevelTutor.class.getName());
        logger.setLevel(Level.ALL);
        try {
            //Handler handler = new FileHandler("files/log.log");
            Handler handler = new ConsoleHandler();
            logger.addHandler(handler);
            handler.setFormatter(new SimpleFormatter());
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.setFilter(new Filter() {
            public boolean isLoggable(LogRecord rec) {
                if (rec.getMessage().contains("filter")) {
                    return false;
                }
                return true;
            }
        });
        logger.severe("Major disaster");
        logger.warning("Potential problem");
        logger.info("Standard output");
        logger.config("Some config notes");
        logger.fine("Fine detail");
        logger.finer("Finer detail");
        logger.finest("Finest detail");
    }

}
