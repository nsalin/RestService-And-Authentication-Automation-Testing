package common_utils;

import org.apache.log4j.Logger;

/**
 * Created by Alin on 4/25/2015.
 */
public class Logging {

    public Logging() {
    }
    public void info (Logger logger, String message){
        if(logger.isInfoEnabled()){
            logger.info(message);
        }
    }

    public void debug(Logger logger, String message){
        if(logger.isDebugEnabled()){
            logger.debug(message);
        }
    }
}
