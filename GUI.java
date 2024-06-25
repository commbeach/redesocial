import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {
    private JFrame frame = new JFrame();

    public GUI() {

        // the clickable button
        JButton cad_pes = new JButton("Cadastrar Pessoa");
        cad_pes.addActionListener(this);

        //ButtonHandler handler = new ButtonHandler();

        JButton cad_emp = new JButton("Cadastrar Empresa");
        cad_emp.addActionListener(this);

        JButton login = new JButton("Login");
        login.addActionListener(this);

        JButton sair = new JButton("Sair");
        sair.addActionListener(this);

        // the panel with the button and text
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(cad_pes);
        panel.add(cad_emp);
        panel.add(login);
        panel.add(sair);
        
        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Minha Rede Social");
        frame.pack();
        frame.setVisible(true);
    }

    // process the button clicks
    public void actionPerformed(ActionEvent e) {
       
    }

    // create one Frame
    public static void main(String[] args) {
        new GUI();
    }
}
