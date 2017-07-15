package fintechDominio

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Gasto {
	String nombre;
	Double monto;
	
	new (){}
	
	new (String nombre, Double monto){
		this.nombre = nombre;
		this.monto = monto;
	} 
}
