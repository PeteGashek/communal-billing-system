package cbs.dao;

import java.util.Set;

import org.joda.time.YearMonth;

import cbs.core.model.Bill;

public interface BillDAO {
    void createBill(YearMonth yearMonth);
    Bill readBill(YearMonth yearMonth);
    void updateBill(Bill bill);
    void deleteBill(YearMonth yearMonth);
    Set<Bill> listBills();
}
