package com.cl.dao;

import com.cl.entity.DaoyoufenpeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaoyoufenpeiView;


/**
 * 导游分配
 * 
 * @author 
 * @email 
 * @date 2024-01-18 14:51:06
 */
public interface DaoyoufenpeiDao extends BaseMapper<DaoyoufenpeiEntity> {
	
	List<DaoyoufenpeiView> selectListView(@Param("ew") Wrapper<DaoyoufenpeiEntity> wrapper);

	List<DaoyoufenpeiView> selectListView(Pagination page,@Param("ew") Wrapper<DaoyoufenpeiEntity> wrapper);
	
	DaoyoufenpeiView selectView(@Param("ew") Wrapper<DaoyoufenpeiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DaoyoufenpeiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DaoyoufenpeiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<DaoyoufenpeiEntity> wrapper);



}
