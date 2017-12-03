/**
 * DispatcherServlet
 * 
 * @Controller
 * @RequestMapping
 * @PathVariable @RequestParam, @RequestHeader ViewResolver
 * 
 * WebApplicationContext ContextLoaderListener ServletContext The
 * WebApplicationContext is an extension of the plain
 * ApplicationContext that has some extra features necessary for
 * web applications. It differs from a normal ApplicationContext
 * in that it is capable of resolving themes (see Section 17.9,
 * “Using themes”), and that it knows which Servlet it is
 * associated with (by having a link to the ServletContext). The
 * WebApplicationContext is bound in the ServletContext, and by
 * using static methods on the RequestContextUtils class you can
 * always look up the WebApplicationContext if you need access to
 * it.
 *
 * HandlerMapping HandlerAdapter HandlerExceptionResolver
 * ViewResolver LocaleResolver ThemeResolver MultipartResolver
 * FlashMapManager InternalResourceViewResolver
 * MultipartHttpServletRequest
 * @ModelAttribute
 *
 * A common pitfall when working with annotated controller
 * classes happens when applying functionality that requires
 * creating a proxy for the controller object
 * (e.g. @Transactional methods). Usually you will introduce an
 * interface for the controller in order to use JDK dynamic
 * proxies. To make this work you must move the @RequestMapping
 * annotations, as well as any other type and method-level
 * annotations (e.g. @ModelAttribute, @InitBinder) to the
 * interface as well as the mapping mechanism can only "see" the
 * interface exposed by the proxy. Alternatively, you could
 * activate proxy-target-class="true" in the configuration for
 * the functionality applied to the controller (in our
 * transaction scenario in <tx:annotation-driven />). Doing so
 * indicates that CGLIB-based subclass proxies should be used
 * instead of interface-based JDK proxies. For more information
 * on various proxying mechanisms see Section 9.6, “Proxying
 * mechanisms”.
 * 
 * Note however that method argument annotations,
 * e.g. @RequestParam, must be present in the method signatures
 * of the controller class.
 *
 * RequestMappingHandlerMapping 
 * RequestMappingHandlerAdapter 
 * DefaultAnnotationHandlerMapping 
 * AnnotationMethodHandlerAdapter
 * HandlerInterceptor 
 * SimpleUrlHandlerMapping 
 * BeanNameUrlHandlerMapping 
 * 
 * WebDataBinder
 * ServletRequest 
 * HttpServletRequest
 * HttpSession
 * WebRequest 
 * NativeWebRequest
 * Principal
 * HttpMessageConverters
 * 
 *HttpMessageConverter is responsible for converting from the HTTP 
 *request message to an object and converting from an object to 
 *the HTTP response body. The RequestMappingHandlerAdapter supports 
 *the @RequestBody annotation with the following default HttpMessageConverters:
 *ByteArrayHttpMessageConverter converts byte arrays.
 *StringHttpMessageConverter converts strings.
 *FormHttpMessageConverter converts form data to/from a MultiValueMap<String, String>.
 *SourceHttpMessageConverter converts to/from a javax.xml.transform.Source.
 *  
 *DefaultHandlerExceptionResolver
 *@SessionAttributes
 *WebBindingInitializer 
 * 
 * @author donald 2017年12月3日 上午9:55:01
 */
package cn.home.modules.webmvc;