package ma.emsi.DAHA;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;

import java.util.Map;

public class testtraducteur {
    public static void main(String[] args) {
        // Clé API
        String apiKey = System.getenv("GEMINI_KEY");

        // Modèle LLM
        ChatLanguageModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-1.5-flash")
                .build();

        PromptTemplate promptTemplate = PromptTemplate.from("Traduis le texte suivant en {{langue}} : {{texte}}");

        Prompt prompt = promptTemplate.apply(Map.of(
                "langue", "arabe",
                "texte", "l'alcool c'est du l'eau"
        ));

        String traduction = model.generate(prompt.text());

        // Affichage
        System.out.println("Traduction : " + traduction);
    }
}
