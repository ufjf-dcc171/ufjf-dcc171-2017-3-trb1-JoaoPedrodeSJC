package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class janelaTrabalho extends JFrame {

    private double valor=0;  
    private final List<Tipo> tipos;
    private final JTable comprados;
    
    private final JList<Tipo> lstTipos = new JList<>(new DefaultListModel<>());
    private final JList<Comida> lstComidas = new JList<>(new DefaultListModel<>());
    
    private final JButton selecionar = new JButton("Selecionar");
    private final JButton adicionar = new JButton("Adicionar");
    private final JButton voltar = new JButton("Voltar");
    private final JButton finalizar = new JButton("Finalizar");
    
    private JLabel imagens = new JLabel();
    private JLabel preco = new JLabel();
    
    private JLabel inicio = new JLabel("-:--");
    
    private JScrollPane westPane,eastPane,westPane2;
    private JPanel botoes,botoes2;

    
    public janelaTrabalho(List<Tipo> sampleData, int numMesa) {
        
        super("mesa " + numMesa);
        setMinimumSize(new Dimension(650, 305));
        
        JPanel formulario = new JPanel();
        formulario.setLayout(new GridLayout(1, 3));
        
        JPanel horario = new JPanel();
        horario.setLayout(new GridLayout(1, 2));
        horario.add(new JLabel("Inicio do atendimento:"));
        horario.add(inicio);
        add(horario,BorderLayout.NORTH);
        
        this.tipos = sampleData;        
        lstTipos.setModel(new TiposListModel(tipos));
        westPane = new JScrollPane(lstTipos);
        formulario.add(westPane);

        Icon icone1 = new ImageIcon("resources/pcala.jpg");        
        imagens.setIcon(icone1);
        formulario.add(imagens); 
        
        Object[] titulos = new Object[]{"Nome","Qtde", "Preço"};
        Object[][] dados = new Object[][]{{"Total",0, "0,00"}};
        comprados = new JTable(new DefaultTableModel(dados, titulos));
        eastPane = new JScrollPane(comprados);
        
        formulario.add(eastPane);
        eastPane.setMaximumSize(new Dimension(100, 100));
        
        add(formulario,BorderLayout.CENTER);
        botoes2 = new JPanel(new GridLayout(1, 2));
        botoes = new JPanel(new GridLayout(1, 2));
        botoes.add(selecionar);
        botoes.add(finalizar);        
        botoes2.add(adicionar);
        botoes2.add(voltar);        
        add(botoes, BorderLayout.SOUTH);
        
        
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
                    formulario.remove(westPane);
                            
                    remove(botoes);
                    add(botoes2, BorderLayout.SOUTH);
                    formulario.add(westPane2,0);

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
                DefaultTableModel modelo = (DefaultTableModel)comprados.getModel();
                
                if(selecionada!=null)
                {  
                    valor+= Double.parseDouble(selecionada.getPreco());
                    int existe = -1;
                    for (int i = 0; i < modelo.getRowCount(); i++)
                    {
                        if(modelo.getValueAt(i, 0)==selecionada.getNome())
                        {
                            existe = i;
                            break;
                        }
                    }
                    if(existe >0)
                    {
                        int aux3 =(Integer)modelo.getValueAt(existe, 1);
                        aux3++;
                        modelo.setValueAt(aux3, existe, 1);
                    }
                    else
                    {
                        modelo.addRow(new Object[]{selecionada.getNome(),1,selecionada.getPreco()});
                        
                    }
                    
                    int aux3 =(Integer)modelo.getValueAt(0, 1);
                    aux3++;
                    modelo.setValueAt(aux3, 0, 1);
                    modelo.setValueAt(valor, 0, 2);
                    validate();repaint();
                    
                    if(inicio.getText().equals("-:--"))
                    {
                        Date date = new Date();
                        DateFormat formato = new SimpleDateFormat("HH:mm");
                        String formattedDate = formato.format(date);
                        inicio.setText(formattedDate);
                    }
                }
            }
        });
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formulario.remove(westPane2);
                remove(botoes2);
                add(botoes, BorderLayout.SOUTH);
                formulario.add(westPane, 0);
                
                validate();repaint();
            }
        });
        
        finalizar.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                
                if(valor> 0.0 )
                {
                    Date date = new Date();
                    DateFormat formato = new SimpleDateFormat("HH:mm");
                    String formattedDate = formato.format(date);

                    DefaultTableModel modelo = (DefaultTableModel)comprados.getModel();                
                    JOptionPane.showMessageDialog(null, "O valor a ser pago é: " + valor,"Inicio atd: " + inicio.getText() + " fim: " + formattedDate ,JOptionPane.INFORMATION_MESSAGE);
                    valor = 0;
                    inicio.setText("-:--");
                    modelo.setValueAt(valor, 0, 2);
                    modelo.setRowCount(1);
                    validate();repaint();
                }
            }
        });
    }

}
