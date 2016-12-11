package com.stee.stl.bhcp.service.impl;

import com.stee.sel.lfm.BurningHourAlert;
import com.stee.stl.bhcp.entity.QueryBean;
import com.stee.stl.bhcp.repository.BurningHourAlertRepository;
import com.stee.stl.bhcp.repository.LampInfoRepository;
import com.stee.stl.bhcp.repository.LifetimeRepository;
import com.stee.stl.bhcp.service.IBurningHourAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_BHCP
 * File Name    : BurningHourAlertServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年12月1日 下午4:13:37
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service
public class BurningHourAlertServiceImpl implements IBurningHourAlertService {

	@Autowired
	BurningHourAlertRepository repository;

	@Autowired
    LampInfoRepository lampRepo;

	@Autowired
    LifetimeRepository lifetimeRepo;

	@Override
	public Page<BurningHourAlert> getAlertPage(QueryBean query, Integer pageNo, Integer pageSize, String direction) {

		PageRequest request = new PageRequest(pageNo, pageSize,
				new Sort(direction.equals("DESC") ? Direction.DESC : Direction.ASC, "ratio"));
		Page<BurningHourAlert> page = null;
		if (null == query) {
			page = this.repository.findAll(request);
		} else {
			page = this.repository.findAll(where(query.getModuleId(), query.getBeginning(), query.getEnding()),
					request);
		}
		return page;
	}

	@Override
	public void computeBurningHourAlert() {

	}

	private Specification<BurningHourAlert> where(final String moduleId, final Integer start, final Integer end) {
		return new Specification<BurningHourAlert>() {

			@Override
			public Predicate toPredicate(Root<BurningHourAlert> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (null != moduleId && !moduleId.equals("")) {
					predicates.add(cb.like(root.<String>get("luminaireId"), moduleId));
				}
				if (null != start && null != end && (start <= end)) {
					predicates.add(cb.between(root.<Integer>get("ratio"), start, end));
				}
				return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
			}
		};
	}

}
