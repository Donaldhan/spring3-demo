package cn.home.modules.webmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author donald 2017年12月3日 下午10:16:16
 */
@Controller
public class ErrorController {

	/**
	 * <error-page> 
	 * 		<location>/error</location> 
	 * </error-page>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/error", produces = "application/json")
	@ResponseBody
	public Map<String, Object> handle(HttpServletRequest request) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", request.getAttribute("javax.servlet.error.status_code"));
		map.put("reason", request.getAttribute("javax.servlet.error.message"));

		return map;
	}

}