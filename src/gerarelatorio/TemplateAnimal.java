package gerarelatorio;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

public class TemplateAnimal {
    static Font textoSimples = FontFactory.getFont(FontFactory.TIMES_ROMAN, 13f, Font.NORMAL, BaseColor.BLACK);
    static Font tituloPrincipal = FontFactory.getFont(FontFactory.TIMES_ROMAN, 40f,Font.UNDERLINE, BaseColor.BLACK);
    static Font subTitulo;
}
