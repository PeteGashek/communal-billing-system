package cbs.core;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.bind.JAXB;

import org.joda.time.YearMonth;

public class TestLogic {

    public static void main(String[] args) throws ParseException,
            InstantiationException, IllegalAccessException {
        Bills bills = new Bills();

        bills.put("electricity", CountableService.class);
        bills.put("hotWater", CountableService.class);
        bills.put("coldWater", CountableService.class);
        bills.put("kvartplata", Service.class);
        bills.put("internet", Service.class);

        List<Service> servicesList = new ArrayList<Service>();
        for (Entry<String, Class<? extends Service>> entry : bills.getServices().entrySet()) {
            Service temp = (Service) entry.getValue().newInstance();
            temp.setServiceName(entry.getKey());
            servicesList.add(temp);
        }

        Bill bill = new Bill();
        bill.setDate(new YearMonth());
        bill.setServices(servicesList);

        bills.add(bill);
        JAXB.marshal(bills, System.out);
        JAXB.marshal(bills, new File("test.xml"));

        System.out.println("============================");

        Bills unmarshalTest = JAXB.unmarshal(new File("test.xml"), Bills.class);
        JAXB.marshal(unmarshalTest, System.out);

    }
}