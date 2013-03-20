package cbs.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Bills {
    private List<Bill> bills = new ArrayList<Bill>();
    private HashMap<String, Class<? extends Service>> services = new HashMap<String, Class<? extends Service>>();

    public HashMap<String, Class<? extends Service>> getServices() {
        return services;
    }

    @XmlElement
    public void setServices(HashMap<String, Class<? extends Service>> services) {
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
