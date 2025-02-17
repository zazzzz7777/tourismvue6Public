package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DaoyouEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaoyouView;


/**
 * 导游
 *
 * @author 
 * @email 
 * @date 2024-01-18 14:51:05
 */
public interface DaoyouService extends IService<DaoyouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaoyouView> selectListView(Wrapper<DaoyouEntity> wrapper);
   	
   	DaoyouView selectView(@Param("ew") Wrapper<DaoyouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaoyouEntity> wrapper);
   	

}

