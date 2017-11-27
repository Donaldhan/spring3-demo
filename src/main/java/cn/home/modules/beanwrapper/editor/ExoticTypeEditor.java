package cn.home.modules.beanwrapper.editor;

import java.beans.PropertyEditorSupport;

import cn.home.modules.beanwrapper.entity.ExoticType;

/**
 * @author donald
 * 2017年11月27日
 * 下午10:38:29
 */
public class ExoticTypeEditor extends PropertyEditorSupport {

	public void setAsText(String text) {
		setValue(new ExoticType(text.toUpperCase()));
	}
}
