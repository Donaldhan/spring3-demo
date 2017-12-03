package cn.home.modules.webmvc.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.home.modules.webmvc.entity.Appointment;
import cn.home.modules.webmvc.entity.AppointmentForm;
import cn.home.modules.webmvc.service.AppointmentBookService;

@Service
public class AppointmentBookServiceImpl implements AppointmentBookService{
	@Override
	public Map<String, Appointment> getAppointmentsForToday() {
		return null;
	}
	@Override
	public Map<String, Appointment> getAppointmentsForDay(Date day) {
		return null;
	}
	@Override
	public void addAppointment(AppointmentForm appointment) {
		
	}

}
