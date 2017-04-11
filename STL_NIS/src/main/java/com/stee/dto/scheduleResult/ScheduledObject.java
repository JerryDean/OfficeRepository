package com.stee.dto.scheduleResult;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by Jerry on 2017/1/22.
 */
@XmlType(name = "resultObject", propOrder = {"status", "errors"})
public class ScheduledObject {
    private String status;
    private List<ScheduledError> errors;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElementWrapper(name = "errors")
    @XmlElement(name = "error")
    public List<ScheduledError> getErrors() {
        return errors;
    }

    public void setErrors(List<ScheduledError> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ScheduledObject{" +
                "status='" + status + '\'' +
                ", errors=" + errors +
                '}';
    }
}
