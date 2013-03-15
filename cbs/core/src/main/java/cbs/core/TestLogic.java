package cbs.core;


import java.io.File;
import java.util.LinkedHashSet;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class TestLogic {

    /**
* @param args
*/
    public static void main(String[] args) {
        // TODO Auto-generated method stub

// ElectricBill electricBill = new ElectricBill();
// electricBill.setCounterStatement(100);
//
// WaterBill waterBill = new WaterBill();
// waterBill.setCounterStatement(100.451);
//
// ElectricBill electricBill2 = new ElectricBill();
// electricBill2.setCounterStatement(123);
//
// WaterBill waterBill2 = new WaterBill();
// waterBill2.setCounterStatement(110.351);
//
// MonthBill monthBill = new MonthBill();
// monthBill.setMonth(Months.January);
// monthBill.setElectricBill(electricBill);
// monthBill.setWaterBill(waterBill);
//
// MonthBill monthBill2 = new MonthBill();
// monthBill2.setMonth(Months.January);
// monthBill2.setElectricBill(electricBill2);
// monthBill2.setWaterBill(waterBill2);
        
        YearBill yearBill = new YearBill();
        yearBill.setNumber(2013);
// LinkedHashSet<MonthBill> al = new LinkedHashSet<MonthBill>();
// al.add(monthBill);
// al.add(monthBill2);
// yearBill.setMonths(al);

        //
        try {

            // File file = new File("E:\\test.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(YearBill.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // jaxbMarshaller.marshal(yearBill, file);
            jaxbMarshaller.marshal(yearBill, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}