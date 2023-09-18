package mit.ibook.btech.mit.controller.base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractController<T> {

    protected final T abstractService;
    protected final Logger logManager;

    protected AbstractController(T abstractService, Class clazz) {
        this.abstractService = abstractService;
        this.logManager = LogManager.getLogger(clazz.getName());
    }


}
