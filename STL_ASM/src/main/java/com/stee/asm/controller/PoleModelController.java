package com.stee.asm.controller;

import com.stee.asm.entity.PoleQueryBean;
import com.stee.asm.service.IPoleModelService;
import com.stee.sel.asm.PoleModelConfig;
import com.stee.sel.common.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
 * File Name    : PoleModelController.java
 * Author       : Jerry
 * Created      : 2016年11月15日 下午1:39:24
 *
 * <p> History : <br><br>
 *
 * SNo / CR PR_No / Modified by / Date Modified / Comments <br>
 * --------------------------------------------------------------------------------
 *  
 */
@RestController
@RequestMapping(value = "/pole/model/config")
public class PoleModelController {
    @Resource(name = "poleModelServiceImpl")
    IPoleModelService poleService;

    /**
     * 获取所有 Lamp Pole Model 信息。 *待分页.
     *
     * @return
     * @author Jerry
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResultData<PoleModelConfig> getAll() {
        return poleService.getAll();
    }

    /**
     * 新增或修改 Lamp Pole Model 的信息。
     *
     * @param config
     * @return
     * @author Jerry
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Map<String, String> save(@RequestBody PoleModelConfig config) {
        Map<String, String> map = new HashMap<>();
        map.put("status", poleService.save(config));
        return map;
    }

    // TODO Delete...
    @Deprecated
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody PoleModelConfig config) {
        return poleService.save(config);
    }

    /**
     * 判断Lamp Pole Model 的名字是否存在。
     *
     * @param name
     * @return
     * @author Jerry
     */
    @RequestMapping(value = "/isNameExits/{name}", method = RequestMethod.GET)
    public boolean isNameExits(@PathVariable("name") String name) {
        return poleService.isNameExits(name);
    }

    /**
     * 删除指定的配置项
     *
     * @param id
     * @return
     * @author Jerry
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Map<String, String> delete(@PathVariable("id") Integer id) {
        Map<String, String> map = new HashMap<>();
        map.put("status", poleService.delete(id));
        return map;
    }

    @RequestMapping(value = "/query/name/like", method = RequestMethod.POST)
    public ResultData<PoleModelConfig> findByNameLike(@RequestBody(required = false) PoleQueryBean query) {
        return poleService.findByQueryBean(query);
    }
}
