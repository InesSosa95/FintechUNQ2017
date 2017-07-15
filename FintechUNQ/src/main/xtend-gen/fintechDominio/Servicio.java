package fintechDominio;

import fintechDominio.Gasto;
import fintechDominio.Periodicidad;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.joda.time.LocalDate;

@Accessors
@SuppressWarnings("all")
public class Servicio extends Gasto {
  private Periodicidad periodicidad;
  
  private Integer dia;
  
  private Integer mes;
  
  private Integer anho;
  
  public Servicio() {
    super("", Double.valueOf(0.0));
    this.periodicidad = Periodicidad.MENSUAL;
  }
  
  public Servicio(final String nombre, final Double monto, final Periodicidad periodicidad, final Integer dia, final Integer mes, final Integer anho) {
    super(nombre, monto);
    this.dia = dia;
    this.mes = mes;
    this.anho = anho;
    this.periodicidad = periodicidad;
  }
  
  public LocalDate vencimiento() {
    return new LocalDate((this.anho).intValue(), (this.mes).intValue(), (this.dia).intValue());
  }
  
  @Pure
  public Periodicidad getPeriodicidad() {
    return this.periodicidad;
  }
  
  public void setPeriodicidad(final Periodicidad periodicidad) {
    this.periodicidad = periodicidad;
  }
  
  @Pure
  public Integer getDia() {
    return this.dia;
  }
  
  public void setDia(final Integer dia) {
    this.dia = dia;
  }
  
  @Pure
  public Integer getMes() {
    return this.mes;
  }
  
  public void setMes(final Integer mes) {
    this.mes = mes;
  }
  
  @Pure
  public Integer getAnho() {
    return this.anho;
  }
  
  public void setAnho(final Integer anho) {
    this.anho = anho;
  }
}
