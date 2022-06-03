package com.dyd.pocdozer.clients;

import com.dyd.pocdozer.models.dto.TheirModel;
import com.dyd.pocdozer.models.dto.TheirModelTwo;

import java.util.List;

public interface Client {
	TheirModel getModel();

	TheirModelTwo getModel2();

	List<TheirModelTwo> getListModel2();
}
