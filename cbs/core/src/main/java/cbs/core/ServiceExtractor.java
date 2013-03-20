package cbs.core;

import org.eclipse.persistence.descriptors.ClassExtractor;
import org.eclipse.persistence.sessions.Record;
import org.eclipse.persistence.sessions.Session;

public class ServiceExtractor extends ClassExtractor {

    @Override
    public Class<?> extractClassFromRow(Record record, Session session) {
        if(null != record.get("@counter")) {
            return CountableService.class;
        } else if(null != record.get("@serviceName")) {
            return Service.class;
        }
        return null;
    }

}
