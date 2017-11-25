package Imprimir;

import GeraRelatorioPDF.PDF;
import java.awt.Desktop;
import java.io.IOException;
import java.util.List;

public class Imprimir {

    public Imprimir() {
    }

    public static void imprimir(List<? extends PDF> relatorio) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < relatorio.size(); i++) {
                    try {
                        Desktop.getDesktop().print(relatorio.get(i).getArquivo());
                    } catch (IOException ex) {
                        System.out.println("ERRO AO IMPRIMIR " + ex.getMessage());
                    }
                }
            }
        }.start();
    }

    public static void imprimir(PDF relatorio) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Desktop.getDesktop().print(relatorio.getArquivo());
                } catch (IOException ex) {
                    System.out.println("ERRO AO IMPRIMIR "+ex.getMessage());
                }
            }
        }.start();
    }
}
