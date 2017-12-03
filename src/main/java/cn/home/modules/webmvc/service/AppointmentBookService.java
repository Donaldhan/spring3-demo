package cn.home.modules.webmvc.service;

import java.util.Date;
import java.util.Map;

import cn.home.modules.webmvc.entity.Appointment;
import cn.home.modules.webmvc.entity.AppointmentForm;

public interface AppointmentBookService {

	Map<String, Appointment> getAppointmentsForToday();

	Map<String, Appointment> getAppointmentsForDay(Date day);

	void addAppointment(AppointmentForm appointment);

}
