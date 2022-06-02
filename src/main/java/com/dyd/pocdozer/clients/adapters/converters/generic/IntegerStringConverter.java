package com.dyd.pocdozer.clients.adapters.converters.generic;

import org.dozer.DozerConverter;
import org.dozer.MappingException;
import org.springframework.stereotype.Component;

@Component
public class IntegerStringConverter extends DozerConverter<String, Integer> {

	public IntegerStringConverter() {
		super(String.class, Integer.class);
	}

	@Override
	public Integer convertTo(String source, Integer destination) {
		try {
			return Integer.valueOf(source);
		} catch (Exception e) {
			throw new MappingException(e);
		}
	}

	@Override
	public String convertFrom(Integer source, String destination) {
		try {
			return source.toString();
		} catch (Exception e) {
			throw new MappingException(e);
		}
	}
}
