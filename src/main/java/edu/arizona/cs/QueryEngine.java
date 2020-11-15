package edu.arizona.cs;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class QueryEngine {
    boolean indexExists=false;
    String inputFilePath ="";

    public QueryEngine(String inputFile){
        inputFilePath =inputFile;
        buildIndex();
    }

    private void buildIndex() {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(inputFilePath).getFile());

    //uncomment this if you want to print the entries in the input file
    // try (Scanner inputScanner = new Scanner(file)) {
    //            while (inputScanner.hasNextLine()) {
    //                System.out.println(inputScanner.nextLine());
    //            }
    //            inputScanner.close();
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }
        indexExists = true;
    }

    public static void main(String[] args ) {
        try {
            String fileName = "input.txt";
            System.out.println("********Welcome to  Homework 3!");
            String[] query = {"information", "retrieval"};
            QueryEngine objQueryEngine = new QueryEngine(fileName);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<ResultClass> runQ4_3_with_smoothing(String[] query) throws java.io.FileNotFoundException {
        if(!indexExists) {
            buildIndex();
        }
        List<ResultClass>  ans=new ArrayList<ResultClass>();
        ans =returnDummyResults(4);
        return ans;
    }

    public List<ResultClass> runQ4_3_without_smoothing(String[] query) throws java.io.FileNotFoundException {
        if (!indexExists) {
            buildIndex();
        }
        List<ResultClass> ans = new ArrayList<ResultClass>();
        ans = returnDummyResultsNoSmoothing(4);
        return ans;
    }

    public double runQ5_2_f1score(String[] query) throws java.io.FileNotFoundException {
        if(!indexExists) {
            buildIndex();
        }
      double ans =0.9;
        return ans;
    }

    private  List<ResultClass> returnDummyResults(int maxNoOfDocs) {

        List<ResultClass> doc_score_list = new ArrayList<ResultClass>();
            for (int i = 0; i < maxNoOfDocs; ++i) {
                Document doc = new Document();
                doc.add(new TextField("title", "", Field.Store.YES));
                doc.add(new StringField("docid", "Doc"+Integer.toString(i+1), Field.Store.YES));
                ResultClass objResultClass= new ResultClass();
                objResultClass.DocName =doc;
                objResultClass.docScore=1-(i*0.1);
                doc_score_list.add(objResultClass);
            }

        return doc_score_list;
    }

    private  List<ResultClass> returnDummyResultsNoSmoothing(int maxNoOfDocs) {

        List<ResultClass> doc_score_list = new ArrayList<ResultClass>();
        for (int i = 0; i < maxNoOfDocs; ++i) {
            Document doc = new Document();
            doc.add(new TextField("title", "", Field.Store.YES));
            doc.add(new StringField("docid", "Doc"+Integer.toString(i+1), Field.Store.YES));
            ResultClass objResultClass= new ResultClass();
            objResultClass.DocName =doc;

            doc_score_list.add(objResultClass);

            switch (i){
                case(0):
                    objResultClass.docScore=0.2;
                    break;
                case(1):
                    objResultClass.docScore=0.1;
                    break;
                case(2):
                    objResultClass.docScore=0;
                    break;
                case(3):
                    objResultClass.docScore=0;
                    break;
            }
        }

        return doc_score_list;
    }

}
