package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.AsignaturaController;
import controller.AsignaturaPorDocenteController;
import controller.DocenteController;
import model.Asignatura;
import model.Asignaturaspordocente;
import model.Docente;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnFiltrar;
	private JTextField jtf;
	private static JComboBox<Docente> jcbDocentes;
	private JButton btnCargarMaterias;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JScrollPane noScrollPane;
	private JScrollPane siScrollPane;
	private JButton btnGuardar;
	private JPanel panel_2;
	private JButton btnTodoDerecha;
	private JButton btnDerecha;
	private JButton btnIzquierda;
	private JButton btnTodoIzquierda;
	private DefaultListModel<Asignatura> nolistModel = null;
	private JList noList;
	private DefaultListModel<Asignatura> siListModel = null;
	private JList siList;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0 };
		gbl_contentPane.columnWeights = new double[] { 1.0 };
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		lblNewLabel = new JLabel("Docentes y asignaturas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0 };
//		gbl_panel.columnWidths = new int[]{0};
//		gbl_panel.rowHeights = new int[]{0};
//		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		jtf = new JTextField();
		GridBagConstraints gbc_jtf = new GridBagConstraints();
		gbc_jtf.gridwidth = 8;
		gbc_jtf.insets = new Insets(50, 0, 5, 5);
		gbc_jtf.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf.gridx = 0;
		gbc_jtf.gridy = 0;
		panel.add(jtf, gbc_jtf);
		jtf.setColumns(10);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrar();
			}
		});
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 25);
		gbc_btnFiltrar.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnFiltrar.gridx = 9;
		gbc_btnFiltrar.gridy = 0;
		panel.add(btnFiltrar, gbc_btnFiltrar);

		jcbDocentes = new JComboBox();
		GridBagConstraints gbc_jcbDocentes = new GridBagConstraints();
		gbc_jcbDocentes.gridwidth = 8;
		gbc_jcbDocentes.insets = new Insets(0, 0, 5, 5);
		gbc_jcbDocentes.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbDocentes.gridx = 0;
		gbc_jcbDocentes.gridy = 1;
		panel.add(jcbDocentes, gbc_jcbDocentes);

		btnCargarMaterias = new JButton("Cargar Materias");
		btnCargarMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMaterias();
			}
		});
		GridBagConstraints gbc_btnCargarMaterias = new GridBagConstraints();
		gbc_btnCargarMaterias.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargarMaterias.gridx = 9;
		gbc_btnCargarMaterias.gridy = 1;
		panel.add(btnCargarMaterias, gbc_btnCargarMaterias);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 10;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0 };
//		gbl_panel_1.columnWidths = new int[]{0};
//		gbl_panel_1.rowHeights = new int[]{0};
//		gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		lblNewLabel_1 = new JLabel("Asignaturas no Seleccionadas");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Asignaturas Seleccionadas");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		noList = new JList(this.getDefaultListModel());
		noList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		siList = new JList(this.getDefaultListModel2());
		siList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		noScrollPane = new JScrollPane(noList);
		GridBagConstraints gbc_NoScrollPane = new GridBagConstraints();
		gbc_NoScrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_NoScrollPane.fill = GridBagConstraints.BOTH;
		gbc_NoScrollPane.gridx = 0;
		gbc_NoScrollPane.gridy = 1;
		panel_1.add(noScrollPane, gbc_NoScrollPane);

		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 3;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
