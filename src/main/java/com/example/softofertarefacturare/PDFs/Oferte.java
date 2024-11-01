package com.example.softofertarefacturare.PDFs;


import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Oferte {

    LocalDate datacurenta = LocalDate.now();
    private int nr_factura;



    private int citesteNrFacturaDinFisier() {
        int nr_factura =0;
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\maria\\OneDrive\\Desktop\\facultate si proiecte\\oop\\proiect 3\\src\\main\\java\\com\\example\\softofertarefacturare\\PDFs\\nrFactura"))) {
            nr_factura = Integer.parseInt(reader.readLine());
            System.out.println(nr_factura);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Fișierul nu există sau numărul este invalid. Se va folosi valoarea implicită.");
        }
        return nr_factura;
    }


    private void scrieNrFacturaInFisier(int nr_factura) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\maria\\OneDrive\\Desktop\\facultate si proiecte\\oop\\proiect 3\\src\\main\\java\\com\\example\\softofertarefacturare\\PDFs\\nrFactura"))) {
            writer.write(String.valueOf(nr_factura));
        } catch (IOException e) {
            System.out.println("Nu s-a putut scrie în fișier: " + e.getMessage());
        }
    }


    public void creare_factura() {
        try {

            int nr_factura_curent = citesteNrFacturaDinFisier();
            scrieNrFacturaInFisier(nr_factura_curent + 1);

            String path = "factura.pdf";
            PdfWriter pdfWriter = new PdfWriter(path);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A4);

            Document document = new Document(pdfDocument);



            float sevencol=190f;
            float sixcol=190f;
            float fivecol=190f;
            float fourcol=190f;
            float threecol = 190f;
            float twocol = 285f;
            float twocol150 = twocol + 150f;
            float two_column_width[] = {twocol150, twocol};
            float three_col_width[] = {threecol, threecol, threecol};
            float seven_col_width[] = {threecol, threecol, threecol,fourcol,fivecol,sixcol,sevencol};
            float fullWidth[] = {threecol * 3};
            Paragraph onesp = new Paragraph("\n");


            Table table = new Table(two_column_width);
            table.addCell(new Cell().add(new Paragraph("Factura")).setFontSize(20f).setBorder(Border.NO_BORDER).setBold());
            Table impartit = new Table(new float[]{twocol / 2, twocol / 2});
            impartit.addCell(get_header_text_cell("Nr. facturii: ").setBorder(Border.NO_BORDER));
            impartit.addCell(get_header_text_cell_value(String.format("%d", nr_factura_curent)).setBorder(Border.NO_BORDER));

            impartit.addCell(get_header_text_cell("Data facturii: ").setBorder(Border.NO_BORDER));
            impartit.addCell(get_header_text_cell_value(String.valueOf(datacurenta)).setBorder(Border.NO_BORDER));


            table.addCell(new Cell().add(impartit).setBorder(Border.NO_BORDER));



            Table table2=new Table(fullWidth);

            table2.addCell(new Cell().add(new Paragraph("Conform oferta de pret nr. .... din data (data de pe oferta)")).setFontSize(7f).setBorder(Border.NO_BORDER));


            Border gb = new SolidBorder(ColorConstants.GRAY, 1f / 2f);
            Table divider = new Table(fullWidth);
            divider.setBorder(gb);


            document.add(table);
            document.add(table2);
            document.add(onesp);
            document.add(divider);
            document.add(onesp);

            Table two_col_table = new Table(two_column_width);
            two_col_table.addCell(get_billing_and_shipping_cell("Informatii de facturare"));
            two_col_table.addCell(get_billing_and_shipping_cell("Informatii de livrare"));


            document.add(two_col_table.setMarginBottom(12f));


            Table two_col_table2 = new Table(two_column_width);
            two_col_table2.addCell(get_cell_10f_left("Companie", true));
            two_col_table2.addCell(get_cell_10f_left("Nume", true));
            two_col_table2.addCell(get_cell_10f_left(" CONSTRUCTII METALICE PE GUSTUL TAU SRL", false));
            two_col_table2.addCell(get_cell_10f_left("", false));


            document.add(two_col_table2);

            Table two_col_table3 = new Table(two_column_width);
            two_col_table3.addCell(get_cell_10f_left("CIF", true));
            two_col_table3.addCell(get_cell_10f_left("Adresa", true));
            two_col_table3.addCell(get_cell_10f_left("46761328", false));
            two_col_table3.addCell(get_cell_10f_left("", false));


            document.add(two_col_table3);


            Table two_col_table4 = new Table(two_column_width);

            two_col_table4.addCell(get_cell_10f_left("Adresa", true));
            two_col_table4.addCell(get_cell_10f_left(" Nr. de telefon", true));
            two_col_table4.addCell(get_cell_10f_left("Mun. Reghin, str. Iernuțeni nr. 120, Hală Metarox, jud. Mures", false));
            two_col_table4.addCell(get_cell_10f_left(" 0712345678 ", false));


            document.add(two_col_table4);


            float one_col_width[] = {twocol150};

            Table one_col_table1 = new Table(one_col_width);
            one_col_table1.addCell(get_cell_10f_left("Reg.com", true));
            one_col_table1.addCell(get_cell_10f_left("J26/1651/2022", false));


            document.add(one_col_table1.setMarginBottom(10f));


            Table table_divider2 = new Table(fullWidth);

            Border dgb = new DashedBorder(ColorConstants.GRAY, 0.5f);

            document.add(table_divider2.setBorder(dgb));

            Paragraph produsParagraf = new Paragraph("Produse");

            document.add(produsParagraf.setBold());

            Table seven_col_table1 = new Table(seven_col_width);
            seven_col_table1.setBackgroundColor(ColorConstants.BLUE, 0.7f);

            seven_col_table1.addCell(new Cell().add(new Paragraph("Descriere")).setBorder(Border.NO_BORDER).setBold().setFontColor(ColorConstants.WHITE));
            seven_col_table1.addCell(new Cell().add(new Paragraph("U.M.")).setBorder(Border.NO_BORDER).setBold().setFontColor(ColorConstants.WHITE));
            seven_col_table1.addCell(new Cell().add(new Paragraph("Cant.")).setBorder(Border.NO_BORDER).setBold().setFontColor(ColorConstants.WHITE));
            seven_col_table1.addCell(new Cell().add(new Paragraph("Pret unitar")).setBorder(Border.NO_BORDER).setBold().setFontColor(ColorConstants.WHITE));
            seven_col_table1.addCell(new Cell().add(new Paragraph("Valoare              (fara tva)")).setBorder(Border.NO_BORDER).setBold().setFontColor(ColorConstants.WHITE));
            seven_col_table1.addCell(new Cell().add(new Paragraph("Cota TVA")).setBorder(Border.NO_BORDER).setBold().setFontColor(ColorConstants.WHITE));
            seven_col_table1.addCell(new Cell().add(new Paragraph("Valoare TVA")).setBorder(Border.NO_BORDER).setBold().setFontColor(ColorConstants.WHITE));


            document.add(seven_col_table1);

            Table seven_col_table2 = new Table(seven_col_width);


           /* if (produse != null) {
                for (Tip_produs produs : produse) {
                    if (produs != null) {


                        three_col_table2.addCell(new Cell().add(new Paragraph(produs.getCategorie())).setBorder(Border.NO_BORDER).setMarginLeft(10f));
                        three_col_table2.addCell(new Cell().add(new Paragraph(produs.getMarime())).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
                        three_col_table2.addCell(new Cell().add(new Paragraph(String.format("%.2f", produs.getPret()))).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
                    } else {
                        three_col_table2.addCell(new Cell().add(new Paragraph("Nu exista produse")).setBorder(Border.NO_BORDER));
                        three_col_table2.addCell(new Cell().add(new Paragraph("Nu exista produse")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER));
                        three_col_table2.addCell(new Cell().add(new Paragraph("Nu exista produse")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
                    }
                }*/
            document.add(seven_col_table2.setMarginBottom(20f));
            // }


            float onetwo[] = {threecol + 125f, threecol * 2};
            Table three_col_table4 = new Table(onetwo);
            three_col_table4.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
            three_col_table4.addCell(new Cell().add(table_divider2).setBorder(Border.NO_BORDER));
            document.add(three_col_table4.setBorder(Border.NO_BORDER));

            // int cantitate = cos_cumparaturi.cantitate_cos;

            Table three_col_table3 = new Table(three_col_width);
            three_col_table3.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER).setMarginLeft(10f));
            three_col_table3.addCell((new Cell().add(new Paragraph("Total prod:")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)));
            three_col_table3.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(String.valueOf(/*cantitate + */" buc"))).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT).setMarginRight(15f));

            three_col_table3.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER).setMarginLeft(10f));
            three_col_table3.addCell((new Cell().add(new Paragraph("Total cost(fara tva):")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)));
            three_col_table3.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(String.valueOf(/*cos_cumparaturi.total_cost() + */" LEI"))).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT).setMarginRight(15f));

            three_col_table3.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER).setMarginLeft(10f));
            three_col_table3.addCell((new Cell().add(new Paragraph("Total cost(cu tva):")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.CENTER)));
            three_col_table3.addCell(new Cell().setBorder(Border.NO_BORDER).add(new Paragraph(String.valueOf(/*cos_cumparaturi.total_cost() + */" LEI"))).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT).setMarginRight(15f));


            document.add(three_col_table3);

            document.add(table_divider2);
            document.add(new Paragraph("\n"));
            document.add(divider.setBorder(new SolidBorder(ColorConstants.GRAY, 1)).setMarginBottom(15f));


            Table tb = new Table(fullWidth);
            tb.addCell(new Cell().add(new Paragraph("Termeni si conditii:")).setBorder(Border.NO_BORDER).setBold());
            List<String> TncList = new ArrayList<>();
            TncList.add("1. Colectam date personale (nume, adresa, date bancare) pentru procesarea si livrarea comenzilor, in conformitate cu legislatia in vigoare.");
            TncList.add("2. Livrarea se face prin curier, cu costuri variabile. Livrare gratuita pentru comenzi peste o anumita suma. Termenul estimat este de 7 zile. Livram în Romania si international, cu transparenta privind taxe si termene.");
            TncList.add("3. Retur în termen de 14 zile fara justificare. Costurile de retur sunt suportate de client, cu exceptia erorilor magazinului. Anumite produse nu pot fi returnate.");
            TncList.add("4. Preturile pot fi modificate in orice moment in functie de piata. Schimbarile vor fi afisate pe site.");
            TncList.add("5. Toate drepturile asupra continutului si marcilor apartin companiei. Utilizarea este permisa doar pentru uz personal.");


            for (String tnc : TncList) {
                tb.addCell(new Cell().add(new Paragraph(tnc)).setBorder(Border.NO_BORDER));
            }

            document.add(tb);


            document.close();

            System.out.println(" Factura a fost eliberata, va rugam sa o verificati cu atentie! ");
        } catch (IOException e) {

            System.out.println(" Eroare!" + e.getMessage());
            e.printStackTrace();
        }

    }

    static Cell get_header_text_cell(String textValue) {

        return new Cell().add(new Paragraph(textValue).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

    }

    static Cell get_header_text_cell_value(String textValue) {

        return new Cell().add(new Paragraph(textValue).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));

    }

    static Cell get_billing_and_shipping_cell(String textValue) {

        return new Cell().add(new Paragraph(textValue)).setFontSize(12f).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);

    }

    static Cell get_cell_10f_left(String textValue, boolean isBold) {

        Cell myCell = new Cell().add(new Paragraph(textValue)).setFontSize(10f).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
        return isBold ? myCell.setBold() : myCell;

    }


}

