package practica1;

import javax.swing.*;


public class LaminaBotones extends JPanel {
	ButtonGroup grupo= new ButtonGroup();
	
	public LaminaBotones(String titulo,String[] opciones ) {
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),titulo));
		//setBorder es de la clase JPanel, BorderFacory Crea borde con titulo
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		//Es tipo caja y el intorior esta distribuido verticalmente
		 grupo= new ButtonGroup();
		for(int i=0;i<opciones.length;i++) {
			JRadioButton bot =new JRadioButton(opciones[i]);// Crea radio button envia texto
			bot.setActionCommand(opciones[i]);//Establece la accion de comando 
			add(bot);//agrega radio buttonj
			grupo.add(bot);//lo mete al ButtonGroup
		bot.setSelected(i==0);//aparece el primero seleccionado es tipo boolean
		}
	}

	
	public String dameSeleccion() {
		ButtonModel miboton =grupo.getSelection();//Se encuentra el radiobutton seleccionado
		String s =miboton.getActionCommand();
		return s;
	
	}

	
	
}
