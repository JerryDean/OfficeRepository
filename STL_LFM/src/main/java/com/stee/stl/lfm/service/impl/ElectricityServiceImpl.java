package com.stee.stl.lfm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.stee.sel.lfm.AlertParam;
import com.stee.sel.lfm.ElectricAlertInfo;
import com.stee.stl.lfm.entity.QueryBean;
import com.stee.stl.lfm.repository.ElectricityAlertRepository;
import com.stee.stl.lfm.service.IElectricityAlertService;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_LFM
 * File Name    : ElectricityServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年12月8日 下午2:27:17
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service
public class ElectricityServiceImpl implements IElectricityAlertService {
	@Autowired
	ElectricityAlertRepository repository;

	@Override
	public Page<ElectricAlertInfo> getAlertPage(QueryBean query, Integer pageNo, Integer pageSize, String direction) {
		PageRequest request = new PageRequest(pageNo, pageSize,
				new Sort(direction.equals("DESC") ? Direction.DESC : Direction.ASC, "ratio"));
		Page<ElectricAlertInfo> page = null;
		if (null == query) {
			page = this.repository.findAll(request);
		} else {
			page = this.repository.findAll(where(query.getModuleId(), query.getBeginning(), query.getEnding()),
					request);
		}
		return page;
	}

	private Specification<ElectricAlertInfo> where(final String moduleId, final Integer start, final Integer end) {
		return new Specification<ElectricAlertInfo>() {

			@Override
			public Predicate toPredicate(Root<ElectricAlertInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (null != moduleId && !moduleId.equals("")) {
					predicates.add(cb.equal(root.<AlertParam>get("alertPara"), AlertParam.valueOf(moduleId)));
				}
				if (null != start && null != end && (start <= end)) {
					predicates.add(cb.between(root.<Integer>get("ratio"), start, end));
				}
				return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
			}
		};
	}
}
