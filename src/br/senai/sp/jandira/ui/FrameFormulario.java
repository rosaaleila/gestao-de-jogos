package br.senai.sp.jandira.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;

import br.senai.sp.jandira.enums.Consoles;
import br.senai.sp.jandira.enums.Fabricantes;
import br.senai.sp.jandira.model.Jogo;
import br.senai.sp.jandira.repository.JogoRepository;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class FrameFormulario extends JFrame {
	
	private JogoRepository colecao;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private final ButtonGroup buttonEstado = new ButtonGroup();
	private JTextField txtValor;
	private JComboBox<String> comboFabricante = new JComboBox<String>();
	private JComboBox<String> comboConsole = new JComboBox<String>();
	private DefaultListModel<String> modelJogos = new DefaultListModel<String>();
	private DefaultComboBoxModel<String> modelFabricante = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelConsole = new DefaultComboBoxModel<String>();
	private JTextField txtObs;

	public FrameFormulario() {
		setResizable(false);
		
		setTitle("Gest\u00E3o de Jogos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBackground(new Color(119, 136, 153));
		panelCadastro.setBounds(10, 11, 764, 200);
		contentPane.add(panelCadastro);
		panelCadastro.setLayout(null);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(10, 23, 77, 20);
		panelCadastro.add(lblTitulo);
		lblTitulo.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(97, 25, 241, 20);
		panelCadastro.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JRadioButton rdbtnZerado = new JRadioButton("Zerado");
		rdbtnZerado.setForeground(Color.WHITE);
		rdbtnZerado.setFont(new Font("SansSerif", Font.PLAIN, 15));
		rdbtnZerado.setBackground(new Color(119, 136, 153));
		buttonEstado.add(rdbtnZerado);
		rdbtnZerado.setBounds(10, 50, 77, 23);
		panelCadastro.add(rdbtnZerado);
		
		JRadioButton rdbtnAndamento = new JRadioButton("Em andamento");
		rdbtnAndamento.setFont(new Font("SansSerif", Font.PLAIN, 15));
		rdbtnAndamento.setForeground(Color.WHITE);
		rdbtnAndamento.setBackground(new Color(119, 136, 153));
		buttonEstado.add(rdbtnAndamento);
		rdbtnAndamento.setBounds(89, 50, 135, 23);
		panelCadastro.add(rdbtnAndamento);
		
		JRadioButton rdbtnNIniciado = new JRadioButton("N\u00E3o iniciado");
		rdbtnNIniciado.setFont(new Font("SansSerif", Font.PLAIN, 15));
		rdbtnNIniciado.setForeground(Color.WHITE);
		rdbtnNIniciado.setBackground(new Color(119, 136, 153));
		buttonEstado.add(rdbtnNIniciado);
		rdbtnNIniciado.setBounds(228, 50, 110, 23);
		panelCadastro.add(rdbtnNIniciado);
		
		JLabel lblFabricante = new JLabel("Fabricante");
		lblFabricante.setForeground(Color.WHITE);
		lblFabricante.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblFabricante.setBounds(10, 79, 77, 20);
		panelCadastro.add(lblFabricante);
		
		comboFabricante.setBounds(97, 80, 200, 22);
		panelCadastro.add(comboFabricante);
		salvarModelFabricante();
		comboFabricante.setModel(modelFabricante);
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setForeground(Color.WHITE);
		lblConsole.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblConsole.setBounds(10, 115, 77, 20);
		panelCadastro.add(lblConsole);
		
		comboConsole.setEnabled(false);
		comboConsole.setBounds(97, 113, 200, 22);
		panelCadastro.add(comboConsole);
		salvarModelConsole();
		comboConsole.setModel(modelConsole);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblValor.setBounds(10, 146, 50, 20);
		panelCadastro.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(97, 146, 100, 20);
		panelCadastro.add(txtValor);
		
		JRadioButton rdbtnGratis = new JRadioButton("Gratuito");
		rdbtnGratis.setBackground(new Color(119, 136, 153));
		rdbtnGratis.setBounds(212, 148, 100, 20);
		panelCadastro.add(rdbtnGratis);
		
		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoes.setForeground(Color.WHITE);
		lblObservacoes.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblObservacoes.setBounds(360, 11, 100, 20);
		panelCadastro.add(lblObservacoes);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSalvar.setBounds(600, 38, 154, 30);
		panelCadastro.add(btnSalvar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnDeletar.setBounds(600, 79, 154, 30);
		panelCadastro.add(btnDeletar);
		
		txtObs = new JTextField();
		txtObs.setBounds(360, 40, 154, 140);
		panelCadastro.add(txtObs);
		txtObs.setColumns(10);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.setBounds(600, 124, 75, 30);
		panelCadastro.add(btnVoltar);
		
		JButton btnAvancar = new JButton(">");
		btnAvancar.setBounds(679, 124, 75, 30);
		panelCadastro.add(btnAvancar);
		
		JPanel panelLista = new JPanel();
		panelLista.setBackground(new Color(119, 136, 153));
		panelLista.setBounds(10, 222, 764, 328);
		contentPane.add(panelLista);
		panelLista.setLayout(null);
		
		JScrollPane scrollJTable = new JScrollPane();
		scrollJTable.setBounds(10, 11, 744, 306);
		panelLista.add(scrollJTable);
		
		JList<String> listJogos = new JList<String>();
		scrollJTable.setViewportView(listJogos);
		listJogos.setModel(modelJogos);
		
		// listeners 
		
		rdbtnGratis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnGratis.isSelected()) {
					txtValor.setEnabled(false);
					txtValor.setBackground(new Color(211, 211, 211));
				} else {
					txtValor.setEnabled(true);
					txtValor.setBackground(new Color(255, 255, 255));
				}
			}
		});
		
		btnVoltar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (listJogos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Você deve selecionar um item da lista!", "Calma aí!", JOptionPane.WARNING_MESSAGE);
				} else {
					listJogos.setSelectedIndex(listJogos.getSelectedIndex()-1);
				}
			}
		});
		
		btnAvancar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (listJogos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Você deve selecionar um item da lista!", "Calma aí!", JOptionPane.WARNING_MESSAGE);
				} else {
					listJogos.setSelectedIndex(listJogos.getSelectedIndex()+1);
				}
			}
		});
		
		btnDeletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				if (listJogos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Você deve selecionar um item da lista!", "Presta atenção...!", JOptionPane.WARNING_MESSAGE);
				} else {
					modelJogos.removeRange(listJogos.getMinSelectionIndex(), listJogos.getMaxSelectionIndex());
					
				}
			}
		});
		
		
		final class gravar implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {	
				Jogo novoJogo = new Jogo();
				novoJogo.setTitulo(txtTitulo.getText());
				novoJogo.setValor(txtValor.getText());
				novoJogo.setFabricante(definirFabricante());
				novoJogo.setConsole(definirConsole());
				
				if (txtValor.isEditable()) {
					novoJogo.setValor(txtValor.getText());					
				} else {
					novoJogo.setValor("Gratuito");
				}
				
				modelJogos.addElement(novoJogo.getTitulo());
			}
		}

		btnSalvar.addActionListener(new gravar());
	
	}
	
	//criando metodos 
	//definir fabricante
	private Fabricantes definirFabricante() {
		if (comboFabricante.getSelectedIndex() == 0) {
			return Fabricantes.SONY;
		} else if (comboFabricante.getSelectedIndex() == 1) {
			return Fabricantes.MICROSOFT;
		} else if (comboFabricante.getSelectedIndex() == 2) {
			return Fabricantes.NINTENDO;
		} else if (comboFabricante.getSelectedIndex() == 3) {
			return Fabricantes.EA;
		} else if (comboFabricante.getSelectedIndex() == 4) {
			return Fabricantes.EPIC;
		} else {
			return Fabricantes.OUTRO;
		}
	}
	
	//definir console
	private Consoles definirConsole() {
		if (comboConsole.getSelectedIndex() == 0) {
			return Consoles.PC;
		} else if (comboConsole.getSelectedIndex() == 1) {
			return Consoles.PS;
		} else if (comboConsole.getSelectedIndex() == 2) {
			return Consoles.MOBILE;
		} else if (comboConsole.getSelectedIndex() == 3) {
			return Consoles.XBOX;
		} else if (comboConsole.getSelectedIndex() == 4) {
			return Consoles.NINTENDO;
		} else {
			return Consoles.OUTRO;
		}
	}
	
	private void salvarModelConsole() {
		for (Consoles console : Consoles.values()) {
			modelConsole.addElement(console.getDescricao());
		}
	}
	
	private void salvarModelFabricante() {
		for (Fabricantes fabricante : Fabricantes.values()) {
			modelFabricante.addElement(fabricante.getDescricao());
		}
	}
}
