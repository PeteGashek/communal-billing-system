package cbs.core.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private Properties property = new Properties();
    private String billsPath = "";

    Config(String path) {
        try {
            property.load(new FileInputStream(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        billsPath = property.getProperty("billsPath");
    }

    public Properties getProperty() {
        return property;
    }

    public void setProperty(Properties property) {
        this.property = property;
    }

    public String getBillsPath() {
        return billsPath;
    }
}
