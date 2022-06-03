package com.dyd.pocdozer.clients.adapters.configuration;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DozerMapper {

	private DozerBeanMapper mapper;

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	private List<CustomConverter> converters;

	void initMapper() {
		mapper = new DozerBeanMapper();

		appContext.getBeansOfType(GenericAdapter.class).values()
				.forEach(genericAdapter -> mapper.addMapping(genericAdapter.getBuilder()));

		mapper.setCustomConverters(converters);
	}

	public DozerBeanMapper getMapper() {
		if(mapper == null )
			initMapper();
		return mapper;
	}

}
