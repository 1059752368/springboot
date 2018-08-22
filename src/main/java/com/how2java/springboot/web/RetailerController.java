package com.how2java.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.RetailerMapper;
import com.how2java.springboot.pojo.Retailer;

@Controller
public class RetailerController {
	@Autowired RetailerMapper retailerMapper;
	
	@RequestMapping("/listRetailer")
    public String listRetailer(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		PageHelper.startPage(start,size,"retailerid desc");
        List<Retailer> cs=retailerMapper.listRetailer();
        PageInfo<Retailer> page = new PageInfo<>(cs);
        
//        final int sum = (int) page.getTotal();
//        final int sumpage = sum/((int)size-(int)start);
//        System.out.println(sum);
//        System.out.println(sumpage-1);
//                
//        m.addAttribute("sumpage",sumpage);
//        m.addAttribute("sum",sum);
    
        m.addAttribute("page", page);       
        return "retailerManage";
    } 
	
	@RequestMapping("/listRetailer/editRetailer")
	public @ResponseBody Retailer editRetailer(@RequestBody String json){
		String id = JSONObject.parseObject(json).getString("id");
		return retailerMapper.getByRetailerId(id);
	}

	@RequestMapping("/deleteRetailer")
    public String deleteRetailer(Retailer r) throws Exception {
		retailerMapper.delete(r.getRetailerId());
        return "redirect:listRetailer";
    }
	
}
