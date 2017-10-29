package DadosTestes;

import java.util.ArrayList;

public class DadosTesteAnimal {
    public static String[] dadosAnimalTabela(){
        String[] dados = {"Nº: 00001","NOME ANIMAL: VACA MIMOSA","SEXO: FÊMEA","BOI TONY","VACA CARINHO",
            "Nº SISBOV: 951521321","NASCIMENTO: 12/07/2002","DESMAMA: 12/02/2003","PESO: 760 KG","IDADE: 15 ANOS",
            "TIPO RAÇA: PURA","PELAGEM: BRANCA","RAÇA: NE-NELORE","LEITE: 9 Litros","REMEDIO: NÃO"};
        return dados;
    }
    public static ArrayList<String> dadosAnimalGraficoCircularNomes(){
        ArrayList<String> dados = new ArrayList<>();
        dados.add("Vaca Mimosa");
        dados.add("Vaca Carinho");
        dados.add("Vaca Sininho");
        dados.add("Vaca Mel");
        return dados;
    }
    public static ArrayList<Double> dadosAnimalGraficoCircularValores(){
        ArrayList<Double> dados = new ArrayList<>();
        dados.add(34.0);
        dados.add(74.0);
        dados.add(84.0);
        dados.add(54.0);
        return dados;
    }
}
