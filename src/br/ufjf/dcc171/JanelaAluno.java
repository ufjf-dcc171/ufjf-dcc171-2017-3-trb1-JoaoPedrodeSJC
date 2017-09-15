package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JanelaAluno extends JFrame {

    private final JLabel lblMatricula = new JLabel("Matrícula");
    private final JLabel lblNome = new JLabel("Nome");
    private final JTextField txtMatricula = new JTextField(30);
    private final JTextField txtNome = new JTextField(30);
    private final JButton btnOk = new JButton("Criar");
    private JanelaTurmas janelaTurmas;

    public JanelaAluno() throws HeadlessException {
        super("Criar novo aluno");
        setSize(200, 90);
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel principal = new JPanel(new GridLayout(2, 2));
        principal.add(lblMatricula);
        principal.add(txtMatricula);
        principal.add(lblNome);
        principal.add(txtNome);
        add(principal, BorderLayout.CENTER);
        add(btnOk, BorderLayout.SOUTH);
        
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtMatricula.getText().isEmpty() && !txtNome.getText().isEmpty()){
                    Aluno a = new Aluno();
                    a.setMatricula(txtMatricula.getText());
                    a.setNome(txtNome.getText());
                    janelaTurmas.adicionaAluno(a);
                }
            }
        });
    }

    public void setJanelaTurmas(JanelaTurmas janela){
        this.janelaTurmas = janela;
    }

    void solicitaNovoAluno() {
        setLocationRelativeTo(null);
        setVisible(true);
        txtMatricula.setText("");
        txtMatricula.requestFocus();
        txtNome.setText("");
    }
}
