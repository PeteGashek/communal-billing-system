package cbs.core;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Igor.Gladkiy
 * 
 */
public class Bill {
    private Date date;

    public Date getDate() {
        return date;
    }

    @XmlAttribute
    public void setDate(Date date) {
        this.date = date;
    }

    public List<Service> getServices() {
        return services;
    }

    @XmlElement
    public void setServices(List<Service> services) {
        this.services = services;
    }

    private List<Service> services;
}
