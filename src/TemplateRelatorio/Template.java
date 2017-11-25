package TemplateRelatorio;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

public final class Template {

    public static final String FONTE_PADRAO = FontFactory.TIMES_ROMAN;
    
    public static final Font TEXTO_SIMPLES = FontFactory.getFont(FontFactory.TIMES_ROMAN,
            13f, Font.NORMAL, BaseColor.BLACK);

    public static final Font TITULO_PRINCIPAL = FontFactory.getFont(FontFactory.TIMES_ROMAN,
            40f, Font.UNDERLINE, BaseColor.BLACK);

    public static final Font SUB_TITULO = FontFactory.getFont(FontFactory.TIMES, 20f, Font.NORMAL, BaseColor.BLACK);

    public static final int NUMERO_COLUNAS_TABELA = 3;
    
    public static final int ALINHAMENTO_TITULO_PRINCIPAL = Element.ALIGN_CENTER;
}
