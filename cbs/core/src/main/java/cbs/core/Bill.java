package cbs.core;



import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Igor.Gladkiy
 * 
 */
@XmlRootElement
public class Bill {
    private String date;

    public String getDate() {
        return date;
    }

    @XmlAttribute
    public void setDate(String date) {
        this.date = date;
    }

    public List<Service> getServices() {
        return services;
    }

    @XmlElements({
        @XmlElement(name="service", type=Service.class),
        @XmlElement(name="service", type=CountableService.class)
    })
    public void setServices(List<Service> services) {
        this.services = services;
    }

    private List<Service> services;
}
