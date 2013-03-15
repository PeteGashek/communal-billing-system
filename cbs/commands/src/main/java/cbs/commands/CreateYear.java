package cbs.commands;

import java.io.File;

import javax.xml.bind.JAXB;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

import cbs.core.YearBill;
import cbs.configs.*;

@Command(scope = "cbs", name = "newyear", description = "create year")
public final class CreateYear extends OsgiCommandSupport {
    @Argument(index = 0, name = "year", description = "create year", required = true, multiValued = false)
    private int year;

    @Override
    protected Object doExecute() throws Exception {
        new File(CbsConfig.data).mkdirs();
        File yearStatement = new File(CbsConfig.data + Integer.valueOf(year).toString() + ".xml");
        if (yearStatement.exists()) {
            System.out.println("File already exsists");
        } else {
            yearStatement.createNewFile();
            YearBill yearBill = new YearBill();
            yearBill.setNumber(2013);
            JAXB.marshal(yearBill, yearStatement);
            System.out.println("File "+yearStatement+" was created");
        }
        return null;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
