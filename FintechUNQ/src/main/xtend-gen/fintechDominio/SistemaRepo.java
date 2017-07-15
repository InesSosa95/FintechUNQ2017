package fintechDominio;

import com.google.common.base.Objects;
import fintechDominio.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class SistemaRepo {
  private List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
  
  public SistemaRepo() {
    Usuario _usuario = new Usuario(Integer.valueOf(38089787), "1234");
    this.listaDeUsuarios.add(_usuario);
  }
  
  public Usuario getUsuario(final Integer usuario) {
    Usuario _xblockexpression = null;
    {
      Usuario resUsuario = null;
      for (final Usuario u : this.listaDeUsuarios) {
        Integer _dni = u.getDni();
        boolean _equals = Objects.equal(_dni, usuario);
        if (_equals) {
          resUsuario = u;
        }
      }
      _xblockexpression = resUsuario;
    }
    return _xblockexpression;
  }
  
  @Pure
  public List<Usuario> getListaDeUsuarios() {
    return this.listaDeUsuarios;
  }
  
  public void setListaDeUsuarios(final List<Usuario> listaDeUsuarios) {
    this.listaDeUsuarios = listaDeUsuarios;
  }
}
