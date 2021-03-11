package es.studium.MiBloc;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class VistaFichero
{
	Frame ventana = new Frame("MiBloc");
	Dialog mensajes = new Dialog(ventana, "Mensaje", true);
	TextField nombreFichero = new TextField(20);
	Button btnCargar = new Button("Cargar");
	Button btnGuardar = new Button("Guardar");
	TextArea txaTexto = new TextArea(15,30);
	Label lblMensaje = new Label("Archivo no Encontrado");
	
	public VistaFichero()
	{
		ventana.setLayout(new FlowLayout());
		
		ventana.add(nombreFichero);
		ventana.add(btnCargar);
		ventana.add(btnGuardar);
		ventana.add(txaTexto);
		
		ventana.setSize(240,370);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		mensajes.setLayout(new FlowLayout());
		mensajes.setSize(180,100);
		mensajes.setResizable(false);
		mensajes.setLocationRelativeTo(null);
		mensajes.add(lblMensaje);
		
	}
}
