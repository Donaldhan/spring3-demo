package cn.home.modules.webmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.home.modules.webmvc.entity.User;
@Component
public class DisplayShoppingCartController implements Controller {
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List cartItems = null;// get a List of CartItem objects
        User user = null; // get the User doing the shopping
        //the logical view name
        ModelAndView mav = new ModelAndView("displayShoppingCart"); 
      //look ma, no name, just the object
        mav.addObject(cartItems); 
        //and again ma!
        mav.addObject(user);
        return mav;
    }
}