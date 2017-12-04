/**
 * Spring provides a couple of out-of-the-box solutions for JSP and JSTL views.
 * Using JSP or JSTL is done using a normal view resolver defined in the
 * WebApplicationContext. Furthermore, of course you need to write some JSPs
 * that will actually render the view.
 * 
 * The InternalResourceBundleViewResolver can be configured for using JSPs as
 * described above. As a best practice, we strongly encourage placing your JSP
 * files in a directory under the 'WEB-INF' directory, so there can be no direct
 * access by clients.
 * 
 * Velocity and FreeMarker are two templating languages that can be used as view
 * technologies within Spring MVC applications. The languages are quite similar
 * and serve similar needs and so are considered together in this section. For
 * semantic and syntactic differences between the two languages, see the
 * FreeMarker web site.
 * 
 * POI JasperReports JasperReportsMultiFormatView JasperReportsHtmlView
 * JasperReportsPdfView JasperReportsXlsView MarhsallingView
 * MappingJackson2JsonView
 * 
 * Your application will need to include the latest release of JasperReports,
 * which at the time of writing was 0.6.1. JasperReports itself depends on the
 * following projects:
 * 
 * BeanShell
 * Commons BeanUtils
 * Commons Collections
 * Commons Digester
 * Commons Logging
 * iText
 * POI
 * 
 * 
 * @author donald 2017年12月4日 上午11:14:02
 */
package cn.home.modules.view;