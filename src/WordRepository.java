import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class WordRepository {
    private static final List<String> WORDS = Arrays.asList(
            "разработка", "дифференциал", "матрица", "интеграл", "автомат"
    );

    private final Random random = new Random();

    public String getRandomWord() {
        return WORDS.get(random.nextInt(WORDS.size()));
    }

}
