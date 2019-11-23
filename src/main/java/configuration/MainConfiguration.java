package configuration;

/**
 * Created by Rinat on 22.11.2019.
 */
public class MainConfiguration {

    public static String getSiteAdress() {
        return System.getProperty("site.adress");
    }

    public static String getPort() {
        return System.getProperty("site.port");
    }
}
