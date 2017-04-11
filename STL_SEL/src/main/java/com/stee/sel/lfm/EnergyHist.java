/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : lim
 * File Name    : EnergyHist
 * Author       : Jerry
 * Created      : 2017/1/17
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
package com.stee.sel.lfm;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SerryMiano on 2017/1/17.
 */
@Entity
@Table(name = "stl_lim_energy_hist")
public class EnergyHist {
    private Integer id;
    private String luminaireId;
    private Double energyUsage;
    private Date associatedTime;
    private String moduleId;
    private String gzoneId;


    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "luminaire_id")
    public String getLuminaireId() {
        return luminaireId;
    }

    public void setLuminaireId(String luminaireId) {
        this.luminaireId = luminaireId;
    }

    @Column(name = "energy_usage")
    public Double getEnergyUsage() {
        return energyUsage;
    }

    public void setEnergyUsage(Double energyUsage) {
        this.energyUsage = energyUsage;
    }

    @Column(name = "associated_time")
    @Temporal(TemporalType.DATE)
    public Date getAssociatedTime() {
        return associatedTime;
    }

    public void setAssociatedTime(Date associatedTime) {
        this.associatedTime = associatedTime;
    }

    @Column(name = "module_id")
    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    @Column(name = "gzone_id")
    public String getGzoneId() {
        return gzoneId;
    }

    public void setGzoneId(String gzoneId) {
        this.gzoneId = gzoneId;
    }

    @Override
    public String toString() {
        return "EnergyHist{" +
                "id=" + id +
                ", luminaireId='" + luminaireId + '\'' +
                ", energyUsage=" + energyUsage +
                ", associatedTime=" + associatedTime +
                ", moduleId='" + moduleId + '\'' +
                ", gzoneId='" + gzoneId + '\'' +
                '}';
    }
}
