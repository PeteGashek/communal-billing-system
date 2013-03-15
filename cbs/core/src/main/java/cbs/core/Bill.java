package cbs.core;

import javax.xml.bind.annotation.XmlElement;

public class Bill {
    protected double counterStatement;

    public double getCounterStatement() {
        return counterStatement;
    }

    @XmlElement
    public void setCounterStatement(double counterStatement) {
        this.counterStatement = counterStatement;
    }
}
