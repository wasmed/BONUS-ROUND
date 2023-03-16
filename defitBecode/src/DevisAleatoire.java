import java.util.Random;

public class DevisAleatoire {

    public static void main(String[] args) {
        String[] sujets = {"l'amour", "la vie", "l'amitié", "le travail", "la réussite"};
        String[] verbes = {"apporte", "donne", "rend", "offre", "amène"};
        String[] complements = {"le bonheur", "la joie", "la satisfaction", "la confiance en soi", "le succès"};

        Random rand = new Random();

        String sujet = sujets[rand.nextInt(sujets.length)];
        String verbe = verbes[rand.nextInt(verbes.length)];
        String complement = complements[rand.nextInt(complements.length)];

        String devis = sujet + " " + verbe + " " + complement + ".";

        System.out.println(devis);
    }
}
