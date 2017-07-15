package fintech;

import fintech.IniciarRestAPI;
import org.uqbar.xtrest.api.XTRest;

@SuppressWarnings("all")
public class NotificacionesApp {
  public static void main(final String[] args) {
    IniciarRestAPI _iniciarRestAPI = new IniciarRestAPI();
    XTRest.startInstance(_iniciarRestAPI, 3000);
  }
}
