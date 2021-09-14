package code_decode;

import desktop.JanelaPrincipal;
import entrada_saida.Leitura;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public class Codec {

    private JanelaPrincipal janela;
    private Vector<Byte> conteudo;
    private Tabela tabela;
    private File arquivo;
    private Codigo crypt;
    private Codigo decrypt;

    public Codec(File arquivo, JanelaPrincipal janela) {
        this.janela = janela;
        this.arquivo = arquivo;
    }

    public void codifica() throws FileNotFoundException, IOException {        
        Leitura ler = new Leitura(janela);
        conteudo = ler.lerArquivo(arquivo);
        tabela = new Tabela(conteudo.size());
        tabela.construirTabela(conteudo);
        System.out.println("TABELA");
        tabela.printTabela();
        crypt = new Codigo(conteudo, tabela);
        decrypt = new Codigo(crypt.getcode(), tabela);        
        System.out.println("Codigo gerado: " + crypt.getcode());
        System.out.println("DADOS DECODIFICADOS:");
        decrypt.imprime_data();
        /*
        Vector<Byte> data_part = new Vector<Byte>();
        int indx = 0;
        int range = 5;
        while (indx < conteudo.size()) {
            if ((conteudo.size()-range) > indx){
                for(int a = 0;a < indx+range;a++){
                    data_part.addElement(conteudo.get(indx+a));
                }
                indx = indx + range;
                crypt = new Codigo(data_part, tabela);
                System.out.println("ENCRIPTAÇÃO");
                System.out.println("Código: " + crypt.getcode() + "Dados: ");
                crypt.imprime_data();
                decrypt = new Codigo(crypt.getcode(), tabela);
                System.out.println("DECRIPTAÇÃO");
                System.out.println("Código: " + decrypt.getcode() + "Dados: ");
                decrypt.imprime_data();
            }else {
                for(int a = indx;a < conteudo.size();a++){
                    data_part.addElement(conteudo.get(a));
                }
                indx = conteudo.size();
                crypt = new Codigo(data_part, tabela);
                System.out.println("ENCRIPTAÇÃO");
                System.out.println("Código: " + crypt.getcode() + "Dados: ");
                crypt.imprime_data();
                decrypt = new Codigo(crypt.getcode(), tabela);
                System.out.println("DECRIPTAÇÃO");
                System.out.println("Código: " + decrypt.getcode() + "Dados: ");
                decrypt.imprime_data();
            }
        }*/
    }

}
