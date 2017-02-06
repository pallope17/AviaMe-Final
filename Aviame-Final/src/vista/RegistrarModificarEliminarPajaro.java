package vista;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.VetoableChangeListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegistrarModificarEliminarPajaro extends JFrame implements ActionListener{
private JPanel panel;
private JButton registrarPajaro, modificarPajaro, 
eliminarPajaro;
JLabel imagenLabel;
public RegistrarModificarEliminarPajaro(){
iniciarGUI();
}
public void iniciarGUI(){
panel= new JPanel();
panel.setLayout(null);
registrarPajaro = new JButton("Registrar Pajaro");
registrarPajaro.addActionListener(this);
modificarPajaro = new JButton("Modificar Pajaro");
modificarPajaro.addActionListener(this);
eliminarPajaro = new JButton("Eliminar Pajaro");
eliminarPajaro.addActionListener(this);
//PONER IMAGEN
imagenLabel = new JLabel();

imagenLabel.setBounds(80, 20, 300, 240);


//LLAMA AL METODO
//ponerImagen();
registrarPajaro.setBounds(100,270,260,40);
modificarPajaro.setBounds(100,320,260,40);
eliminarPajaro.setBounds(100,370,260,40);
panel.add(registrarPajaro);
panel.add(modificarPajaro);
panel.add(eliminarPajaro);
add(panel);
//PROPIEDADES PANEL
setSize(460,560);
setVisible(true);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setTitle("Registar/Modificar/Eliminar Pajaro");
}

@Override
public void actionPerformed(ActionEvent arg0) {
// TODO Auto-generated method stub
}

public  void ponerImagen(){
	/*String rutaImagen="imagen1.jpg";
	URL url= getClass().getResource(rutaImagen);
	ImageIcon imagen= new  ImageIcon(url);*/
	
	ImageIcon imagen= new  ImageIcon("imagen1.jpg");
	Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_DEFAULT));
	imagenLabel.setIcon(icono);
	this.repaint();
	
}
}
