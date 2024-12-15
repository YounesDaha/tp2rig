package ma.emsi.DAHA;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.googleai.GoogleAiEmbeddingModel;
import dev.langchain4j.store.embedding.CosineSimilarity;

import java.time.Duration;

public class testembeddings {
    public static void main(String[] args) {
        String apiKey = System.getenv("GEMINI_KEY");

        if (apiKey == null || apiKey.isEmpty()) {
            System.err.println("Erreur : La clé GEMINI_KEY n'est pas définie.");
            return;
        }

        EmbeddingModel embeddingModel = new GoogleAiEmbeddingModel(
                "text-embedding-004", // Nom du modèle
                apiKey,
                300,
                GoogleAiEmbeddingModel.TaskType.SEMANTIC_SIMILARITY,
                "",
                200,
                Duration.ofSeconds(10),
                true // Logging activé
        );

        String phrase1 = "samedi soir";
        String phrase2 = "samedi noir";

        try {
            Embedding embedding1 = embeddingModel.embed(phrase1).content();
            Embedding embedding2 = embeddingModel.embed(phrase2).content();

            double similarity = CosineSimilarity.between(embedding1, embedding2);

            // Affichage des résultats
            System.out.println("Phrase 1 : " + phrase1);
            System.out.println("Phrase 2 : " + phrase2);
            System.out.println("Similarité cosinus : " + similarity);
        } catch (Exception e) {
            System.err.println("Erreur lors du traitement des embeddings : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
