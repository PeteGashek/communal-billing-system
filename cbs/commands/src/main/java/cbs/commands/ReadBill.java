package cbs.commands;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.joda.time.YearMonth;

import cbs.core.model.Bill;
import cbs.dao.BillDAO;

@Command(scope = "cbs", name = "readbill", description = "read bill")
public class ReadBill extends OsgiCommandSupport {
    @Argument(index = 0, name = "year", description = "year", required = true, multiValued = false)
    private Integer year;
    @Argument(index = 1, name = "month", description = "month", required = true, multiValued = false)
    private Integer month;
    private BillDAO billdao;

    @Override
    protected Object doExecute() throws Exception {
        try {
            Bill tempBill = billdao.readBill(new YearMonth(year, month));
            JAXBContext jaxbContext = JAXBContext.newInstance(tempBill
                    .getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "");

            jaxbMarshaller.marshal(tempBill, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setBilldao(BillDAO billdao) {
        this.billdao = billdao;
    }

}