package desktop;

import code_decode.Codec;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class JButtonActionListener implements ActionListener {
private JanelaPrincipal janela;
public JButtonActionListener(JanelaPrincipal janela){
    this.janela = janela;
}
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Codec")) {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(janela);
            Codec codec = new Codec(fc.getSelectedFile(), janela);
            try {
                codec.codifica();
            } catch (FileNotFoundException ex) {
                System.out.println("FileNotFoundException");
            } catch (IOException ex) {
                System.out.println("IOException");
            }
        } else if (e.getActionCommand().equals("Decodec")) {
        }
    }
}
