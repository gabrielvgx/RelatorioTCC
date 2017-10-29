package RelatorioAnimal;

import DadosTestes.DadosTesteAnimal;
import GeraRelatorioPDF.PDF;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.IOException;

public class GerarRelatorioAnimal {
    private PDF relatorioAnimal;
    private PdfPTable getTabelaDados(){
        PdfPTable tabela = new PdfPTable(TemplateAnimal.nColunasTabela);
        int i = 0;
        for (String txtCelula : DadosTesteAnimal.dadosAnimalTabela()) {
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
        
        return tabela;
    }
    public void criarRelatorio() throws IOException, DocumentException{
        relatorioAnimal = new PDF();
        relatorioAnimal.gerarDocumento("Resumo Animal");
        relatorioAnimal.addTitulo("Relatorio Animal", TemplateAnimal.tituloPrincipal, Element.ALIGN_CENTER);
        relatorioAnimal.addTabela(getTabelaDados());
        relatorioAnimal.addGraficoCircular("Produção de Leite", 
                DadosTesteAnimal.dadosAnimalGraficoCircularNomes(), DadosTesteAnimal.dadosAnimalGraficoCircularValores(),
                500, 400);
        relatorioAnimal.fecharDocumento();
    }
}
