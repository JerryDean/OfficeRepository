package com.stee.nia.model.nms.realtime;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by Jerry on 2016/12/18.
 */
@XmlType(name = "resultObject")
public class RealtimeResultObject {
    private String clazz;

    private List<RealtimeResponse> responses;

    @Override
    public String toString() {
        return "RealtimeResultObject{" +
                "clazz='" + clazz + '\'' +
                ", responses=" + responses +
                '}';
    }

    @XmlAttribute(name = "class")
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @XmlElementWrapper(name = "responses")
    @XmlElement(name = "response")
    public List<RealtimeResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<RealtimeResponse> responses) {
        this.responses = responses;
    }
}
