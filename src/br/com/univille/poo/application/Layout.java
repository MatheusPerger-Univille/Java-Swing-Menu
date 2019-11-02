package br.com.univille.poo.application;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import br.com.univille.poo.business.CalculosBusiness;

public class Layout extends JFrame {
	
	private JFrame jframe;
	private JMenuBar menu;
	private JTabbedPane tabs;
	private JPanel painelMoeda = painelMoeda();
	private JPanel painelComprimento = painelComprimento();
	private JPanel painelTemperatura = painelTemperatura();
	private JComboBox<String> comboBoxMoedaDe;
	private JComboBox<String> comboBoxMoedaPara;
	private JComboBox<String> comboBoxTemperaturaDe;
	private JComboBox<String> comboBoxTemperaturaPara;
	private JComboBox<String> comboBoxComprimentoDe;
	private JComboBox<String> comboBoxComprimentoPara;
	private JTextField valorMoedaDe;
	private JTextField valorMoedaPara;
	private JTextField valorTemperaturaDe;
	private JTextField valorTemperaturaPara;
	private JTextField valorComprimentoDe;
	private JTextField valorComprimentoPara;
	private CalculosBusiness calculosBusiness;

	public Layout(JFrame jframe) {
		this.jframe = jframe;
		calculosBusiness = new CalculosBusiness();
	}
	
	public JFrame getJframe() {
		return jframe;
	}
	
	public void setJframe(JFrame jframe) {
		this.jframe = jframe;
	}

	public JFrame setandoLayout() {
		
		JPanel painel = new JPanel();
		
		criandoMenu(painel);
		criandoAbas(painel);
		
		return getJframe();
	}
	
