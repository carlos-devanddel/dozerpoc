package com.dyd.pocdozer.clients.adapters.configuration;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.lang.reflect.ParameterizedType;

public abstract class GenericAdapter<T, R> extends XmlAdapter<T, R> {

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

	public Class<T> getClT() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<R> getClR() {
		return (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
}
