
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Pavly
 */
 interface Rev{
    public void Array();
    public void Threading();
    public void javaArrayCopy();
}
public class Array_Collections implements Rev{
    @Override
    public void Array(){
        //Array declaration + Array Initializer
        int []arr1=new int[]{ 1 , 2, 3};
        //another form 
        int []arr2={1,2,3};
        //third form
        int []arr3=new int[3];
        arr3[0]=1;
        arr3[1]=2;
        //limit length = 3 with index 2 :-))
        arr3[2]=3;
        
         System.out.println();
        System.out.println("Itrate over a single dimensional array using regular for loop: ");
        //pass over those suckers <for_loop>
        for(int position=0;position<arr1.length;position++){
            System.out.println(arr1[position]);
        }
        //another form using for each ; where number isnot an array , its rather a regualr int to pass over the arr1 
        //<for_each>
         System.out.println();
        System.out.println("Iterate over a single dimensional array using for-each loop : ");
        for(int number :arr1){
            System.out.println(number);
        }
        //multi-diemensional array ; we use two for loops to iterate over the two arrays synchronously
        //1st form
        int [][]arrMulti1=new int [][]{
            {1,2,3},  // main array "rows" 0
            {4,5,6},  //row 1
            {7,8,9},  //row 2
            {10,11,12} //row 3 
        };
        //2nd form note: {last index =size-1 }
        int [][]arrMulti2=new int[4][3];
        
         System.out.println();
        System.out.println("Storing data inside an Array using regular for loop : ");
        int x=0;
        //fill this array form    
        iterateRows:
        //rows<4 not rows<=4 beacuse (last index =size-1)
        for(int rows=0; rows<arrMulti2.length ;rows++){
                iterateColumns_In_Each_Row:
                //arrMulti2[rows].length gets the length of each subArray Synchronously
                for(int columns=0; columns<arrMulti2[rows].length; columns++){
                    arrMulti2[rows][columns]=++x;
            }
        }
        
        
         System.out.println();
        System.out.println("Iterate over the array (arrMulti2) using for each loop : ");
        /**
         * iterate over those suckers
         * 1st mehod using for each loop with inner array & outer array
        */
           //fetch the rows one by one 
        for(int rows[] : arrMulti2){
            //fetch each column data at a specific row as if the row has a array of numbers
            for(int columns:rows ){
                System.out.println(columns);
            }
        }
        
        System.out.println();
        System.out.println("Iterate over the array using regular for loop : ");
        //2nd method using regular for loop
        for(int rows=0;rows<arrMulti1.length;rows++){
            for(int columns=0; columns<arrMulti1[rows].length;  columns++){
                System.out.println(arrMulti1[rows][columns]);
            }
        }
        
        /**
         * another way for the second method
         * for-loop method
         * 
         * getting rows instead of columns
         */
        
        System.out.println();
        System.out.println("Getting rows within a stable column : ");
        for(int columns=0; columns<3; columns++ ){
            for(int rows=0;rows<4;rows++){
                System.out.println(arrMulti1[rows][columns]);
            }
        }
        System.out.println();
        System.out.println("Multi-Dimensional Array 3d Array : ");
        
        //1st form 2"main list" x 2"submain list in each main list" x 3"children of the submain list" 
        int [][][]array3d=new int[][][]{
            {{1,2,3},{4,5,6}} , {{7,8,9},{10,11,12}}
        };
        //passing over the array members
        for(int dimension1=0; dimension1<array3d.length ; dimension1++){
            for(int dimension2=0; dimension2<array3d[dimension1].length; dimension2++){
                for(int dimension3=0; dimension3<array3d[dimension1][dimension2].length; dimension3++){
                    System.out.println(array3d[dimension1][dimension2][dimension3]);
                }
            }
        }
        
        //passing over using for each
        for(int dimension3[][]:array3d){
            for(int dimension2[]:dimension3){
                for(int dimension1:dimension2){
                    System.out.println(dimension1);
                }
            }
        }
        
        System.out.println();
        System.out.println("Multi-Dimensional Array 4d Array : ");
        
        //1st form 
        int [][][][]array4d={
            { { {1,2,3},{4,5,6},{7,8,9} }   ,   { {10,11,12},{13,14,15},{16,17,18} }  }  , { { {19,20,21},{22,23,24},{25,26,27} }   ,   { {28,29,30}}  }    
        };
        //passing over the array using a for loop
        for(int dimension1=0; dimension1<array4d.length; dimension1++){
            for(int dimension2=0; dimension2<array4d[dimension1].length; dimension2++){
                for(int dimension3=0; dimension3<array4d[dimension1][dimension2].length; dimension3++){
                    for(int dimension4=0; dimension4<array4d[dimension1][dimension2][dimension3].length; dimension4++){
                        System.out.print(array4d[dimension1][dimension2][dimension3][dimension4]);
                    }
                }
            }
        }
        //passing over using for each or Enhanced for loop
        for(int dimension1[][][]:array4d){
            for(int dimension2[][]:dimension1){
                for(int dimension3[]:dimension2){
                    for(int dimension4:dimension3){
                        System.out.println(dimension4);
                    }
                }
            }
        }
    }
    