	public void criandoMenu(JPanel panel) {
		menu = new JMenuBar();
		
        JMenu arquivoMenu = new JMenu("Arquivo");
        JMenu editarMenu = new JMenu("Editar");
        JMenu ajudaMenu = new JMenu("Ajuda");
		
		JMenuItem menuItemArquivo;
		menuItemArquivo = new JMenuItem("Sair", KeyEvent.VK_I);
		
		menuItemArquivo.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	jframe.dispatchEvent(new WindowEvent(jframe, WindowEvent.WINDOW_CLOSING));
 
            }
        });
		
		JMenuItem menuItemEditar1;
		menuItemEditar1 = new JMenuItem("Limpar campos", KeyEvent.VK_I);
		
		menuItemEditar1.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	valorMoedaDe.setText("");
            	valorMoedaPara.setText("");
            	valorTemperaturaDe.setText("");
            	valorTemperaturaPara.setText("");
            	valorComprimentoDe.setText("");
            	valorComprimentoPara.setText("");
 
            }
        });
		
		JCheckBoxMenuItem showMoedas = new JCheckBoxMenuItem("Exibir Moedas");
		showMoedas.setSelected(true);
		showMoedas.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(showMoedas.isSelected())
					tabs.addTab("Moeda", painelMoeda);
				else
					tabs.remove(painelMoeda);
					
			}
		});
		
		JCheckBoxMenuItem showTemperatura = new JCheckBoxMenuItem("Exibir Temperaturas");
		showTemperatura.setSelected(true);
		showTemperatura.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(showTemperatura.isSelected())
					tabs.addTab("Temperatura", painelTemperatura);
				else
					tabs.remove(painelTemperatura);
					
			}
		});
		
		JCheckBoxMenuItem showComprimento = new JCheckBoxMenuItem("Exibir Comprimentos");
		showComprimento.setSelected(true);
		showComprimento.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(showComprimento.isSelected())
					tabs.addTab("Comprimento", painelComprimento);
				else
					tabs.remove(painelComprimento);
					
			}
		});
		
		JMenuItem menuItemAjuda1;
		menuItemAjuda1 = new JMenuItem("Desenvolvedores", KeyEvent.VK_I);
		
		menuItemAjuda1.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	JOptionPane.showMessageDialog(null, "Desenvolvedor: Matheus Perger Estevão Bezerra");
 
            }
        });
		
		JMenuItem menuItemAjuda2;
		menuItemAjuda2 = new JMenuItem("Repositório GitHub", KeyEvent.VK_I);
		
		menuItemAjuda2.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	try {
            		// Abrindo repositório no browser
					java.awt.Desktop.getDesktop().browse( new java.net.URI( "https://github.com/MatheusPerger-Univille/Java-Swing-Menu" ) );
				} catch (IOException | URISyntaxException e1) {
					e1.printStackTrace();
				}
 
            }
        });
		
		JMenuItem menuItemAjuda3;
		menuItemAjuda3 = new JMenuItem("Sobre", KeyEvent.VK_I);
		
		menuItemAjuda3.addActionListener(new ActionListener()
        {
 
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	JOptionPane.showMessageDialog(null, "Telas desenvolvidas para a disciplina de POO do professor Leanderson André.");
 
            }
        });
		
        menu.add(arquivoMenu);
        arquivoMenu.add(menuItemArquivo);
        
        menu.add(editarMenu);
        editarMenu.add(menuItemEditar1);
        editarMenu.addSeparator();
        editarMenu.add(showMoedas);
        editarMenu.add(showTemperatura);
        editarMenu.add(showComprimento);
        
        menu.add(ajudaMenu);
        ajudaMenu.add(menuItemAjuda1);
        ajudaMenu.add(menuItemAjuda2);
        ajudaMenu.add(menuItemAjuda3);
        
        jframe.setJMenuBar(menu);
        jframe.add(panel);
	}
	
	public void criandoAbas(JPanel panel) {
		
		tabs = new JTabbedPane();
		
		tabs.addTab("Moeda", painelMoeda);
		
		tabs.addTab("Temperatura", painelTemperatura);
		
		tabs.addTab("Comprimento", painelComprimento);
		
		tabs.setBorder(BorderFactory.createEmptyBorder(30,50,50,50));

		panel.add(tabs);
		
		jframe.add(panel);
	}
	
    private JPanel painelMoeda() {
    	JPanel panel = new JPanel();
    	
    	Dimension tamanhoPreferido = new Dimension(80,20);
    	
    	String itens [] = {"Real","Dólar","Euro"};
    	
    	comboBoxMoedaDe = new JComboBox<String>(itens);
    	comboBoxMoedaDe.setPreferredSize(tamanhoPreferido);
    	comboBoxMoedaDe.setSelectedIndex(0);
		
    	comboBoxMoedaPara = new JComboBox<String>(itens);
		comboBoxMoedaPara.setPreferredSize(tamanhoPreferido);
    	comboBoxMoedaPara.setSelectedIndex(1);
    	comboBoxMoedaPara.setBounds(180, 40, 100, 30);
    	
    	valorMoedaDe = new JTextField(20);
    	valorMoedaPara = new JTextField(20);
    	valorMoedaPara.setEditable(false);
    	
    	JButton button = new JButton("Converter");
		button.setBounds(140, 70, 100, 30);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(valorMoedaDe.getText().equals(""))
					return;
				
				String valorConvertido = calculosBusiness.calculoMoeda(comboBoxMoedaDe.getSelectedItem().toString()
																		, comboBoxMoedaPara.getSelectedItem().toString()
																		, valorMoedaDe.getText());
				
				valorMoedaPara.setText(valorConvertido);
			}
		});
		
    	panel.add(new JLabel("De"));
		panel.add(comboBoxMoedaDe);
		panel.add(new JLabel("Para"));
		panel.add(comboBoxMoedaPara);
		panel.add(valorMoedaDe);
		panel.add(valorMoedaPara);
		panel.add(button);
    	
    	panel.setPreferredSize(new Dimension(400, 400));
    	
    	return panel;
    }
    
    private JPanel painelTemperatura() {
    	JPanel panel = new JPanel();
    	
    	Dimension tamanhoPreferido = new Dimension(80,20);
    	
    	String itens [] = {"Celsius","Kelvin"};
    	
    	comboBoxTemperaturaDe = new JComboBox<String>(itens);
    	comboBoxTemperaturaDe.setPreferredSize(tamanhoPreferido);
    	comboBoxTemperaturaDe.setSelectedIndex(0);
		
    	comboBoxTemperaturaPara = new JComboBox<String>(itens);
		comboBoxTemperaturaPara.setPreferredSize(tamanhoPreferido);
    	comboBoxTemperaturaPara.setSelectedIndex(1);
    	comboBoxTemperaturaPara.setBounds(180, 40, 100, 30);
    	
    	valorTemperaturaDe = new JTextField(20);
    	valorTemperaturaPara = new JTextField(20);
    	valorTemperaturaPara.setEditable(false);
    	
    	JButton button = new JButton("Converter");
		button.setBounds(140, 70, 100, 30);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(valorTemperaturaDe.getText().equals(""))
					return;
				
				String valorConvertido = calculosBusiness.calculoTemperatura(comboBoxTemperaturaDe.getSelectedItem().toString()
						, comboBoxTemperaturaPara.getSelectedItem().toString()
						, valorTemperaturaDe.getText());

				valorTemperaturaPara.setText(valorConvertido);
			}
		});
		
    	panel.add(new JLabel("De"));
		panel.add(comboBoxTemperaturaDe);
		panel.add(new JLabel("Para"));
		panel.add(comboBoxTemperaturaPara);
		panel.add(valorTemperaturaDe);
		panel.add(valorTemperaturaPara);
		panel.add(button);
    	
    	panel.setPreferredSize(new Dimension(400, 400));
    	
    	return panel;
    }
    
    private JPanel painelComprimento() {
    	JPanel panel = new JPanel();
    	
    	Dimension tamanhoPreferido = new Dimension(80,20);
    	
    	String itens [] = {"Metro","Milimetro"};
    	
    	comboBoxComprimentoDe = new JComboBox<String>(itens);
    	comboBoxComprimentoDe.setPreferredSize(tamanhoPreferido);
    	comboBoxComprimentoDe.setSelectedIndex(0);
		
    	comboBoxComprimentoPara = new JComboBox<String>(itens);
		comboBoxComprimentoPara.setPreferredSize(tamanhoPreferido);
    	comboBoxComprimentoPara.setSelectedIndex(1);
    	comboBoxComprimentoPara.setBounds(180, 40, 100, 30);
    	
    	valorComprimentoDe = new JTextField(20);
    	valorComprimentoPara = new JTextField(20);
    	valorComprimentoPara.setEditable(false);
    	
    	JButton button = new JButton("Converter");
		button.setBounds(140, 70, 100, 30);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(valorComprimentoDe.getText().equals(""))
					return;
				
				String valorConvertido = calculosBusiness.calculoComprimento(comboBoxComprimentoDe.getSelectedItem().toString()
						, comboBoxComprimentoPara.getSelectedItem().toString()
						, valorComprimentoDe.getText());
				
				valorComprimentoPara.setText(valorConvertido.toString());
			}
		});
		
    	panel.add(new JLabel("De"));
		panel.add(comboBoxComprimentoDe);
		panel.add(new JLabel("Para"));
		panel.add(comboBoxComprimentoPara);
		panel.add(valorComprimentoDe);
		panel.add(valorComprimentoPara);
		panel.add(button);
    	
    	panel.setPreferredSize(new Dimension(400, 400));
    	
    	return panel;
    }
	
}
