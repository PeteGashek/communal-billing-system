package cbs.core;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Service {
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
