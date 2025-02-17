package com.cl.dao;

import com.cl.entity.JingdianmenpiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JingdianmenpiaoView;


/**
 * 景点门票
 * 
 * @author 
 * @email 
 * @date 2024-01-18 14:51:05
 */
public interface JingdianmenpiaoDao extends BaseMapper<JingdianmenpiaoEntity> {
	
	List<JingdianmenpiaoView> selectListView(@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);

	List<JingdianmenpiaoView> selectListView(Pagination page,@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);
	
	JingdianmenpiaoView selectView(@Param("ew") Wrapper<JingdianmenpiaoEntity> wrapper);
	

}
