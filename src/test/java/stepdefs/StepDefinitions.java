package stepdefs;

import com.apps.SentencesArrayApp;
import com.examples.SentencesArray;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class StepDefinitions {

    private static final Logger LOG = Logger.getLogger(StepDefinitions.class);
    PrintStream standardOuput = System.out;
    InputStream standardInput = System.in;
    File actualOutputFile=new File("src\\test\\resources\\actualOuputFile");
    SentencesArrayApp theApplication;
    String input ="";

    @When("User calls showMenu method then the menu is displayed")
    public void testShowMenu() throws FileNotFoundException {
        SentencesArray anArray = new SentencesArray();
//        File outputFile = new File("output");
        System.setOut(new PrintStream(actualOutputFile));
        anArray.showMenu();
        // read the output file
        // verify that
        // line number 1 --
    }

    @Given("The application is started")
    public void theApplicationIsStarted() {
        try {
            System.setOut(new PrintStream(actualOutputFile));
             theApplication= new SentencesArrayApp();
        } catch (FileNotFoundException e) {
            Assert.fail("The output file is not ready");
        }
    }

    @Then("the application menu should be displayed")
    public void theApplicationMenuShouldBeDisplayed() {
        enterInput("9"+System.lineSeparator());
        theApplication.main(new String [0]);

        String expectedSecondLine = "Menu :::::";
        String expectedThirdLine = "1.Enter a full sentence";
        String expectedFourthLine = "2.Print out all sentences entered thus far in the given order";
        String expectedFifthLine = "3.Print out the number of sentences that have been entered thus far";
        String expectedSixthLine = "4.Print out all sentences entered thus far in the reverse order";
        String expectedSeventhLine = "5.the number of characters in all sentences combined";
        String expectedEighthLine = "6.the total number of vowels contained in all stored sentences";
        String expectedNinthLine = "7.search for a given word using case insensitive comparisons";
        String expectedTenthLine = "8.search for a given word using case sensitive comparisons";
        String expectedEleventhLine = "9.Exit";

        List<String> actualLines;
        try {
            actualLines = FileUtils.readLines(actualOutputFile, StandardCharsets.UTF_8);
            Assert.assertEquals(actualLines.get(1),expectedSecondLine);
            Assert.assertEquals(actualLines.get(2),expectedThirdLine);
            Assert.assertEquals(actualLines.get(3),expectedFourthLine);
            Assert.assertEquals(actualLines.get(4),expectedFifthLine);
            Assert.assertEquals(actualLines.get(5),expectedSixthLine);
            Assert.assertEquals(actualLines.get(6),expectedSeventhLine);
            Assert.assertEquals(actualLines.get(7),expectedEighthLine);
            Assert.assertEquals(actualLines.get(8),expectedNinthLine);
            Assert.assertEquals(actualLines.get(9),expectedTenthLine);
            Assert.assertEquals(actualLines.get(10),expectedEleventhLine);
        } catch (IOException e) {
            Assert.fail("actual output file is not created.");
        }

    }
    public void enterInput(String inputString){
        System.setIn(IOUtils.toInputStream(inputString, StandardCharsets.UTF_8));
    }

    @When("user enters two sentences by following prompts")
    public void  userEntersTwoSentencesByFollowingPrompts() {
        input = input + "1"+System.lineSeparator()+
                        "Once upon a time there was an old mother pig"+System.lineSeparator()+
                        "1"+System.lineSeparator()+
                        "who had three little pigs and not enough food to eat"+System.lineSeparator();
    }

    @And("user enters the third option")
    public void userEntersTheThirdOption()
    {
        input = input + "3"+System.lineSeparator();
    }

    @Then("the application should display the count of the sentences")
    public void CountOfTheSentences() {
        enterInput(input+"9"+System.lineSeparator());
        theApplication.main(new String [0]);

        String expectedLine = "Select Option from the menu::: The number of sentences that have been entered 2";

        List<String> actualLines;
        try {
            actualLines = FileUtils.readLines(actualOutputFile, StandardCharsets.UTF_8);
            Assert.assertEquals(actualLines.get(40),expectedLine);
        } catch (IOException e) {
            Assert.fail("actual output file is not created.");
        }
    }

    @And("user enters the second option")
    public void userEntersTheSecondOption() {
        input = input + "2" +System.lineSeparator();
    }

    @Then("the application should display all the sentences")
    public void printTheSentences() {
        enterInput(input+"9"+System.lineSeparator());
        theApplication.main(new String [0]);


        String expectedLine1 = "Select Option from the menu::: ";
        String expectedLine2 = "Sentences in the Array are::" ;
        String expectedLine3 = "1 Once upon a time there was an old mother pig";
        String expectedLine4 = "2 who had three little pigs and not enough food to eat";

        try {
            List<String> actualLines = FileUtils.readLines(actualOutputFile, StandardCharsets.UTF_8);
            String actualLine1=actualLines.get(40);
            String actualLine2=actualLines.get(41);
            String actualLine3=actualLines.get(42);
            String actualLine4=actualLines.get(43);
//            for(int i=40;i<45;i++) {
//                actualLine = actualLine+actualLines.get(i);
//            }
            Assert.assertEquals(actualLine1, expectedLine1);
            Assert.assertEquals(actualLine2, expectedLine2);
             Assert.assertEquals(actualLine3, expectedLine3);
             Assert.assertEquals(actualLine4, expectedLine4);
        } catch (IOException e) {
            Assert.fail("actual output file is not created.");
        }
    }

    @And("user enters the fourth option")
    public void userEntersTheFourthOption() {
        input = input + "4" +System.lineSeparator();
    }

    @Then("the application should display all the sentences in the reverse order")
    public void printReverse() {
        enterInput(input+"9"+System.lineSeparator());
        theApplication.main(new String [0]);


        String expectedLine1 = "Select Option from the menu::: ";
        String expectedLine2 = "The Reverse order of Sentences are :: ";
        String expectedLine3 = "2 who had three little pigs and not enough food to eat";
        String expectedLine4 = "1 Once upon a time there was an old mother pig";

        try {
            List<String> actualLines = FileUtils.readLines(actualOutputFile, StandardCharsets.UTF_8);
            String actualLine1=actualLines.get(40);
            String actualLine2=actualLines.get(41);
            String actualLine3=actualLines.get(42);
            String actualLine4=actualLines.get(43);
//            for(int i=40;i<45;i++) {
//                actualLine = actualLine+actualLines.get(i);
//            }
            Assert.assertEquals(actualLine1, expectedLine1);
            Assert.assertEquals(actualLine2, expectedLine2);
            Assert.assertEquals(actualLine3, expectedLine3);
            Assert.assertEquals(actualLine4, expectedLine4);
        } catch (IOException e) {
            Assert.fail("actual output file is not created.");
        }
    }

    @And("user enters the fifth option")
    public void userEntersTheFifthOption() {
        input = input + "5" +System.lineSeparator();
    }

    @Then("the application should display the number of characters")
    public void numberOfCharacters() {
        enterInput(input+"9"+System.lineSeparator());
        theApplication.main(new String [0]);

        String expectedLine1 = "Select Option from the menu::: ";
        String expectedLine2 = "The Character Count is : 77";

        List<String> actualLines;
        try {
            actualLines = FileUtils.readLines(actualOutputFile, StandardCharsets.UTF_8);
            Assert.assertEquals(actualLines.get(40),expectedLine1);
            Assert.assertEquals(actualLines.get(42),expectedLine2);

        } catch (IOException e) {
            Assert.fail("actual output file is not created.");
        }
    }

    @And("user enters the sixth option")
    public void userEntersTheSixthOption() {
        input = input + "6" +System.lineSeparator();
    }

    @Then("the application should display the total number of vowels")
    public void vowelCount() {
        enterInput(input+"9"+System.lineSeparator());
        theApplication.main(new String [0]);

        String expectedLine1 = "Select Option from the menu::: ";
        String expectedLine2 = "The Vowel count is :32";
        List<String> actualLines ;
        try {
            actualLines = FileUtils.readLines(actualOutputFile, StandardCharsets.UTF_8);
            Assert.assertEquals(actualLines.get(40),expectedLine1);
            Assert.assertEquals(actualLines.get(41),expectedLine2);

        } catch (IOException e) {
            Assert.fail("actual output file is not created.");
        }
    }

    @And("user enters the seventh option")
    public void userEntersTheSeventhOption() {

        input = input + "7" +System.lineSeparator();
    }

    @And("user enters {string} as the search word")
    public void userEntersAsTheSearchWord(String searchWord) {

        input = input + searchWord +System.lineSeparator();

    }

    @Then("the application should display the second sentence")
    public void theApplicationShouldDisplayTheSecondSentence() {
        enterInput(input+"9"+System.lineSeparator());
        theApplication.main(new String [0]);

        String expectedLine ="who had three little pigs and not enough food to eat";
        try {
            List<String> actualLines = FileUtils.readLines(actualOutputFile, StandardCharsets.UTF_8);
            String actualLine=actualLines.get(43);

            Assert.assertEquals(actualLine, expectedLine);
        } catch (IOException e) {
            Assert.fail("actual output file is not created.");
        }

    }

    @And("user enters the eighth option")
    public void userEntersTheEighthOption() {
        input = input + "8" +System.lineSeparator();
    }

    @And("user enters {string} as the search word which is caseSensitive")
    public void userEntersAsTheSearchWordWhichIsCaseSensitive(String searchWord) {
        input = input + searchWord +System.lineSeparator();
    }

    @Then("the application should display the first sentence")
    public void theApplicationShouldDisplayTheFirstSentence() {
        enterInput(input+"9"+System.lineSeparator());
        theApplication.main(new String [0]);

        String expectedLine ="Once upon a time there was an old mother pig";
        try {
            List<String> actualLines = FileUtils.readLines(actualOutputFile, StandardCharsets.UTF_8);

            Assert.assertEquals(actualLines.get(42), expectedLine);
        } catch (IOException e) {
            Assert.fail("actual output file is not created.");
        }
    }


    @Then("the application should display an error message")
    public void theApplicationShouldDisplayAnErrorMessage() {
        enterInput(input+"9"+System.lineSeparator());
        theApplication.main(new String [0]);

        String expectedLine ="Select Option from the menu::: select case 1 first for entering the sentence";
        try {
            List<String> actualLines = FileUtils.readLines(actualOutputFile, StandardCharsets.UTF_8);

            Assert.assertEquals(actualLines.get(12), expectedLine);
        } catch (IOException e) {
            Assert.fail("actual output file is not created.");
        }
    }
}

