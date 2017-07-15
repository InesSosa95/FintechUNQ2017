package fintechDominio

import org.eclipse.xtend.lib.annotations.Accessors
import org.joda.time.LocalDate

@Accessors
class Servicio extends Gasto {
//	LocalDate vencimiento;
	Periodicidad periodicidad;
	Integer dia;
	Integer mes;
	Integer anho;

	new() {
		super("", 0.0)
		this.periodicidad = Periodicidad.MENSUAL;
	}

	new(String nombre, Double monto, Periodicidad periodicidad, Integer dia, Integer mes, Integer anho) {
		super(nombre, monto)
		this.dia = dia;
		this.mes = mes;
		this.anho = anho;
//		this.vencimiento = new LocalDate(dia, mes, anho)
		this.periodicidad = periodicidad
	}

	def vencimiento() {
		return new LocalDate(anho, mes, dia)
	}

}
