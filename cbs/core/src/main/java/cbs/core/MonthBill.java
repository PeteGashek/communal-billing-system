package cbs.core;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MonthBill {
    private int monthNumber;
    ElectricBill electricBill;

    public ElectricBill getElectricBill() {
        return electricBill;
    }

    @XmlElement
    public void setElectricBill(ElectricBill electricBill) {
        this.electricBill = electricBill;
    }

    public WaterBill getWaterBill() {
        return waterBill;
    }

    @XmlElement
    public void setWaterBill(WaterBill waterBill) {
        this.waterBill = waterBill;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    @XmlAttribute
    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    WaterBill waterBill;
}
