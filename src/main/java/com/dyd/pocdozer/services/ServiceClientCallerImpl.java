package com.dyd.pocdozer.services;

import com.dyd.pocdozer.clients.Client;
import com.dyd.pocdozer.clients.adapters.configuration.ClientFactoryAdapterImpl;
import com.dyd.pocdozer.models.MyModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
