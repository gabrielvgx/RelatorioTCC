package InterfaceRelatorio;

import GeraRelatorioPDF.PDF;
import com.itextpdf.text.DocumentException;
import java.io.IOException;

public interface Relatorio {
    public void gerarRelatorio() throws IOException, DocumentException;
    public PDF getRelatorio();
    public void imprimirRelatorio();
}
