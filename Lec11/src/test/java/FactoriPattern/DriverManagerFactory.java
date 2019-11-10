package FactoriPattern;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case MOZILLE:
                driverManager = new MozillaDriverManager();
                break;
            default:
                driverManager = null;
                break;

        }
        return driverManager;

    }
}