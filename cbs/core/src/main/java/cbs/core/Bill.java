package cbs.core;

import javax.xml.bind.annotation.XmlElement;

public class Bill {
    protected long counterStatement;

    public long getCounterStatement() {
        return counterStatement;
    }

    @XmlElement
    public void setCounterStatement(long counterStatement) {
        this.counterStatement = counterStatement;
    }
}
