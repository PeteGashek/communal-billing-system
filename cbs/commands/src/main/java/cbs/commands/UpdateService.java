package cbs.commands;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.joda.time.YearMonth;

import cbs.dao.exceptions.BillNotFoundException;
import cbs.dao.exceptions.ServiceNotFoundException;
import cbs.dao.service.ServiceUpdater;

@Command(scope = "cbs", name = "updservice", description = "update service")
public class UpdateService extends OsgiCommandSupport {
    @Argument(index = 0, name = "year", description = "year", required = true, multiValued = false)
    private Integer year;
    @Argument(index = 1, name = "month", description = "month", required = true, multiValued = false)
    private Integer month;
    //
    @Argument(index = 2, name = "serviceName", description = "serviceName", required = true, multiValued = false)
    private String serviceName;
    @Argument(index = 3, name = "counter", description = "counter", required = true, multiValued = false)
    private double counter;
    //
    private ServiceUpdater updater;

    @Override
    protected Object doExecute() {
        try {
            updater.updateService(new YearMonth(year,month), serviceName, counter);
        } catch (ServiceNotFoundException e) {
            e.printStackTrace();
        } catch (BillNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setUpdater(ServiceUpdater updater) {
        this.updater = updater;
    }

}