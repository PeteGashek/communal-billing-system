package cbs.core;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class TestLogic {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ElectricBill electricBill = new ElectricBill();
        electricBill.setCounterStatement(100);
        WaterBill waterBill = new WaterBill();
        waterBill.setCounterStatement(100);
        MonthBill monthBill = new MonthBill();
        monthBill.setMonthNumber(0);
        monthBill.setElectricBill(electricBill);
        monthBill.setWaterBill(waterBill);
        YearBill yearBill = new YearBill();
        ArrayList<MonthBill> al = new ArrayList<MonthBill>();
        al.add(monthBill);
        yearBill.setMonths(al);
        
        //
        try {
            
            File file = new File("G:\\test.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(YearBill.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
     
            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
     
            jaxbMarshaller.marshal(yearBill, file);
            jaxbMarshaller.marshal(yearBill, System.out);
     
              } catch (JAXBException e) {
            e.printStackTrace();
              }
    }

}
