package cbs.commands;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.joda.time.YearMonth;

import cbs.dao.BillDAO;

@Command(scope = "cbs", name = "createbill", description = "create bill")
public class CreateBill extends OsgiCommandSupport {
    @Argument(index = 0, name = "year", description = "year", required = false, multiValued = false)
    private Integer year;
    @Argument(index = 1, name = "month", description = "month", required = false, multiValued = false)
    private Integer month;
    private BillDAO billdao;

    @Override
    protected Object doExecute() throws Exception {
        if ((month != null) && (year != null)) {
            billdao.createBill(new YearMonth(year, month));
        } else if (((month == null) && (year != null)) || ((month != null) && (year == null))) {
            System.out.println("Invalid arguments ! Retype!");
        } else {
            billdao.createBill();
        }
        return null;
    }

    public void setBilldao(BillDAO billdao) {
        this.billdao = billdao;
    }

}
