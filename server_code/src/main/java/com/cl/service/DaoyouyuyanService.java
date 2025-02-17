package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DaoyouyuyanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaoyouyuyanView;


/**
 * 导游语言
 *
 * @author 
 * @email 
 * @date 2024-01-18 14:51:06
 */
public interface DaoyouyuyanService extends IService<DaoyouyuyanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaoyouyuyanView> selectListView(Wrapper<DaoyouyuyanEntity> wrapper);
   	
   	DaoyouyuyanView selectView(@Param("ew") Wrapper<DaoyouyuyanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaoyouyuyanEntity> wrapper);
   	

}

