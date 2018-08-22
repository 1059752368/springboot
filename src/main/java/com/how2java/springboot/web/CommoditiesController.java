package com.how2java.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.CommoditiesMapper;
import com.how2java.springboot.pojo.Commodities;
import com.how2java.springboot.pojo.Retailer;

@Controller
public class CommoditiesController {
	@Autowired CommoditiesMapper commoditiesMapper;
	
	@RequestMapping("/listCommodities")
	public String CommoditiesMainPage(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size)throws Exception{
		PageHelper.startPage(start,size,"fruitid desc");
        List<Commodities> ls=commoditiesMapper.listCommodities();
        PageInfo<Commodities> pagecom = new PageInfo<>(ls);
		
        m.addAttribute("pagecom", pagecom);
		return "Commodities";
	}
}
