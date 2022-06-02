package com.dyd.pocdozer.clients.impl;

import com.dyd.pocdozer.clients.Client;
import com.dyd.pocdozer.models.dto.TheirModel;
import org.springframework.stereotype.Service;

@Service
public class DummyClientImpl implements Client {

	@Override
	public TheirModel getModel(){
		TheirModel model = new TheirModel();
		model.setStringField1("abc");
		model.setStringField2("def");
		model.setStringField3("123456");
		return model;
	}

}
