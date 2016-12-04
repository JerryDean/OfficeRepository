package com.stee.asm.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stee.asm.service.ILuminaireModelService;
import com.stee.sel.asm.LuminaireModelConfig;
import com.stee.sel.common.ResultData;

/* Copyright (C) 2016, ST Electronics Info-Comm Systems PTE. LTD
 * All rights reserved.
 *
 * This software is confidential and proprietary property of 
 * ST Electronics Info-Comm Systems PTE. LTD.
 * The user shall not disclose the contents of this software and shall
 * only use it in accordance with the terms and conditions stated in
 * the contract or license agreement with ST Electronics Info-Comm Systems PTE. LTD.
 *
 * Project Name : STL_ASM
 * File Name    : LuminaireModelController.java
 * Author       : Jerry
 * Created      : 2016年11月15日 下午1:37:54
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/luminaire/model/config")
public class LuminaireModelController {
	@Resource(name = "luminaireModelServiceImpl")
	ILuminaireModelService luminaireService;

	/**
	 * 获取所有LuminaireModel的配置信息. *待分页
	 * 
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ResultData<LuminaireModelConfig> getAll() {
		return luminaireService.getAll();
	}

	/**
	 * 新增或修改相应的LuminaireModel 的配置.
	 * 
	 * @param config
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@RequestBody LuminaireModelConfig config) {
		System.out.println(config);
		return luminaireService.save(config);
	}

	// TODO delete...
	@Deprecated
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestBody LuminaireModelConfig config) {
		return luminaireService.save(config);
	}

	/**
	 * 判断ModelId 是否已经存在.
	 * 
	 * @param id
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/isIdExits/{id}", method = RequestMethod.GET)
	public boolean isIdExits(@PathVariable("id") Integer id) {
		return luminaireService.isIdExits(id);
	}

	/**
	 * 删除指定的配置项
	 * 
	 * @param id
	 * @return
	 * @author Jerry
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		return luminaireService.delete(id);
	}

}
