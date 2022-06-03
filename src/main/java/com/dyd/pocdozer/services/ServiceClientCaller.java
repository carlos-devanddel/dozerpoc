package com.dyd.pocdozer.services;

import com.dyd.pocdozer.models.MyModel;
import com.dyd.pocdozer.models.MyModelTwo;

import java.util.List;

public interface ServiceClientCaller {

	MyModel getDataFromClient();

	List<MyModelTwo> getData2FromClient();
}
