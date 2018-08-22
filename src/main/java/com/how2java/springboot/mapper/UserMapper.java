package com.how2java.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.how2java.springboot.pojo.User;

@Mapper
public interface UserMapper {
	@Insert("insert into user (username,password,name,telephone) values (#{username},#{password},#{name},#{telephone})")
	public void addUser(User user);
	
	@Select("select * from user where username = #{username} and password = #{password}")
	public User loginCheck(User user); 
	
	@Select("select * from user where username = #{username}")
	public User nameCheck(User user);
}
