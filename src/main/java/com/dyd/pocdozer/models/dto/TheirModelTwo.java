package com.dyd.pocdozer.models.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TheirModelTwo {

	private Integer id;
	private String estado;
	private List<String> acciones = new ArrayList<>();
	private String idColectivo;
	private String usuario;
	private Integer idTipoPrestacion;
	private TheirModel model;
}
