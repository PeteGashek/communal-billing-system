package cbs.commands;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

import cbs.dao.BillDAO;

@Command(scope = "cbs", name = "createbill", description = "create bill")
public class CreateBill extends OsgiCommandSupport {

    private BillDAO billdao;
    
    @Override
    protected Object doExecute() throws Exception {
        billdao.createBill();
        return null;
    }

    public void setBilldao(BillDAO billdao) {
        this.billdao = billdao;
    }

}
