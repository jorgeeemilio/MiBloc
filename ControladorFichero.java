package es.studium.MiBloc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ControladorFichero implements ActionListener, WindowListener
{
	VistaFichero vistaFichero;
	ModeloFichero modeloFichero;

	public ControladorFichero(VistaFichero vf, ModeloFichero mf)
	{
		vistaFichero = vf;
		modeloFichero = mf;

		vistaFichero.ventana.addWindowListener(this);
		vistaFichero.btnCargar.addActionListener(this);
		vistaFichero.btnGuardar.addActionListener(this);
		vistaFichero.dlgMensajes.addWindowListener(this);
	}

	@Override
	public void windowActivated(WindowEvent arg0){}

	@Override
	public void windowClosed(WindowEvent arg0){}

	@Override
	public void windowClosing(WindowEvent arg0)
	{
		if(vistaFichero.dlgMensajes.isActive())
		{
			vistaFichero.dlgMensajes.setVisible(false);
		}
		else
		{
			System.exit(0);
		}
	}

	@Override
	public void windowDeactivated(WindowEvent arg0){}

	@Override
	public void windowDeiconified(WindowEvent arg0){}

	@Override
	public void windowIconified(WindowEvent arg0){}

	@Override
	public void windowOpened(WindowEvent arg0){}

	@Override
	public void actionPerformed(ActionEvent evento)
	{
		if(evento.getSource().equals(vistaFichero.btnCargar))
		{
			//Como usaremos FileReader y puede lanzar una excepción
			//necesitaremos un bloque try – catch
			try
			{
				//Origen de los datos en el proyecto anterior
				FileReader fr = new FileReader(vistaFichero.txtNombreFichero.getText());
				//Buffer de lectura
				BufferedReader entrada = new BufferedReader(fr);
				String s;
				vistaFichero.txaTexto.selectAll();
				vistaFichero.txaTexto.setText("");
				//Bucle para sacar la información del archivo
				while((s=entrada.readLine())!=null)
				{
					vistaFichero.txaTexto.append(s);
					vistaFichero.txaTexto.append("\n");
				}
				//Cerrar el objeto entrada
				entrada.close();
				fr.close();
				vistaFichero.lblMensaje.setText("Archivo leído");
			}
			catch(FileNotFoundException e)
			{
				vistaFichero.lblMensaje.setText("Archivo NO encontrado");
			}
			catch(IOException i)
			{
				vistaFichero.lblMensaje.setText("Se produjo un error de Archivo");
			}
			finally
			{
				vistaFichero.dlgMensajes.setVisible(true);
			}
		}
		else if(evento.getSource().equals(vistaFichero.btnGuardar))
		{
			//FileWriter también puede lanzar una excepción
			try
			{
				// Destino de los datos
				FileWriter fw = new FileWriter(vistaFichero.txtNombreFichero.getText());
				// Buffer de escritura
				BufferedWriter bw = new BufferedWriter(fw);
				// Objeto para la escritura
				PrintWriter salida = new PrintWriter(bw);
				//Guardamos la primera línea
				salida.println(vistaFichero.txaTexto.getText());
				//Cerrar el objeto salida, el objeto bw y el fw
				salida.close();
				bw.close();
				fw.close();
				vistaFichero.lblMensaje.setText("¡Archivo creado correctamente!");
			}
			catch(IOException i)
			{
				vistaFichero.lblMensaje.setText("Se produjo un error de Archivo");
			}
			finally
			{
				vistaFichero.dlgMensajes.setVisible(true);
			}
		}
	}
}
