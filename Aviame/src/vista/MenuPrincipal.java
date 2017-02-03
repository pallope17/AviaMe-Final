package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPrincipal extends JFrame implements ActionListener {
private JPanel panel;
private JButton accionesPajaros, verEnfermedadesSintomas, 
verMedicamentosAdministracion, ponerEnfermedadSintomas, 
ponerMedicamentoAdministracion;
public MenuPrincipal() {
iniciarGUI();
}
public void iniciarGUI(){
panel= new JPanel();
panel.setLayout(null);
accionesPajaros= new JButton("Registar/Elimiar/Modificar Pajaro");
accionesPajaros.addActionListener(this);
verEnfermedadesSintomas =  new JButton("Ver Enfermedades y Sintomas");
verEnfermedadesSintomas.addActionListener(this);
verMedicamentosAdministracion = new JButton("Ver Medicamentos y Administracion");
verMedicamentosAdministracion.addActionListener(this);
ponerEnfermedadSintomas = new JButton("Poner Enfermedades y Sintomas");
ponerEnfermedadSintomas.addActionListener(this);
ponerMedicamentoAdministracion = new JButton("Poner Medicamentos y Administracion");
ponerMedicamentoAdministracion.addActionListener(this);
//SetBounds
accionesPajaros.setBounds(40,20,100,20);
accionesPajaros.setBounds(60,40,120,40);
accionesPajaros.setBounds(80,60,140,60);
accionesPajaros.setBounds(100,80,160,80);
//AÑADIR AL PANEL
panel.add(accionesPajaros);
panel.add(verEnfermedadesSintomas);
panel.add(verMedicamentosAdministracion);
panel.add(verEnfermedadesSintomas);
panel.add(ponerMedicamentoAdministracion);
//AÑADIR PANEL
add(panel);
//PROPIEDADES PANEL
pack();
setSize(300,160);
setVisible(true);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setTitle("Bienvenido a Aviame");
}

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
}

}