package cn.home.modules.typeconversion;

import org.springframework.core.convert.converter.Converter;

/**
 * @author donald
 * 2017年11月28日
 * 上午9:06:44
 */
final class StringToInteger implements Converter<String, Integer> {

    /* (non-Javadoc)
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Integer convert(String source) {
        return Integer.valueOf(source);
    }

}
