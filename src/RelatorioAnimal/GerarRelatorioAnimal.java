package RelatorioAnimal;

import DadosTestes.DadosTesteAnimal;
import GeraRelatorioPDF.PDF;
import Imprimir.Imprimir;
import InterfaceRelatorio.Relatorio;
import TemplateRelatorio.Template;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.IOException;

public class GerarRelatorioAnimal implements Relatorio {

    private PDF relatorio;

    private PdfPTable getTabelaDados() {
        PdfPTable tabela = new PdfPTable(Template.NUMERO_COLUNAS_TABELA);
        int i = 0;
        for (String txtCelula : DadosTesteAnimal.dadosAnimalTabela()) {
            i++;
            Paragraph pr = new Paragraph(txtCelula, Template.TEXTO_SIMPLES);
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
        
        return tabela;
    }

    @Override
    public void gerarRelatorio() throws IOException, DocumentException {
        relatorio = new PDF();
        relatorio.gerarDocumento("Resumo Animal");
        relatorio.addTitulo("Relatorio Animal", Template.TITULO_PRINCIPAL, Element.ALIGN_CENTER);
        relatorio.addTabela(getTabelaDados());
        relatorio.addGraficoCircular("Produção de Leite",
                DadosTesteAnimal.dadosAnimalGraficoCircularNomes(), DadosTesteAnimal.dadosAnimalGraficoCircularValores(),
                500, 400);
        relatorio.fecharDocumento();
    }

    @Override
    public PDF getRelatorio() {
        return relatorio;
    }

    @Override
    public void imprimirRelatorio() {
        Imprimir.imprimir(relatorio);
    }
}
