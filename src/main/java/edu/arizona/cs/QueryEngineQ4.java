package edu.arizona.cs;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import edu.arizona.cs.Document;

public class QueryEngineQ4 {
    String inputFilePath ="";
    public QueryEngineQ4(String inputFile){
        inputFilePath =inputFile;
        buildModel();
    }

    /*
     * "This method computes the parameters of the language model".
     *
     */
    private void buildModel() {
        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(inputFilePath).getFile());
    }

    public static void main(String[] args ) {
        try {
            /*add your code here*/
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /*
     * List of documents that you return for runQ4_3_with_smoothing must be sorted in the descending order of scores.
     *
     */

    public List<ResultClass> runQ4_3_with_smoothing(String[] query) throws java.io.FileNotFoundException {
        /*this is just dummy code. add your code here*/
        List<ResultClass>  ans=new ArrayList<ResultClass>();
        ans =returnDummyResults(4);
        return ans;
    }
    /*
     * List of documents that you return for runQ4_3_without_smoothing must be sorted in descending order of scores. Even documents with score=0 must be returned.
     *
     */
    public List<ResultClass> runQ4_3_without_smoothing(String[] query) throws java.io.FileNotFoundException {
        /*this is just dummy code. add your code here*/
        List<ResultClass> ans = new ArrayList<ResultClass>();
        ans = returnDummyResultsNoSmoothing(4);
        return ans;
    }

    /*
     * Dummy function and dummy results provided for skeletal purposes.
     * You shouldn't be returning these finally.
     *
     */
    private  List<ResultClass> returnDummyResults(int maxNoOfDocs) {

        List<ResultClass> doc_score_list = new ArrayList<ResultClass>();
            for (int i = 0; i < maxNoOfDocs; ++i) {
                Document doc=new Document("Doc"+(i+1));
                ResultClass objResultClass= new ResultClass();
                objResultClass.DocName =doc;
                objResultClass.docScore=1+(i*0.1);
                doc_score_list.add(objResultClass);
            }
        return doc_score_list;
    }
    /*
     * Dummy function and dummy results provided for skeletal purposes.
     * You shouldn't be returning these finally.
     *
     */
    private  List<ResultClass> returnDummyResultsNoSmoothing(int maxNoOfDocs) {
        List<ResultClass> doc_score_list = new ArrayList<ResultClass>();
        for (int i = 0; i < maxNoOfDocs; ++i) {
            Document doc=new Document("Doc"+(i+1));
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
                    objResultClass.docScore=1;
                    break;
                case(3):
                    objResultClass.docScore=1;
                    break;
            }
        }
        return doc_score_list;
    }

}
