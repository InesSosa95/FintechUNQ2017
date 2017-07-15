package fintech

import org.uqbar.xtrest.api.XTRest

class NotificacionesApp {
	
	def static void main(String[] args){
		XTRest.startInstance(new IniciarRestAPI(), 3000)
		
	}
	
	
}

