package com.dyd.pocdozer.models;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class MyModelTwo {

	private Integer id;
	private String estado;
	private List<String> acciones = new ArrayList<>();
	private String idColectivo;
	private String usuario;
	private Integer idTipoPrestacion;
	private MyModel model;
}
