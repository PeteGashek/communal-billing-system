package cbs.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.joda.time.YearMonth;

import cbs.core.model.Bill;
import cbs.core.model.Bills;
import cbs.core.model.Service;
import cbs.core.model.ServiceStructure;

public class BillDAOXmlImpl implements BillDAO {

    private Bills bills;
    private ServiceStructure serviceStructure;
    // private String billsPath = "./cbs/bills/";
    private Properties properties;

    BillDAOXmlImpl() {
        this.bills = new Bills();
        properties = new Properties();
        try {
            properties
                    .load(new FileInputStream("etc/org.room72.cbs.paths.cfg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(properties.getProperty("billsPath"));
        file.mkdirs();
        unmarshal();
    }

    public ServiceStructure getServiceStructure() {
        return serviceStructure;
    }

    public void setServiceStructure(ServiceStructure serviceStructure) {
        this.serviceStructure = serviceStructure;
    }

    private void unmarshal() {
        try {
            File file = new File(properties.getProperty("billsPath")
                    + properties.getProperty("billsName"));
            try {
                if (file.createNewFile()) {
                    bills = new Bills();
                } else {
                    JAXBContext jaxbContext = JAXBContext
                            .newInstance(Bills.class);
                    Unmarshaller jaxbUnMarshaller = jaxbContext
                            .createUnmarshaller();
                    bills = (Bills) jaxbUnMarshaller.unmarshal(file);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // JAXBContext jaxbContext = JAXBContext.newInstance(Bills.class);
            // Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            // bills = (Bills) jaxbUnMarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void marshal() {
        try {
            File file = new File(properties.getProperty("billsPath")
                    + properties.getProperty("billsName"));
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
        if (!bills.add(bill)) {
            System.out.println("Bill already exists!");
        }

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
        Set<Bill> temp = bills.getBills();
        Bill tempBill = new Bill();
        tempBill.setDate(yearMonth);
        temp.remove(tempBill);
        bills.setBills(temp);
        marshal();
    }

    @Override
    public Set<Bill> listBills() {
        // TODO Auto-generated method stub
        return null;
    }

}
