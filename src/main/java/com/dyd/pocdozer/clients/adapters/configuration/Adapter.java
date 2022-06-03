package com.dyd.pocdozer.clients.adapters.configuration;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class Adapter<T, R> extends XmlAdapter<T, R> {

	private BeanMappingBuilder builder;

	@Autowired
	protected DozerMapper dozerMapper;

	public BeanMappingBuilder getBuilder() {
		if (builder == null) {
			builder = new BeanMappingBuilder() {
				protected void configure() {
					TypeMappingBuilder mapBuilder = mapping(getClT(), getClR(), TypeMappingOptions.mapNull(false));
					addMappingBuilder(mapBuilder);
				}
			};
		}

		return builder;
	}

	protected TypeMappingBuilder addMappingBuilder(TypeMappingBuilder map) {

		return map;

	}

	@Override
	public R unmarshal(T v) {
		if (v == null)
			return null;
		return dozerMapper.getMapper().map(v, getClR());
	}

	@Override
	public T marshal(R v) {
		if (v == null)
			return null;
		return dozerMapper.getMapper().map(v, getClT());
	}


	public List<R> unmarshal(Iterable<T> sources) {
		if (sources == null)
			return null;
		ArrayList<R> targets = new ArrayList<R>();
		for (T source : sources) {
			targets.add(unmarshal(source));
		}
		return targets;
	}

	public List<T> marshal(Iterable<R> sources) {
		if (sources == null)
			return null;
		ArrayList<T> targets = new ArrayList<T>();
		for (R source : sources) {
			targets.add(marshal(source));
		}
		return targets;
	}


	public Class<T> getClT() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<R> getClR() {
		return (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
}
