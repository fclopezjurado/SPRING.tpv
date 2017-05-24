package services;

import static config.ResourceNames.BARCODES_PDFS_ROOT;
import static config.ResourceNames.BARCODE_PDF;

import java.util.List;

import com.itextpdf.barcodes.BarcodeEAN;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import entities.core.Product;

public class BarcodesPdfGenerator extends PdfGenerator<List<Product>> {
    private static final float DESCRIPTION_SIZE = 7;

    private static final float BARCODE_MARGIN = 5;

    private static final float BARCODE_SIZE = 11.5f;

    private final static float[] BARCODE_COLUMN_WIDTH = new float[] {50.0f, 50.0f, 50.0f, 50.0f};

    public BarcodesPdfGenerator(List<Product> embroideryAndTextile) {
        super(embroideryAndTextile);
    }

    @Override
    protected String ownPath() {
        return BARCODES_PDFS_ROOT + BARCODE_PDF;
    }

    @Override
    protected PageSize ownPageSize() {
        return PageSize.A4;
    }

    @Override
    protected void buildPdf(PdfDocument pdfDocument, Document document) {
        Table table = new Table(BARCODE_COLUMN_WIDTH);
        for (int i = 0; i < entity.size(); i++) {
            Product product = entity.get(i);
            table.addCell(createBarcode(product, pdfDocument));
        }
        document.add(table);
        document.close();
    }

    public static Cell createBarcode(Product product, PdfDocument pdfDocument) {
        BarcodeEAN barcode = new BarcodeEAN(pdfDocument);
        barcode.setCodeType(BarcodeEAN.EAN13);
        barcode.setCode(product.getCode());
        barcode.setX(BARCODE_SIZE / 10);
        barcode.setSize(BARCODE_SIZE);
        barcode.setBaseline(BARCODE_SIZE);
        barcode.setBarHeight(BARCODE_SIZE * 3);

        Cell cell = new Cell();
        cell.setKeepTogether(true);

        Paragraph description = new Paragraph(product.getDescription());
        description.setFontSize(DESCRIPTION_SIZE);
        description.setTextAlignment(TextAlignment.CENTER);

        cell.add(description);
        cell.add(new Image(barcode.createFormXObject(pdfDocument)));
        cell.setMargin(BARCODE_MARGIN);
        return cell;
    }

}
