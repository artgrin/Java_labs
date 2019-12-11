import org.junit.Assert;
//import static org.junit.jupiter.api.Assertions.*;

class VocabularyTest {

    @org.junit.jupiter.api.Test
    void translatePhraseInUkrainian() {
        Vocabulary v1 = new Vocabulary();
        v1.addPair("chair", "стілець");
        v1.addPair("green", "зелений");
        String expected = "зелений стілець",
                actual = v1.translatePhraseInUkrainian("Green chair");
        Assert.assertEquals(expected, actual);
    }
}
