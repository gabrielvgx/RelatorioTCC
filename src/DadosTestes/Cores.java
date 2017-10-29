package DadosTestes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Cores {
    private static List<Color> cores = new ArrayList<>();
    public static List<Color> getCores(){
        carregarCores();
        return cores;
    }
    private static void carregarCores(){
      cores.add(new Color(40, 130, 185)); 
      cores.add(new Color(200, 160, 40)); 
      cores.add(new Color(242, 173, 53)); 
      cores.add(new Color(173, 255, 47)); 
      cores.add(new Color(153, 102, 204)); 
      cores.add(new Color(123, 160, 91)); 
      cores.add(new Color(5, 79, 119)); 
      cores.add(new Color(128, 0, 0)); 
      cores.add(new Color(255, 127, 80)); 
      cores.add(new Color(240, 128, 128)); 
      cores.add(new Color(218, 165, 32)); 
      cores.add(new Color(255, 36, 0, 8)); 
      cores.add(new Color(33, 36, 31)); 
      cores.add(new Color(80, 200, 120)); 
      cores.add(new Color(85, 107, 47)); 
      cores.add(new Color(15, 77, 146)); 
    }
    
    public static void embaralharCores(){
        Collections.shuffle(cores);
    }
}