//		gbl_panel_2.columnWidths = new int[]{0};
//		gbl_panel_2.rowHeights = new int[]{0};
//		gbl_panel_2.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_panel_2.rowWeights = new double[]{Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);

		btnTodoDerecha = new JButton(">>");
		btnTodoDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTodoSi();
			}
		});
		GridBagConstraints gbc_btnTodoDerecha = new GridBagConstraints();
		gbc_btnTodoDerecha.insets = new Insets(0, 0, 5, 0);
		gbc_btnTodoDerecha.gridx = 1;
		gbc_btnTodoDerecha.gridy = 1;
		panel_2.add(btnTodoDerecha, gbc_btnTodoDerecha);

		btnDerecha = new JButton(">");
		btnDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarSeleccionadosSi();
			}
		});
		GridBagConstraints gbc_btnDerecha = new GridBagConstraints();
		gbc_btnDerecha.insets = new Insets(0, 0, 5, 0);
		gbc_btnDerecha.gridx = 1;
		gbc_btnDerecha.gridy = 2;
		panel_2.add(btnDerecha, gbc_btnDerecha);

		btnIzquierda = new JButton("<");
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarSeleccionadosNo();
			}
		});
		GridBagConstraints gbc_btnIzquierda = new GridBagConstraints();
		gbc_btnIzquierda.insets = new Insets(0, 0, 5, 0);
		gbc_btnIzquierda.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnIzquierda.gridx = 1;
		gbc_btnIzquierda.gridy = 3;
		panel_2.add(btnIzquierda, gbc_btnIzquierda);

		btnTodoIzquierda = new JButton("<<");
		btnTodoIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarTodoNo();
			}
		});
		GridBagConstraints gbc_btnTodoIzquierda = new GridBagConstraints();
		gbc_btnTodoIzquierda.insets = new Insets(0, 0, 20, 0);
		gbc_btnTodoIzquierda.anchor = GridBagConstraints.NORTH;
		gbc_btnTodoIzquierda.gridx = 1;
		gbc_btnTodoIzquierda.gridy = 4;
		panel_2.add(btnTodoIzquierda, gbc_btnTodoIzquierda);

		siScrollPane = new JScrollPane(siList);
		GridBagConstraints gbc_SiScrollPane = new GridBagConstraints();
		gbc_SiScrollPane.fill = GridBagConstraints.BOTH;
		gbc_SiScrollPane.gridx = 4;
		gbc_SiScrollPane.gridy = 1;
		panel_1.add(siScrollPane, gbc_SiScrollPane);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 2;
		contentPane.add(btnGuardar, gbc_btnGuardar);

	}
	
	public void guardar() {
		AsignaturaPorDocenteController.delete(AsignaturaPorDocenteController.findByDocente((Docente) jcbDocentes.getSelectedItem()));
		List<Asignatura> list = new ArrayList();
		
		for (int j = 0; j < siListModel.getSize(); j++) {
			list.add(siListModel.getElementAt(j));
		}
		for (Asignatura a : list) {
			Asignaturaspordocente asig = new Asignaturaspordocente();
			asig.setDocente((Docente) jcbDocentes.getSelectedItem());
			asig.setAsignatura(a);
			AsignaturaPorDocenteController.insert(asig);
		}
		filtrar();
	
		
	}

	private DefaultListModel getDefaultListModel2() {
		this.siListModel = new DefaultListModel<Asignatura>();
		return this.siListModel;
	}

	private DefaultListModel getDefaultListModel() {
		this.nolistModel = new DefaultListModel<Asignatura>();
		return this.nolistModel;
	}

	public void filtrar() {
		jcbDocentes.removeAllItems();
		for (Docente iterable_element : DocenteController.findByDesc(jtf.getText())) {
			jcbDocentes.addItem(iterable_element);
		}

	}

	public void cargarMaterias() {
		List<Asignatura> aNo = AsignaturaController.findAll();
		siListModel.removeAllElements();
		nolistModel.removeAllElements();
		Docente d = (Docente) jcbDocentes.getSelectedItem();
		List<Asignaturaspordocente> ad = d.getAsignaturaspordocentes();
		List<Asignatura> a = new ArrayList();
		for (Asignaturaspordocente asignaturaspordocente : ad) {
			a.add(asignaturaspordocente.getAsignatura());
		}
		siListModel.addAll(a);
		aNo.removeAll(a);
		nolistModel.addAll(aNo);
	}
	private void cambiarSeleccionadosSi() {
		this.siListModel.addAll(noList.getSelectedValuesList());
		for (int i = this.noList.getSelectedIndices().length - 1; i >= 0; i--) {
			this.nolistModel.removeElementAt(this.noList.getSelectedIndices()[i]);
		}
	}

	private void cambiarSeleccionadosNo() {
		this.nolistModel.addAll(siList.getSelectedValuesList());
		for (int i = this.siList.getSelectedIndices().length - 1; i >= 0; i--) {
			this.siListModel.removeElementAt(this.siList.getSelectedIndices()[i]);
		}
	}

	private void cambiarTodoNo() {
		List<Asignatura> aNo = AsignaturaController.findAll();
		nolistModel.removeAllElements();
		siListModel.removeAllElements();
		nolistModel.addAll(aNo);
	}

	private void cambiarTodoSi() {
		List<Asignatura> aNo = AsignaturaController.findAll();
		nolistModel.removeAllElements();
		siListModel.removeAllElements();
		siListModel.addAll(aNo);

	}
}
