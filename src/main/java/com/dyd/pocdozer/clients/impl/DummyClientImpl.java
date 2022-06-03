package com.dyd.pocdozer.clients.impl;

import com.dyd.pocdozer.clients.Client;
import com.dyd.pocdozer.models.dto.TheirModel;
import com.dyd.pocdozer.models.dto.TheirModelTwo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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

	@Override
	public TheirModelTwo getModel2(){
		TheirModelTwo model = new TheirModelTwo();
		model.setAcciones(Arrays.asList("abc", "def"));
		model.setId(1);
		model.setEstado("123456");
		model.setIdColectivo("123456");
		model.setModel(getModel());
		return model;
	}

	@Override
	public List<TheirModelTwo> getListModel2() {
		return Arrays.asList(getModel2(), getModel2(), getModel2());
	}

}
