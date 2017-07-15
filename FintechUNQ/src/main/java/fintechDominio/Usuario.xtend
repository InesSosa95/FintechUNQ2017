package fintechDominio

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Usuario {
	
	Integer dni;
	String contrasenha;
	Cuenta cuenta
	
	
	new (Integer dni, String contrasenha){
		this.dni = dni;
		this.contrasenha = contrasenha
		this.cuenta = new Cuenta
	}
	
}
