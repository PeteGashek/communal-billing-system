package cbs.core.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

public class ServiceStructure {
    private Map<String, Class<? extends Service>> services = new HashMap<String, Class<? extends Service>>();
    
    private Properties properties;

    @SuppressWarnings("unchecked")
    public ServiceStructure() throws ClassNotFoundException {
        properties = new Properties();
        try {
            properties
                    .load(new FileInputStream("etc/org.room72.cbs.servicesStructure.cfg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Entry<Object, Object> entry : properties.entrySet()) {
            services.put((String)entry.getKey(), (Class<? extends Service>) Class.forName((String) entry.getValue()));
        }
    }

    public Map<String, Class<? extends Service>> getServices() {
        return services;
    }

    public void setServices(Map<String, Class<? extends Service>> services) {
        this.services = services;
    }

    public Class<? extends Service> put(String key,
            Class<? extends Service> value) {
        return services.put(key, value);
    }
    
    
}
