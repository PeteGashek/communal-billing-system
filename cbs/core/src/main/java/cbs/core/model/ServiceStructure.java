package cbs.core.model;

import java.util.HashMap;
import java.util.Map;

public class ServiceStructure {
    private Map<String, Class<? extends Service>> services = new HashMap<String, Class<? extends Service>>();

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
