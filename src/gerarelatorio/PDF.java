/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerarelatorio;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Familia
 */
public class PDF implements Documento {

    private Document doc;
    private PdfWriter escritor;

    public PDF() {

    }

    @Override
    public void gerarDocumento() throws IOException, DocumentException {
        doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("documento.pdf"));
        doc.open();
    }

    @Override
    public void gerarDocumento(String nomeDocumento) throws IOException, DocumentException {
        doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(nomeDocumento + ".pdf"));
        doc.open();
    }

    @Override
    public void addTituloDocumento(String titulo) throws DocumentException {
        doc.addTitle(titulo);
    }

    @Override
    public void addImagem(Image img, int alinhamento, float largura, float altura) throws DocumentException {
        img.scaleAbsolute(largura, altura);
        img.setAlignment(alinhamento);
        doc.add(img);
    }

    @Override
    public void addGrafico(Image grafico, int alinhamento, float largura, float altura) throws DocumentException {
        grafico.scaleAbsolute(largura, altura);
        grafico.setAlignment(alinhamento);
        doc.add(grafico);
    }

    @Override
    public void addTexto(String texto, FontFamily fonte, int alinhamento, int tamanho, int estilo, BaseColor cor) throws DocumentException {
        Paragraph textoParagrafo = new Paragraph(texto, FontFactory.getFont(fonte.name(), tamanho, estilo, cor));
        textoParagrafo.setAlignment(alinhamento);
        doc.add(textoParagrafo);
    }

    public void add() {
        Paragraph p = new Paragraph("Hello", FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new BaseColor(255, 150, 200)));
        p.setAlignment(Element.ALIGN_CENTER);
        try {
            doc.add(p);
        } catch (DocumentException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addTexto(String texto, Font fonte, int alinhamento) throws DocumentException {
        Paragraph textoParagrafo = new Paragraph(texto, fonte);
        textoParagrafo.setAlignment(alinhamento);
        doc.add(textoParagrafo);
    }

    @Override
    public void addTexto(String texto, Font fonte) throws DocumentException {
        Paragraph textoParagrafo = new Paragraph(texto, fonte);

        textoParagrafo.setAlignment(Element.ALIGN_CENTER);
        textoParagrafo.setSpacingBefore(-50f);
        textoParagrafo.setSpacingAfter(50f);
        //   textoParagrafo.setFont(fonte);
        doc.add(textoParagrafo);
    }

    @Override
    public void addTexto(String texto) throws DocumentException {
        Paragraph textoParagrafo = new Paragraph(texto);
        doc.add(textoParagrafo);
    }

    @Override
    public void addTexto(String texto, int tamanho) throws DocumentException {
        Paragraph textoParagrafo = new Paragraph(texto);
        doc.add(textoParagrafo);
    }

    @Override
    public void addTexto(String texto, int alinhamento, int tamanho) throws DocumentException {
        Paragraph textoParagrafo = new Paragraph(texto);
        textoParagrafo.setAlignment(alinhamento);
        doc.add(textoParagrafo);
    }

    @Override
    public void fecharDocumento() {
        doc.close();

    }

    @Override
    public void addTabela(Paragraph[] celula, int nColunas) throws DocumentException {
        PdfPTable tabela = new PdfPTable(nColunas);//Número de colunas
        for (Paragraph paragrafoCelula : celula) {
            tabela.addCell(paragrafoCelula);

        }
        if (tabela.getLastCompletedRowIndex() != tabela.getRows().size()) {
            tabela.completeRow();
        }
        tabela.setTotalWidth(100f);
        tabela.setLockedWidth(true);
        doc.add(tabela);
    }

    @Override
    public void addTabela(String[] celula, int nColunas) throws DocumentException {
        PdfPTable tabela = new PdfPTable(nColunas);
        int i = 0;
        for (String txtCelula : celula) {
            i++;
            Paragraph pr = new Paragraph(txtCelula, TemplateAnimal.textoSimples);
            PdfPCell celulaPDF = new PdfPCell(pr);
            celulaPDF.setBorder(0);
            if (i % 2 == 0) {
                celulaPDF.setColspan(2);
            }
            tabela.setLockedWidth(true);
            tabela.setTotalWidth(550f);
            if (txtCelula.contains("Nº") && !txtCelula.contains("Nº SISBOV")) {
                celulaPDF.setColspan(3);
            }
            celulaPDF.setMinimumHeight(25f);
            tabela.addCell(celulaPDF);
        }

        for (int j = tabela.getRows().size(); j > tabela.getLastCompletedRowIndex(); j--) {
            PdfPCell vazia = new PdfPCell(new Paragraph(""));
            vazia.setBorder(0);
            tabela.addCell(vazia);
        }

        doc.add(tabela);
    }

    @Override
    public void addGraficoCircular(String tituloGrafico, ArrayList<String> nome, ArrayList<Double> valor,
            int larguraGrafico, int alturaGrafico)
            throws IOException, BadElementException, DocumentException {

        DefaultPieDataset data = new DefaultPieDataset();
        for (int i = 0; i < nome.toArray().length; i++) {
            data.setValue("" + nome.get(i), valor.get(i));
        }
        JFreeChart chart = ChartFactory.createPieChart(tituloGrafico,
                data, true, true, true);
        Plot plot = chart.getPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setOutlineVisible(false);
       
        Image graf = graficoPNG(chart, tituloGrafico, larguraGrafico, alturaGrafico);
        graf.setAlignment(Element.ALIGN_CENTER);
        doc.add(graf);

    }

    @Override
    public void addGraficoCircular(String tituloGrafico, ArrayList<String> nome, ArrayList<Double> valor)
            throws IOException, BadElementException, DocumentException {

        DefaultPieDataset data = new DefaultPieDataset();
        for (int i = 0; i < nome.toArray().length; i++) {
            data.setValue(nome.get(i), valor.get(i));
        }
        JFreeChart chart = ChartFactory.createPieChart3D(tituloGrafico,
                data, true, true, true);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setLabelLinksVisible(true);
        plot.setNoDataMessage("Não existem dados para serem exibidos no gráfico");
        plot.setStartAngle(90);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        plot.setInteriorGap(0.20);
        Image graf = graficoPNG(chart, tituloGrafico, 300, 300);
        graf.setAlignment(Element.ALIGN_CENTER);
        doc.add(graf);

    }

    private Image graficoPNG(JFreeChart grafico, String tituloGrafico, int largura, int altura) throws IOException, BadElementException {
        OutputStream arquivo = new FileOutputStream(tituloGrafico + ".png");
        ChartUtilities.writeChartAsPNG(arquivo, grafico, largura, altura);
        Image png = Image.getInstance(tituloGrafico + ".png");
        return png;
    }

    /*
    tituloGrafico: O texto que fica acima do grafico
    nomeLinha: A legenda para o eixo X
    nomeColuna: A legenda para o eixo Y
    nome: Posições no eixo X (Ex: Anos dias)
    linha: O nome das linhas que o grafico contem
    valor: Cada linha da matriz eh uma linha do grafico e cada Coluna eh um valor
    Ex: valor[0][0] é o valor Da linha 1 no primeiro ano;
     */
    @Override
    public void addGraficoLinha(String tituloGrafico, String nomeLinha,
            String nomeColuna, ArrayList<String> nome, ArrayList<String> linha, double[][] valor) throws IOException,
            BadElementException, DocumentException {

        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        for (int i = 0; i < valor.length; i++) {
            for (int j = 0; j < valor[valor.length - 1].length; j++) {
                ds.addValue(valor[i][j], linha.get(i), nome.get(j));
            }
        }
        JFreeChart grafico = ChartFactory.createLineChart(tituloGrafico, nomeLinha,
                nomeColuna, ds, PlotOrientation.VERTICAL, true, false, false);
        CategoryPlot plot = grafico.getCategoryPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setOutlineVisible(false);
        Image png = graficoPNG(grafico, tituloGrafico, 300, 300);
        png.setAlignment(Element.ALIGN_CENTER);
        png.scaleAbsolute(400f, 300f);
        doc.add(png);
    }

}
