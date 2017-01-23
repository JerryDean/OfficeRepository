package com.stee.nia.model.nms.scheduled;

import com.sun.xml.internal.txw2.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Created by Jerry on 2017/1/22.
 */
@XmlType(name = "error")
public class ScheduledError {
    private String code;
    private String value;

    @XmlAttribute
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ScheduledError{" +
                "code='" + code + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
