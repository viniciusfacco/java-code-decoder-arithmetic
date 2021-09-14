package code_decode;

public class ItemTabela {
    private byte character;
    private int vezes;
    private double probabilidade;
    private double limiteInferior;
    private double limiteSuperior;
    private double delta;

    public ItemTabela(byte character, int vezes) {
        this.character = character;
        this.vezes = vezes;
    }
    public void atualizaProbabilidade(double probabilidade){
        this.probabilidade = probabilidade*vezes;
    }

    public void setCharacter(byte character) {
        this.character = character;
    }

    public void setLimiteInferior(double limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public void setLimiteSuperior(double limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public void setProbabilidade(double probabilidade) {
        this.probabilidade = probabilidade;
    }

    public void setVezes(int vezes) {
        this.vezes = vezes;
    }

    public byte getCharacter() {
        return character;
    }

    public double getLimiteInferior() {
        return limiteInferior;
    }

    public double getLimiteSuperior() {
        return limiteSuperior;
    }

    public double getProbabilidade() {
        return probabilidade;
    }

    public int getVezes() {
        return vezes;
    }
}
