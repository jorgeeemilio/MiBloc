package es.studium.MiBloc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
			modeloFichero.cargarFichero(vistaFichero);
		}
		else if(evento.getSource().equals(vistaFichero.btnGuardar))
		{
			modeloFichero.guardarFichero(vistaFichero);
		}
	}
}
