package com.soprasteria.innersource.programming;

import lombok.extern.slf4j.Slf4j;
/*##################################LAB numéro 1 "################################*/
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class Lab1 {

    private static final Random random = new Random(); //sans utiliser le thread() local
    public static final String AGES = "Salut !  vous êtes trop âgé(e)s";
    public static final String JEUNE = "Salut ! vous êtes trop jeune";

    public static void main(String[] args) {


        /*
        * Consumer -> il consomme une valeur a -> void
        *
        * Supplier -> il produit une valeur () -> T
        ** Predicate -> il consomme une valeur et retourne in boolean a -> bool
        * callable -> il lance une méthode/action () void -> peut lever une exception
        * Runnable -> il lance une méthode/action () -> void -> ne lève pas d'exception
        * Function -> prend une valeur et retourne un autre type de valeur a -> b
         * */



        //------------------------------------------EXO1-----------------------------//
        //1ère méthode
        Supplier<String> lambda1 = () -> {
            return "t" + Thread.currentThread().getId() + "-" + new Random().nextInt(1024);

        };

        log.info("Résultat lambda lab 1: {}", lambda1.get());


        //2ème métode corrigée propre
        Supplier<String> formatThreadRandom = () -> String
                .format("t%s-%s",Thread.currentThread().getId(), ThreadLocalRandom.current().nextInt(1024));
        log.info("Résultat lambda lab 1: {}", formatThreadRandom.get());
        log.info("Résultat lmabda lab 1: {}", formatThreadRandom.get());

        //3ème métode corrigée propre + Bonnes pratiques
        Supplier<String> lambda2 = () -> String
                .format("t%s-%s",Thread.currentThread().getId(), random.nextInt(1024));
        log.info("Résultat lambda lab 1: {}", lambda2.get());
        log.info("Résultat lmabda lab 1: {}", lambda2.get());

        //4ème méthode
        Supplier<Long> threadId = () ->  Thread.currentThread().getId();

        Supplier<Integer> random1024 = () -> random.nextInt(1024);

        Supplier<String> formatThreadRandom2 = () -> String
                .format("t%s-%s", threadId.get(), random1024.get());

        log.info("Résultat lambda lab 1: {}", formatThreadRandom2.get());
        log.info("Résultat lambda lab 1: {}", formatThreadRandom2.get());

        //----------------------------------------EXO2----------------------------//
        /*
        * data ne peut pas être null
        * */
        Function<String, Integer> dataLength = data -> data == null ? 0 : data.length();
        log.info("Length: {}", dataLength.apply("Java is awesome"));

        log.info("Length: {}", dataLength.apply(null));

        //--------------------------------Exo3-----------------------------------//

        //déclaration de la fonction lambda --> chatgpt
        BiFunction<String, Integer, String> ageMessage = (nom, age) -> {
            if (age > 80) {
                return "Vous êtes vieux, " + nom + "!";
            } else {
                return "Vous êtes encore jeune, " + nom + "!";
            }
        };



        //Correction Craftmanship
        BiFunction<String, Integer, String> testForAge = (String name, Integer age) -> age > 80 ? AGES : JEUNE;

        log.info("Votre age: {}", testForAge.apply("Elie", 81));
        log.info("votre age: {}", testForAge.apply("Mehdi", 25));

        // appel de la fonction lambda
        String message = ageMessage.apply("Jean", 75);
        log.info(message);



    }

    private Optional<String> doIt(){
        return Optional.empty();
    }
}
