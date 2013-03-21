package cbs.core;

import javax.xml.bind.annotation.XmlElement;

class MapElements {
    @XmlElement
    public String key;
    @XmlElement
    public Class<? extends Service> value;

    public MapElements() {
    } // Required by JAXB

    public MapElements(String key, Class<? extends Service> value) {
        this.key = key;
        this.value = value;
    }
}
