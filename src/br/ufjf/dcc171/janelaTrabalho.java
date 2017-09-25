package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class janelaTrabalho extends JFrame {

    private double valor=0;
    private String comprados = "<html>"; 
    private final List<Tipo> tipos;
    private final JLabel lblcomprados = new JLabel("Total________$0.00");
    
    private final JList<Tipo> lstTipos = new JList<>(new DefaultListModel<>());
    private final JList<Comida> lstComidas = new JList<>(new DefaultListModel<>());
    
    private final JButton selecionar = new JButton("Selecionar");
    private final JButton adicionar = new JButton("Adicionar");
    private final JButton voltar = new JButton("Voltar");
    private final JButton finalizar = new JButton("Finalizar");
    
    private JLabel imagens = new JLabel();
    private JLabel preco = new JLabel();
    private JScrollPane westPane,eastPane,westPane2;
    private JPanel botoes,botoes2;
    //private final JanelaAluno janelaAluno = new JanelaAluno();
    
    public janelaTrabalho(List<Tipo> sampleData) {
        super("FastFood");
        setMinimumSize(new Dimension(610, 300));
        
        this.tipos = sampleData;        
        lstTipos.setModel(new TiposListModel(tipos));
        westPane = new JScrollPane(lstTipos);
        add(westPane, BorderLayout.WEST);
        
        eastPane = new JScrollPane(lblcomprados);
        add(eastPane, BorderLayout.EAST);
        
        botoes2 = new JPanel(new GridLayout(1, 2));
        botoes = new JPanel(new GridLayout(1, 2));
        botoes.add(selecionar);
        botoes.add(finalizar);        
        botoes2.add(adicionar);
        botoes2.add(voltar);        
        add(botoes, BorderLayout.SOUTH);
        
        Icon icone1 = new ImageIcon("resources/pcala.jpg");
        
        imagens.setIcon(icone1);
        add(imagens, BorderLayout.CENTER);
        
        lstTipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstComidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        lstTipos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                Tipo selecionada = lstTipos.getSelectedValue();
                
                if (selecionada != null) {
                    Icon newIcon = new ImageIcon("resources/" + lstTipos.getSelectedValue().getImagem());
                    
                    imagens.setIcon(newIcon);
                    validate();repaint();
                }
            }
        });
        
        lstComidas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Comida selecionada = lstComidas.getSelectedValue();
                if (selecionada != null) {
                    Icon newIcon = new ImageIcon("resources/" + lstComidas.getSelectedValue().getImagem());
                    imagens.setIcon(newIcon);

                    validate();repaint();
                }
            }
        });
        
        selecionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tipo selecionada = lstTipos.getSelectedValue();
                if (selecionada != null) {
                    
                    lstComidas.setModel(new ComidasListModel(selecionada.getComidas()));
                    westPane2 = new JScrollPane(lstComidas);
                    
                    remove(westPane);
                    remove(botoes);
                    add(botoes2, BorderLayout.SOUTH);
                    add(westPane2, BorderLayout.WEST);

                    validate();repaint();
                    
                } else {
                    lstComidas.setModel(new DefaultListModel<>());
                }
            }
        });
        adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Comida selecionada = lstComidas.getSelectedValue();
                if(selecionada!=null)
                {
                    String preencher = "_";
                    String tamanho = ""+valor;
                    for (int i = 0; i < 11 - (tamanho.length()); i++) {
                        preencher = preencher + "_";
                    }  
                    valor+= Double.parseDouble(selecionada.getPreco());
                    comprados = comprados + selecionada + "<br>";
                    lblcomprados.setText(comprados + "Total"+preencher+"$" + valor +"</html>");
                    validate();repaint();
                }
            }
        });
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(westPane2);
                remove(botoes2);
                add(botoes, BorderLayout.SOUTH);
                add(westPane, BorderLayout.WEST);
                
                validate();repaint();
            }
        });
        
        finalizar.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                
                comprados = "<html>";
                valor = 0;
                lblcomprados.setText("Total________$0.00");
                validate();repaint();
            }
        });
    }

}
