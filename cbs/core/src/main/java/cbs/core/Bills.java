package cbs.core;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Bills {
    private List<Bill> bills;

    public List<Bill> getBills() {
        return bills;
    }

    @XmlElement
    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
