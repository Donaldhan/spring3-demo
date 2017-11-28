package cn.home.modules.typeconversion.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class MyModel {
	@NumberFormat(style = Style.CURRENCY)
	private BigDecimal decimal;
	@DateTimeFormat(iso = ISO.DATE)
	private Date date;

}
