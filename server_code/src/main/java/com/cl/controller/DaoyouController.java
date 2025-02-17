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

import com.cl.entity.DaoyouEntity;
import com.cl.entity.view.DaoyouView;

import com.cl.service.DaoyouService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MD5Util;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 导游
 * 后端接口
 * @author 
 * @email 
 * @date 2024-01-18 14:51:05
 */
@RestController
@RequestMapping("/daoyou")
public class DaoyouController {
    @Autowired
    private DaoyouService daoyouService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		DaoyouEntity u = daoyouService.selectOne(new EntityWrapper<DaoyouEntity>().eq("daoyouzhanghao", username));
		if(u==null || !u.getDaoyoumima().equals(MD5Util.md5(password))) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(u.getId(), username,"daoyou",  "导游" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody DaoyouEntity daoyou){
    	//ValidatorUtils.validateEntity(daoyou);
    	DaoyouEntity u = daoyouService.selectOne(new EntityWrapper<DaoyouEntity>().eq("daoyouzhanghao", daoyou.getDaoyouzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		daoyou.setId(uId);
                daoyou.setDaoyoumima(MD5Util.md5(daoyou.getDaoyoumima()));
        daoyouService.insert(daoyou);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        DaoyouEntity u = daoyouService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	DaoyouEntity u = daoyouService.selectOne(new EntityWrapper<DaoyouEntity>().eq("daoyouzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setDaoyoumima(MD5Util.md5("123456"));
        daoyouService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DaoyouEntity daoyou,
		HttpServletRequest request){
        EntityWrapper<DaoyouEntity> ew = new EntityWrapper<DaoyouEntity>();

		PageUtils page = daoyouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoyou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DaoyouEntity daoyou, 
		HttpServletRequest request){
        EntityWrapper<DaoyouEntity> ew = new EntityWrapper<DaoyouEntity>();

		PageUtils page = daoyouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoyou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DaoyouEntity daoyou){
       	EntityWrapper<DaoyouEntity> ew = new EntityWrapper<DaoyouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( daoyou, "daoyou")); 
        return R.ok().put("data", daoyouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DaoyouEntity daoyou){
        EntityWrapper< DaoyouEntity> ew = new EntityWrapper< DaoyouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( daoyou, "daoyou")); 
		DaoyouView daoyouView =  daoyouService.selectView(ew);
		return R.ok("查询导游成功").put("data", daoyouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DaoyouEntity daoyou = daoyouService.selectById(id);
        return R.ok().put("data", daoyou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DaoyouEntity daoyou = daoyouService.selectById(id);
        return R.ok().put("data", daoyou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DaoyouEntity daoyou, HttpServletRequest request){
    	daoyou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoyou);
    	DaoyouEntity u = daoyouService.selectOne(new EntityWrapper<DaoyouEntity>().eq("daoyouzhanghao", daoyou.getDaoyouzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		daoyou.setId(new Date().getTime());
                daoyou.setDaoyoumima(MD5Util.md5(daoyou.getDaoyoumima())); 
        daoyouService.insert(daoyou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DaoyouEntity daoyou, HttpServletRequest request){
    	daoyou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoyou);
    	DaoyouEntity u = daoyouService.selectOne(new EntityWrapper<DaoyouEntity>().eq("daoyouzhanghao", daoyou.getDaoyouzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		daoyou.setId(new Date().getTime());
                daoyou.setDaoyoumima(MD5Util.md5(daoyou.getDaoyoumima()));
        daoyouService.insert(daoyou);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DaoyouEntity daoyou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daoyou);
	DaoyouEntity daoyouEntity = daoyouService.selectById(daoyou.getId());
        if(StringUtils.isNotBlank(daoyou.getDaoyoumima()) && !daoyou.getDaoyoumima().equals(daoyouEntity.getDaoyoumima())) {
                daoyou.setDaoyoumima(MD5Util.md5(daoyou.getDaoyoumima()));
        }
        daoyouService.updateById(daoyou);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        daoyouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
