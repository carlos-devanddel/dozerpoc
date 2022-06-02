package com.dyd.pocdozer.clients.adapters.converters.custom;

import com.dyd.pocdozer.clients.adapters.configuration.GenericAdapter;
import com.dyd.pocdozer.clients.adapters.converters.generic.IntegerStringConverter;
import com.dyd.pocdozer.models.MyModel;
import com.dyd.pocdozer.models.dto.TheirModel;
import org.dozer.loader.api.FieldsMappingOptions;
import org.dozer.loader.api.TypeMappingBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyModelAdapter extends GenericAdapter<MyModel, TheirModel> {

	@Override
	protected TypeMappingBuilder addMappingBuilder(TypeMappingBuilder map) {
		return super.addMappingBuilder(
				map.fields("numericField3", "stringField3", FieldsMappingOptions.customConverter(IntegerStringConverter.class)));

	}
}
