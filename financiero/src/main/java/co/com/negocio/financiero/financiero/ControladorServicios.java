package co.com.negocio.financiero.financiero;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<ArrayList<UsuariosModelDTO>> consultaUsuarios(@RequestBody  
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
	public ResponseEntity<Boolean>  modificacionUsuarios (@RequestBody  
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
	public ResponseEntity<Boolean>  insercionUsuarios(@RequestBody  
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
	public ResponseEntity<Boolean>  elmininacionUsuarios(@RequestBody  
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
	public ResponseEntity<ArrayList<ParametrosModelDTO>> consultaParametros(@RequestBody  
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
	public ResponseEntity<Boolean>  modificacionParametros (@RequestBody  
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
	public ResponseEntity<Boolean>  insercionParametros(@RequestBody  
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
	public ResponseEntity<Boolean>  elmininacionParametros(@RequestBody  
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
	public ResponseEntity<ArrayList<GastosModelDTO>> consultaGastos(@RequestBody  
			GastosModelDTO pGastosModelDTO) 
					throws Exception {
		
		ArrayList<GastosModelDTO> lGastosModelDTOArray = new ArrayList<GastosModelDTO>();
		lGastosModelDTOArray = (ArrayList<GastosModelDTO>) lGastosModelManagerImpl.consultarRegistros(pGastosModelDTO.getEfectivo(),
				pGastosModelDTO.getQuincenaUno(),
				pGastosModelDTO.getUsuario().toString());
	
		return new ResponseEntity<>(lGastosModelDTOArray, HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = lCrossOrigins)
	@PostMapping(path ="/modificacionGastos",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean>  modificacionGastos (@RequestBody  
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
	public ResponseEntity<Boolean>  insercionGastos(@RequestBody  
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
	public ResponseEntity<Boolean>  elmininacionGastos(@RequestBody  
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
	public ResponseEntity<ArrayList<BalanceUsuarioModelDTO>> BalanceGeneral (@RequestBody  
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
	
	
	@CrossOrigin(origins = lCrossOrigins)
	@GetMapping("/ConsultaGastos/{usuario}/{quin1}/{efec}")
	public ResponseEntity<ArrayList<GastosModelDTO>> 
		ConsultaGastos(@PathVariable String usuario,
				@PathVariable String quin1,
				@PathVariable String efec) 
				throws Exception {
		URI location = URI.create("control_gastos_api");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
	    responseHeaders.set("MyResponseHeader", "MyValue");
		ArrayList<GastosModelDTO> lGastosModelBalanceUsuarioDTO = new ArrayList<GastosModelDTO>();
		lGastosModelBalanceUsuarioDTO = (ArrayList<GastosModelDTO>) lGastosModelManagerImpl.consultarRegistros(efec,quin1,usuario);
		return new ResponseEntity<>(lGastosModelBalanceUsuarioDTO,responseHeaders, HttpStatus.OK);
		
	}
	
	@GetMapping("/modificarGastos/{name}")
	public ResponseEntity<Boolean> 
	   modificarGastos(@PathVariable String name) 
			   throws Exception {
		
		GastosModelDTO lGastosModelBalanceUsuarioDTO = new GastosModelDTO();
		
		lGastosModelBalanceUsuarioDTO.setDescripcion("GAME PASS");
		lGastosModelBalanceUsuarioDTO.setEfectivo("N");
		lGastosModelBalanceUsuarioDTO.setQuincenaDos("N");
		lGastosModelBalanceUsuarioDTO.setQuincenaUno("A");
		lGastosModelBalanceUsuarioDTO.setIdGastos(new BigDecimal(20));
		lGastosModelBalanceUsuarioDTO.setUsuario(name);
		lGastosModelBalanceUsuarioDTO.setValor(new BigDecimal(29900));
		
		
		
		boolean lRetorno = true;
		lRetorno = lGastosModelManagerImpl.EliminarRegisto(lGastosModelBalanceUsuarioDTO);
		return new ResponseEntity<>(lRetorno, HttpStatus.OK);
	}
	
	@GetMapping("/ConsultaParametros/{name}")
	public ResponseEntity<ArrayList<ParametrosModelDTO>>  
	ConsultaParametros (@PathVariable String name) 
			throws Exception {
		
		ArrayList<ParametrosModelDTO> lGastosModelBalanceUsuarioDTO = new ArrayList<ParametrosModelDTO>();
		lGastosModelBalanceUsuarioDTO = (ArrayList<ParametrosModelDTO>) lGastosModelManagerParametrosImpl.consultarRegistros(null,null,name);
		return new ResponseEntity<>(lGastosModelBalanceUsuarioDTO, HttpStatus.OK);
	}
	
	
	@GetMapping("/modificacionParametros/{name}")
	public ResponseEntity<Boolean>  modificacionParametros (@PathVariable/*(value = "name", defaultValue = "1030568079") */String name) throws Exception {
		ParametrosModelDTO lGastosModelBalanceUsuarioDTO = new ParametrosModelDTO();
		lGastosModelBalanceUsuarioDTO.setDescripcion("SALUD");
		lGastosModelBalanceUsuarioDTO.setIdParametro(new BigDecimal(15));
		lGastosModelBalanceUsuarioDTO.setValor(new BigDecimal(4));
		lGastosModelBalanceUsuarioDTO.setIdUsuario(name);
		
		boolean lRetorno = true;
		lRetorno = lGastosModelManagerParametrosImpl.InsertarRegisto(lGastosModelBalanceUsuarioDTO);
		return new ResponseEntity<>(lRetorno, HttpStatus.OK);
	}

}
