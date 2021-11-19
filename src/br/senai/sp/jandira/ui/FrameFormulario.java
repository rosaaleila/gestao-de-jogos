package br.senai.sp.jandira.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.senai.sp.jandira.enums.Consoles;
import br.senai.sp.jandira.model.Fabricantes;
import br.senai.sp.jandira.model.Jogo;
import br.senai.sp.jandira.repository.FabricanteRepository;
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
import javax.swing.JTextArea;

public class FrameFormulario extends JFrame {
	
	private JogoRepository colecao;
	private int posicao;
	private JPanel contentPane;
	private FabricanteRepository fabricantes = new FabricanteRepository();
	private Fabricantes fabricante;
	private JTextField txtTitulo;
	private JTextField txtValor;
	private JTextArea txtObs;
	private JRadioButton rdbtnGratis;
	private JRadioButton rdbtnZerado;
	private JComboBox<String> comboFabricante = new JComboBox<String>();
	private JComboBox<String> comboConsole = new JComboBox<String>();
	private DefaultListModel<String> modelJogos = new DefaultListModel<String>();
	private DefaultComboBoxModel<String> modelFabricante = new DefaultComboBoxModel<String>();
	private DefaultComboBoxModel<String> modelConsole = new DefaultComboBoxModel<String>();

	public FrameFormulario() {
		int tamanhoColecao = Integer.parseInt(JOptionPane.showInputDialog("Por favor, insira o tamanho da coleção:"));
		colecao = new JogoRepository(tamanhoColecao);
		
		setResizable(false);
		
		setTitle("Gest\u00E3o de Jogos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBackground(new Color(112, 128, 144));
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
		
		rdbtnZerado = new JRadioButton("Zerado");
		rdbtnZerado.setForeground(Color.WHITE);
		rdbtnZerado.setFont(new Font("SansSerif", Font.PLAIN, 15));
		rdbtnZerado.setBackground(new Color(112, 128, 144));
		rdbtnZerado.setBounds(10, 50, 77, 23);
		panelCadastro.add(rdbtnZerado);
		
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
		txtValor.setBounds(97, 146, 65, 20);
		panelCadastro.add(txtValor);
		
		rdbtnGratis = new JRadioButton("Gratuito");
		rdbtnGratis.setBackground(new Color(112, 128, 144));
		rdbtnGratis.setBounds(174, 145, 100, 20);
		panelCadastro.add(rdbtnGratis);
		
		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoes.setForeground(Color.WHITE);
		lblObservacoes.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblObservacoes.setBounds(425, 20, 100, 20);
		panelCadastro.add(lblObservacoes);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSalvar.setBounds(600, 95, 154, 30);
		panelCadastro.add(btnSalvar);
		
//		JButton btnDeletar = new JButton("Deletar");
//		btnDeletar.setFont(new Font("SansSerif", Font.BOLD, 12));
//		btnDeletar.setBounds(600, 95, 154, 30);
//		panelCadastro.add(btnDeletar);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.setBounds(600, 136, 75, 30);
		panelCadastro.add(btnVoltar);
		
		JButton btnAvancar = new JButton(">");
		btnAvancar.setBounds(679, 136, 75, 30);
		panelCadastro.add(btnAvancar);
		
		txtObs = new JTextArea();
		txtObs.setLineWrap(true);
		txtObs.setBounds(425, 44, 141, 122);
		panelCadastro.add(txtObs);
		
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
		
//		btnDeletar.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {	
//				if (listJogos.isSelectionEmpty()) {
//					JOptionPane.showMessageDialog(null, "Você deve selecionar um item da lista!", "Presta atenção...!", JOptionPane.WARNING_MESSAGE);
//				} else {
//					modelJogos.removeRange(listJogos.getMinSelectionIndex(), listJogos.getMaxSelectionIndex());
//					for (int quantia = listJogos.getMinSelectionIndex(); quantia < listJogos.getMaxSelectionIndex(); quantia++) {
//						colecao.deletarJogo(quantia);
//					}
//				}
//
//			}
//		});
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (verificarDados() == false) {
					JOptionPane.showMessageDialog(null, "Preencha os campos de cadastro!", "Tá falando sério?", JOptionPane.ERROR_MESSAGE);
				} else {
					Jogo novoJogo = new Jogo();
					novoJogo.setTitulo(txtTitulo.getText());
					novoJogo.setValor(txtValor.getText());
					novoJogo.setConsole(definirConsole());
					novoJogo.setObservacoes(txtObs.getText());
					novoJogo.setFabricante(definirFabricante());
					
					if (rdbtnZerado.isSelected()) {
						novoJogo.setEstado("Zerado");
					} else {
						novoJogo.setEstado("Em andamento");
					}
					
					if (txtValor.isEditable()) {
						novoJogo.setValor(txtValor.getText());					
					} else {
						novoJogo.setValor("Gratuito");
					}

					modelJogos.addElement(novoJogo.getTitulo());
					colecao.cadastrar(novoJogo, posicao);
					posicao++;
					
					if (modelJogos.getSize() == colecao.getTamanho()) {
						 btnSalvar.setEnabled(false);
						 JOptionPane.showMessageDialog(null, "Você alcançou o limite da coleção! Delete alguns jogos ou crie uma nova coleção!, ", "Respira...", JOptionPane.ERROR_MESSAGE);
					}
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
		
		listJogos.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int indice = listJogos.getSelectedIndex();
				txtTitulo.requestFocus();
				Jogo jogoSelecionado = colecao.listarJogo(indice);
				
				txtTitulo.setText(colecao.listarJogo(indice).getTitulo());
				
				if (jogoSelecionado.getValor().equals("Gratuito")) {
					rdbtnGratis.setEnabled(true);
				} else {
					txtValor.setText(jogoSelecionado.getValor());
				}
				
				comboConsole.setSelectedIndex(jogoSelecionado.getConsole().ordinal());
				comboFabricante.setSelectedIndex(salvarIndex());
				
				txtObs.setText(jogoSelecionado.getObservacoes());
				
				if (jogoSelecionado.getEstado().equals("Zerado")) {
					rdbtnZerado.setSelected(true);
				} else {
					rdbtnZerado.setSelected(false);
				}
			}
		});
		
	}
	
	//criando metodos 
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
	
	private Fabricantes definirFabricante() {
		if (comboConsole.getSelectedIndex() == 0) {
			return fabricantes.listarFabricante(0);
		} else if (comboConsole.getSelectedIndex() == 1) {
			return fabricantes.listarFabricante(1);
		} else if (comboConsole.getSelectedIndex() == 2) {
			return fabricantes.listarFabricante(2);
		} else {
			return fabricantes.listarFabricante(3);
		}
	}
	
	private void salvarModelConsole() {
		for (Consoles console : Consoles.values()) {
			modelConsole.addElement(console.getDescricao());
		}
	}
	
	private void salvarModelFabricante() {
		for (int i = 0; i < fabricantes.getTamanho(); i++) {
			modelFabricante.addElement(fabricantes.listarFabricante(i).getNome());
		}
	}
	
	private int salvarIndex() {
		if (comboConsole.getSelectedIndex() == 0) {
			return 0;
		} else if (comboConsole.getSelectedIndex() == 1) {
			return 1;
		} else if (comboConsole.getSelectedIndex() == 2) {
			return 2;
		} else {
			return 3;
		}
	}

	
	private boolean verificarDados() {
		if (txtTitulo.getText() == null) {
			return false;
		} else if (txtValor.getText() == null && rdbtnGratis.isSelected() == false) {
			return false;
		} else if (txtObs.getText() == null){
			return false;
		} else {
			return true;
		}
	}
}
