package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DaoyoufenpeiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaoyoufenpeiView;


/**
 * 导游分配
 *
 * @author 
 * @email 
 * @date 2024-01-18 14:51:06
 */
public interface DaoyoufenpeiService extends IService<DaoyoufenpeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaoyoufenpeiView> selectListView(Wrapper<DaoyoufenpeiEntity> wrapper);
   	
   	DaoyoufenpeiView selectView(@Param("ew") Wrapper<DaoyoufenpeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaoyoufenpeiEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<DaoyoufenpeiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<DaoyoufenpeiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<DaoyoufenpeiEntity> wrapper);



}

