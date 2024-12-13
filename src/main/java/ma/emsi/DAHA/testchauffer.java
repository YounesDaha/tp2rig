package ma.emsi.DAHA;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class testchauffer {
    public static void main(String[] args) {

        String cle = System.getenv("GEMINI_KEY");
        ChatLanguageModel modele = GoogleAiGeminiChatModel
                .builder()
                .apiKey(cle)
                .modelName("gemini-1.5-flash")
                .build();
        String reponse = modele.generate("avec quoi je peux malanger la vodka ?");
        System.out.println(reponse);
    }
}
