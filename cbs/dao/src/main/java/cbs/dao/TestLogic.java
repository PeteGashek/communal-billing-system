package cbs.dao;

import java.text.ParseException;

import org.joda.time.YearMonth;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLogic {

    public static void main(String[] args) {
        
        
        
//        ApplicationContext acx = new ClassPathXmlApplicationContext("META-INF/spring/context.xml");
//        BillDAOXmlImpl impl = (BillDAOXmlImpl) acx.getBean("billdaoxml");
//        impl.createBill();
//        impl.createBill(new YearMonth(2015, 6));
        
        
        
        
        
        
        
//        Bills bills = new Bills();
//
//        bills.put("electricity", CountableService.class);
//        bills.put("hotWater", CountableService.class);
//        bills.put("coldWater", CountableService.class);
//        bills.put("kvartplata", UncountableService.class);
//        bills.put("internet", UncountableService.class);
//
//        List<Service> servicesList = new ArrayList<Service>();
//        for (Entry<String, Class<? extends Service>> entry : bills
//                .getServices().entrySet()) {
//            Service temp = (Service) entry.getValue().newInstance();
//            temp.setServiceName(entry.getKey());
//            if (temp instanceof CountableService) {
//                ((CountableService) temp).setCounter(999);
//            }
//            servicesList.add(temp);
//        }
//
//        Bill bill = new Bill();
//        bill.setDate(new YearMonth());
//        bill.setServices(servicesList);
//
//        bills.add(bill);
//        ApplicationContext acx = new ClassPathXmlApplicationContext("META-INF/spring/context.xml");
////        Config conf = (Config)acx.getBean("config");
////        System.out.println(conf.getBillsPath());
//        try {
//
//            File file = new File("test.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(Bills.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "");
//
//            jaxbMarshaller.marshal(bills, file);
//            jaxbMarshaller.marshal(bills, System.out);
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("============================");
//
//        try {
//
//            File file = new File("test.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(Bills.class);
//            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//            Bills unmarshalTest = (Bills) jaxbUnMarshaller.unmarshal(file);
//
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "");
//
//            jaxbMarshaller.marshal(unmarshalTest, System.out);
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }

    }
}