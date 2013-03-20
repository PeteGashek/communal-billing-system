package cbs.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class Bills {
    private List<Bill> bills = new ArrayList<Bill>();
    private Map<String, Class<? extends Service>> services = new HashMap<String, Class<? extends Service>>();

    public Map<String, Class<? extends Service>> getServices() {
        return services;
    }

    @XmlJavaTypeAdapter(MapAdapter.class)
    @XmlElement
    public void setServices(Map<String, Class<? extends Service>> services) {
        this.services = services;
    }

    public Class<? extends Service> put(String key, Class<? extends Service> value) {
        return services.put(key, value);
    }

    public boolean add(Bill e) {
        return bills.add(e);
    }

    public List<Bill> getBills() {
        return bills;
    }

    @XmlElement(name = "bill")
    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

}
