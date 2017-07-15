package fintech

import fintechDominio.Servicio
import fintechDominio.SistemaRepo
import fintechDominio.Usuario
import org.uqbar.xtrest.api.annotation.Body
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.annotation.Post
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.json.JSONUtils
import fintechDominio.Gasto

@Controller
class IniciarRestAPI {
	extension JSONUtils = new JSONUtils
	SistemaRepo repo = new SistemaRepo

	@Get("/IniciarSesion/:id")
	def iniciarSesion() {
		response.contentType = ContentType.APPLICATION_JSON
		var Usuario usuario = repo.getUsuario(Integer.valueOf(id)) as Usuario
		usuario.cuenta.crearNotificacion
		ok(usuario.toJson)
	}

	@Post("/AgregarServicio/:id")
	def agregarServicio(@Body String body) {
		var Servicio serv = body.fromJson(Servicio)
		this.repo.getUsuario(Integer.valueOf(id)).cuenta.agregarServicio(serv)
		ok("Servicio Agregado con Exito!")
	}

	@Post("/AgregarGasto/:id")
	def agregarDato(@Body String body) {
		var Gasto gasto = body.fromJson(Gasto)
		this.repo.getUsuario(Integer.valueOf(id)).cuenta.agregarGasto(gasto)
		ok("Gasto Agregado con Exito!")
	}

}
