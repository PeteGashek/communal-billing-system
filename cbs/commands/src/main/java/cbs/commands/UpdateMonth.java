package cbs.commands;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

import cbs.core.Months;

@Command(scope = "cbs", name = "update", description = "updates month")
public final class UpdateMonth extends OsgiCommandSupport {
    @Argument(index = 0, name = "year", description = "year", required = true, multiValued = false)
    private int year;
    
    @Argument(index = 1, name = "month", description = "month", required = true, multiValued = false)
    private Months month;
    
    @Argument(index = 2, name = "electricCounterStatement", description = "electricCounterStatement", required = true, multiValued = false)
    private double electricCounterStatement;
    
    @Argument(index = 3, name = "waterCounterStatement", description = "waterCounterStatement", required = true, multiValued = false)
    private double waterCounterStatement;

    @Override
    protected Object doExecute() throws Exception {
        Commands.updateMonth(year, month, electricCounterStatement, waterCounterStatement);
        return null;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(Months month) {
        this.month = month;
    }

}
