package cn.home.modules.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PathUriTemplateController {

	@RequestMapping("/pets/{petId}")
	public void findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {
		// implementation omitted
	}
}
