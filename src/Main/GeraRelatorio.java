/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package Main;

import RelatorioAnimal.GerarRelatorioAnimal;
import RelatorioControleLeiteiro.GerarRelatorioControleLeiteiro;
import com.itextpdf.text.DocumentException;
import java.io.IOException;

/**

 @author Familia
 */
public class GeraRelatorio {

    /**
     @param args the command line arguments

     @throws java.io.IOException
     @throws com.itextpdf.text.DocumentException
     */
    public static void main(String[] args) throws IOException, DocumentException {
        GerarRelatorioAnimal a = new GerarRelatorioAnimal();
        GerarRelatorioControleLeiteiro b = new GerarRelatorioControleLeiteiro();
        a.gerarRelatorio();
        b.gerarRelatorio();
    }

}
