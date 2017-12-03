package cn.home.modules.webmvc.controller;

import java.io.IOException;
import java.io.Writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.home.modules.webmvc.entity.Clinic;
import cn.home.modules.webmvc.entity.Owner;
import cn.home.modules.webmvc.entity.Pet;
import cn.home.modules.webmvc.service.OwnerService;

@Controller
public class RelativePathUriTemplateController {
	@Autowired
	private OwnerService ownerService;
	private Clinic clinic;

	@RequestMapping(value = "/owners/{ownerId}", method = RequestMethod.GET)
	public String findOwner(@PathVariable String ownerId, Model model) {
		Owner owner = ownerService.findOwner(ownerId);
		model.addAttribute("owner", owner);
		return "displayOwner";
	}

	@RequestMapping(value = "/owners/{ownerId}/pets/{petId}", method = RequestMethod.GET)
	public String findPet(@PathVariable String ownerId, @PathVariable String petId, Model model) {
		Owner owner = ownerService.findOwner(ownerId);
		Pet pet = owner.getPet(petId);
		model.addAttribute("pet", pet);
		return "displayPet";
	}

	@RequestMapping(value = "/pets/{petId}", method = RequestMethod.GET, params = "myParam=myValue")
	public void findPetParm(@PathVariable String ownerId, @PathVariable String petId, Model model) {
	}

	@RequestMapping(value = "/pets", method = RequestMethod.GET, headers = "myHeader=myValue")
	public void findPetHeader(@PathVariable String ownerId, @PathVariable String petId, Model model) {
	}

	@RequestMapping(method = RequestMethod.POST)
	public void processSubmit(@ModelAttribute("pet") Pet pet, BeanPropertyBindingResult result, Model model) {
	}

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(@RequestParam("petId") int petId, ModelMap model) {
		Pet pet = (Pet) clinic.loadPet(petId);
		model.addAttribute("pet", pet);
		return "petForm";
	}
	@RequestMapping(method = RequestMethod.GET)
	public String setupFormx(@RequestParam(value="id", required=false) int petId, ModelMap model) {
		Pet pet = (Pet) clinic.loadPet(petId);
		model.addAttribute("pet", pet);
		return "petForm";
	}
	@RequestMapping(value = "/something", method = RequestMethod.PUT)
	public void handle(@RequestBody String body, Writer writer) throws IOException {
	  writer.write(body);
	}
}
