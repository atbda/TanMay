/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sony.controller;

import com.sony.dao.UserDao;
import com.sony.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Shahrukh
 */
@Controller
public class UserController {
    
    @Autowired
    UserDao udao;
    @RequestMapping(value = {"/register"})
    public ModelAndView getJSP(){
    ModelAndView mav=new ModelAndView();
    mav.setViewName("register");
    mav.addObject("cmd", new User());
    return mav;
    }
    
    
    
    @RequestMapping( value = "/saveRegister",method = RequestMethod.POST)
public ModelAndView register(@ModelAttribute User cmd){
    ModelAndView mav=new ModelAndView();
    udao.save(cmd);
    mav.setViewName("success");
return mav;

}
    
    
    }
