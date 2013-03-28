package cbs.dao.service;

import org.joda.time.YearMonth;

import cbs.dao.exceptions.BillNotFoundException;
import cbs.dao.exceptions.ServiceNotFoundException;

public interface ServiceUpdater {
    void updateService(YearMonth yearMonth, String serviceName, double counter) throws ServiceNotFoundException, BillNotFoundException;

}
