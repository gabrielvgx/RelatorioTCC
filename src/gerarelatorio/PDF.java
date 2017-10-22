/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerarelatorio;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Familia
 */
public class PDF implements Documento {

    public PDF() {

    }

    @Override
    public void addTitulo(String titulo, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addImagem(Object img, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addGrafico(Object grafico, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTexto(String texto, int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void gerarDocumento() {
        Document doc = new Document();
        try {
            //PdfWriter.getInstance(doc, new FileOutputStream("documento.pdf"));
            PdfWriter escritor = PdfWriter.getInstance(doc, new FileOutputStream("documento.pdf"));
            doc.open();
            for (int i = 0; i < 50; i++) {
                doc.add(new Paragraph("teste"));
            }
            Image i = Image.getInstance("imagens/img.jpg");
            i.scaleAbsolute(100f, 100f);

            i.setAbsolutePosition(0f, 0f);
            doc.add(i);
            // cria o conjunto de dados
            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            ds.addValue(40.5, "maximo", "dia 1");
            ds.addValue(38.2, "maximo", "dia 2");
            ds.addValue(37.3, "maximo", "dia 3");
            ds.addValue(31.5, "maximo", "dia 4");
            ds.addValue(35.7, "maximo", "dia 5");
            ds.addValue(42.5, "maximo", "dia 6");

// cria o gráfico
            JFreeChart grafico = ChartFactory.createLineChart("Meu Grafico", "Dia",
                    "Valor", ds, PlotOrientation.VERTICAL, true, true, false);
OutputStream arquivo = new FileOutputStream("grafico.png");
ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
            doc.addCreationDate();
            doc.addTitle("Titulo");
            Image graf = Image.getInstance("grafico.png");
            doc.add(graf);
            System.out.println("Nº pag: " + escritor.getPageNumber());
        } catch (DocumentException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            doc.close();
        }

    }

}
