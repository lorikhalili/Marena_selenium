package logs;
import implementation.Loginlmpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class Logs {
   // public static final Logger logger = Logger.getLogger(String.valueOf(Loginlmpl.class));
    public static final Logger log = LogManager.getLogger(Loginlmpl.class);
        public static void  info (String message) {
        log.trace(message);
        log.debug(message);
        log.info(message);
        log.warn(message);
        log.error(message);
        log.fatal(message);
    }


}


