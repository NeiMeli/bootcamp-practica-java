package clase3.tt;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MiFactory {
    @SuppressWarnings("unchecked")
    public static <T> Sorter<T> getInstance(String objName) {
        try {
            Class<?> clazz = Class.forName(objName);
            return (Sorter<T>) clazz.getDeclaredConstructor().newInstance();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Sorter<T> getInstance() {
        try {
            Properties prop = new Properties();
            InputStream inputStream = new FileInputStream("src/clase3/tt/MiFactory.properties");
            prop.load(inputStream);
            return getInstance(prop.getProperty("sorter"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
