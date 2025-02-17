package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.DaoyouyuyanEntity;
import com.cl.entity.view.DaoyouyuyanView;

import com.cl.service.DaoyouyuyanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 导游语言
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-18 14:51:06
 */
@RestController
@RequestMapping("/daoyouyuyan")
public class DaoyouyuyanController {
    @Autowired
    private DaoyouyuyanService daoyouyuyanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DaoyouyuyanEntity daoyouyuyan,
		HttpServletRequest request){
        EntityWrapper<DaoyouyuyanEntity> ew = new EntityWrapper<DaoyouyuyanEntity>();

		PageUtils page = daoyouyuyanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoyouyuyan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DaoyouyuyanEntity daoyouyuyan, 
		HttpServletRequest request){
        EntityWrapper<DaoyouyuyanEntity> ew = new EntityWrapper<DaoyouyuyanEntity>();

		PageUtils page = daoyouyuyanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoyouyuyan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DaoyouyuyanEntity daoyouyuyan){
       	EntityWrapper<DaoyouyuyanEntity> ew = new EntityWrapper<DaoyouyuyanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( daoyouyuyan, "daoyouyuyan")); 
        return R.ok().put("data", daoyouyuyanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DaoyouyuyanEntity daoyouyuyan){
        EntityWrapper< DaoyouyuyanEntity> ew = new EntityWrapper< DaoyouyuyanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( daoyouyuyan, "daoyouyuyan")); 
		DaoyouyuyanView daoyouyuyanView =  daoyouyuyanService.selectView(ew);
		return R.ok("查询导游语言成功").put("data", daoyouyuyanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DaoyouyuyanEntity daoyouyuyan = daoyouyuyanService.selectById(id);
        return R.ok().put("data", daoyouyuyan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DaoyouyuyanEntity daoyouyuyan = daoyouyuyanService.selectById(id);
        return R.ok().put("data", daoyouyuyan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DaoyouyuyanEntity daoyouyuyan, HttpServletRequest request){
    	daoyouyuyan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoyouyuyan);
        daoyouyuyanService.insert(daoyouyuyan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DaoyouyuyanEntity daoyouyuyan, HttpServletRequest request){
    	daoyouyuyan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoyouyuyan);
        daoyouyuyanService.insert(daoyouyuyan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DaoyouyuyanEntity daoyouyuyan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daoyouyuyan);
        daoyouyuyanService.updateById(daoyouyuyan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        daoyouyuyanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
