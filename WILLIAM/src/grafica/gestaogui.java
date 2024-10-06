package grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class gestaogui {

    private static ArrayList<Coletor> coletores = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestão dos Coletores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));


        JButton button1 = new JButton("Usar Coletor");
        JButton button2 = new JButton("Devolver Coletor");
        JButton button3 = new JButton("Coletores em Uso");
        JButton button4 = new JButton("Eventualidade");
        JButton button5 = new JButton("Sair");

        button1.addActionListener(e -> usarColetor());
        button2.addActionListener(e -> devolverColetor());
        button3.addActionListener(e -> procurarColetor());
        button5.addActionListener(e -> System.exit(0));

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void usarColetor() {

        JFrame frame = new JFrame("Usar Coletor");
        JPanel panel = new JPanel(new GridLayout(5, 2));

        JTextField nomeField = new JTextField();
        JTextField matriculaField = new JTextField();
        JTextField funcionarioField = new JTextField();
        JTextField turnoField = new JTextField();

        panel.add(new JLabel("Nome do Coletor:"));
        panel.add(nomeField);
        panel.add(new JLabel("Matrícula do Usuário:"));
        panel.add(matriculaField);
        panel.add(new JLabel("Colaborador:"));
        panel.add(funcionarioField);
        panel.add(new JLabel("Turno:"));
        panel.add(turnoField);

        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(e -> {
            String nome = nomeField.getText();
            int matricula = Integer.parseInt(matriculaField.getText());
            String funcionario = funcionarioField.getText();
            String turno = turnoField.getText();

            Coletor coletor = new Coletor(nome, matricula, funcionario, turno);
            coletores.add(coletor);
            JOptionPane.showMessageDialog(frame, "Coletor registrado com sucesso!");
            frame.dispose();
        });

        panel.add(addButton);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private static void devolverColetor() {
        StringBuilder message = new StringBuilder("Coletores em uso:\n");
        for (Coletor c : coletores) {
            message.append(c.getNome()).append("\n");
        }

        String nome = JOptionPane.showInputDialog(message.toString() + "Digite o nome do coletor a ser devolvido:");
        coletores.removeIf(c -> c.getNome().equals(nome));
        JOptionPane.showMessageDialog(null, "Coletor removido com sucesso!");
    }

    private static void procurarColetor() {
        StringBuilder message = new StringBuilder("Coletores em operação:\n");
        for (Coletor c : coletores) {
            message.append(c.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }
}

class Coletor {
    private String nome;
    private int matricula;
    private String funcionario;
    private String turno;

    public Coletor(String nome, int matricula, String funcionario, String turno) {
        this.nome = nome;
        this.matricula = matricula;
        this.funcionario = funcionario;
        this.turno = turno;
    }

    public String getNome() {
        return nome;
    }

    // Outros getters e setters omitidos para brevidade
}