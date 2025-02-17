package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JingdianmenpiaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingdianmenpiaoView;


/**
 * 景点门票
 *
 * @author 
 * @email 
 * @date 2024-01-18 14:51:05
 */
public interface JingdianmenpiaoService extends IService<JingdianmenpiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingdianmenpiaoView> selectListView(Wrapper<JingdianmenpiaoEntity> wrapper);
   	
   	JingdianmenpiaoView selectView(@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingdianmenpiaoEntity> wrapper);
   	

}

