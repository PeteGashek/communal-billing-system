package cbs.core;

<<<<<<< HEAD
=======


>>>>>>> 654791b98866c92a9ee5a7e98d1b690db9dd9030
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.YearMonth;


/**
 * @author Igor.Gladkiy
 * 
 */
@XmlRootElement
public class Bill {
<<<<<<< HEAD
    private YearMonth date;
    private List<Service> services;
=======
    private String date;

    public String getDate() {
        return date;
    }

    @XmlAttribute
    public void setDate(String date) {
        this.date = date;
    }
>>>>>>> 654791b98866c92a9ee5a7e98d1b690db9dd9030

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
