import org.junit.Before;
import org.junit.Test;

import java.util.logging.*;

public class LogHierarchyTutor2 {
    @Before
    public void init() {
        LogManager.getLogManager().reset();
    }

    @Test
    public void log() {
        Handler handler = new ConsoleHandler();
        Logger base = Logger.getLogger("org.jdom");
        base.addHandler(handler);
        Logger elt = Logger.getLogger("org.jdom.Element");
        Logger attr = Logger.getLogger("org.jdom.Attribute");

        elt.info("elt.info Displayed");
        attr.info("attr.info Displayed");
        base.setLevel(Level.SEVERE);
        elt.info("Level.SEVERE: elt.info Hidden");
        attr.info("Level.SEVERE: attr.info Hidden");
        elt.setLevel(Level.INFO);
        elt.info("Level.INFO: elt.info Displayed");
        elt.fine("Level.INFO: elt.fine Fine");
        attr.severe("Level.INFO: attr.severe Severe");
    }
}
