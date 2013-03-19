package cbs.core;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "service")
public class CountableService extends Service {
    private double counter;

    public double getCounter() {
        return counter;
    }

    @XmlAttribute
    public void setCounter(double counter) {
        this.counter = counter;
    }
}
