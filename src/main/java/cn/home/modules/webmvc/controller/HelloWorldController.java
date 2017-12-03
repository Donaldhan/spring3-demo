package cn.home.modules.webmvc.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import cn.home.modules.webmvc.entity.Pet;

@Controller
@SessionAttributes("pet")
public class HelloWorldController {

	@RequestMapping("/helloWorld")
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello World!");
		return "helloWorld";
	}

	@RequestMapping(value = "/something", method = RequestMethod.PUT)
	@ResponseBody
	public String helloWorld() {
		return "Hello World";
	}

	@RequestMapping("/something")
	public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException {
		String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
		byte[] requestBody = requestEntity.getBody();
		// do something with request header and body
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/owners/{ownerId}/pets/{petId}/edit", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute Pet pet) {
		return "";
	}

	@RequestMapping("/displayHeaderInfo.do")
	public void displayHeaderInfo(@CookieValue("JSESSIONID") String cookie) {
		// ...
	}

	@RequestMapping("/displayHeaderInfo.do")
	public void displayHeaderInfo(@RequestHeader("Accept-Encoding") String encoding,
			@RequestHeader("Keep-Alive") long keepAlive) {

		// ...

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping
	public String myHandleMethod(WebRequest webRequest, Model model) {

		long lastModified = 0L;// 1. application-specific calculation

		/*
		 * if (request.checkNotModified(lastModified)) { // 2. shortcut exit -
		 * no further processing necessary return null; }
		 */

		// 3. or otherwise further request processing, actually preparing
		// content
		model.addAttribute("", "");
		return "myViewName";
	}

	@RequestMapping(method = RequestMethod.POST)
	public Callable<String> processUpload(final MultipartFile file) {
		return new Callable<String>() {
			public String call() throws Exception {
				// ...
				return "someView";
			}
		};
	}

	/**
	 * // In some other thread.. deferredResult.setResult(data);
	 * 
	 * @return
	 */
	@RequestMapping("/quotes")
	@ResponseBody
	public DeferredResult<String> quotes() {
		DeferredResult<String> deferredResult = new DeferredResult<String>();
		// Save the deferredResult in in-memory queue ...
		return deferredResult;
	}

	/**
	 * If a view name is returned that has the prefix redirect:, the
	 * UrlBasedViewResolver (and all subclasses) will recognize this as a
	 * special indication that a redirect is needed. The rest of the view name
	 * will be treated as the redirect URL. The net effect is the same as if the
	 * controller had returned a RedirectView, but now the controller itself can
	 * simply operate in terms of logical view names. A logical view name such
	 * as redirect:/myapp/some/resource will redirect relative to the current
	 * Servlet context, while a name such as
	 * redirect:http://myhost.com/some/arbitrary/path will redirect to an
	 * absolute URL.
	 * 
	 * @return
	 */
	@RequestMapping(value = "/files/{path}", method = RequestMethod.POST)
	public String upload() {
		// ...
		return "redirect:files/{path}";
	}

}
