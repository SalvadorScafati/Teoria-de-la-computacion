package analizador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.*;

public class vista {
	private JFrame frame;
	private  JScrollPane scrollInput;
	private  JTextArea textAreaInput;
	private  JTextArea textAreaOutput;
	private  JScrollPane scrollOutput;
	private  JButton cargarB;
	private  JButton analizarB;
	
	public void mostrar(String s) {
		this.textAreaOutput.setText(this.textAreaOutput.getText()+"\n"+s);
	}
	
	public void crearTextAreaInput()  
	{  
	  this.textAreaInput=new JTextArea();  
	  this.scrollInput = new JScrollPane (textAreaInput, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	  scrollInput.setBounds(20,30,500,250);
	  this.frame.add(scrollInput);  
	
	
	}
	
	public void crearTextAreaOutput()  
	{  
	  this.textAreaOutput=new JTextArea();  
	  this.textAreaOutput.setEditable(false);
	  this.scrollOutput = new JScrollPane (textAreaOutput, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	  scrollOutput.setBounds(20,300,500,250);
	  this.frame.add(scrollOutput);  
	  //JPanel test = new JPanel();
	
	}
	
	public void crearBoton() {
		this.cargarB=new JButton("Cargar Input al archivo");
		cargarB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargar();
            }
        });
		cargarB.setBounds(580,30, 200,250);
		this.frame.add(cargarB);
		this.analizarB=new JButton("Analizar");
		analizarB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                analizar();
            }
        });
		analizarB.setBounds(580,280, 200,250);
		this.frame.add(analizarB);
	}
	private void cargar() {
		try {
		    
		      FileWriter myWriter = new FileWriter("codigo.txt");
		      myWriter.write(this.textAreaInput.getText());
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	
	}
	
	
	
	private void analizar() {
	      try {
	    	  String text = ""; try { text = new String(Files.readAllBytes(Paths.get("codigo.txt")));
				this.textAreaInput.setText(text);} 
				catch (IOException e) { e.printStackTrace(); }
	    	  	this.textAreaOutput.setText("");
				FileReader f = new FileReader("codigo.txt");
				Lexico Lexer = new Lexico(f);
				Lexer.setVista(this);
				Lexer.setescribirArchivo(new escribirArchivo());
				Lexer.next_token();	 
				
				
				
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}
	
	
	public void iniciar() {
		this.frame=new JFrame();
	    JLabel l1,l2;  
	    l1=new JLabel("Ingresar codigo:");  
	    l1.setBounds(20,5, 100,30); 
	    l2=new JLabel("Salida:");  
	    l2.setBounds(20,275, 100,30); 
	    this.frame.add(l1);
	    this.frame.add(l2);
		frame.setSize(800,600);
		crearBoton();
		crearTextAreaInput();
		crearTextAreaOutput();
		frame.setLayout(null);  
		frame.setVisible(true);
	}	
	

	

	
	
	
}
