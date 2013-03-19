package cbs.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXB;

public class TestLogic {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Service uncountable = new Service();
        uncountable.setServiceName("internet");
        uncountable.setPayment(500.2325);
        //
        CountableService countable = new CountableService();
        countable.setServiceName("electricity");
        countable.setPayment(2121.033);
        countable.setCounter(223.22);
        //
        Bill bill = new Bill();
        bill.setDate(new Date());
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