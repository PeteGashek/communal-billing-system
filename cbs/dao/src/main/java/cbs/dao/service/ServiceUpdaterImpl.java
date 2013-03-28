package cbs.dao.service;

import java.util.Iterator;

import org.joda.time.YearMonth;

import cbs.core.model.Bill;
import cbs.core.model.CountableService;
import cbs.core.model.Service;
import cbs.dao.bill.BillDAO;
import cbs.dao.exceptions.BillNotFoundException;
import cbs.dao.exceptions.ServiceNotFoundException;

public class ServiceUpdaterImpl implements ServiceUpdater {
    private BillDAO billDAO;

    @Override
    public void updateService(YearMonth yearMonth, String serviceName, double counter)
            throws ServiceNotFoundException, BillNotFoundException {
        Bill tmpBill = null;

        tmpBill = billDAO.readBill(yearMonth);
        boolean isFound = false;
        for (Iterator<Service> it = tmpBill.getServices().iterator(); it.hasNext();) {
            Service service = it.next();
            if ((service.getServiceName().equals(serviceName)) && (service instanceof CountableService)) {
                //
                ((CountableService) service).setCounter(counter);
                isFound = true;

            }
        }
        if (isFound == false) {
            throw new ServiceNotFoundException();
        }
        billDAO.updateBill(tmpBill);
    }

    public BillDAO getBillDAO() {
        return billDAO;
    }

    public void setBillDAO(BillDAO billDAO) {
        this.billDAO = billDAO;
    }

}
