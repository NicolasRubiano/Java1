package practica1;
import java.awt.GridLayout;

import javax.swing.*;

public class MarcoDialogos extends JFrame{
private LaminaBotones lamina_tipo;
	public MarcoDialogos() {
		setTitle("Prueba de diálogos");
		setBounds(500,200,600,450);
		JPanel lamina_cuadricula=new JPanel();//Agregar lamina tipo float
		lamina_cuadricula.setLayout(new GridLayout(2,3));//Cambiar lamina a tipo gridLayout
		add(lamina_cuadricula);//Mostrar lamina
		String primero[]= {"Mensaje5", "Confirmar","Opción","Entrada"};
		lamina_tipo=new LaminaBotones("Tipo", primero);
		lamina_cuadricula.add(lamina_tipo);
		add(lamina_cuadricula);
		}
	
	
	
	
}
