package cn.home.modules.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.home.modules.webmvc.entity.Clinic;

@Controller
public class ClinicController {

	private final Clinic clinic;

	@Autowired
	public ClinicController(Clinic clinic) {
		this.clinic = clinic;
	}

	@RequestMapping("/")
	public void welcomeHandler() {
	}

	@RequestMapping("/vets")
	public ModelMap vetsHandler() {
		return new ModelMap(this.clinic.getVets());
	}

}
