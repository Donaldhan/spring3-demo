package cn.home.modules.context.listener;

import org.springframework.context.ApplicationListener;

import cn.home.modules.context.event.BlackListEvent;

/**
 * @author donald
 * 2017年11月26日
 * 下午10:20:26
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {
	private String notificationAddress;

	public void setNotificationAddress(String notificationAddress) {
		this.notificationAddress = notificationAddress;
	}

	public void onApplicationEvent(BlackListEvent event) {
		// notify appropriate parties via notificationAddress...
	}
}
