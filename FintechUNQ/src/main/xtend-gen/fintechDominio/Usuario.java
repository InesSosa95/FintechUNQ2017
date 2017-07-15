package fintechDominio;

import fintechDominio.Cuenta;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Usuario {
  private Integer dni;
  
  private String contrasenha;
  
  private Cuenta cuenta;
  
  public Usuario(final Integer dni, final String contrasenha) {
    this.dni = dni;
    this.contrasenha = contrasenha;
    Cuenta _cuenta = new Cuenta();
    this.cuenta = _cuenta;
  }
  
  @Pure
  public Integer getDni() {
    return this.dni;
  }
  
  public void setDni(final Integer dni) {
    this.dni = dni;
  }
  
  @Pure
  public String getContrasenha() {
    return this.contrasenha;
  }
  
  public void setContrasenha(final String contrasenha) {
    this.contrasenha = contrasenha;
  }
  
  @Pure
  public Cuenta getCuenta() {
    return this.cuenta;
  }
  
  public void setCuenta(final Cuenta cuenta) {
    this.cuenta = cuenta;
  }
}
