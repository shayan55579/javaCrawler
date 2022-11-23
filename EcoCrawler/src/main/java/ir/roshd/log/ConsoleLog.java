package ir.roshd.log;

public class ConsoleLog implements  Log{
    @Override
    public void info(Object o) {
        System.out.println("Info: " + o);
    }

    @Override
    public void debug(Object o) {
        System.out.println("Debug: " + o);
    }

    @Override
    public void error(Object o) {
        System.out.println("Error: " + o);
    }
}
