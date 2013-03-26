package cbs.commands;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.joda.time.YearMonth;

import cbs.dao.BillDAO;

@Command(scope = "cbs", name = "deletebill", description = "delete bill")
public class DeleteBill extends OsgiCommandSupport {
    @Argument(index = 0, name = "year", description = "year", required = true, multiValued = false)
    private Integer year;
    @Argument(index = 1, name = "month", description = "month", required = true, multiValued = false)
    private Integer month;
    private BillDAO billdao;

    @Override
    protected Object doExecute() throws Exception {
        billdao.deleteBill(new YearMonth(year, month));
        return null;
    }

    public void setBilldao(BillDAO billdao) {
        this.billdao = billdao;
    }

}
