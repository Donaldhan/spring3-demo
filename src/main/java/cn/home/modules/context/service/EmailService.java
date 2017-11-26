package cn.home.modules.context.service;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import cn.home.modules.context.event.BlackListEvent;

/**
 * @author donald
 * 2017年11月26日
 * 下午10:17:06
 */
public class EmailService implements ApplicationEventPublisherAware {
	private List<String> blackList;
	private ApplicationEventPublisher publisher;

	public void setBlackList(List<String> blackList) {
		this.blackList = blackList;
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void sendEmail(String address, String text) {
		if (blackList.contains(address)) {
			BlackListEvent event = new BlackListEvent(this, address, text);
			publisher.publishEvent(event);
			return;
		}
		// send email...
	}
}
