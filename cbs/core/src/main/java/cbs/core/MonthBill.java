package cbs.core;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MonthBill {
    private Months month;
    private ElectricBill electricBill;
    private WaterBill waterBill;

    public ElectricBill getElectricBill() {
        return electricBill;
    }

    @XmlElement(name = "electic")
    public void setElectricBill(ElectricBill electricBill) {
        this.electricBill = electricBill;
    }

    public WaterBill getWaterBill() {
        return waterBill;
    }

    @XmlElement(name = "water")
    public void setWaterBill(WaterBill waterBill) {
        this.waterBill = waterBill;
    }

    public Months getMonth() {
        return month;
    }

    @XmlAttribute(name = "name")
    public void setMonth(Months month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return ((MonthBill) obj).getMonth().equals(this.getMonth());
        } else {
            return false;
        }
    }

}
