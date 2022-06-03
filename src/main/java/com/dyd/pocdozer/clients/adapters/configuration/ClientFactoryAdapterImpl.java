package com.dyd.pocdozer.clients.adapters.configuration;

import com.dyd.pocdozer.clients.adapters.converters.custom.GenericAdapterImpl;
import com.dyd.pocdozer.clients.adapters.converters.custom.MyModelAdapter;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ClientFactoryAdapterImpl {

	@Autowired
	private MyModelAdapter myModelAdapter;

	@Autowired
	private GenericAdapterImpl genericAdapter;

}
