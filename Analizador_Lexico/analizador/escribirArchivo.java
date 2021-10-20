package analizador;

import java.io.FileWriter;
import java.io.IOException;

public class escribirArchivo implements Guardar{
	private FileWriter fw ;
	private String entrada = "";
	
	private void guardarTablaSimbolos() throws IOException { 
		this.fw.write(this.getEntrada()); 
	}
	
	private void setEntrada(String entrada) { this.entrada = entrada; }
	private void resetEntrada() {this.entrada = ""; }
	private String getEntrada() {return this.entrada; }
	
	public escribirArchivo() throws IOException { 
		this.fw = new FileWriter("ts.txt",true);
	
		
		}
	
	public void cerrarModulo() throws IOException {
		this.fw.close(); //TODO: cuidado! en futura implementacion podria dañar el funcionamiento.
	}

	@Override
	public void guardarID(String Lexema, String Token) throws IOException {
		this.resetEntrada(); //reseto, primero el flujo de datos previo.
		this.setEntrada("NOMBRE: "+Lexema+" | TOKEN: "+Token+ " | TIPO:  - | VALOR: - | LONGITUD: - \n"); //preparo el formato de la salida datos al archivo
		System.out.println(this.getEntrada());
		this.guardarTablaSimbolos(); //invoco a esta funcion que genera una nueva entrada en el archivo.
	}

	@Override
	public void guardarCTEString(String Lexema, String Token) throws IOException{
		this.resetEntrada();
		this.setEntrada("NOMBRE: _"+Lexema+" | TOKEN: "+Token+ " | TIPO:  - | VALOR: - | LONGITUD: "+(Lexema.length()-2)+"\n");
		System.out.println(this.getEntrada());
		this.guardarTablaSimbolos();
	}

	@Override
	public void guardarCTEChar(String Lexema, String Token) throws IOException {
		this.resetEntrada(); 
		this.setEntrada("NOMBRE: _"+Lexema+" | TOKEN: "+Token+ " | TIPO:  - | VALOR: "+Lexema+" | LONGITUD: "+(Lexema.length()-2)+"\n");
		System.out.println(this.getEntrada());
		this.guardarTablaSimbolos();
	}

	@Override
	public void guardarCTEEntera(String Lexema, String Token) throws IOException {
		this.resetEntrada();
		this.setEntrada("NOMBRE: _"+Lexema+" | TOKEN: "+Token+ " | TIPO:  - | VALOR: "+Lexema+" | LONGITUD: - \n");
		System.out.println(this.getEntrada());
		this.guardarTablaSimbolos();
	}

	@Override
	public void guardarCTEFloat(String Lexema, String Token) throws IOException {
		this.resetEntrada();
		this.setEntrada("NOMBRE: _"+Lexema+" | TOKEN: "+Token+ " | TIPO:  - | VALOR: "+Lexema+" | LONGITUD: - \n");
		System.out.println(this.getEntrada());
		this.guardarTablaSimbolos();
	}
}
