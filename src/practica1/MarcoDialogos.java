package practica1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MarcoDialogos extends JFrame{
private LaminaBotones lamina_tipo,lamina_tipo_mensajes,lamina_mensaje,lamina_tipo_opcion,lamina_opciones,lamina_botones;
	public MarcoDialogos() {
		setTitle("Prueba de diálogos");
		setBounds(500,200,600,450);
		JPanel lamina_cuadricula=new JPanel();//Agregar lamina tipo float
		lamina_cuadricula.setLayout(new GridLayout(2,3));//Cambiar lamina a tipo gridLayout
		add(lamina_cuadricula);//Mostrar lamina
		String primero[]= {"Mensaje", "Confirmar","Opción","Entrada"};
		lamina_tipo=new LaminaBotones("Tipo", primero);
		lamina_tipo_mensajes=new LaminaBotones("Tipo de Mensaje",new String[]{"ERROR_MESSAGE", "INFORMATION_MESSAGE","WARNING_MESSAGE","QUESTION_MESSAGE","PLAIN__MESSAGE"});
		lamina_mensaje=new LaminaBotones("Mensaje",new String[]{"Cadena", "Icono","Component","Otros","Object[]"});
		lamina_tipo_opcion=new LaminaBotones("Confirmar",new String[]{"default_option", "Yes_No_option","Yes_No_Cancel","OK_Cancel"});
		lamina_opciones=new LaminaBotones("Opcion",new String[]{"String[]","Icon[]","Object[]"});
		lamina_botones=new LaminaBotones("Entrada",new String[]{"Campo texto","ComboBox"});
		setLayout(new BorderLayout());
		lamina_cuadricula.add(lamina_tipo);
		lamina_cuadricula.add(lamina_tipo_mensajes);
		lamina_cuadricula.add(lamina_mensaje);
		lamina_cuadricula.add(lamina_tipo_opcion);
		lamina_cuadricula.add(lamina_opciones);
		lamina_cuadricula.add(lamina_botones);
		
		//Constuimos la lamina inferior del botonn
		JPanel lamina_mostrar=new JPanel();
		JButton boton_mostrar=new JButton("Mostrar");
		boton_mostrar.addActionListener(new AccionMostrar());
		lamina_mostrar.add(boton_mostrar);
		add(lamina_mostrar, BorderLayout.SOUTH);
		add(lamina_cuadricula,BorderLayout.CENTER);
		
		}
	
	
	private class AccionMostrar implements ActionListener{
//ACCIOMN BOTON MOSTRAR
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(lamina_tipo_mensajes.dameSeleccion());
		}
		
	}
	
}
