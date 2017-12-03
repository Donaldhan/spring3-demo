package cn.home.modules.webmvc.controller;

import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.home.modules.webmvc.entity.Appointment;
import cn.home.modules.webmvc.entity.AppointmentForm;
import cn.home.modules.webmvc.service.impl.AppointmentBookServiceImpl;

/**
 * @author donald
 * 2017年12月3日
 * 上午10:48:40
 */
@Controller
@RequestMapping("/appointments")
public class AppointmentsController {
	@Autowired
    private  AppointmentBookServiceImpl appointmentBookService;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Appointment> get() {
        return appointmentBookService.getAppointmentsForToday();
    }

    @RequestMapping(value="/{day}", method = RequestMethod.GET)
    public Map<String, Appointment> getForDay(@PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) Date day, Model model) {
        return appointmentBookService.getAppointmentsForDay(day);
    }

    @RequestMapping(value="/new", method = RequestMethod.GET)
    public AppointmentForm getNewForm() {
        return new AppointmentForm();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@Valid AppointmentForm appointment, BindingResult result) {
        if (result.hasErrors()) {
            return "appointments/new";
        }
        appointmentBookService.addAppointment(appointment);
        return "redirect:/appointments";
    }
}