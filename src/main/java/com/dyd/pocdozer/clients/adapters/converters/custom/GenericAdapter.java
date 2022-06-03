package com.dyd.pocdozer.clients.adapters.converters.custom;

import com.dyd.pocdozer.clients.adapters.configuration.Adapter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenericAdapter extends Adapter<Object, Object> {

	public <T, R> List<T> transform(Iterable<R> sources,  Class<T> destinyClass) {
		if (sources == null)
			return null;

		List<T> result = new ArrayList<>();
		sources.forEach(element -> result.add(transform(element, destinyClass)));
		return result;
	}


	public <T> T transform(Object object, Class<T> destinyClass) {
		if (object == null)
			return null;
		return dozerMapper.getMapper().map(object, destinyClass);
	}
}
