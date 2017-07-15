package fintech;

import fintechDominio.Cuenta;
import fintechDominio.Gasto;
import fintechDominio.Servicio;
import fintechDominio.SistemaRepo;
import fintechDominio.Usuario;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Request;
import org.eclipse.xtext.xbase.lib.Extension;
import org.uqbar.xtrest.api.Result;
import org.uqbar.xtrest.api.annotation.Body;
import org.uqbar.xtrest.api.annotation.Controller;
import org.uqbar.xtrest.api.annotation.Get;
import org.uqbar.xtrest.api.annotation.Post;
import org.uqbar.xtrest.http.ContentType;
import org.uqbar.xtrest.json.JSONUtils;
import org.uqbar.xtrest.result.ResultFactory;

@Controller
@SuppressWarnings("all")
public class IniciarRestAPI extends ResultFactory {
  @Extension
  private JSONUtils _jSONUtils = new JSONUtils();
  
  private SistemaRepo repo = new SistemaRepo();
  
  @Get("/IniciarSesion/:id")
  public Result iniciarSesion(final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      response.setContentType(ContentType.APPLICATION_JSON);
      Integer _valueOf = Integer.valueOf(id);
      Usuario _usuario = this.repo.getUsuario(_valueOf);
      Usuario usuario = ((Usuario) _usuario);
      Cuenta _cuenta = usuario.getCuenta();
      _cuenta.crearNotificacion();
      String _json = this._jSONUtils.toJson(usuario);
      _xblockexpression = ResultFactory.ok(_json);
    }
    return _xblockexpression;
  }
  
  @Post("/AgregarServicio/:id")
  public Result agregarServicio(@Body final String body, final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      Servicio serv = this._jSONUtils.<Servicio>fromJson(body, Servicio.class);
      Integer _valueOf = Integer.valueOf(id);
      Usuario _usuario = this.repo.getUsuario(_valueOf);
      Cuenta _cuenta = _usuario.getCuenta();
      _cuenta.agregarServicio(serv);
      _xblockexpression = ResultFactory.ok("Servicio Agregado con Exito!");
    }
    return _xblockexpression;
  }
  
  @Post("/AgregarGasto/:id")
  public Result agregarDato(@Body final String body, final String id, final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) {
    Result _xblockexpression = null;
    {
      Gasto gasto = this._jSONUtils.<Gasto>fromJson(body, Gasto.class);
      Integer _valueOf = Integer.valueOf(id);
      Usuario _usuario = this.repo.getUsuario(_valueOf);
      Cuenta _cuenta = _usuario.getCuenta();
      _cuenta.agregarGasto(gasto);
      _xblockexpression = ResultFactory.ok("Gasto Agregado con Exito!");
    }
    return _xblockexpression;
  }
  
  public void handle(final String target, final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    {
    	Matcher matcher = 
    		Pattern.compile("/IniciarSesion/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Get") && matcher.matches()) {
    		// take parameters from request
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
    		
    	    Result result = iniciarSesion(id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/AgregarServicio/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
    		
    	    Result result = agregarServicio(body, id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    {
    	Matcher matcher = 
    		Pattern.compile("/AgregarGasto/(\\w+)").matcher(target);
    	if (request.getMethod().equalsIgnoreCase("Post") && matcher.matches()) {
    		// take parameters from request
    		String body = readBodyAsString(request);
    		
    		// take variables from url
    		String id = matcher.group(1);
    		
    		
    	    Result result = agregarDato(body, id, target, baseRequest, request, response);
    	    result.process(response);
    	    
    		response.addHeader("Access-Control-Allow-Origin", "*");
    	    baseRequest.setHandled(true);
    	    return;
    	}
    }
    this.pageNotFound(baseRequest, request, response);
  }
  
  public void pageNotFound(final Request baseRequest, final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
    response.getWriter().write(
    	"<html><head><title>XtRest - Page Not Found!</title></head>" 
    	+ "<body>"
    	+ "	<h1>Page Not Found !</h1>"
    	+ "	Supported resources:"
    	+ "	<table>"
    	+ "		<thead><tr><th>Verb</th><th>URL</th><th>Parameters</th></tr></thead>"
    	+ "		<tbody>"
    	+ "			<tr>"
    	+ "				<td>GET</td>"
    	+ "				<td>/IniciarSesion/:id</td>"
    	+ "				<td>id</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/AgregarServicio/:id</td>"
    	+ "				<td>body, id</td>"
    	+ "			</tr>"
    	+ "			<tr>"
    	+ "				<td>POST</td>"
    	+ "				<td>/AgregarGasto/:id</td>"
    	+ "				<td>body, id</td>"
    	+ "			</tr>"
    	+ "		</tbody>"
    	+ "	</table>"
    	+ "</body>"
    );
    response.setStatus(404);
    baseRequest.setHandled(true);
  }
}
