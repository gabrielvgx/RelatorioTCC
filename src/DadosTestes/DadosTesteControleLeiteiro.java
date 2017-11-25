package DadosTestes;

import java.util.ArrayList;

public class DadosTesteControleLeiteiro {

    public static String[] nomeColunaTabela() {
        String dados[] = {"ANO", "PRODUCAO ANUAL", "MEDIA MENSAL"};
        return dados;
    }

    public static String[] anoTabela() {
        String[] ano = {"2014", "2015", "2016", "2017"};
        return ano;
    }

    public static ArrayList<String> anoTabelaArrayList() {
        ArrayList<String> ano = new ArrayList<>();
        ano.add("2014");
        ano.add("2015");
        ano.add("2016");
        ano.add("2017");
        return ano;
    }

    public static double[] producaoAnualTabela() {
        double[] producao = {2000.0, 4500.0, 2340, 2100.1};
        return producao;
    }
    public static ArrayList<Double> producaoAnualTabelaArrayList() {
        ArrayList<Double> producao = new ArrayList<>();
        producao.add(2000.0);
        producao.add(4500.0);
        producao.add(2340.0);
        producao.add(2100.1);
        return producao;
    }

    public static double[] mediaMensalTabela() {
        double[] mediaMensal = {200, 400, 150, 210};
        return mediaMensal;
    }

    public static String[] nomeGraficoBarra() {
        String nome[] = {"2014", "2015", "2016", "2017"};
        return nome;
    }

    public static double[] valorGraficoBarra() {
        double[] valores = {2000.0, 4500.0, 2340, 2100.1};
        return valores;
    }

    public static String[] tabela() {
        String[] tabela = {"ANO", "PRODUCAO ANUAL", "MEDIA MENSAL",
            "2014", "2000.0", "200",
            "2015", "4500.0", "400",
            "2016", "2340", "150",
            "2017", "2100.1", "210"};
        return tabela;
    }
}
