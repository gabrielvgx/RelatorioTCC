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
public interface Documento {

    public void addTitulo(String titulo, int x, int y);

    public void addImagem(Object img, int x, int y);

    public void addGrafico(Object grafico, int x, int y);

    public void addTexto(String texto, int x, int y);

    public void gerarDocumento();
}
