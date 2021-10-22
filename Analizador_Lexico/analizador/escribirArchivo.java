package analizador;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class escribirArchivo implements Guardar{
	private FileWriter fw ;
	private String entrada = "";
	private List<String> listaID = new ArrayList<String>();
	private List<String> listaString = new ArrayList<String>();
	private List<String> listaChar = new ArrayList<String>();
	private List<String> listaInt = new ArrayList<String>();
	private List<String> listaFloat = new ArrayList<String>();
	private void guardarTablaSimbolos() throws IOException { this.fw.write(this.getEntrada()); }
	
	private void setEntrada(String entrada) { this.entrada = entrada; }
	private void resetEntrada() { this.entrada = ""; }
	private String getEntrada() { return this.entrada; }
	
	/***
	 * Recibe un identificador. Retorna, verdadero si ya existe en un registro.
	 * Falso, en caso contrario.
	 * @param ID
	 * @return
	 */
	private boolean existeID(String ID) {
		boolean existencia = false;
		
		if (!this.listaID.isEmpty()) { // si la lista no esta vacia.
			if (this.listaID.contains(ID)) { existencia = true; } //compruebo si existe ese id en la lista.
		}
		
		return existencia;
	}
	private boolean existeString(String s) {
		boolean existencia = false;
		
		if (!this.listaString.isEmpty()) { 
			if (this.listaString.contains(s)) { existencia = true; } 
		}
		
		return existencia;
	}
	private boolean existeInt(String s) {
		boolean existencia = false;
		
		if (!this.listaInt.isEmpty()) { 
			if (this.listaInt.contains(s)) { existencia = true; } 
		}
		
		return existencia;
	}
	private boolean existeChar(String s) {
		boolean existencia = false;
		
		if (!this.listaChar.isEmpty()) { 
			if (this.listaChar.contains(s)) { existencia = true; } 
		}
		
		return existencia;
	}
	private boolean existeFloat(String s) {
		boolean existencia = false;
		
		if (!this.listaFloat.isEmpty()) { 
			if (this.listaFloat.contains(s)) { existencia = true; } 
		}
		
		return existencia;
	}
	
	/**
	 * Recibe un identificador. Se registra para futura evaluacion de ids repetidos.
	 * @param ID
	 */
	private void registrarID(String ID) { this.listaID.add(ID); }
	private void registrarString(String ID) { this.listaString.add(ID); }
	private void registrarInt(String ID) { this.listaInt.add(ID); }
	private void registrarFloat(String ID) { this.listaFloat.add(ID); }
	private void registrarChar(String ID) { this.listaChar.add(ID); }
	public escribirArchivo() throws IOException { this.fw = new FileWriter("ts.txt",true); 
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();  
		this.setEntrada("\n---------- "+dtf.format(now)+" --------------\n\n Nombre|Token|Tipo|Valor|longitud\n\n");
		this.guardarTablaSimbolos();
	}
	
	/**
	 * Metodo que cierra esta clase para evitar que no se pierdan datos en la escritura del archivo.
	 * @throws IOException
	 */
	public void cerrarModulo() throws IOException {
		this.fw.close(); //TODO: cuidado! en futura implementacion podria dañar el funcionamiento.
	}

	@Override
	public void guardarID(String Lexema, String Token) throws IOException {
		if (!this.existeID(Lexema)) { //si no existe registro lexema
			this.registrarID(Lexema); //lo registro y hago el procedimiento de registracion.
			this.resetEntrada(); //reseto, primero el flujo de datos previo.
			this.setEntrada(Lexema+"  "+Token+"  "+"-"+"  "+"-"+"  "+"-"+"\n"); //preparo el formato de la salida datos al archivo
			System.out.println(this.getEntrada());
			this.guardarTablaSimbolos(); //invoco a esta funcion que genera una nueva entrada en el archivo.
		}
	}

	@Override
	public void guardarCTEString(String Lexema, String Token) throws IOException{
		if (!this.existeString(Lexema)) { //si no existe registro lexema
		this.registrarString(Lexema);
		this.resetEntrada();
		this.setEntrada('_'+Lexema+"  "+Token+"  "+"-"+"  "+Lexema+"  "+(Lexema.length()-2)+"\n");
		System.out.println(this.getEntrada());
		this.guardarTablaSimbolos();
		}
	}

	@Override
	public void guardarCTEChar(String Lexema, String Token) throws IOException {
		if (!this.existeChar(Lexema)) { //si no existe registro lexema
		this.registrarChar(Lexema);
		this.resetEntrada();
		this.setEntrada('_'+Lexema+"  "+Token+"  "+"-"+"  "+Lexema+"  "+(Lexema.length()-2)+"\n");
		System.out.println(this.getEntrada());
		this.guardarTablaSimbolos();
		}
	}

	@Override
	public void guardarCTEEntera(String Lexema, String Token) throws IOException {
		if (!this.existeInt(Lexema)) { //si no existe registro lexema
			this.registrarInt(Lexema);
		this.resetEntrada();
		this.setEntrada('_'+Lexema+"  "+Token+"  "+"-"+"  "+Lexema+"  "+"-"+"\n");
		System.out.println(this.getEntrada());
		this.guardarTablaSimbolos();
		}
	}

	@Override
	public void guardarCTEFloat(String Lexema, String Token) throws IOException {
		if (!this.existeFloat(Lexema)) { //si no existe registro lexema
			this.registrarFloat(Lexema);
		this.resetEntrada();
		this.setEntrada('_'+Lexema+"  "+Token+"  "+"-"+"  "+Lexema+"  "+"-"+"\n");
		System.out.println(this.getEntrada());
		this.guardarTablaSimbolos();
		}
	}
}
