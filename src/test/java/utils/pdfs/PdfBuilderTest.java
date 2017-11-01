package utils.pdfs;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class PdfBuilderTest {

    @Test
    public void testBuildTicket() {
        PdfBuilder pdf = new PdfBuilder("/test/ticket").pageTermic();
        pdf.addImage("logo_upm.jpg");
        pdf.paragraphEmphasized("Tfno: 666.666.666").paragraph("NIF: 12345678Z")
                .paragraph("Campus Sur UPM, Calle Nikola Tesla, s/n, 28031 Madrid");

        pdf.barCode("201707083").separator();
        pdf.paragraphEmphasized(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar.getInstance().getTime()));
        pdf.valuesTable(20, 85, 20, 30, 40, 15).tableHeader(" ", "Desc.", "Ud.", "Dto.", "€", "E.");
        pdf.tableCell("1", "Articulo 2345", "1", "10%", "99,45€", "");
        pdf.tableCell("2", "Articulo 234876", "3", "10%", "99,45€", "No");
        pdf.tableCell("3", "Articulo 433", "2", "10%", "22,45€", "");
        pdf.tableCell("4", "Articulo 232245", "1", "10%", "99,45€", "");
        pdf.tableCell("5", "Articulo 553", "3", "10%", "99,45€", "No");
        pdf.tableCell("6", "Articulo 335", "2", "10%", "22,45€", "");
        pdf.tableColspanRight("TOTAL: 234,34€").separator();

        pdf.paragraph("Periodo de devolución o cambio: 15 dias a partir de la fecha del ticket");
        pdf.paragraphEmphasized("Gracias por su compra");
        pdf.qrCode("GasRd5jfTgGGt4fDeSW3");

        pdf.build();
    }

    @Test
    public void testBuildInvoice() {
        PdfBuilder pdf = new PdfBuilder("/test/invoice").pageTermic();
        pdf.header("logo_upm.jpg", "UPM" + "\n" + "NIF: 12345678Z" + "\n" + "Calle Alan Turing s/n, 28031 Madrid");
        pdf.header(
                "Factura Nº: 2017/3" + "       " + new SimpleDateFormat("dd 'de' MMM 'de' yyyy").format(Calendar.getInstance().getTime()));
        pdf.separator();
        pdf.header("Jesús García Gómez" + "\n" + "NIF: 12345678Z" + "\n" + "Calle de Miw, 28031 Madrid").separator();
        pdf.valuesTable(20, 85, 20, 30, 40).tableHeader(" ", "Desc.", "Ud.", "Dto.", "€");
        pdf.tableCell("1", "Articulo 2345", "1", "10%", "99,45€");
        pdf.tableCell("2", "Articulo 234876", "3", "10%", "99,45€");
        pdf.tableCell("3", "Articulo 433", "2", "10%", "22,45€");
        pdf.tableCell("4", "Articulo 232245", "1", "10%", "99,45€");
        pdf.tableCell("5", "Articulo 553", "3", "10%", "99,45€");
        pdf.tableCell("6", "Articulo 335", "2", "10%", "22,45€");
        pdf.tableColspanRight("Base Imponible: 200,01€").tableColspanRight("21% IVA: 34,56€").tableColspanRight("TOTAL: 234,34€")
                .separator();
        pdf.barCode("20173");

        pdf.build();
    }

    @Test
    public void testBuildLabel24a() {
        PdfBuilder pdf = new PdfBuilder("/test/label");
        pdf.prepareTags24();
        pdf.addTag24("Zapato Niño Colegio T25", "0000150250003");
        pdf.addTag24("Zapato Niño Colegio T26", "0000150260002");
        pdf.addTag24("Zapato Niño Colegio T27", "0000150270001");
        pdf.addTag24("Zapato Niño Colegio T27", "0000150270001");
        pdf.addTag24("Zapato Niño Colegio T28", "0000150280000");
        pdf.addTag24("Zapato Niño Colegio T28", "0000150280000");
        pdf.addTag24("Zapato Niño Colegio T28", "0000150280000");
        pdf.addTag24("Zapato Niño Colegio T29", "0000150290009");
        pdf.addTag24("Zapato Niño Colegio T29", "0000150290009");
        pdf.addTag24("Zapato Niño Colegio T29", "0000150290009");

        pdf.addTag24("Zapato Niño Colegio T30", "0000150300005");
        pdf.addTag24("Zapato Niño Colegio T30", "0000150300005");
        pdf.addTag24("Zapato Niño Colegio T30", "0000150300005");
        pdf.addTag24("Zapato Niño Colegio T31", "0000150310004");
        pdf.addTag24("Zapato Niño Colegio T31", "0000150310004");
        pdf.addTag24("Zapato Niño Colegio T31", "0000150310004");
        pdf.addTag24("Zapato Niño Colegio T32", "0000150320003");
        pdf.addTag24("Zapato Niño Colegio T32", "0000150320003");
        pdf.addTag24("Zapato Niño Colegio T32", "0000150320003");
        pdf.addTag24("Zapato Niño Colegio T33", "0000150330002");

        pdf.addTag24("Zapato Niño Colegio T33", "0000150330002");
        pdf.addTag24("Zapato Niño Colegio T33", "0000150330002");
        pdf.addTag24("Zapato Niño Colegio T34", "0000150340001");
        pdf.addTag24("Zapato Niño Colegio T34", "0000150340001");
        pdf.build();
    }
    @Test
    public void testBuildLabel24b() {
        PdfBuilder pdf = new PdfBuilder("/test/label");
        pdf.prepareTags24();
        pdf.addTag24("Zapato Niño Colegio T34", "0000150340001");
        pdf.addTag24("Zapato Niño Colegio T35", "0000150350000");
        pdf.addTag24("Zapato Niño Colegio T35", "0000150350000");
        pdf.addTag24("Zapato Niño Colegio T35", "0000150350000");
        pdf.addTag24("Zapato Niño Colegio T36", "0000150360009");
        pdf.addTag24("Zapato Niño Colegio T36", "0000150360009");
        pdf.addTag24("Zapato Niño Colegio T37", "0000150370008");
        pdf.addTag24("Zapato Niño Colegio T37", "0000150370008");
        pdf.addTag24("Zapato Niño Colegio T38", "0000150380007");
        pdf.addTag24("Zapato Niño Colegio T38", "0000150380007");

        pdf.addTag24("Zapato Niño Colegio T38", "0000150380007");
        pdf.addTag24("Zapato Niño Colegio T39", "0000150390006");
        pdf.addTag24("Zapato Niño Colegio T39", "0000150390006");
        pdf.addTag24("Zapato Niño Colegio T39", "0000150390006");
        pdf.addTag24("Zapato Niño Colegio T40", "0000150400005");
        pdf.addTag24("Zapato Niño Colegio T40", "0000150400005");
        pdf.addTag24("-", null);
        pdf.addTag24("-", null); //Tienen que ser multiplos de 3
        pdf.build();
    }
    @Test
    public void testBuildLabel24c() {
        PdfBuilder pdf = new PdfBuilder("/test/label");
        pdf.prepareTags24();
        pdf.addTag24("Zapato Niña Colegio T24", "8400000151245");
        pdf.addTag24("Zapato Niña Colegio T24", "8400000151245");
        pdf.addTag24("Zapato Niña Colegio T25", "8400000151252");
        pdf.addTag24("Zapato Niña Colegio T25", "8400000151252");
        
        pdf.addTag24("Zapato Niña Colegio T26", "8400000151269");
        pdf.addTag24("Zapato Niña Colegio T26", "8400000151269");
        pdf.addTag24("Zapato Niña Colegio T26", "8400000151269");
        pdf.addTag24("Zapato Niña Colegio T27", "8400000151276");
        pdf.addTag24("Zapato Niña Colegio T27", "8400000151276");
        pdf.addTag24("Zapato Niña Colegio T27", "8400000151276");

        pdf.addTag24("Zapato Niña Colegio T28", "8400000151283");
        pdf.addTag24("Zapato Niña Colegio T28", "8400000151283");
        pdf.addTag24("Zapato Niña Colegio T29", "8400000151290");
        pdf.addTag24("Zapato Niña Colegio T29", "8400000151290");
        pdf.addTag24("Zapato Niña Colegio T30", "8400000151306");
        pdf.addTag24("Zapato Niña Colegio T30", "8400000151306");
        
        pdf.addTag24("Zapato Niña Colegio T31", "8400000151313");
        pdf.addTag24("Zapato Niña Colegio T31", "8400000151313");
        pdf.addTag24("Zapato Niña Colegio T32", "8400000151320");
        pdf.addTag24("Zapato Niña Colegio T32", "8400000151320");

        pdf.addTag24("Zapato Niña Colegio T33", "8400000151337");
        pdf.addTag24("Zapato Niña Colegio T33", "8400000151337");
        pdf.addTag24("Zapato Niña Colegio T33", "8400000151337");
        pdf.addTag24("-", null);
        pdf.build();
    }
    
    @Test
    public void testBuildLabel24d() {
        PdfBuilder pdf = new PdfBuilder("/test/label");
        pdf.prepareTags24();
        pdf.addTag24("Zapato Niña Colegio T34", "8400000151344");
        pdf.addTag24("Zapato Niña Colegio T34", "8400000151344");
        pdf.addTag24("Zapato Niña Colegio T34", "8400000151344");
        
        pdf.addTag24("Zapato Niña Colegio T35", "8400000151351");
        pdf.addTag24("Zapato Niña Colegio T35", "8400000151351");
        pdf.addTag24("Zapato Niña Colegio T36", "8400000151368");
        pdf.addTag24("Zapato Niña Colegio T36", "8400000151368");
        pdf.addTag24("Zapato Niña Colegio T37", "8400000151375");
        pdf.addTag24("Zapato Niña Colegio T37", "8400000151375");
        pdf.build();
    }


}
