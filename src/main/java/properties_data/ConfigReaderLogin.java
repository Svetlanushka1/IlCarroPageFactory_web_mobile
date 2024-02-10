package properties_data;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderLogin {
    static Properties properties = new Properties();

    public static String getProperty(String param) {
        if(properties.toString().equals("{}")){
            initProperty();
        }
        return properties.getProperty(param);
    }
    public static void initProperty(){
        try(FileReader fileReader = new FileReader("src/test/resources/login.properties")) {
            properties.load(fileReader);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
