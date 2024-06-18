package Model;

/**
 *
 * @author Juvencio Custodio
 */
public class ErrosTokens {
    private String erroLexema;
    private String erroTokenClass;
    private int erroPosicao;

    public ErrosTokens(String erroLexema, String erroTokenClass, int erroPosicao) {
        this.erroLexema = erroLexema;
        this.erroTokenClass = erroTokenClass;
        this.erroPosicao = erroPosicao;
    }

    public String getErroLexema() {
        return erroLexema;
    }

    public String getErroTokenClass() {
        return erroTokenClass;
    }

    public int getErroPosicao() {
        return erroPosicao;
    }

}