import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Test {

    //private static Logger logger = LoggerFactory.getLogger(Log4j2Test.class);

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Log4j2Test.class);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
