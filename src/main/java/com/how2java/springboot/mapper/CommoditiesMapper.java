package com.how2java.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.how2java.springboot.pojo.Commodities;

@Mapper
public interface CommoditiesMapper {
	@Select("select * from commodities")
	public List<Commodities> listCommodities();
}
