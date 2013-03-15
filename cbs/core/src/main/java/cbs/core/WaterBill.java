package cbs.core;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class WaterBill extends Bill {

    @Override
    public String toString() {
        return "WaterBill [counterStatement=" + counterStatement + "]";
    }

}
