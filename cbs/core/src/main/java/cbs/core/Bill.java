package cbs.core;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.YearMonth;

public class Bill {
    private YearMonth date;
    private List<Service> services = new ArrayList<Service>();

    public boolean add(Service e) {
        return services.add(e);
    }

    public List<Service> getServices() {
        return services;
    }

    @XmlElement(name = "service")
    public void setServices(List<Service> services) {
        this.services = services;
    }

    public YearMonth getDate() {
        return date;
    }

    @XmlAttribute
    @XmlJavaTypeAdapter(YearMonthAdapter.class)
    public void setDate(YearMonth date) {
        this.date = date;
    }

}
