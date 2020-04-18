package practica1;

import javax.swing.*;


public class LaminaBotones extends JPanel {
	ButtonGroup grupo= new ButtonGroup();//Crea un grupo de botones
	//-------Constructor-----------
	public LaminaBotones(String titulo,String[] opciones ) {//dos parametros el titulo del box y array de los titulos de los botones
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),titulo));	//setBorder es de la clase JPanel, BorderFacory Crea borde con titulo
			
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));//alinea los box en el eje y
		//Es tipo caja y el intorior esta distribuido verticalmente
		 grupo= new ButtonGroup();
		 
		 //CREA LOS BOTONES EN CADA UNO DE LOS GRUPOSDE RADIO BUTONS
		for(int i=0;i<opciones.length;i++) {
			JRadioButton bot =new JRadioButton(opciones[i]);// Crea radio button envia texto
			bot.setActionCommand(opciones[i]);//Establece la accion de comando  para leer cual esat seleccionado
			add(bot);//agrega radio buttonj
			grupo.add(bot);//lo mete al ButtonGroup
		bot.setSelected(i==0);//aparece el primero seleccionado es tipo boolean por defecto
		}
	}

	//-------Funcion devuelve el boton seleccionado
	public String dameSeleccion() {
		ButtonModel miboton =grupo.getSelection();//Se encuentra el radiobutton seleccionado
		String s =miboton.getActionCommand();
		return s;
	
	}

	
	
}
