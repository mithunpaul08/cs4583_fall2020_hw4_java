package edu.arizona.cs;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestQ5_2_f1score {
    @Test
    public void testDocsAndScores() {
        String inputFileFullPath = "input.txt";
        QueryEngine objQueryEngine = new QueryEngine(inputFileFullPath);
        try {
            String[] common_query = {"information", "retrieval"};
            double ans = objQueryEngine.runQ5_2_f1score(common_query);
            assertThat("ans",ans>0.8);
        } catch (java.io.FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (java.io.IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}



