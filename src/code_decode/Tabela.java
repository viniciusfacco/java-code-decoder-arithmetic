package code_decode;

import java.util.Vector;

public class Tabela {

    private Vector<ItemTabela> itens;
    private double probabilidade;
    private int tamanhoTabela;
    private int tamanhoDados;

    public Tabela() {
        itens = new Vector<ItemTabela>();
        tamanhoTabela = 0;
    }

    public Tabela(int sizeVector) {
        itens = new Vector<ItemTabela>();
        probabilidade = 1 / sizeVector;
    }

    public void construirTabela(Vector<Byte> conteudo) {
       tamanhoDados = conteudo.size();
        boolean achou;
        int a;
        for (int i = 0; i < tamanhoDados; i++) {
            if (tamanhoTabela != 0) {
                tamanhoTabela = itens.size();
                byte byteAtual = conteudo.get(i);
                a = 0;
                achou = false;
                while (!achou && a < tamanhoTabela){
                    if (byteAtual == itens.get(a).getCharacter()) {
                        itens.get(a).setVezes(itens.get(a).getVezes() + 1);
                        achou = true;
                    }
                a++;
                }
                if (!achou){itens.addElement(new ItemTabela(byteAtual, 1));}
            }
            else{
                byte byteAtual = conteudo.get(i);
                itens.addElement(new ItemTabela(byteAtual, 1));
                tamanhoTabela = itens.size();
            }
        }
        tamanhoTabela = itens.size();
        probabilidade = 1.0 / (tamanhoDados+1);
        this.atualizaTabela();
    }

    public void printTabela() {
        for (int i = 0; i < itens.size(); i++) {
            ItemTabela item = itens.get(i);
            System.out.println(
                    "Byte: " + item.getCharacter() +
                    "Letra: " + (char)item.getCharacter() +
                    " Vezes: " + item.getVezes() +
                    " Probabilidade: " + item.getProbabilidade() +
                    " Lim. Inferior: " + item.getLimiteInferior() +
                    " Lim. Superior: " + item.getLimiteSuperior()
                    );
        }
    }

    public void atualizaTabela(){
        double lim = this.probabilidade;
        if (tamanhoTabela > 0){
            itens.get(0).atualizaProbabilidade(probabilidade);
            itens.get(0).setLimiteInferior(lim);
            lim = lim + itens.get(0).getProbabilidade();
            itens.get(0).setLimiteSuperior(lim);
        }
        for (int i = 1; i < tamanhoTabela; i++) {
            itens.get(i).atualizaProbabilidade(probabilidade);
            lim = itens.get(i-1).getLimiteSuperior();
            itens.get(i).setLimiteInferior(lim);
            lim = lim + itens.get(i).getProbabilidade();
            itens.get(i).setLimiteSuperior(lim);
        }
    }
    
    public void atualizaTabela(int num){
        itens.get(0).setLimiteInferior(0.6);
        itens.get(0).setLimiteSuperior(0.7);
        itens.get(1).setLimiteInferior(0.7);
        itens.get(1).setLimiteSuperior(0.8);
        itens.get(2).setLimiteInferior(0.1);
        itens.get(2).setLimiteSuperior(0.2);
        itens.get(3).setLimiteInferior(0.4);
        itens.get(3).setLimiteSuperior(0.5);
        itens.get(4).setLimiteInferior(0.2);
        itens.get(4).setLimiteSuperior(0.4);
    }
    
    public ItemTabela getitem_byte(Byte caracter){
        int a = 0;
        boolean achou = false;
        while (!achou){
            if (caracter == itens.get(a).getCharacter()) {
                achou = true;
            }
            a++;
        }
        return itens.get(a-1);
    }
    
    public ItemTabela getitem_double(double limite){
        int a = 0;
        boolean achou = false;
        while (!achou){
            if ((limite >= itens.get(a).getLimiteInferior()) && (limite < itens.get(a).getLimiteSuperior())) {
                achou = true;
            }
            a++;
        }
        return itens.get(a-1);
    }
    
    public int get_tam_tabela(){
        return this.tamanhoTabela;
    }
    
    public int get_tam_dados(){
        return this.tamanhoDados;
    }
    
}
