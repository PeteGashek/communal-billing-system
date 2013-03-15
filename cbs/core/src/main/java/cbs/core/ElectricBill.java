package cbs.core;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ElectricBill extends Bill {

    @Override
    public String toString() {
        return "ElectricBill [counterStatement=" + counterStatement + "]";
    }

}
