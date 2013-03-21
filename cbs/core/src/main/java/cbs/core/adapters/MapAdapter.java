package cbs.core.adapters;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import cbs.core.model.Service;

public class MapAdapter extends XmlAdapter<MapElements[], Map<String, Class<? extends Service>>> {

    @Override
    public Map<String, Class<? extends Service>> unmarshal(MapElements[] v)
            throws Exception {
        Map<String, Class<? extends Service>> r = new HashMap<String, Class<? extends Service>>();
        for (MapElements mapelement : v)
            r.put(mapelement.key, mapelement.value);
        return r;
    }

    @Override
    public MapElements[] marshal(Map<String, Class<? extends Service>> v)
            throws Exception {
        MapElements[] mapElements = new MapElements[v.size()];
        int i = 0;
        for (Entry<String, Class<? extends Service>> entry : v.entrySet())
            mapElements[i++] = new MapElements(entry.getKey(), entry.getValue());

        return mapElements;
    }

}
