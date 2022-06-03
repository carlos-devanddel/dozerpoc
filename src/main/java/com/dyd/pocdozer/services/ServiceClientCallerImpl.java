package com.dyd.pocdozer.services;

import com.dyd.pocdozer.clients.Client;
import com.dyd.pocdozer.clients.adapters.configuration.ClientFactoryAdapterImpl;
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
	private ClientFactoryAdapterImpl factoryAdapter;

	@Override
	public MyModel getDataFromClient() {
		return factoryAdapter.getMyModelAdapter().marshal(client.getModel());
	}

	@Override
	public List<MyModelTwo> getData2FromClient() {
		return factoryAdapter.getGenericAdapter().genericMarshal(client.getListModel2(), MyModelTwo.class);
	}
}
