import java.util.Scanner;
import java.util.HashSet;
import java.util.Random;

public class Juego {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] palabrasSecretas = {"inteligencia", "desarrollo", "programacion", "java", "tecnologia"};
        String palabraSecreta = palabrasSecretas[new Random().nextInt(palabrasSecretas.length)];
        int intentosMaximos = 5;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        HashSet<Character> letrasIncorrectas = new HashSet<>();
        HashSet<Character> letrasAdivinadasSet = new HashSet<>();

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            System.out.println("Letras incorrectas: " + letrasIncorrectas);
            System.out.println("Introduce una letra, por favor");

            char letra = Character.toLowerCase(scanner.next().charAt(0));
            if (letrasAdivinadasSet.contains(letra) || letrasIncorrectas.contains(letra)) {
                System.out.println("Ya has probado con esta letra. Intenta con otra.");
                continue;
            }

            boolean letraCorrecta = false;
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                letrasIncorrectas.add(letra);
                System.out.println("¡Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos.");
            } else {
                letrasAdivinadasSet.add(letra);
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("Felicidades, has adivinado la palabra secreta: " + palabraSecreta);
            }
        }

        if (!palabraAdivinada) {
            System.out.println("¡Qué pena! Te has quedado sin intentos. La palabra secreta era: " + palabraSecreta + ". GAME OVER");
        }

        scanner.close();
    }
}
