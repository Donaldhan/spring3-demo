package cn.home.modules.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 * @author donald
 * 2017年12月4日
 * 下午12:28:09
 */
public class PDFPage extends AbstractPdfView {
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.document.AbstractPdfView#buildPdfDocument(java.util.Map, com.lowagie.text.Document, com.lowagie.text.pdf.PdfWriter, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("rawtypes")
	protected void buildPdfDocument(Map model, Document doc, PdfWriter writer, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {

		List words = (List) model.get("wordList");

		for (int i = 0; i < words.size(); i++)
			doc.add(new Paragraph((String) words.get(i)));

	}
}