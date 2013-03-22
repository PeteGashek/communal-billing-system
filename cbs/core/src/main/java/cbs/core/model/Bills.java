package cbs.core.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bills {
    private List<Bill> bills = new ArrayList<Bill>();

    public boolean add(Bill e) {
        return bills.add(e);
    }

    public List<Bill> getBills() {
        return bills;
    }

    @XmlElement(name = "bill")
    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

}
