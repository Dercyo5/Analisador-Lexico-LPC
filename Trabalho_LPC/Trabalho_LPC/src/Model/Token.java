package Model;

/**
 *
 * @author Juvencio Custodio
 */
public class Token {
    private String lexema;
    private String tokenClass;
    private int posicao;

    public Token(String lexema, String tokenClass, int posicao) {
        this.lexema = lexema;
        this.tokenClass = tokenClass;
        this.posicao = posicao;
    }

    public String getLexema() {
        return lexema;
    }

    public String getTokenClass() {
        return tokenClass;
    }

    public int getPosicao() {
        return posicao;
    }

}