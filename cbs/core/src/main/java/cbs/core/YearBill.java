package cbs.core;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class YearBill {
    private List<MonthBill> months;

    public List<MonthBill> getMonths() {
        return months;
    }

    @XmlElement
    public void setMonths(List<MonthBill> months) {
        this.months = months;
    }
}
