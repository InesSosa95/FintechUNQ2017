package fintechDominio

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.joda.time.LocalDate
import java.util.ArrayList

@Accessors
class Cuenta {

	List<Gasto> gastos;
	List<Servicio> servicios;
	List<Servicio> notificaciones;

	new() {
		this.gastos = newArrayList;
		this.servicios = newArrayList;
		this.notificaciones = new ArrayList
	}

	def agregarGasto(Gasto gasto) {
		gastos.add(gasto)
	}

	def agregarServicio(Servicio servicio) {
		servicios.add(servicio)
	// Throw exception
	}

	def eliminarGasto(Gasto gasto) {
		this.gastos.remove(gasto)
	}

	def eliminarServicio(Servicio servicio) {
		this.servicios.remove(servicio)
	}

	def crearNotificacion() {
		var serviciosAPagar = newArrayList
		for (s : servicios) {
			if (LocalDate.now().plusDays(10) >= s.vencimiento)
				notificaciones.add(s)
		}
	}

}
