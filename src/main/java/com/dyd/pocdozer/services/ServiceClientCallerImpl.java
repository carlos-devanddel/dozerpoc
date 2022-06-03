package com.dyd.pocdozer.services;

import com.dyd.pocdozer.clients.Client;
import com.dyd.pocdozer.clients.adapters.converters.custom.GenericAdapter;
import com.dyd.pocdozer.models.MyModel;
import com.dyd.pocdozer.models.MyModelTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClientCallerImpl implements ServiceClientCaller {
	@Autowired
	private Client client;

	@Autowired
	private GenericAdapter genericAdapter;

	@Override
	public MyModel getDataFromClient() {
		return genericAdapter.transform(client.getModel(), MyModel.class);
	}

	@Override
	public List<MyModelTwo> getData2FromClient() {
		return genericAdapter.transform(client.getListModel2(), MyModelTwo.class);
	}
}
