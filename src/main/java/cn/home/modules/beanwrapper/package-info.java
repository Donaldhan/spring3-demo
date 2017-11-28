/**
 * BeanWrapper Then, the BeanWrapper supports the ability to add standard
 * JavaBeans PropertyChangeListeners and VetoableChangeListeners, without the
 * need for supporting code in the target class. Last but not least, the
 * BeanWrapper provides support for the setting of indexed properties. The
 * BeanWrapper usually isn't used by application code directly, but by the
 * DataBinder and the BeanFactory.
 * 
 * The way the BeanWrapper works is partly indicated by its name: it wraps a
 * bean to perform actions on that bean, like setting and retrieving properties.
 * 
 * ############################
 * PropertyEditors 
 * ByteArrayPropertyEditor
 * ClassEditor
 * CustomBooleanEditor
 * CustomCollectionEditor
 * CustomDateEditor
 * CustomNumberEditor
 * FileEditor
 * InputStreamEditor
 * LocaleEditor
 * PatternEditor
 * PropertiesEditor
 * StringTrimmerEditor
 * URLEditor
 * PropertyEditorManager 
 * ###########
 * ConfigurableBeanFactory 
 * CustomEditorConfigurer 
 * PropertyEditorRegistrars 
 * DataBinder
 * SimpleFormController
 * @author donald 2017年11月27日 下午10:17:32
 */
package cn.home.modules.beanwrapper;