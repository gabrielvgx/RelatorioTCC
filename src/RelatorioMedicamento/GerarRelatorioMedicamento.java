package RelatorioMedicamento;

import GeraRelatorioPDF.PDF;
import Imprimir.Imprimir;
import InterfaceRelatorio.Relatorio;
import com.itextpdf.text.DocumentException;
import java.io.IOException;

public class GerarRelatorioMedicamento implements Relatorio {

    private PDF relatorio;

    @Override
    public void gerarRelatorio() throws IOException, DocumentException {
        relatorio = new PDF();
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
