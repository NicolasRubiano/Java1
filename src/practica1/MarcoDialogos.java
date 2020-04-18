package practica1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.*;

public class MarcoDialogos extends JFrame{
	//------------Variables---------
private LaminaBotones lamina_tipo,lamina_tipo_mensajes,lamina_mensaje,lamina_tipo_opcion,lamina_opciones,lamina_entrada;
private String cadenaMensaje="Mensaje";
private Icon iconoMensaje=new ImageIcon("src/practica1/icono.gif");
private Object objetoMensaje=new Date();
private Component  componenteMensaje=new JButton();

//------------------Constructor----------------------------------
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
		lamina_entrada=new LaminaBotones("Entrada",new String[]{"Campo texto","ComboBox"});
		setLayout(new BorderLayout());
		lamina_cuadricula.add(lamina_tipo);
		lamina_cuadricula.add(lamina_tipo_mensajes);
		lamina_cuadricula.add(lamina_mensaje);
		lamina_cuadricula.add(lamina_tipo_opcion);
		lamina_cuadricula.add(lamina_opciones);
		lamina_cuadricula.add(lamina_entrada);
		
		//Constuimos la lamina inferior del botonn
		JPanel lamina_mostrar=new JPanel();
		JButton boton_mostrar=new JButton("Mostrar");
		boton_mostrar.addActionListener(new AccionMostrar());
		lamina_mostrar.add(boton_mostrar);
		add(lamina_mostrar, BorderLayout.SOUTH);
		add(lamina_cuadricula,BorderLayout.CENTER);
		
		}

//-----------------CLASE INTERNA GESTIONA BOTON MOSTRAR--------------------
private class AccionMostrar implements ActionListener{
//ACCIOMN BOTON MOSTRAR
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(lamina_tipo.dameSeleccion());
			if(lamina_tipo.dameSeleccion().equals("Mensaje")) {
				JOptionPane.showMessageDialog(MarcoDialogos.this, dameMensaje(),"Titulo",dameTipo(lamina_tipo_mensajes));
			}
			
			else if(lamina_tipo.dameSeleccion().equals("Confirmar")) {
				JOptionPane.showConfirmDialog(MarcoDialogos.this, dameMensaje(),"Titulo",dameTipo(lamina_tipo_opcion),dameTipo(lamina_tipo_mensajes));
			}
			
			else if (lamina_tipo.dameSeleccion().equals("Entrada")) {
				if(lamina_entrada.dameSeleccion().equals("Campo texto")) {
				JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(),"Titulo",dameTipo(lamina_tipo_mensajes));
				}else {
					JOptionPane.showInputDialog(MarcoDialogos.this, dameMensaje(),"Titulo",dameTipo(lamina_tipo_mensajes),null,new String[] {"Amarillo","Azul","Rojo"},"Azul");	
				}
				
				}
			
			else if (lamina_tipo.dameSeleccion().equals("Opción")) {
				JOptionPane.showOptionDialog(MarcoDialogos.this, dameMensaje(),"Titulo",1,dameTipo(lamina_tipo_mensajes),null,dameOpciones(lamina_opciones),null);
			}
		}
		
	}

	//-----------------------PROPORCIONA ERROR SELECCIONADO Y GESTIONA LAMINA CONFIRMAR CUARTA------------
public int dameTipo(LaminaBotones lamina) {
	String s=lamina.dameSeleccion();

	
	if(s.equals("ERROR_MESSAGE")||s.equals("Yes_No_option")) {
		return 	0;
	}
	
	else if(s.contentEquals("INFORMATION_MESSAGE")||s.equals("Yes_No_Cancel")) {
		return 1;
	}
	
	else if(s.contentEquals("WARNING_MESSAGE")||s.equals("OK_Cancel")) {
		return 2;
	}

	else if(s.contentEquals("QUESTION_MESSAGE")) {
		return 3;
	}

		
	else if(s.contentEquals("PLAIN__MESSAGE")|| s.equals("default_option")) {
		return 	-1;
	}	
	
	else {
		return -1;
	}
	
}



	//------------------------------ PROPORCIONA EL MENSAJE---------------

	public Object dameMensaje() {
		String  s=lamina_mensaje.dameSeleccion();
		if(s.equals("Cadena")) {
			return cadenaMensaje; 
		}
		
		else if(s.equals("Icono")) {
			return iconoMensaje;
		}
		
		
		else if (s.equals("Component")) {
			return componenteMensaje;
			
		}
		
		else if(s.equals("Otros")) {
			return objetoMensaje;
		}
		
		else if (s.equals("Object[]")) {
			
			return new Object[] {cadenaMensaje,iconoMensaje,componenteMensaje,objetoMensaje};
		}
		
		else {
			return null;
		}
		
		
	}

//---------- DA OPCIONES A LA LAMINA OPCION--------------
	public Object[] dameOpciones(LaminaBotones lamina) {
		String  s=lamina_opciones.dameSeleccion();
		
	
	
		if(s.equals("String[]")) {
			return new String[] {"Amarillo","Azul","Rojo"}; 
		}
		
		else if(s.equals("Icon[]")) {
			return new Object[] {new ImageIcon("src/practica1/icono.gif"),new ImageIcon("src/practica1/icono2.gif"),new ImageIcon("src/practica1/icono3.gif")};
		}
		
		
		else if (s.equals("Object[]")) {
			return new Object[] {cadenaMensaje,iconoMensaje,componenteMensaje,objetoMensaje};
			
		}
		
		
		
		else {
			return null;
		}
	}
//------------------
	
	
	
}


