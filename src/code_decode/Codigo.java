package code_decode;

import java.util.Vector;

public class Codigo {

    private double code;
    private Vector<Byte> data;
    
    public Codigo(){
        code = 0;
    }
    
    public Codigo(double codigo, Tabela tabela_limites){
        code = codigo;
        data = gera_data(codigo, tabela_limites);
    }
    
    public Codigo(Vector<Byte> dados, Tabela tabela_limites){
        data = dados;
        code = gera_code(dados,tabela_limites);
    }
    
    private double gera_code(Vector<Byte> conteudo, Tabela table){
        int tamanho = conteudo.size();
        double delta;
        double low;
        //double tmp01,tmp02;
        double high;
        ItemTabela item;
        double codigo = 0;
        if (tamanho != 0){
            byte byteAtual = conteudo.get(0);
            item = table.getitem_byte(byteAtual);
            low = item.getLimiteInferior();
            high = item.getLimiteSuperior();
            //delta = (high*Math.pow(10,32) - low*Math.pow(10,32))/Math.pow(10,32);
            delta = high - low;
            codigo = low;
            for(int i = 1; i < tamanho; i++){
                byteAtual = conteudo.get(i);
                item = table.getitem_byte(byteAtual);
                high = low;
                low = low + (item.getLimiteInferior() * delta);
                //tmp01 = ((item.getLimiteInferior()*Math.pow(10,32)) * (delta*Math.pow(10,32)));
                //tmp02 = low*Math.pow(10,64);
                //low = (tmp01 + tmp02);
                high = high + (item.getLimiteSuperior() * delta);
                //tmp01 = ((item.getLimiteSuperior()*Math.pow(10,32)) * (delta*Math.pow(10,32)));
                //tmp02 = high*Math.pow(10,64);
                //high = (tmp01 + tmp02);
                delta = (high - low);
                //low = low/Math.pow(10,64);
                //high = high/Math.pow(10,64);
                //delta = (high*Math.pow(10,32) - low*Math.pow(10,32))/Math.pow(10,32);
                codigo = low;
            }
        }
        else {System.out.println("Não há dados a codificar");}
        System.out.println(codigo);
        return codigo;
    }
    
    private Vector<Byte> gera_data(double src_code, Tabela table) {
        Vector<Byte> dados = new Vector<Byte>();
        int countDados = 0;
        double codigo = src_code;
        double delta;
        //,tmp01,tmp02;
        ItemTabela item;
        while((codigo > 0) && (countDados < table.get_tam_dados())){
            item = table.getitem_double(codigo);
            dados.addElement(new Byte(item.getCharacter()));
            codigo = (codigo - item.getLimiteInferior());
            //tmp01 = codigo*Math.pow(10,16);
            //tmp02 = item.getLimiteInferior()*Math.pow(10,16);
            //codigo = tmp01 - tmp02;
            delta = (item.getLimiteSuperior()-item.getLimiteInferior());
            //tmp01 = item.getLimiteSuperior()*Math.pow(10,16);
            //tmp02 = item.getLimiteInferior()*Math.pow(10,16);
            //delta = tmp01 - tmp02;
            codigo = codigo/delta;
            //codigo = codigo/Math.pow(10,16);
            countDados++;
        }
        return dados;
    }
    
    public double getcode(){
        return this.code;
    }
    
    public Vector<Byte> getdata(){
        return this.data;
    }
    
    public void imprime_data(){
        Vector<Byte> array = this.getdata();
        byte byteAtual = 0;
        for(int a = 0; a < array.size(); a++){
            byteAtual = array.get(a);
            System.out.println(byteAtual + " " + (char)byteAtual);        
        }
    }    
}