    public void javaArrayCopy(){
        int[][] source = {
              {1, 2, 3, 4}, 
              {5, 6},
              {0, 2, 42, -4, 5}
              };

        int[][] destination = new int[source.length][];

        for (int i = 0; i < source.length; ++i) {

             // allocating space for each row of destination array
             destination[i] = new int[source[i].length];
             System.arraycopy(source[i], 0, destination[i], 0, destination[i].length);
        }
     
        // displaying destination array
        System.out.println(Arrays.deepToString(destination));      
    
    }
    @Override
    public void Threading(){
        //use main program thread
        Thread mainThread=Thread.currentThread();
        System.out.println(mainThread);
    }
    int x=3;
    public static void main(String args[]){
        //calling a non-static method in a static context require the presence of an instance
        new Array_Collections().Array();
        new Array_Collections().Threading();
        /*
         # 1st threading example by implemeting Runnable interface just like Thread class & use a threading instance to control changes timeout
        */
        Threading1 t=new Threading1();
        //use synchronize
        synchronized(t){
            t.thread.start();
        }
        /*
         # 2nd threading example by extending Thread class & calling its constructor
        */
        Threading2 thread2=new Threading2();
        synchronized(thread2){
            thread2.start();
        }
        
       bitWiseTrial();
       javaIO();
       JsonWrite();
       JsonRead();
       UsingHashMap();
        JsonArrayExample("thomas", "Sun Collision", 22, 220, 1200, 200, 100.22f);
     
    }
    
    
    public static void bitWiseTrial(){
        int a=0b00000001;
        int leftShiftOne= a << 2;
        System.out.println(a);
        System.out.println(leftShiftOne);
        int screenwidth="Screen".length();
        int [][] screen={
            {
             0b0001000,
             0b0001000,
             0b0001000,
             0b0001000
            }
            ,{
             0b1111111,
             0b0001000,
             0b0001000,
             0b0001000
            }  
        };
        
        for(int rows=0; rows<screen.length; rows++){
            for(int columns=0; columns<screen[rows].length; columns++){
                for(int shifter=1; shifter <=screenwidth; shifter++){
                    screen[rows][columns] >>= (shifter % screenwidth);
                    System.out.print(Integer.toBinaryString( screen[rows][columns]));

                }
            }
            
        }
        System.out.println("");
       

    }
    
