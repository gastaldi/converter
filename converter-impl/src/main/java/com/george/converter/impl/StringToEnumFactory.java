package com.george.converter.impl;

import javax.converter.Converter;
import javax.converter.ConverterFactory;

public class StringToEnumFactory implements ConverterFactory<String, Enum> {

    public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
	return new StringToEnum(targetType);
    }

    private final class StringToEnum<T extends Enum> implements Converter<String, T> {

	private Class<T> enumType;

	public StringToEnum(Class<T> enumType) {
	    this.enumType = enumType;
	}

	public T convert(String source) {
	    return (T) Enum.valueOf(this.enumType, source.trim());
	}
    }
}
