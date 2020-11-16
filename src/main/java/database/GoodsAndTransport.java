package database;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import customer.Ticket;
import goods.Goods;
import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;
import org.bson.UuidRepresentation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Marius on 2020-11-09.
 * @version %I%, %G%
 */
public class GoodsAndTransport {

    private static Dotenv dotenv = Dotenv.load();
    private static ConnectionString uri = new ConnectionString(dotenv.get("CONNECTION_STRING"));
    private static MongoClientSettings settings = MongoClientSettings.builder()
            .uuidRepresentation(UuidRepresentation.STANDARD)
            .applyConnectionString(uri)
            .retryWrites(true)
            .build();
    private static MongoClient mongoClient = MongoClients.create(settings);
    private static MongoDatabase database = mongoClient.getDatabase("app");
    private static MongoCollection<Document> goodsCollection = database.getCollection("goods");
    private static MongoCollection<Document> transportCollection = database.getCollection("transport");

    public static void createNewGoods(Goods newGoods) throws FileNotFoundException, DocumentException {
        if (goodsCollection.insertOne(newGoods.getAsDocument()).wasAcknowledged()){
            com.itextpdf.text.Document receipt = new com.itextpdf.text.Document();
            PdfWriter.getInstance(receipt, new FileOutputStream("GoodsReceipt_" + newGoods.getShippingId().toString() + ".pdf"));

            receipt.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);
            receipt.add(new Chunk("Shipping receipt for " + newGoods.getShippingId().toString(), font));

            receipt.close();
        }
    }

    public static void createNewTransportTicket(Ticket newTicket) throws FileNotFoundException, DocumentException {
        if (transportCollection.insertOne(newTicket.getAsDocument()).wasAcknowledged()) {
            com.itextpdf.text.Document ticket = new com.itextpdf.text.Document();
            PdfWriter.getInstance(ticket, new FileOutputStream("GoodsReceipt_" + newTicket.getTicketId().toString() + ".pdf"));

            ticket.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);
            ticket.add(new Chunk("Ticket ID: " + newTicket.getTicketId().toString(), font));

            ticket.close();
        }
    }

}
