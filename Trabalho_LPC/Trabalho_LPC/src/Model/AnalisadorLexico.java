package Model;

import static Controller.WordSplitter.splitBySpace;
/**
 *
 * @author Juvencio Custodio
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalisadorLexico {
    private static final String[] Palavras_Reservadas = {
            "program", "var", "begin", "end", "integer", "char", "boolean", "if", "then", "else", "while", "do", "of", "read",
            "write", "array", "function", "procedure", "true", "false"
    };
    private static final String[] Operadores_Relacionais = {
            "=", "<>", "<", "<=", ">=", ">", "or", "and", "not"
    };
    private static final String[] Operadores_Aritmeticos = {
            "+", "-", "*", "/", ":="
    };

    public AnaliseResultados analise(String codigoFonte) throws LexicalException {
        List<Token> tokens = new ArrayList<>();
        List<ErrosTokens> errosTokens = new ArrayList<>();
        List<String> linhas = splitLines(codigoFonte);

        boolean inComentario = false;
        boolean inString = false;
        StringBuilder stringToken = new StringBuilder();

        for (int i = 0; i < linhas.size(); i++) {
            String linha = linhas.get(i);

            // Remover comentários de linha
            int indiceComentario = linha.indexOf("//");
            if (indiceComentario != -1) {
                linha = linha.substring(0, indiceComentario);
            }

            // Lidar com comentários de várias linhas
            if (inComentario) {
                int indiceFimComentario = linha.indexOf("*/");
                if (indiceFimComentario != -1) {
                    inComentario = false;
                    linha = linha.substring(indiceFimComentario + 2);
                } else {
                    continue; // Ignorar linha se ainda estiver em um comentário
                }
            }

            linha = addSpacesToPunctuation(linha);
            String[] palavras = splitBySpace(linha);

            for (String palavra : palavras) {
                if (inString) {
                    if (palavra.endsWith("'")) {
                        inString = false;
                        stringToken.append(" ").append(palavra.substring(0, palavra.length() - 1));
                        tokens.add(new Token(stringToken.toString(), "String", i + 1));
                        stringToken.setLength(0);
                    } else {
                        stringToken.append(" ").append(palavra);
                    }
                } else if (isPalavraReservada(palavra)) {
                    tokens.add(new Token(palavra, "Reserved Key", i + 1));
                } else if (isOperadorRelacional(palavra)) {
                    tokens.add(new Token(palavra, "Operador relational", i + 1));
                } else if (isOperadorAritmetico(palavra)) {
                    tokens.add(new Token(palavra, "Operator Artmetric", i + 1));
                } else if (isIdentificador(palavra)) {
                    if (isConstanteIdentifier(palavra)) {
                        tokens.add(new Token(palavra, "Identifier const", i + 1));
                    } else {
                        tokens.add(new Token(palavra, "Identifier", i + 1));
                    }
                } else if (isNumber(palavra)) {
                    tokens.add(new Token(palavra, "Number", i + 1));
                } else if (isStringStart(palavra)) {
                    inString = true;
                    stringToken.append(palavra.substring(1));
                } else if (palavra.equals(":=")) {
                    tokens.add(new Token(palavra, "Atribuition", i + 1));
                } else if (palavra.equals("=")) {
                    tokens.add(new Token(palavra, "Equals", i + 1));
                } else if (isCommentStart(palavra)) {
                    if (!palavra.endsWith("*/")) {
                        inComentario = true;
                    }
                } else if (isMethodOrFunction(palavra)) {
                    // Ignorar palavras que contenham parênteses como métodos ou funções
                    continue;
                } else if (!palavra.isEmpty() && !isIgnorable(palavra)) {
                    errosTokens.add(new ErrosTokens(palavra, "Erro, token inválido!", i + 1));
                }
            }
        }

        return new AnaliseResultados(tokens, errosTokens);
    }

    private List<String> splitLines(String codigoFonte) {
        return Arrays.asList(codigoFonte.split("\n"));
    }

    private String addSpacesToPunctuation(String linha) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < linha.length(); i++) {
            char c = linha.charAt(i);
            if (isPunctuation(c)) {
                if (i > 0 && !isInQuotes(linha, i)) {
                    sb.append(" ");
                }
                sb.append(c);
                if (i < linha.length() - 1 && !isInQuotes(linha, i)) {
                    sb.append(" ");
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private boolean isInQuotes(String linha, int indice) {
        boolean inSingleQuotes = false;
        boolean inDoubleQuotes = false;

        for (int i = 0; i < indice; i++) {
            char c = linha.charAt(i);
            if (c == '\'') {
                inSingleQuotes = !inSingleQuotes;
            } else if (c == '"') {
                inDoubleQuotes = !inDoubleQuotes;
            }
        }

        return inSingleQuotes || inDoubleQuotes;
    }

    private boolean isPunctuation(char c) {
        return Character.getType(c) == Character.OTHER_PUNCTUATION;
    }

    private boolean isPalavraReservada(String palavra) {
        for (String keyword : Palavras_Reservadas) {
            if (keyword.equalsIgnoreCase(palavra)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOperadorRelacional(String palavra) {
        for (String operador : Operadores_Relacionais) {
            if (operador.equals(palavra)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOperadorAritmetico(String palavra) {
        for (String operador : Operadores_Aritmeticos) {
            if (operador.equals(palavra)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIdentificador(String palavra) {
        if (palavra.isEmpty() || !Character.isLetter(palavra.charAt(0))) {
            return false;
        }

        for (int i = 1; i < palavra.length(); i++) {
            char c = palavra.charAt(i);
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }

        return true;
    }

    private boolean isNumber(String palavra) {
        if (palavra.isEmpty()) {
            return false;
        }

        for (int i = 0; i < palavra.length(); i++) {
            char currentChar = palavra.charAt(i);
            if (currentChar < '0' || currentChar > '9') {
                return false;
            }
        }

        return true;
    }

    private boolean isStringStart(String palavra) {
        return palavra.startsWith("'") && !palavra.endsWith("'");
    }

    private boolean isCommentStart(String palavra) {
        return palavra.startsWith("/*") && !palavra.endsWith("*/");
    }

    public static boolean isIgnorable(String palavra) {
        return palavra.equals("{") || palavra.equals("}") || palavra.equals(";") || palavra.equals(":") || palavra.equals(",");
    }

    private boolean isConstanteIdentifier(String palavra) {
        if (!isIdentificador(palavra)) {
            return false;
        }

        for (String palavraReservada : Palavras_Reservadas) {
            if (palavraReservada.equalsIgnoreCase(palavra)) {
                return false;
            }
        }

        return true;
    }
    
    public static boolean isMethodOrFunction(String word) {
    // Verifica se a palavra contém parênteses, indicando um método ou função
    int openParenIndex = word.indexOf('(');
    int closeParenIndex = word.indexOf(')');

    if (openParenIndex != -1 && closeParenIndex != -1 && openParenIndex < closeParenIndex) {
        // A palavra contém ambos os parênteses e eles estão na ordem correta
        return true;
    }

    return false;
}

}
