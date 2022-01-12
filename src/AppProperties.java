import java.io.*;
import java.util.Properties;

public class AppProperties {
    private Properties prop;
    private File  propFile;

    public AppProperties() {
        try {
            prop  = new Properties();
            propFile = new File("config.properties");
            if (!propFile.exists()) propFile.createNewFile();
            prop.load(new FileReader("config.properties"));
        } catch (FileNotFoundException e) {
            System.out.println("File config.properties not found!");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Some problem with reading file config.properties!");
            System.exit(1);
        }
    }

    public Properties getProp() {
        return prop;
    }

    public void setAtr() {
        // запись объекта в файл
        try {
            prop.store(new FileWriter(propFile), null);
        } catch (IOException e) {
            System.out.println("File properties don't write");
        }
    }
}
