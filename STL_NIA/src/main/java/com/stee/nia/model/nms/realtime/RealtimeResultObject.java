package com.stee.nia.model.nms.realtime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by Jerry on 2016/12/18.
 */
@XmlType(name = "resultObject")
public class RealtimeResultObject {
    private List<RealtimeResponse> responses;

    @XmlElementWrapper(name = "responses")
    @XmlElement(name = "response")
    public List<RealtimeResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<RealtimeResponse> responses) {
        this.responses = responses;
    }

    @Override
    public String toString() {
        return "RealtimeResultObject{" +
                "responses=" + responses +
                '}';
    }
}
