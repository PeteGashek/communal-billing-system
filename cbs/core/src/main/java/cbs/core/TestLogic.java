package cbs.core;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXB;

import org.joda.time.YearMonth;


public class TestLogic {

    /**
     * @param args
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {
        Service uncountable = new Service();
        uncountable.setServiceName("internet");
        uncountable.setPayment(500.2325);
        //
        CountableService countable = new CountableService();
        countable.setServiceName("electricity");
        countable.setCounter(223.22);
        countable.setPayment(2121.033);
        //
        Bill bill = new Bill();
        bill.setDate(new YearMonth(2013, 3));
        List<Service> all = new ArrayList<Service>();
        all.add(countable);
        all.add(uncountable);
        bill.setServices(all);
        //
        Bills allBills = new Bills();
        List<Bill> output = new ArrayList<Bill>();
        output.add(bill);
        allBills.setBills(output);
        //
        JAXB.marshal(allBills, System.out);
        
    }
}