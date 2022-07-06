package co.com.negocio.financiero.financiero;


import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.negocio.financiero.manager.GastosModelOperacionesManager;
import co.com.negocio.financiero.manager.managerImpl.GastosModelManagerImpl;
import co.com.negocio.financiero.manager.managerImpl.GastosModelManagerParametrosImpl;
import co.com.negocio.financiero.manager.managerImpl.GastosModelManagerUsuariosImpl;
import co.com.negocio.financiero.model.dto.BalanceUsuarioModelDTO;
import co.com.negocio.financiero.model.dto.GastosModelDTO;
import co.com.negocio.financiero.model.dto.ParametrosModelDTO;
import co.com.negocio.financiero.model.dto.UsuariosModelDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class ControladorServicios { 
	
	private final static String lCrossOrigins = "http://192.168.20.22:8100";
	
	@Autowired
	private	GastosModelManagerUsuariosImpl lGastosModelManagerUsuariosImpl;
	
	@Autowired
	private	GastosModelManagerImpl lGastosModelManagerImpl;
	
	@Autowired
	private	GastosModelManagerParametrosImpl lGastosModelManagerParametrosImpl;
	
	@Autowired
	private GastosModelOperacionesManager lGastosModelOperacionesManager;
	
	
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/consultaUsuarios",
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> consultaUsuarios(@RequestBody  
			UsuariosModelDTO pUsuariosModelDTO) 
					throws Exception {
		
		ArrayList<UsuariosModelDTO> lUsuariosModelDTOArray = new ArrayList<UsuariosModelDTO>();
		lUsuariosModelDTOArray = (ArrayList<UsuariosModelDTO>) lGastosModelManagerUsuariosImpl.consultarRegistros(null,null,pUsuariosModelDTO.getIdUsuario().toString());
	
		return new ResponseEntity<>(lUsuariosModelDTOArray, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/modificacionUsuarios",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>  modificacionUsuarios (@RequestBody  
			UsuariosModelDTO pUsuariosModelDTO) 
					throws Exception {
		
		boolean lRetorno = true;
		lRetorno = lGastosModelManagerUsuariosImpl.ActualizarRegisto(pUsuariosModelDTO);
		return new ResponseEntity<>(lRetorno, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/insercionUsuarios",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>  insercionUsuarios(@RequestBody  
			UsuariosModelDTO pUsuariosModelDTO) 
					throws Exception {
		
		boolean lRetorno = true;
		lRetorno = lGastosModelManagerUsuariosImpl.InsertarRegisto(pUsuariosModelDTO);
		return new ResponseEntity<>(lRetorno, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/eliminacionUsuarios",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>  elmininacionUsuarios(@RequestBody  
			UsuariosModelDTO pUsuariosModelDTO) 
					throws Exception {
		
		boolean lRetorno = true;
		lRetorno = lGastosModelManagerUsuariosImpl.EliminarRegisto(pUsuariosModelDTO);
		return new ResponseEntity<>(lRetorno, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/consultaParametros",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> consultaParametros(@RequestBody  
			ParametrosModelDTO pParametrosModelDTO) 
					throws Exception {
		
		ArrayList<ParametrosModelDTO> lParametrosModelDTOArray = new ArrayList<ParametrosModelDTO>();
		lParametrosModelDTOArray = (ArrayList<ParametrosModelDTO>) lGastosModelManagerParametrosImpl.consultarRegistros(null,null,pParametrosModelDTO.getIdUsuario().toString());
	
		return new ResponseEntity<>(lParametrosModelDTOArray, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/modificacionParametros",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>  modificacionParametros (@RequestBody  
			ParametrosModelDTO pParametrosModelDTO) 
					throws Exception {
		
		boolean lRetorno = true;
		lRetorno = lGastosModelManagerParametrosImpl.ActualizarRegisto(pParametrosModelDTO);
		return new ResponseEntity<>(lRetorno, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/insercionParametros",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>  insercionParametros(@RequestBody  
			ParametrosModelDTO pParametrosModelDTO) 
					throws Exception {
		
		boolean lRetorno = true;
		lRetorno = lGastosModelManagerParametrosImpl.InsertarRegisto(pParametrosModelDTO);
		return new ResponseEntity<>(lRetorno, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/elmininacionParametros",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>  elmininacionParametros(@RequestBody  
			ParametrosModelDTO pParametrosModelDTO) 
					throws Exception {
		
		boolean lRetorno = true;
		lRetorno = lGastosModelManagerParametrosImpl.EliminarRegisto(pParametrosModelDTO);
		return new ResponseEntity<>(lRetorno, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/consultaGastos",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "consulta Gastos", httpMethod = "POST", notes="Consulta el detalle de gastos según parametros")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message="SUCCESSFUL", response = GastosModelDTO.class),
			@ApiResponse(code = 400, message="BAD REQUEST"),
			@ApiResponse(code = 500, message="INTERNAL SERVER ERROR")			
	})
	public ResponseEntity<Object> consultaGastos(@RequestBody  
			GastosModelDTO pGastosModelDTO) 
					throws Exception {
		
		ArrayList<GastosModelDTO> lGastosModelDTOArray = new ArrayList<GastosModelDTO>();
		
		if(pGastosModelDTO.getUsuario() == null  || 
				pGastosModelDTO.getEfectivo() == null || 
					pGastosModelDTO.getQuincenaUno() == null) {
			
			return new ResponseEntity<> (null, HttpStatus.BAD_REQUEST);
			
		} 	
		
		lGastosModelDTOArray = (ArrayList<GastosModelDTO>) lGastosModelManagerImpl.consultarRegistros(pGastosModelDTO.getEfectivo(),
				pGastosModelDTO.getQuincenaUno(),
				pGastosModelDTO.getUsuario().toString());		
			
		return new ResponseEntity<>(lGastosModelDTOArray.size() > 1 ? lGastosModelDTOArray: null, 
				lGastosModelDTOArray.size() > 1 ? HttpStatus.OK: HttpStatus.NO_CONTENT);
		
		
		
	}
	
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/modificacionGastos",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>  modificacionGastos (@RequestBody  
			GastosModelDTO pGastosModelDTO) 
					throws Exception {
		
		boolean lRetorno = true;
		lRetorno = lGastosModelManagerImpl.ActualizarRegisto(pGastosModelDTO);
		return new ResponseEntity<>(lRetorno, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/insercionGastos",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>  insercionGastos(@RequestBody  
			GastosModelDTO pGastosModelDTO) 
					throws Exception {
		
		boolean lRetorno = true;
		lRetorno = lGastosModelManagerImpl.InsertarRegisto(pGastosModelDTO);
		return new ResponseEntity<>(lRetorno, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/eliminacionGastos",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>  elmininacionGastos(@RequestBody  
			GastosModelDTO pGastosModelDTO) 
					throws Exception {
		
		boolean lRetorno = true;
		lRetorno = lGastosModelManagerImpl.EliminarRegisto(pGastosModelDTO);
		return new ResponseEntity<>(lRetorno, HttpStatus.OK);
		
	}
	
	@SuppressWarnings("unchecked")
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/BalanceGeneral",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> BalanceGeneral (@RequestBody  
			UsuariosModelDTO pUsuariosModelDTO) 
			throws Exception {
		
		URI location = URI.create("");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
	    responseHeaders.set("MyResponseHeader", "MyValue");

		ArrayList<BalanceUsuarioModelDTO> lGastosModelBalanceUsuarioDTO = new ArrayList<BalanceUsuarioModelDTO>();
		lGastosModelBalanceUsuarioDTO = (ArrayList<BalanceUsuarioModelDTO>) lGastosModelOperacionesManager.obtenerBalanceGeneral(pUsuariosModelDTO.getIdUsuario().toString());
		return new ResponseEntity<>(lGastosModelBalanceUsuarioDTO,responseHeaders, HttpStatus.OK);
		
	}	
	
}
