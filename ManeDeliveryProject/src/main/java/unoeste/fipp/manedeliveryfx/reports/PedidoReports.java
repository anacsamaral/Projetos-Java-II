package unoeste.fipp.manedeliveryfx.reports;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import unoeste.fipp.manedeliveryfx.db.entidades.Pedido;

import java.awt.*;
import java.io.File;
import java.util.List;

public class PedidoReports {
    public static void relPedidos(List<Pedido> pedidoList){
        String dest = "pedidos.pdf";
        PdfWriter writer = null;
        try {
            writer = new PdfWriter(dest);

            PdfDocument pdf = new PdfDocument(writer);
            Document doc = new Document(pdf);

            PdfFont fonteTitulo = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
            Text titulo = new Text("Relatório de Pedidos");
            titulo.setFont(fonteTitulo);
            titulo.setFontSize(32);

            Paragraph paragraph = new Paragraph(titulo);
            doc.add(paragraph);

            float[] pointColumnWidths = {40F, 140F, 80F, 60F, 60F, 100F, 80F};
            Table table = new Table(pointColumnWidths);

            // Cabeçalhos
            table.addCell(new Cell().add("ID").setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add("Cliente").setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add("Data").setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add("Entregue").setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add("Total").setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add("Pagamento").setBackgroundColor(Color.LIGHT_GRAY));
            table.addCell(new Cell().add("Endereço").setBackgroundColor(Color.LIGHT_GRAY));

            // Linhas da tabela
            for (Pedido p : pedidoList) {
                table.addCell(new Cell().add(String.valueOf(p.getId())));
                table.addCell(new Cell().add(p.getNomeCliente() + "\n" + p.getFoneCliente()));
                table.addCell(new Cell().add(p.getData().toString()));
                table.addCell(new Cell().add(p.getEntregue().equalsIgnoreCase("S") ? "Sim" : "Não"));
                table.addCell(new Cell().add(String.format("R$ %.2f", p.getTotal())));
                table.addCell(new Cell().add(p.getTipoPagamento() != null ? p.getTipoPagamento().getNome() : "-"));
                table.addCell(new Cell().add(p.getLocal() + ", nº " + p.getNumero()));
            }
            doc.add(table);
            doc.close();

            Desktop.getDesktop().open(new File(dest));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


