package cbs.commands;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

import cbs.dao.BillDAO;

@Command(scope = "cbs", name = "createbill", description = "create bill")
public class CreateBill extends OsgiCommandSupport {

//    @Argument(index = 0, name = "billdaoxml", description = "billdaoxml", required = true, multiValued = false)
    private BillDAO billdao;
    
    @Override
    protected Object doExecute() throws Exception {
        billdao.createBill();
        return null;
    }

    public BillDAO getBilldao() {
        return billdao;
    }

    public void setBilldao(BillDAO billdao) {
        this.billdao = billdao;
    }
}
