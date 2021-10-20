package analizador;

import java.io.IOException;

public interface Guardar{
	/**
	 * Recibe un lexema y su token. Arma una entrada en la tabla de simbolos.
	 * @param Lexema
	 * @param Token
	 */
	public void guardarID (String Lexema,String Token) throws IOException;
	/**
	 * Recibe un lexema y su token. Arma una entrada en la tabla de simbolos.
	 * Debe contar el largo del string y almacenarlo.
	 * @param Lexema
	 * @param Token
	 */
	public void guardarCTEString (String Lexema,String Token) throws IOException;
	/**
	 * Recibe un lexema y su token. Arma una entrada en la tabla de simbolos.
	 * @param Lexema
	 * @param Token
	 */
	public void guardarCTEChar (String Lexema, String Token) throws IOException;
	/**
	 * Recibe un lexema y su token. Arma una entrada en la tabla de simbolos.
	 * @param Lexema
	 * @param Token
	 */
	public void guardarCTEEntera (String Lexema, String Token) throws IOException;
	/**
	 * Recibe un lexema y su nombre. Arma una entrada en la tabla de simbolos.
	 * @param Lexema
	 * @param Token
	 */
	public void guardarCTEFloat (String Lexema, String Token) throws IOException;
}
