package cbs.core.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bills {
    private Set<Bill> bills = new HashSet<Bill>();

    public boolean add(Bill e) {
        return bills.add(e);
    }

    public Set<Bill> getBills() {
        return bills;
    }

    @XmlElement(name = "bill")
    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

}
