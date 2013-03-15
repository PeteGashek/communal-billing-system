package cbs.commands;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

import cbs.core.Months;

@Command(scope = "cbs", name = "clear", description = "cleans month")
public final class ClearMonth extends OsgiCommandSupport {
    @Argument(index = 0, name = "year", description = "year", required = true, multiValued = false)
    private int year;
    
    @Argument(index = 1, name = "month", description = "month", required = true, multiValued = false)
    private Months month;
    @Override
    protected Object doExecute() throws Exception {
        Commands.clearMonth(year, month);
        return null;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Months getMonth() {
        return month;
    }

    public void setMonth(Months month) {
        this.month = month;
    }




}
