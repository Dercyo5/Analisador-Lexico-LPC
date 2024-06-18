package Model;

import java.util.List;

/**
 *
 * @author Juvencio Custodio
 */
public class LexicalException extends Exception{
    private List<ErrosTokens> erroTokens;
    
    public LexicalException(String message) {
        super(message);
    }

    public LexicalException(String message, List<ErrosTokens> erroTokens) {
        super(message);
        this.erroTokens = erroTokens;
    }

    public List<ErrosTokens> getErroTokens() {
        return erroTokens;
    }
}