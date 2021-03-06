package cn.home.modules.beanwrapper.entity;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.SimpleBeanInfo;

import org.springframework.beans.propertyeditors.CustomNumberEditor;

/**
 * Foo age 属性编辑器PropertyEditor
 * @author donald
 * 2017年11月27日
 * 下午10:30:33
 */
public class FooBeanInfo extends SimpleBeanInfo {

	public PropertyDescriptor[] getPropertyDescriptors() {
		try {
			final PropertyEditor numberPE = new CustomNumberEditor(Integer.class, true);
			PropertyDescriptor ageDescriptor = new PropertyDescriptor("age", Foo.class) {
				public PropertyEditor createPropertyEditor(Object bean) {
					return numberPE;
				};
			};
			return new PropertyDescriptor[] { ageDescriptor };
		} catch (IntrospectionException ex) {
			throw new Error(ex.toString());
		}
	}
}
