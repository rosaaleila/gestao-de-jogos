package br.senai.sp.jandira.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import br.senai.sp.jandira.model.Fabricantes;
import br.senai.sp.jandira.repository.FabricanteRepository;

public class FrameFabricantes extends JFrame {
	private FabricanteRepository fabricantes;
	private int posicao = 0;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSede;
	private JTextField txtFundador;

	public FrameFabricantes() { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(10, 11, 414, 239);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblNome = new JLabel(" Nome");
		lblNome.setBounds(10, 16, 46, 14);
		panelPrincipal.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(66, 13, 86, 20);
		txtNome.setColumns(10);
		panelPrincipal.add(txtNome);
		
		JLabel lblSede = new JLabel(" Sede");
		lblSede.setBounds(10, 44, 46, 14);
		panelPrincipal.add(lblSede);
		
		txtSede = new JTextField();
		txtSede.setBounds(66, 41, 86, 20);
		txtSede.setColumns(10);
		panelPrincipal.add(txtSede);
		
		JLabel lblFundadores = new JLabel("Fundador");
		lblFundadores.setBounds(10, 72, 58, 14);
		panelPrincipal.add(lblFundadores);
		
		txtFundador = new JTextField();
		txtFundador.setBounds(66, 69, 86, 20);
		txtFundador.setColumns(10);
		panelPrincipal.add(txtFundador);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(243, 13, 165, 35);
		panelPrincipal.add(btnSalvar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(243, 51, 165, 35);
		panelPrincipal.add(btnDeletar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 394, 132);
		panelPrincipal.add(scrollPane);
		
		DefaultListModel<String> modelFabricantes = new DefaultListModel<String>();
		
		JList<String> listFabricantes = new JList<String>();
		listFabricantes.setModel(modelFabricantes);
		scrollPane.setViewportView(listFabricantes);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					Fabricantes novoFabricante = new Fabricantes();
					novoFabricante.setNome(txtNome.getText());
					novoFabricante.setSede(txtSede.getText());
					novoFabricante.setFundador(txtFundador.getText());
					
					fabricantes.gravar(novoFabricante, posicao);
					posicao++;
					
					modelFabricantes.addElement(novoFabricante.getNome());
			}
		});
		
		btnDeletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (listFabricantes.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Você deve selecionar um item da lista!", "Presta atenção...!", JOptionPane.WARNING_MESSAGE);
				} else {
					modelFabricantes.removeRange(listFabricantes.getMinSelectionIndex(), listFabricantes.getMaxSelectionIndex());
					for (int contador = listFabricantes.getMinSelectionIndex(); contador < listFabricantes.getMaxSelectionIndex(); contador++) {
						fabricantes.deletarFabricante(contador);
					}
				}
			}
		});
	}
}
