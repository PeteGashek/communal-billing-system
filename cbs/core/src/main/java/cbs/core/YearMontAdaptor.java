package cbs.core;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.YearMonth;

public class YearMontAdaptor extends XmlAdapter<String, YearMonth> {

    @Override
    public YearMonth unmarshal(String v) throws Exception {
        return YearMonth.parse(v);
    }

    @Override
    public String marshal(YearMonth v) throws Exception {
        return v.toString();
    }

}