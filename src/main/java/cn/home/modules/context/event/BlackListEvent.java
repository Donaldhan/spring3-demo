package cn.home.modules.context.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author donald
 * 2017年11月26日
 * 下午10:14:55
 */
public class BlackListEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6877246788002727572L;
	
	private final String address;
	private final String test;

	public BlackListEvent(Object source, String address, String test) {
		super(source);
		this.address = address;
		this.test = test;
	}

	// accessor and other methods...

}
