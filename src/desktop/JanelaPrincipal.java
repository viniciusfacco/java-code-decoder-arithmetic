package desktop;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.io.File;
import java.security.Principal;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JanelaPrincipal extends JFrame {

    private int WIDTH = 400;
    private int HEIGHT = 600;
    private JButton CODEC = new JButton("Codec");
    private JButton DECODEC = new JButton("Decodec");
    private JTextArea CODIGO = new JTextArea(10, 10);
    JScrollPane scrollingArea = new JScrollPane(CODIGO);

    public JanelaPrincipal() {
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        CODEC.addActionListener(new JButtonActionListener(this));
        pane.add(CODEC, c);
        c.gridx = 1;
        c.gridy = 0;
        DECODEC.addActionListener(new JButtonActionListener(this));
        pane.add(DECODEC, c);
        c.weighty = 5;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 1;
        CODIGO.setLineWrap(true);
        CODIGO.setEditable(false);
        scrollingArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollingArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pane.add(scrollingArea, c);
        this.add(pane);
    }

    public JTextArea getCODIGO() {
        return CODIGO;
    }
}
