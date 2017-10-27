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
import java.util.ArrayList;

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
            ArrayList a = new ArrayList();
            ArrayList<Double> b = new ArrayList<>();
            ArrayList<String> nomes = new ArrayList<>();
            a.add("Grupo 1");
            a.add("Grupo 2");
            a.add("Grupo 3");
            a.add("Grupo 4");
            a.add("Grupo 5");
            b.add(13.5);
            b.add(33.2);
            b.add(13.5);
            b.add(25.3);
            b.add(28.0);
            nomes.add("2 Anos");
            nomes.add("6 Anos");
            nomes.add("10 Anos");
            nomes.add("14 Anos");
            ArrayList<String> linhas = new ArrayList<>();
            linhas.add("Litros de Leite");
            double[][] valor = new double[1][4];
            valor[0][0] = 10.0;
            valor[0][1] = 15.0;
            valor[0][2] = 13.0;
            valor[0][3] =  9.0;
            
            doc.addGraficoCircular("Produção de Leite", a, b,400,300);
            doc.addGraficoLinha("Produção de Leite_Idade", "Anos de Vida", "Produção de Leite(L)", nomes, linhas, valor);
            Desktop.getDesktop().open(new File(pdf.getName()+".pdf"));
            System.out.println("PDF gerado com Sucesso!");
            doc.fecharDocumento();
        } catch (IOException | DocumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
