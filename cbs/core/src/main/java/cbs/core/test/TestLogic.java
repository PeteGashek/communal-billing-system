package cbs.core.test;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.joda.time.YearMonth;

import cbs.core.model.Bill;
import cbs.core.model.Bills;
import cbs.core.model.CountableService;
import cbs.core.model.Service;
import cbs.core.model.UncountableService;

public class TestLogic {

    public static void main(String[] args) throws ParseException,
            InstantiationException, IllegalAccessException {
        Bills bills = new Bills();

        bills.put("electricity", CountableService.class);
        bills.put("hotWater", CountableService.class);
        bills.put("coldWater", CountableService.class);
        bills.put("kvartplata", UncountableService.class);
        bills.put("internet", UncountableService.class);

        List<Service> servicesList = new ArrayList<Service>();
        for (Entry<String, Class<? extends Service>> entry : bills
                .getServices().entrySet()) {
            Service temp = (Service) entry.getValue().newInstance();
            temp.setServiceName(entry.getKey());
            if (temp instanceof CountableService) {
                ((CountableService) temp).setCounter(999);
            }
            servicesList.add(temp);
        }

        Bill bill = new Bill();
        bill.setDate(new YearMonth());
        bill.setServices(servicesList);

        bills.add(bill);
        try {

            File file = new File("test.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Bills.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "");

            jaxbMarshaller.marshal(bills, file);
            jaxbMarshaller.marshal(bills, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        System.out.println("============================");

        try {

            File file = new File("test.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Bills.class);
            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            Bills unmarshalTest = (Bills) jaxbUnMarshaller.unmarshal(file);

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "");

            jaxbMarshaller.marshal(unmarshalTest, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}