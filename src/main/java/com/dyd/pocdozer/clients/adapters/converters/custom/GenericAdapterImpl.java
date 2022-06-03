package com.dyd.pocdozer.clients.adapters.converters.custom;

import com.dyd.pocdozer.clients.adapters.configuration.GenericAdapter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenericAdapterImpl extends GenericAdapter<Object, Object> {
	public <T, R> List<T> genericMarshal(Iterable<R> sources,  Class<T> destinyClass) {
		if (sources == null)
			return null;

		List<T> result = new ArrayList<>();
		sources.forEach(element -> result.add(genericMarshal(element, destinyClass)));
		return result;
	}


	public <T> T genericMarshal(Object object, Class<T> destinyClass) {
		if (object == null)
			return null;
		return dozerMapper.getMapper().map(object, destinyClass);
	}
}
