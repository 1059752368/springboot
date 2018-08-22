package com.how2java.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.how2java.springboot.pojo.Retailer;

@Mapper
public interface RetailerMapper {
	@Select("select * from retailer")
	public List<Retailer> listRetailer(); 
	
	@Select("select from retailer where retailerid = '#{retailerid}'")
	public Retailer getByRetailerId(String id);
	
	@Delete("delete from retailer where retailerid = #{retailerid}")
    public void delete(String id);
	
	@Insert("insert into retailer (name,telephone,address) values (#{name},#{telephone},#{address})")
	public Retailer addRetailer(Retailer r);
}
