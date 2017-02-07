package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ActualizaPajaro extends JFrame implements TableModelListener , MouseListener, ActionListener{
	
	private ModeloTablaActualizar miModelo;
	private JTable tablaPajaros;
	
	 public ActualizaPajaro() {
		iniciarGUI();
	}
	
	public void iniciarGUI(){
		
		try {
			miModelo= new ModeloTablaActualizar();
			tablaPajaros= new JTable(miModelo);
			
			tablaPajaros.getModel().addTableModelListener(this);
			
			tablaPajaros.addMouseListener(this);
			tablaPajaros.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			tablaPajaros.setPreferredScrollableViewportSize(new Dimension(500, 100));
			JScrollPane scroll = new JScrollPane(tablaPajaros);
			add(scroll, BorderLayout.PAGE_END);
			
			
			pack();
			setSize(600,480);
			setLocationRelativeTo(null);
		
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
