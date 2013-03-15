package cbs.core;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Igor.Gladkiy
 *
 */
public class Bill {
    protected double counterStatement;

    public double getCounterStatement() {
        return counterStatement;
    }

    @XmlElement
    public void setCounterStatement(double counterStatement) {
        this.counterStatement = counterStatement;
    }

    @Override
    public String toString() {
        return "Bill [counterStatement=" + counterStatement + "]";
    }
    
}
