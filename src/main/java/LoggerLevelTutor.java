/**
 * Created by KAdamczyk on 2016-01-19.
 */
import org.junit.Test;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerLevelTutor {

    @Test
    public void logLevels() {
        Logger logger = Logger.getLogger(LoggerLevelTutor.class.getName());

        Handler[] rootHandlers = logger.getHandlers();
        for (Handler handler : rootHandlers) {
            logger.removeHandler(handler);
        }
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINEST);

        logger.addHandler(consoleHandler);

        logger.setLevel(Level.FINEST);

        logger.severe("Major disaster");
        logger.warning("Potential problem");
        logger.info("Standard output");
        logger.config("Some config notes");
        logger.fine("Fine detail");
        logger.finer("Finer detail");
        logger.finest("Finest detail");
    }

}
