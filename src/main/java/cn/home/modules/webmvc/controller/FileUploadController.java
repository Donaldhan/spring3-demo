package cn.home.modules.webmvc.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	private static final Logger log = LoggerFactory.getLogger(FileUploadController.class);

	/**
	 * use MultipartHttpServletRequest or MultipartFile in the method
	 * parameters:
	 * 
	 * @param name
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String handleFormUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
			} catch (IOException e) {
				log.error("save file exception", e);
			}
			// store the bytes somewhere
			return "redirect:uploadSuccess";
		} else {
			return "redirect:uploadFailure";
		}
	}

	/**
	 * using Servlet 3.0 multipart parsing you can also use
	 * javax.servlet.http.Part for the method parameter
	 * 
	 * @param name
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String handleFormUpload(@RequestParam("name") String name, @RequestParam("file") Part file) {
		try {
			InputStream inputStream = file.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// store bytes from uploaded file somewhere

		return "redirect:uploadSuccess";
	}

	/**
	 * @param metadata
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/someUrl", method = RequestMethod.POST)
	public String onSubmit(/*@RequestPart("meta-data") MetaData metadata,*/
			@RequestPart("file-data") MultipartFile file) {
		// ...
		return "";

	}

}