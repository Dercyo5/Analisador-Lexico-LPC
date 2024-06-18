package Model;

import java.util.List;

/**
 *
 * @author Ilidio Custodio
 */
public class AnaliseResultados {
    private List<Token> tokens;
    private List<ErrosTokens> erros;

    public AnaliseResultados(List<Token> tokens, List<ErrosTokens> erros) {
        this.tokens = tokens;
        this.erros = erros;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public List<ErrosTokens> getErros() {
        return erros;
    }
}