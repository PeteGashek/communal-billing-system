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
import cbs.core.model.Service;
import cbs.core.model.ServiceStructure;

public class BillDAOXmlImpl implements BillDAO {

    private Bills bills;
    private ServiceStructure serviceStructure;

    private Properties property;
    private String billsPath = "";

    BillDAOXmlImpl(String path) {
        property = new Properties();
        bills = new Bills();
        try {
            property.load(new FileInputStream(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        billsPath = property.getProperty("billsPath");

        File file = new File(billsPath);
        file.mkdirs();

        marshal();
    }

    public Properties getProperty() {
        return property;
    }

    public void setProperty(Properties property) {
        this.property = property;
    }

    public String getBillsPath() {
        return billsPath;
    }

    public ServiceStructure getServiceStructure() {
        return serviceStructure;
    }

    public void setServiceStructure(ServiceStructure serviceStructure) {
        this.serviceStructure = serviceStructure;
    }

    private void unmarshal() {
        try {
            File file = new File(billsPath + "test.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Bills.class);
            Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
            bills = (Bills) jaxbUnMarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void marshal() {
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
        bill.setDate(new YearMonth());
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
