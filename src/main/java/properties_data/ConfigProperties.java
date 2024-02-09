package properties_data;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    static Properties properties = new Properties();
    public static String getProperty(String parametr) {
        if(properties.toString().equals("{}")){//single tone - if file of properties  = empty read it, read and remember
            initProperty();
        }
        return properties.getProperty(parametr);
        //method getProperty return parameters
    }
    private static void initProperty(){
        //Initialization property from file by link src/test/resources/%s.properties
        String target = System.getProperty("target", "prod");

        String path = String.format("src/test/resources/%s.properties", target);
        //target will be or production or stage according file in resource
        try(FileReader fileReader = new FileReader(path)) {
            properties.load(fileReader);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
