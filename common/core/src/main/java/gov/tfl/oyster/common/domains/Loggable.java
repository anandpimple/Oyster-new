package gov.tfl.oyster.common.domains;

import sun.util.logging.PlatformLogger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by dev on 17/10/16.
 */
public interface Loggable {
    Logger getLogger();

    default void debug(String message, Throwable t) {
        if (getLogger().isLoggable(Level.FINE)) {
            getLogger().log(Level.FINE, message, t);
        }
    }

    default void info(String message, Throwable t) {
        if (getLogger().isLoggable(Level.INFO)) {
            getLogger().log(Level.INFO, message, t);
        }
    }

    default void warn(String message, Throwable t) {
        if (getLogger().isLoggable(Level.WARNING)) {
            getLogger().log(Level.WARNING, message, t);
        }
    }

    default void error(String message, Throwable t) {
        if (getLogger().isLoggable(Level.SEVERE)) {
            getLogger().log(Level.SEVERE, message, t);
        }
    }
}
