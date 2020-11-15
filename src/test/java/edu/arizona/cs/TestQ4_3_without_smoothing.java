package edu.arizona.cs;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;



public class TestQ4_3_without_smoothing {

    @Test
    public void testDocsAndScores() {

        String inputFileFullPath="input.txt";

        QueryEngine objQueryEngine = new QueryEngine(inputFileFullPath);
        try {
            String[] common_query = {"information", "retrieval"};
            List<ResultClass> ans = objQueryEngine.runQ4_3_without_smoothing(common_query);
            String[] doc_names_q1 = {"Doc1", "Doc2",  "Doc3","Doc4"};
            assertEquals(ans.size(), (doc_names_q1.length));
            assertEquals(doc_names_q1[0], ans.get(0).DocName.get("docid"));
            assertEquals(doc_names_q1[1], ans.get(1).DocName.get("docid"));
            assertEquals(doc_names_q1[2], ans.get(2).DocName.get("docid"));
            assertEquals(doc_names_q1[3], ans.get(3).DocName.get("docid"));
            assertThat( "ans", ans.get(0).docScore > ans.get(1).docScore);
            assertThat( "ans", ans.get(1).docScore > ans.get(2).docScore);
            assertEquals(0, ans.get(2).docScore );
            assertEquals(0, ans.get(3).docScore );

        }
        catch ( java.io.FileNotFoundException ex)
        {
            System.out.println(ex.getMessage()); }

        catch ( java.io.IOException ex)
        {
            System.out.println(ex.getMessage()); }

    }


}



