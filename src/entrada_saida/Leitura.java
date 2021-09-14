package entrada_saida;

import desktop.JanelaPrincipal;
import java.io.*;
import java.util.Vector;

public class Leitura {

    private JanelaPrincipal janela;

    public Leitura(JanelaPrincipal janela) {
        this.janela = janela;
    }

    public Vector<Byte> lerArquivo(File arquivo) throws FileNotFoundException, IOException {
        Vector<Byte> conteudo = new Vector<Byte>();
        byte i;
        try {
            FileInputStream fi = null;
            fi = new FileInputStream(arquivo);
            DataInputStream dataStream = new DataInputStream(fi);
            while ((i = dataStream.readByte()) != -1) {
                conteudo.addElement(new Byte(i));
                //System.out.println(i);
                janela.getCODIGO().setText(janela.getCODIGO().getText() + String.valueOf(i) + "");
            }
            fi.close();
        } catch (EOFException eof) {
            System.out.println("Fim do Arquivo.");
        }
        return conteudo;
    }
}
