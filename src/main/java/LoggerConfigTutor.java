/**
 * Created by KAdamczyk on 2016-01-20.
 */
import org.junit.Test;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerConfigTutor {
    static Logger logger = Logger.getLogger(LoggerConfigTutor.class.getName());
    static {
        logger.setLevel(Level.SEVERE);
    }
    public static final String loggerConfig =
            "handlers=java.util.logging.ConsoleHandler\n"+
                    ".level=INFO\n"+
                    "java.util.logging.ConsoleHandler.level=FINEST\n"+
                    "LoggerConfigTutor.level=ALL\n"+
                    "my.level=ALL";

    // place -Djava.util.logging.config.file=logger.properties to VM arguments
    @Test
    public void logTest() {
        logger.severe("severe");
        logger.info("info");
        logger.fine("fine");
        logger.finest("finest");
    }

    @Test
    public void testLoggerProperties() throws Exception {
        InputStream stream =
                new ByteArrayInputStream(loggerConfig.getBytes("UTF-8"));
        LogManager.getLogManager().readConfiguration(stream);
        logger.severe("severe");
        logger.info("info");
        logger.fine("fine");
        logger.finest("finest");
        Logger.getLogger("my").finest("hi from my logger!");
    }

    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(
                    new FileInputStream("logger.properties"));
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.severe("severe");
        logger.info("info");
        logger.finest("finest");
    }
}
