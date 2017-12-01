package cn.home.modules.oxm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.castor.CastorMarshaller;

import cn.home.modules.oxm.entity.Settings;
import cn.home.util.JacksonUtil;

/**
 * 测试spring-oxm 对象XML转换
 * @author donald
 * 2017年12月1日
 * 下午5:29:39
 */
public class OxmDemo {
	private static Logger log = LoggerFactory.getLogger(OxmDemo.class);
	private static final String FILE_NAME = "settings.xml";
	private Settings settings = new Settings();
	private Marshaller marshaller;
	private Unmarshaller unmarshaller;
	public void setMarshaller(Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public void saveSettings() throws IOException {
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(FILE_NAME);
			this.marshaller.marshal(settings, new StreamResult(os));
			log.info("object to xml is ok...");
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	public void loadSettings() throws IOException {
		FileInputStream is = null;
		try {
			is = new FileInputStream(FILE_NAME);
			this.settings = (Settings) this.unmarshaller.unmarshal(new StreamSource(is));
			log.info("xml to object is ok:\n{}",JacksonUtil.getInstance().toJson(settings));
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		CastorMarshaller  castorMarshaller = new CastorMarshaller();
		OxmDemo oxmDemo = new OxmDemo();
		oxmDemo.setMarshaller(castorMarshaller);
		oxmDemo.setUnmarshaller(castorMarshaller);
		oxmDemo.settings.setFooEnabled(true);
		oxmDemo.saveSettings();
		oxmDemo.loadSettings();
	}
}
