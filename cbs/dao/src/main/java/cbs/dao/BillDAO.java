package cbs.dao;

import org.joda.time.YearMonth;

import cbs.core.model.Bill;

public interface BillDAO {
    void createBill(YearMonth yearMonth) throws Exception;
    Bill readBill(YearMonth yearMonth) throws Exception;
    void updateBill(Bill bill);
    void deleteBill(YearMonth yearMonth);
}
