package cbs.core;

import java.util.LinkedHashSet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class YearBill {
    private  LinkedHashSet<MonthBill> months;

    public LinkedHashSet<MonthBill> getMonths() {
        return months;
    }

    @XmlElement
    public void setMonths( LinkedHashSet<MonthBill> months) {
        this.months = months;
    }
}
