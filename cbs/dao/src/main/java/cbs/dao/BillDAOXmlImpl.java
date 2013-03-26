package cbs.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.joda.time.YearMonth;

import cbs.core.model.Bill;
import cbs.core.model.Bills;
import cbs.core.model.CountableService;
import cbs.core.model.Service;
import cbs.core.model.ServiceStructure;
import cbs.core.model.UncountableService;

public class BillDAOXmlImpl implements BillDAO {

    private Bills bills;
    private ServiceStructure serviceStructure;

//    private Properties property;
    private String billsPath = "";

    BillDAOXmlImpl() {

        // serviceStructure = new ServiceStructure();
        // serviceStructure.put("aaa", CountableService.class);
        // serviceStructure.put("bbb", UncountableService.class);

        // this.bills = bills;
        this.bills = new Bills();
        billsPath = "./cbs/bills/";
        File file = new File(billsPath);
        file.mkdirs();
//        try {
//            property.load(new FileInputStream("./cbs/bills/"));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        serviceStructure = new ServiceStructure();
//        serviceStructure.put("aaa", CountableService.class);
//        serviceStructure.put("bbb", UncountableService.class);

        // marshal();
    }

//    public Properties getProperty() {
//        return property;
//    }
//
//    public void setProperty(Properties property) {
//        this.property = property;
//    }

    public String getBillsPath() {
        return billsPath;
    }

    public ServiceStructure getServiceStructure() {
        return serviceStructure;
    }

    public void setServiceStructure(ServiceStructure serviceStructure) {
        this.serviceStructure = serviceStructure;
    }

    // private void unmarshal() {
    // try {
    // File file = new File(billsPath + "test.xml");
    // JAXBContext jaxbContext = JAXBContext.newInstance(Bills.class);
    // Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
    // bills = (Bills) jaxbUnMarshaller.unmarshal(file);
    // } catch (JAXBException e) {
    // e.printStackTrace();
    // }
    // }

    public void marshal() {
        try {
            File file = new File(billsPath + "test.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(bills.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "");

            jaxbMarshaller.marshal(bills, file);
            jaxbMarshaller.marshal(bills, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createBill() {
        createBill(new YearMonth());
    }

    @Override
    public void createBill(YearMonth yearMonth) {
        Bill bill = new Bill();
        for (Entry<String, Class<? extends Service>> entry : serviceStructure
                .getServices().entrySet()) {
            Service temp;
            try {
                temp = (Service) entry.getValue().newInstance();
                temp.setServiceName(entry.getKey());
                bill.add(temp);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        bill.setDate(yearMonth);
        bills.add(bill);
        marshal();

    }

    @Override
    public Bill readBill(YearMonth yearMonth) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateBill(Bill bill) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteBill(YearMonth yearMonth) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Bill> listBills() {
        // TODO Auto-generated method stub
        return null;
    }

}
