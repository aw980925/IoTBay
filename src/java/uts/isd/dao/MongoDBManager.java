package uts.isd.dao;

 

import com.mongodb.BasicDBObject;

import java.util.ArrayList;

import uts.isd.model.*;

 

import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoCursor;

import com.mongodb.client.model.Filters;

 

import static com.mongodb.client.model.Filters.*;

import com.mongodb.client.model.Updates;

import java.util.Iterator;

import java.util.List;

import java.util.function.Consumer;

import org.bson.Document;

import org.bson.conversions.Bson;

 

/**

 * @author George Connect to MongoDB Atlas and perform CRUD operations

 * https://docs.mongodb.com/drivers/java/ [Java MongoDB Connection]

 * https://mvnrepository.com/ [JAR Repository]

 *

 */

public class MongoDBManager extends MongoDB {

 

    private MongoCollection collection;

    

   public MongoDBManager() {

        super( " < your- username>  ", " <your-password> ", "<the-role>", "<the database>  " );

    }

 

    public MongoDBManager(String owner, String password, String role, String db) {

        super(owner, password, role, db);

    }

 

    public void connect(String name) {

        this.collection = super.database.getCollection(name);

    }

 

    //Create operation

    public void create(<use the proper parameters for your labs project>) {

            ////Insert the code for create operation

    }

 

     //Read operation

    public void read( <use the proper parameters for your labs project> ) {

           ////Insert the code for read operation

    }

 

     //Update Operation

    public void update( <use the proper parameters for your labs project> ) {

            ////Insert the code for update operation

    }

 

    //Delete operation

    public void delete( <use the proper parameters for your labs project> ) {

           ////Insert the code for delete operation

    }

 

     //View a collection data as Json format – Fetch All

    public void showCollection() {

        PrettyJson.printJSON(this.collection.find().iterator().next());

 

        /* Method 2

            MongoCursor cursor = this.collection.find().iterator();

            while (cursor.hasNext()) {

                PrettyJson.printJSON(cursor.next());

            }

         */

          /* Method 3

            this.collection.find().forEach(new Consumer () {

            @Override

            public void accept(Document doc) {

                PrettyJson.printJSON(doc);

            }

            });

         */

    }

}