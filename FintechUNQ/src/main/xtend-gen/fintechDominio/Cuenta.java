package fintechDominio;

import fintechDominio.Gasto;
import fintechDominio.Servicio;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.joda.time.LocalDate;

@Accessors
@SuppressWarnings("all")
public class Cuenta {
  private List<Gasto> gastos;
  
  private List<Servicio> servicios;
  
  private List<Servicio> notificaciones;
  
  public Cuenta() {
    ArrayList<Gasto> _newArrayList = CollectionLiterals.<Gasto>newArrayList();
    this.gastos = _newArrayList;
    ArrayList<Servicio> _newArrayList_1 = CollectionLiterals.<Servicio>newArrayList();
    this.servicios = _newArrayList_1;
    ArrayList<Servicio> _arrayList = new ArrayList<Servicio>();
    this.notificaciones = _arrayList;
  }
  
  public boolean agregarGasto(final Gasto gasto) {
    return this.gastos.add(gasto);
  }
  
  public boolean agregarServicio(final Servicio servicio) {
    return this.servicios.add(servicio);
  }
  
  public boolean eliminarGasto(final Gasto gasto) {
    return this.gastos.remove(gasto);
  }
  
  public boolean eliminarServicio(final Servicio servicio) {
    return this.servicios.remove(servicio);
  }
  
  public void crearNotificacion() {
    ArrayList<Object> serviciosAPagar = CollectionLiterals.<Object>newArrayList();
    for (final Servicio s : this.servicios) {
      LocalDate _now = LocalDate.now();
      LocalDate _plusDays = _now.plusDays(10);
      LocalDate _vencimiento = s.vencimiento();
      boolean _greaterEqualsThan = (_plusDays.compareTo(_vencimiento) >= 0);
      if (_greaterEqualsThan) {
        this.notificaciones.add(s);
      }
    }
  }
  
  @Pure
  public List<Gasto> getGastos() {
    return this.gastos;
  }
  
  public void setGastos(final List<Gasto> gastos) {
    this.gastos = gastos;
  }
  
  @Pure
  public List<Servicio> getServicios() {
    return this.servicios;
  }
  
  public void setServicios(final List<Servicio> servicios) {
    this.servicios = servicios;
  }
  
  @Pure
  public List<Servicio> getNotificaciones() {
    return this.notificaciones;
  }
  
  public void setNotificaciones(final List<Servicio> notificaciones) {
    this.notificaciones = notificaciones;
  }
}
