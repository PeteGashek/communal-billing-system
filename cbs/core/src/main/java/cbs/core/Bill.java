package cbs.core;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.YearMonth;

public class Bill {
    private YearMonth date;
    private List<Service> services;

    public List<Service> getServices() {
        return services;
    }

    @XmlElements({ @XmlElement(name = "service", type = Service.class),
            @XmlElement(name = "service", type = CountableService.class) })
    public void setServices(List<Service> services) {
        this.services = services;
    }

    public YearMonth getDate() {
        return date;
    }

    @XmlAttribute
    @XmlJavaTypeAdapter(YearMontAdaptor.class)
    public void setDate(YearMonth date) {
        this.date = date;
    }

}
