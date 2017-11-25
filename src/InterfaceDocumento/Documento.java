/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceDocumento;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Familia
 */
public interface Documento {

    public void gerarDocumento() throws IOException, DocumentException;

    public void gerarDocumento(String nomeDocumento) throws IOException, DocumentException;

    public void addTituloDocumento(String titulo) throws DocumentException;

    public void addImagem(Image img, int alinhamento, float largura, float altura) throws DocumentException;

    public void addTexto(String texto, int alinhamento, int tamanho) throws DocumentException;

    public void addTexto(String texto, int tamanho) throws DocumentException;

    public void addTexto(String texto) throws DocumentException;

    public void addTexto(String texto, Font fonte) throws DocumentException;

    public void addTexto(String texto, Font fonte, int alinhamento) throws DocumentException;

    public void addTexto(String texto, Font.FontFamily fonte, int alinhamento, int tamanho, int estilo, BaseColor cor) throws DocumentException;

    public void addTabela(Paragraph[] celula, int nColunas) throws DocumentException;

    public void addTabela(String[] celula, int nColunas) throws DocumentException;
    
    public void addTabela(Object tabela) throws DocumentException;
    
    public void addGraficoCircular(String tituloGrafico, ArrayList<String> nome, ArrayList<Double> valor,
            int larguraGrafico, int alturaGrafico)
            throws IOException, BadElementException, DocumentException;

    public void addGraficoLinha(String tituloGrafico, String nomeLinha, String nomeColuna, ArrayList<String> nome, 
            ArrayList<String> linha, double[][] valor) throws IOException, BadElementException, DocumentException;

    public void fecharDocumento();
    public File getArquivo();
}
