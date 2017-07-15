package fintechDominio

import java.util.List
import java.util.ArrayList
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class SistemaRepo {
	
	List<Usuario> listaDeUsuarios = new ArrayList()
	
	new(){
		listaDeUsuarios.add(new Usuario(38089787, "1234"))
		}
	
	def getUsuario(Integer usuario) {
		var Usuario resUsuario
		for(u : listaDeUsuarios) {
			if(u.dni == usuario ) {
				resUsuario = u
			}
		}
		resUsuario
	}

}
