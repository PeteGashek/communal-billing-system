package cbs.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.YearMonth;

import cbs.core.adapters.YearMonthAdapter;

@XmlRootElement
public class Bill {

    private YearMonth date;
    private Set<Service> services = new HashSet<Service>();

    public boolean add(Service e) {
        return services.add(e);
    }

    public Set<Service> getServices() {
        return services;
    }

    @XmlElement(name = "service")
    public void setServices(Set<Service> services) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bill other = (Bill) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        return true;
    }


}
