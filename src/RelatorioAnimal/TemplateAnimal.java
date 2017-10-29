package RelatorioAnimal;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

public class TemplateAnimal {
    public static String fontePadrao = FontFactory.TIMES_ROMAN;
    public static Font textoSimples = FontFactory.getFont(FontFactory.TIMES_ROMAN,
            13f, Font.NORMAL, BaseColor.BLACK);

    public static Font tituloPrincipal = FontFactory.getFont(FontFactory.TIMES_ROMAN,
            40f, Font.UNDERLINE, BaseColor.BLACK);

    public static Font subTitulo;
    
    public static int nColunasTabela = 3;
}
