package cbs.dao;

import java.util.List;

import org.joda.time.YearMonth;

import cbs.core.model.Bill;

public interface BillDAO {
    void createBill();
    Bill readBill(YearMonth yearMonth);
    void updateBill(Bill bill);
    void deleteBill(YearMonth yearMonth);
    List<Bill> listBills();
}
