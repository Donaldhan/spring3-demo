package cn.home.modules.typeconversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * @author donald
 * 2017年11月28日
 * 上午9:10:17
 */
@SuppressWarnings("rawtypes")
final class StringToEnumConverterFactory implements ConverterFactory<String, Enum> {

    @SuppressWarnings({ "unchecked" })
	public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToEnumConverter(targetType);
    }

	private final class StringToEnumConverter<T extends Enum> implements Converter<String, T> {

        private Class<T> enumType;

        public StringToEnumConverter(Class<T> enumType) {
            this.enumType = enumType;
        }

        @SuppressWarnings("unchecked")
		public T convert(String source) {
            return (T) Enum.valueOf(this.enumType, source.trim());
        }
    }
}
