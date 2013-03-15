package cbs.core;

import java.util.LinkedHashSet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "year")
public class YearBill {
    private int number;
    private LinkedHashSet<MonthBill> months;

    public YearBill() {
        months = new LinkedHashSet<MonthBill>();
        for (int i = 0; i < Months.values().length; i++) {
            ElectricBill tempElectricBill = new ElectricBill();
            tempElectricBill.setCounterStatement(-1);

            WaterBill tempWaterBill = new WaterBill();
            tempWaterBill.setCounterStatement(-1);

            MonthBill tempMonthBill = new MonthBill();
            tempMonthBill.setMonth(Months.values()[i]);
            tempMonthBill.setElectricBill(tempElectricBill);
            tempMonthBill.setWaterBill(tempWaterBill);

            months.add(tempMonthBill);
        }
    }

    public LinkedHashSet<MonthBill> getMonths() {
        return months;
    }

    @XmlElement
    public void setMonths(LinkedHashSet<MonthBill> months) {
        this.months = months;
    }

    public int getNumber() {
        return number;
    }

    @XmlAttribute(name = "number")
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "YearBill [number=" + number + ", \nmonths=" + months + "]";
    }

}
