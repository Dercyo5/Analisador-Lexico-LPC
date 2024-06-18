package Controller;

import Model.AnalisadorLexico;
import Model.AnaliseResultados;
import Model.ErrosTokens;
import Model.LexicalException;
import Model.Token;
import View.Compilador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Juvencio Custodio
 */

public class Controller {
    private AnalisadorLexico analisadorLexico;
    private Compilador view;
    private File logFile; // Campo de classe para armazenar o arquivo de log
    private boolean salvo = false;
    private File arquivoSalvo;

    // Método para definir o arquivo de log
    public void setLogFile(File logFile) {
        this.logFile = logFile;
    }

    public Controller(AnalisadorLexico lexicalAnalyzer, Compilador view) {
        this.analisadorLexico = lexicalAnalyzer;
        this.view = view;
    }

    public void analiseCodigoFonte(String sourceCode) {
        if (sourceCode.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo de código vazio, por favor escreva alguma coisa!");
        } else {
            try {
                long startTime = System.currentTimeMillis();
                AnaliseResultados resultado = analisadorLexico.analise(sourceCode);
                List<Token> tokens = resultado.getTokens();
                List<ErrosTokens> erros = resultado.getErros();
                long elapsedTime = System.currentTimeMillis() - startTime;

                // Atualizar o arquivo salvo, se necessário
                if (salvo && arquivoSalvo != null) {
                    atualizarPrograma(sourceCode, arquivoSalvo);
                    JOptionPane.showMessageDialog(null, "Programa atualizado com sucesso!");
                }

                // Exibir os resultados na view
                view.displayTokens(tokens, elapsedTime, erros);
            } catch (LexicalException e) {
                view.displayError(e.getMessage());
            }
        }
    }

    public void atualizarPrograma(String codigoFonte, File arquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            writer.write(codigoFonte);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o programa.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void GuardarPrograma(String codigoFonte, File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(codigoFonte);
            salvo = true;
            arquivoSalvo = file;
            JOptionPane.showMessageDialog(null, "Programa salvo com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o programa.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String CarregarPrograma(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder codigoFonte = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                codigoFonte.append(linha).append("\n");
            }
            salvo = true;
            arquivoSalvo = file;
            return codigoFonte.toString();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao importar o programa.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return "";
    }
}
