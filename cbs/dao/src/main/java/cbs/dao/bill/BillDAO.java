package cbs.dao.bill;

import org.joda.time.YearMonth;

import cbs.core.model.Bill;
import cbs.dao.exceptions.BillAlreadyExistsException;
import cbs.dao.exceptions.BillNotFoundException;

public interface BillDAO {
    void createBill(YearMonth yearMonth) throws BillAlreadyExistsException ;
    Bill readBill(YearMonth yearMonth) throws BillNotFoundException ;
    void updateBill(Bill bill);
    void deleteBill(YearMonth yearMonth);
}
