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
	Dialog dlgMensajes = new Dialog(ventana, "Mensaje", true);
	TextField txtNombreFichero = new TextField(20);
	Button btnCargar = new Button("Cargar");
	Button btnGuardar = new Button("Guardar");
	TextArea txaTexto = new TextArea(15,30);
	Label lblMensaje = new Label("Archivo no Encontrado");
	
	public VistaFichero()
	{
		ventana.setLayout(new FlowLayout());
		
		ventana.add(txtNombreFichero);
		ventana.add(btnCargar);
		ventana.add(btnGuardar);
		ventana.add(txaTexto);
		
		ventana.setSize(240,370);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		dlgMensajes.setLayout(new FlowLayout());
		dlgMensajes.setSize(180,100);
		dlgMensajes.setResizable(false);
		dlgMensajes.setLocationRelativeTo(null);
		dlgMensajes.add(lblMensaje);
		
	}
}
