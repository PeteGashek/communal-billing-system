package cbs.core.model;

import javax.xml.bind.annotation.XmlAttribute;

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
