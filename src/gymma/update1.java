/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymma;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;
import java.util.Arrays;
/**
 *
 * @author PRATIK-laptop
 */
public class update1 {
    public static void main( String args[] ) {
	
      try{   
		
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
			
         // Now connect to your databases
         DB db = mongoClient.getDB( "gym" );
         System.out.println("Connect to database successfully");
			

			
         DBCollection collection = db.getCollection("entry");
         System.out.println("Collection mycol selected successfully");
			
         DBCursor cursor = collection.find();
			
         while (cursor.hasNext()) { 
            DBObject updateDocument = cursor.next();
            updateDocument.put("likes","200");
            collection.update(updateDocument, updateDocument); 
         }
			
         System.out.println("Document updated successfully");
         cursor = collection.find();
			
         int i = 1;
			
         while (cursor.hasNext()) { 
            System.out.println("Updated Document: "+i); 
            System.out.println(cursor.next()); 
            i++;
         }
			
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
   }
    
}
