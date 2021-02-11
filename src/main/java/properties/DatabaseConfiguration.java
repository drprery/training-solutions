package properties;

import java.io.*;
import java.nio.file.Files;
import java.util.Properties;

public class DatabaseConfiguration {
    //private String host;
    //private int port;
    //private String schema;
    private Properties properties = new Properties();

    public static final String CHAR_CODE="UTF-8";

    public String getHost() {
        return properties.getProperty("db.host");
    }

    public int getPort() {
        return Integer.parseInt(properties.getProperty("db.port"));
    }

    public String getSchema() {
        return properties.getProperty("db.schema");
    }

    public DatabaseConfiguration(){
        try(InputStream is = DatabaseConfiguration.class.getResourceAsStream("db.properties")){
            properties.load(new InputStreamReader(is, CHAR_CODE));
        } catch (IOException ioe){
            throw new IllegalArgumentException("Cannot read file");
        }

        //host = properties.getProperty("db.host");
        //port = Integer.parseInt(properties.getProperty("db.port"));
        //schema = properties.getProperty("db.schema");
    }

    public DatabaseConfiguration(File file){
        try(BufferedReader br = Files.newBufferedReader(file.toPath())){
            properties.load(br);
        } catch (IOException ioe){
            throw new IllegalArgumentException("Cannot read file");
        }

        //host = properties.getProperty("db.host");
        //port = Integer.parseInt(properties.getProperty("db.port"));
        //schema = properties.getProperty("db.schema");
    }
}