    public static void javaIO(){
        /**
         * Writing Data
         */
        
        String text="FileOutputStream tutorial is really important\t\n"+
                      "Agree or not is your choice\t\n"  ;
        
                //using FileOutputStream
                //get string encoded bytes
        byte []encoder=text.getBytes();
        
            //Robust code version try-with resources will close the outputStream whenever we have ended our streaming session
            //NB: the file resource E:\\trial.txt is a windows style with escaped backslash
        try(FileOutputStream fileOut=new FileOutputStream(new File("E:\\trial.txt"))){
           //save the whole text
            fileOut.write(encoder);
            //choose some words"AKA bytes"
            for(int bytE=0;bytE<encoder.length;bytE++){
                fileOut.write(encoder[bytE]);
            }
        }catch(IOException error){
            error.printStackTrace();
        }
        
        
            //convert the String to charArray
        char[] charArray=text.toCharArray();
        //using FileWriter using try with resources ..catch exceptions 
        //NB: the file resource E:/trial.txt is a UNIX style file resource with forward slash
        try(FileWriter fileWriter=new FileWriter(new File("E:/trial.dll"))){
            //save the whole text
            fileWriter.write(charArray);
            //go over each charachter
            for(int charPosition=0; charPosition<charArray.length; charPosition++){
                fileWriter.write(charArray[charPosition]);
            }
        }catch(FileNotFoundException ex1){
            System.err.println(ex1);
        }catch(IOException ex2){
            System.err.println(ex2);
        } finally {
            System.out.println("Successfull");
        }
        
        
        //using BufferedWriter with try with resources to auto-close stream 
        try(BufferedWriter bwriter=new BufferedWriter(new FileWriter("E:/trial.cmd"))){
            bwriter.write(text);
        }catch(FileNotFoundException ex0){
            System.err.println(ex0.getMessage());
        }catch(IOException ex1){
            System.err.println(ex1.getMessage());
        }
        
        /**
         * Reading Data
         */
        
        //1 w/ inputStream
        String resultString="";
        try(FileInputStream inputFile=new FileInputStream(new File("E:/trial.cmd"))){
            int size=inputFile.available();
                for(int charPosition=0; charPosition<size; charPosition++){
                    resultString+=(char)inputFile.read();
                }
            JOptionPane.showMessageDialog(null, resultString);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        
        
        //2 w/ FileReader
        try(FileReader reader=new FileReader(new File("E:/trial.dll"))){
            resultString="";
                while(reader.ready()){
                    resultString+=(char) reader.read();
                }
            JOptionPane.showMessageDialog(null, "FileReader example\t\n"+resultString);
        }catch(FileNotFoundException ex0){
            ex0.printStackTrace();
        }catch(IOException ex1){
            ex1.printStackTrace();
        }
        
        //3 w/ BufferedReader
        try(BufferedReader breader=new BufferedReader(new FileReader(new File(getPath("trial.dll"))))){
            resultString="";
                while(breader.ready()){
                    resultString+=breader.readLine()+"\n";
                    /**
                     * OR
                     */
                    //resultString+=(char)breader.read();
                }
          JOptionPane.showMessageDialog(null, "BufferedReader example\t\n"+resultString);
        }catch(FileNotFoundException ex0){
            ex0.printStackTrace();
        }catch(IOException ex1){
            ex1.printStackTrace();
        }
        
      
    }
    
    //method to return parent work directory of the class or the jar file
    public static String getPath(String directory){
         /**Factory methods for file systems. 
          * This class defines the {@link #getDefault
          * getDefault} method to get the default file system and factory methods to
          * construct other types of file systems.
          */
        /** getDefault(); Returns the default {@code FileSystem}. The default file system creates
        * objects that provide access to the file systems accessible to the Java
        * virtual machine. The <em>working directory</em> of the file system is
        * the current user directory, named by the system property {@code user.dir}.
        * This allows for interoperability with the {@link java.io.File java.io.File}
        * class.
        */
        String path=FileSystems.getDefault().getPath(directory).toAbsolutePath().toString();
        return path;
    }
    public static void sqlite_connection(){
        /**
         * Check Connectivity
         */
        try(Connection connection=DriverManager.getConnection("jdbc:sqlite:C:\\sqlite\\sql.db");
                Statement statement=connection.createStatement()){
            System.out.println("connection established");
   
            
            String command="CREATE TABLE warehouses (\n"
                + "	id integer PRIMARY KEY DEFAULT 100,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");\n";
            statement.execute(command);
            command="SELECT * FROM warehouses";
            ResultSet set=statement.executeQuery(command);
            while(set.next()){
                  System.out.println(set.getInt("id") +  "\t" );
            }

        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        
        
    }
    
    public static void JsonWrite(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("Name", "pavly");
        jsonObject.put("Score",22);
        jsonObject.put("Team", "Scrappers");
        byte [] stringbytes=jsonObject.toJSONString().getBytes();
        try(FileOutputStream fileout=new FileOutputStream(new File("E:/trial.json"))){
            fileout.write(stringbytes);
        }catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public static void JsonRead(){
        JSONParser parser=new JSONParser();
        try{
            JSONObject jSONObject=(JSONObject) parser.parse(new FileReader(new File("E:/trial.json")));
            System.out.println(jSONObject.get("Name"));
        }catch(IOException ex){
            System.err.println(ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(Array_Collections.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    public static void UsingHashMap(){
        //hashMap is a built-in java.util collection(array based) class library 
        /**
         * at this context of use we would like to implemement this collection & use it as databases
         */
        HashMap hashmap=new HashMap();
        hashmap.put("name", "Pavly");
        hashmap.put("age", 22);
        //try with resources is used to auto close the stearm whenever there's no data to return or read & it supports the catch & finally all in one statement
        try(FileOutputStream fileout=new FileOutputStream(new File("E:/trial.hashedFile"))){
            fileout.write(hashmap.toString().getBytes());
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void JsonArrayExample(String username,String deathReason,int bestcombo,int score,int exp,int gunshoots,float gamelifetime){
        /**
         * Data Modelling Using JavaScript Object Notation code(JSON):
         * 
         * Best approach:
         * JsonArray has multiple objects , each objects have elements & each element got a key to be called with 
         * 
         * [JSON]
         * 
         * [
         * {
         * "username":"pavly",
         * "Score":450,
         * "Exp":1200,
         * "Death Reason":"Galactic Space Turrent",
         * "Best combo":10,
         * "Game Life Time":23.44,
         * "Gun Shoots":500
         * },
         * {
         * "username":"John",
         * "Score":600,
         * "Exp":1000,
         * "Death Reason":"Sun Collision",
         * "Best combo":20,
         * "Game Life Time":60.44,
         * "Gun Shoots"1000
         * },
         * {
         * "username":"Twisted Metal",
         * "Score":1000,
         * "Exp":1800,
         * "Death Reason":"Rocks Collision",
         * "Best combo":12,
         * "Game Life Time":199.44,
         * "Gun Shoots":800
         * }
         * ]
         * 
         * [JSON/]
         * 
         */
        
        /**
         * JSON Writing data to a JSON File
         * 
         */
        
        JSONArray jsonArr=null;
        //create a jsonParser to get the old db file if exists
        JSONParser readparser=new JSONParser();

        try{
                //return the file as a json Array if the file exists
            jsonArr=(JSONArray) readparser.parse(new FileReader(new File(getPath("newJson.json"))));
        }catch(Exception e){
            System.err.println(e.getMessage());
            //if the file doesnot exist then create new JsonArray to take in new data
            jsonArr=new JSONArray();
        }
        JSONObject jsonObject=new JSONObject();
        String[] keys={"username","Score","Exp","Death Reason","Best combo","Game Life Time","Gun Shoots"};
        Object JsonElement[]={username,score,exp,deathReason,bestcombo,gamelifetime,gunshoots};
       
            //passing over elements & thier keys and applying data in a new JsonObj
        for(int element=0; element<keys.length; element++){
            jsonObject.putIfAbsent(keys[element], JsonElement[element]);
        }

                //add a new jsonObject that has elements ,this new jsonObject represents the player data {username,score,Exp level,best combo,...etc}
                    jsonArr.add(jsonObject);
                
        //now create new file that has the old and the new data
        try(FileOutputStream fileOut=new FileOutputStream(new File(getPath("newJson.json")))){
            fileOut.write(jsonArr.toJSONString().getBytes());
        }catch(IOException error){
            System.err.println(error.getMessage());
        }
        
        
        /**
         * Json Reading Data from a JSON File
         * 
         */
        
        //Defining jsonparser instance
        JSONParser parser=new JSONParser();
        try {
                //reading the json file from file System the default directory
            JSONArray jsonarrayReader=(JSONArray) parser.parse(new FileReader(new File(getPath("newJson.json"))));
                //iterating over each jsonObject [{...},{...},{...}] in the jsonArray
            for(int jsonObjs=0; jsonObjs<jsonarrayReader.toArray().length; jsonObjs++){
                //iterating over each json Element {...} represented by dots in the jsonObject according to predefined keys(represents user's data)
                for(int element=0; element<keys.length; element++){
                    //printing out data in a joptionPanel
                    JOptionPane.showMessageDialog(null, keys[element]+" "+((JSONObject)jsonarrayReader.get(jsonObjs)).get(keys[element]));
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
}
