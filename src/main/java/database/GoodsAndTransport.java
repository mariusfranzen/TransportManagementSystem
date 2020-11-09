package database;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import goods.Goods;
import io.github.cdimascio.dotenv.Dotenv;
import org.bson.Document;
import org.bson.UuidRepresentation;

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

    public static void createNewGoods(Goods newGoods){
        goodsCollection.insertOne(newGoods.getAsDocument());
    }

}
