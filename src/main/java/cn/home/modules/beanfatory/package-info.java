/**
 * BeanFactory,ApplicationContext Use an ApplicationContext unless you have a
 * good reason for not doing so.
 * 
 * Because the ApplicationContext includes all functionality of the BeanFactory,
 * it is generally recommended over the BeanFactory, except for a few situations
 * such as in an Applet where memory consumption might be critical and a few
 * extra kilobytes might make a difference. However, for most typical enterprise
 * applications and systems, the ApplicationContext is what you will want to
 * use. Spring 2.0 and later makes heavy use of the BeanPostProcessor extension
 * point (to effect proxying and so on). If you use only a plain BeanFactory, a
 * fair amount of support such as transactions and AOP will not take effect, at
 * least not without some extra steps on your part. This situation could be
 * confusing because nothing is actually wrong with the configuration.
 * 
 * 
 * 
 * @author donald 2017年11月27日 上午9:14:56
 */
package cn.home.modules.beanfatory;


