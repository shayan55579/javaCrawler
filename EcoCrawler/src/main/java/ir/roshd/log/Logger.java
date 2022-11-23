package ir.roshd.log;

public class Logger {
    public static Log log;

//    public static void setLog(Log log) {
//        if(log == null)
//            Logger.log = log;
//    }
    public static void info(Object o){
        log.info(o);
    }
    public static void debug(Object o){
        log.debug(o);
    }
    public static void error(Object o){
        log.error(o);
    }

}
