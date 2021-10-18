package analizador;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class principal {

    public static void main(String[] args) throws IOException {
        try {
            // TODO code application logic here
            FileReader f = new FileReader("C:/Users/Intel/Desktop/prueba.txt");
            Lexico Lexer = new Lexico(f);
            Lexer.next_token();
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo");
        }
        
    }
    
}
