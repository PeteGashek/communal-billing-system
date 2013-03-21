package cbs.core.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({CountableService.class, UncountableService.class})
public abstract class Service {
    private String serviceName;
    private double payment;

    public String getServiceName() {
        return serviceName;
    }

    @XmlAttribute
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPayment() {
        return payment;
    }

    @XmlElement
    public void setPayment(double payment) {
        this.payment = payment;
    }
}
