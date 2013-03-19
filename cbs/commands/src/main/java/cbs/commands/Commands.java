//package cbs.commands;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.LinkedHashSet;
//
//import javax.xml.bind.JAXB;
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//
//import cbs.configs.CbsConfig;
//import cbs.core.MonthBill;
//import cbs.core.Months;
//import cbs.core.YearBill;
//
//public class Commands {
//
//    public static void createYear(int year) {
//        new File(CbsConfig.data).mkdirs();
//        File yearStatement = new File(CbsConfig.data + Integer.valueOf(year).toString() + ".xml");
//        if (yearStatement.exists()) {
//            System.out.println("File already exsists");
//        } else {
//            try {
//                yearStatement.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            YearBill yearBill = new YearBill();
//            yearBill.setNumber(year);
//            JAXB.marshal(yearBill, yearStatement);
//            System.out.println("File " + yearStatement + " was created");
//        }
//    }
//
//    public static void updateMonth(int year, Months month, double electricCounterStatement,
//            double waterCounterStatement) {
//        YearBill yearBill = JAXB.unmarshal(new File(CbsConfig.data + Integer.valueOf(year).toString()
//                + ".xml"), YearBill.class);
//        LinkedHashSet<MonthBill> monthBills = yearBill.getMonths();
//        for (MonthBill monthBill : monthBills) {
//            if (monthBill.getMonth().equals(month)) {
//                monthBill.getElectricBill().setCounterStatement(electricCounterStatement);
//                monthBill.getWaterBill().setCounterStatement(waterCounterStatement);
//            }
//        }
//        yearBill.setMonths(monthBills);
//        JAXB.marshal(yearBill, new File(CbsConfig.data + Integer.valueOf(year).toString() + ".xml"));
//    }
//
//    public static void showList(int year, Months month) {
//        YearBill yearBill = JAXB.unmarshal(new File(CbsConfig.data + Integer.valueOf(year).toString()
//                + ".xml"), YearBill.class);
//        if (month == null) {
//            try {
//                JAXBContext jaxbContext = JAXBContext.newInstance(YearBill.class);
//                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//                jaxbMarshaller.marshal(yearBill, System.out);
//            } catch (JAXBException e) {
//                e.printStackTrace();
//            }
//        } else {
//            LinkedHashSet<MonthBill> monthBills = yearBill.getMonths();
//            for (MonthBill monthBill : monthBills) {
//                if (monthBill.getMonth().equals(month)) {
//                    try {
//                        JAXBContext jaxbContext = JAXBContext.newInstance(MonthBill.class);
//                        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//                        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//                        jaxbMarshaller.marshal(monthBill, System.out);
//                    } catch (JAXBException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//
//    }
//
//    public static void clearMonth(int year, Months month) {
//        updateMonth(year, month, -1, -1);
//        // YearBill yearBill = JAXB.unmarshal(new File(CbsConfig.data +
//        // Integer.valueOf(year).toString()
//        // + ".xml"), YearBill.class);
//        // LinkedHashSet<MonthBill> monthBills = yearBill.getMonths();
//        // for (MonthBill monthBill : monthBills) {
//        // if (monthBill.getMonth().equals(month)) {
//        // monthBill.getElectricBill().setCounterStatement(-1);
//        // monthBill.getWaterBill().setCounterStatement(-1);
//        // }
//        // }
//        // yearBill.setMonths(monthBills);
//        // JAXB.marshal(yearBill, new File(CbsConfig.data +
//        // Integer.valueOf(year).toString() + ".xml"));
//    }
//}
