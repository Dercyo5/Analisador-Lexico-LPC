package Controller;

/**
 *
 * @author Ilidio Custodio
 */
public class WordSplitter {

    public static String[] splitBySpace(String linha) {
        // Conta quantas palavras existem na linha
        int count = countSpaces(linha) + 1;

        // Inicializa o array com o tamanho adequado
        String[] words = new String[count];

        // Itera sobre a linha para extrair as palavras
        int startIndex = 0;
        for (int i = 0; i < count; i++) {
            int spaceIndex = linha.indexOf(' ', startIndex);
            if (spaceIndex == -1) {
                // Se não houver mais espaços, pega a substring até o fim da linha
                words[i] = linha.substring(startIndex);
            } else {
                // Caso contrário, pega a substring até o espaço
                words[i] = linha.substring(startIndex, spaceIndex);
                startIndex = spaceIndex + 1; // Atualiza o índice inicial para a próxima palavra
            }
        }

        return words;
    }

    public static int countSpaces(String linha) {
        int count = 0;
        for (int i = 0; i < linha.length(); i++) {
            if (linha.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }
}