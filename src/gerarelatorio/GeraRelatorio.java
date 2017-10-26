/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerarelatorio;

import com.itextpdf.text.DocumentException;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Familia
 */
public class GeraRelatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        try {
            PDF doc = new PDF();
            File pdf = new File("Resumo_Animal");
            doc.gerarDocumento(pdf.getName());
            doc.addTituloDocumento("Resumo Animal");//String texto, FontFamily fonte, int alinhamento, int tamanho, int estilo, BaseColor cor)
            doc.addTexto("Resumo Animal", TemplateAnimal.tituloPrincipal);
            doc.addTabela(DadosTeste.dadosAnimalTabela(), 3);
            Desktop.getDesktop().open(new File(pdf.getName()+".pdf"));
            System.out.println("PDF gerado com Sucesso!");
            doc.fecharDocumento();
        } catch (IOException | DocumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
