package com.stee.stl.lfm.service.impl;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.stee.sel.lfm.EventSource;
import com.stee.sel.lfm.EventTypeEnum;
import com.stee.sel.lfm.FailureEvent;
import com.stee.stl.lfm.entity.FailureEventQueryBean;
import com.stee.stl.lfm.repository.FailureEventRepository;
import com.stee.stl.lfm.service.IFailureEventService;
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
import java.util.Date;
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
 * Project Name : STL_LFM
 * File Name    : FailureEventServiceImpl.java
 * Author       : Jerry
 * Created      : 2016年12月9日 下午3:04:30
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@Service
public class FailureEventServiceImpl implements IFailureEventService {
	@Autowired
	FailureEventRepository repository;

	@Override
	public Page<FailureEvent> findByEventSource(String es, Integer pageNo, Integer pageSize, String direction) {
		Page<FailureEvent> page = null;
		if (direction == null) {
			direction = "DESC";
		}
		PageRequest pageRequest = new PageRequest(pageNo, pageSize,
				new Sort(direction.equals("DESC") ? Direction.DESC : Direction.ASC, "severityLevel"));
		if (!es.equals("none")) {
			page = repository.findByEventSource(EventSource.valueOf(es), pageRequest);
		} else {
			page = repository.findAll(pageRequest);
		}
		return page;
	}

    @Override
    public Page<FailureEvent> findByQueryBean(Integer pageNo, Integer pageSize, String direction, String sortBy, FailureEventQueryBean queryBean) {
		PageRequest pageRequest = new PageRequest(pageNo, pageSize, new Sort(direction == "DESC" ? Direction.DESC : Direction.ASC, sortBy));
        if (null == queryBean) {
            return repository.findAll(pageRequest);
        } else {
            return repository.findAll(where(queryBean), pageRequest);
        }
    }

    private Specification<FailureEvent> where (final FailureEventQueryBean queryBean) {
	    return new Specification<FailureEvent>() {
            @Override
            public Predicate toPredicate(Root<FailureEvent> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = Lists.newArrayList();
                if (!Strings.isNullOrEmpty(queryBean.getEventSource())) {
                    predicates.add(criteriaBuilder.equal(root.<String>get("eventSource"), EventSource.valueOf(queryBean.getEventSource())));
                }
                if (!Strings.isNullOrEmpty(queryBean.getEventType())) {
                    predicates.add(criteriaBuilder.equal(root.<String>get("eventType"), EventTypeEnum.valueOf(queryBean.getEventType())));
                }
                if (!Strings.isNullOrEmpty(queryBean.getObjectId())) {
                    predicates.add(criteriaBuilder.like(root.<String>get("objectId"), "%" +queryBean.getObjectId() + "%"));
                }
                if (!Strings.isNullOrEmpty(queryBean.getMessage())) {
                    predicates.add(criteriaBuilder.like(root.<String>get("message"), "%" +queryBean.getMessage() + "%"));
                }
                if (null != queryBean.getStart() && null != queryBean.getEnd()) {
                    predicates.add(criteriaBuilder.between(root.<Date>get("occurDate"), queryBean.getStart(), queryBean.getEnd()));
                }
                if (null != queryBean.getSeverityStart() && null != queryBean.getSeverityEnd()) {
                    predicates.add(criteriaBuilder.between(root.<Integer>get("severityLevel"), queryBean.getSeverityStart(), queryBean.getSeverityEnd()));
                }
                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        };
    }

}
