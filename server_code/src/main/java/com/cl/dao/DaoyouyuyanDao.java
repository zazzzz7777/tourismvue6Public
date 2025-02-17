package com.cl.dao;

import com.cl.entity.DaoyouyuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaoyouyuyanView;


/**
 * 导游语言
 * 
 * @author 
 * @email 
 * @date 2024-01-18 14:51:06
 */
public interface DaoyouyuyanDao extends BaseMapper<DaoyouyuyanEntity> {
	
	List<DaoyouyuyanView> selectListView(@Param("ew") Wrapper<DaoyouyuyanEntity> wrapper);

	List<DaoyouyuyanView> selectListView(Pagination page,@Param("ew") Wrapper<DaoyouyuyanEntity> wrapper);
	
	DaoyouyuyanView selectView(@Param("ew") Wrapper<DaoyouyuyanEntity> wrapper);
	

}
