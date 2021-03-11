package es.studium.MiBloc;

public class MiBloc
{
	public static void main(String[] args)
	{
		VistaFichero vistaFichero = new VistaFichero();
		ModeloFichero modeloFichero = new ModeloFichero();
		new ControladorFichero(vistaFichero, modeloFichero);
	}
}