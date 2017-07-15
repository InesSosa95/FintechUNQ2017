package fintechDominio;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Gasto {
  private String nombre;
  
  private Double monto;
  
  public Gasto() {
  }
  
  public Gasto(final String nombre, final Double monto) {
    this.nombre = nombre;
    this.monto = monto;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public Double getMonto() {
    return this.monto;
  }
  
  public void setMonto(final Double monto) {
    this.monto = monto;
  }
}
