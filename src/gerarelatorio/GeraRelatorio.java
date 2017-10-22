/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerarelatorio;

/**
 *
 * @author Familia
 */
public class GeraRelatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PDF documento = new PDF();
        documento.gerarDocumento();
    }
    
}
