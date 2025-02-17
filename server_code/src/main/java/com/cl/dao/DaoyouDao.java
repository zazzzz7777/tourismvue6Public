package com.cl.dao;

import com.cl.entity.DaoyouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaoyouView;


/**
 * 导游
 * 
 * @author 
 * @email 
 * @date 2024-01-18 14:51:05
 */
public interface DaoyouDao extends BaseMapper<DaoyouEntity> {
	
	List<DaoyouView> selectListView(@Param("ew") Wrapper<DaoyouEntity> wrapper);

	List<DaoyouView> selectListView(Pagination page,@Param("ew") Wrapper<DaoyouEntity> wrapper);
	
	DaoyouView selectView(@Param("ew") Wrapper<DaoyouEntity> wrapper);
	

}
