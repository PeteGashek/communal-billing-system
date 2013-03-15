package cbs.commands;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

import cbs.core.Months;

@Command(scope = "cbs", name = "list", description = "list")
public final class ShowList extends OsgiCommandSupport {
    @Argument(index = 0, name = "year", description = "year", required = true, multiValued = false)
    private int year;
    
    @Argument(index = 1, name = "month", description = "month", required = false, multiValued = false)
    private Months month;
    
    @Override
    protected Object doExecute() throws Exception {
        Commands.showList(year, month);
        return null;
    }


}
