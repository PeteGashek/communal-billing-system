package cbs.core;

import javax.xml.bind.annotation.XmlElement;

class MapElements {
    @XmlElement
    public String key;
    @XmlElement
    public Class value;

    private MapElements() {
    } // Required by JAXB

    public MapElements(String key, Class value) {
        this.key = key;
        this.value = value;
    }
}
