package cbs.commands;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

import javax.xml.bind.JAXB;

import cbs.configs.CbsConfig;
import cbs.core.MonthBill;
import cbs.core.Months;
import cbs.core.YearBill;

public class Commands {
    
    public static void createYear(int year) {
        new File(CbsConfig.data).mkdirs();
        File yearStatement = new File(CbsConfig.data + Integer.valueOf(year).toString() + ".xml");
        if (yearStatement.exists()) {
            System.out.println("File already exsists");
        } else {
            try {
                yearStatement.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            YearBill yearBill = new YearBill();
            yearBill.setNumber(2013);
            JAXB.marshal(yearBill, yearStatement);
            System.out.println("File "+yearStatement+" was created");
        }
    }
    
    public static void updateMonth(int year, Months month, double electricCounterStatement, double waterCounterStatement) {
        YearBill yearBill = JAXB.unmarshal(new File(CbsConfig.data + Integer.valueOf(year).toString() + ".xml"), YearBill.class);
        LinkedHashSet<MonthBill> monthBills = yearBill.getMonths();
        for (MonthBill monthBill : monthBills) {
            if(monthBill.getMonth().equals(month)) {
                monthBill.getElectricBill().setCounterStatement(electricCounterStatement);
                monthBill.getWaterBill().setCounterStatement(waterCounterStatement);
            }
        }
        yearBill.setMonths(monthBills);
        JAXB.marshal(yearBill, new File(CbsConfig.data + Integer.valueOf(year).toString() + ".xml"));
    }
}
