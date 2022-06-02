package com.dyd.pocdozer.clients.adapters.configuration;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

@Component
public class DozerMapper {

	private DozerBeanMapper m;

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	private List<CustomConverter> converters;

	void initMapper() {

		m = new DozerBeanMapper();

		String varname1 = "<mappings xmlns=\"http://dozer.sourceforge.net\"" + " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
				+ " xsi:schemaLocation=\"http://dozer.sourceforge.net http://dozer.sourceforge.net/schema/beanmapping.xsd\" > " + "  <configuration> "
				+ "<copy-by-references>" + "<copy-by-reference>" + " </copy-by-reference>" + "</copy-by-references>" + "  </configuration> "
				+ "</mappings>";

		Map<String, GenericAdapter> beansOfType = appContext.getBeansOfType(GenericAdapter.class);
		for (GenericAdapter genericAdapter : beansOfType.values()) {
			m.addMapping(genericAdapter.getBuilder());
		}

		m.setCustomConverters(converters);

		m.addMapping((new ByteArrayInputStream(varname1.getBytes())));

		m.map(new Object(), Object.class);

	}

	public DozerBeanMapper getMapper() {
		if(m == null )
			initMapper();
		return m;
	}

}
