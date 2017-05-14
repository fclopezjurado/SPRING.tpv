package services;

import static config.ResourceNames.VOUCHERS_PDFS_ROOT;
import static config.ResourceNames.VOUCHER_PDF_FILENAME_ROOT;

import java.text.SimpleDateFormat;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.layout.element.Paragraph;

import entities.core.Voucher;

public class VoucherPdfGenerator extends PdfGenerator<Voucher>{

    public VoucherPdfGenerator(Voucher voucher) {
        super(voucher);
    }

    @Override
    protected String ownPath() {
        return VOUCHERS_PDFS_ROOT + VOUCHER_PDF_FILENAME_ROOT + entity.getId();
    }

    @Override
    protected PageSize ownPageSize() {
        return PageSize.A5;
    }

    @Override
    protected void buildPdf() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        pdfDocument.add(new Paragraph(entity.getReference()));
        pdfDocument.add(new Paragraph(entity.getValue().toPlainString()));
        pdfDocument.add(new Paragraph(formatter.format(entity.getCreated().getTime())));
        pdfDocument.add(new Paragraph(formatter.format(entity.getDateOfUse().getTime())));
    }

}
