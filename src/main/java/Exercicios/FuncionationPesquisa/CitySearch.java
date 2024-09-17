package Exercicios.FuncionationPesquisa;

import java.util.ArrayList;
import java.util.List;

public class CitySearch {

    private static final List<String> cities = new ArrayList<>();

    static {
        cities.add("Paris");
        cities.add("Budapeste");
        cities.add("Skopje");
        cities.add("Roterdã");
        cities.add("Valência");
        cities.add("Vancouver");
        cities.add("Amsterdã");
        cities.add("Viena");
        cities.add("Sydney");
        cities.add("Nova York");
        cities.add("Londres");
        cities.add("Bangkok");
        cities.add("Hong Kong");
        cities.add("Dubai");
        cities.add("Roma");
        cities.add("Istambul");
    }

    public static List<String> searchCity(String searchText) {
        List<String> result = new ArrayList<>();

        // Se a busca tiver menos de 2 caracteres, retornar vazio
        if (searchText.length() < 2 && !searchText.equals("*")) {
            return result;
        }

        //  Se for busca por "*", retornar todas as cidades
        if (searchText.equals("*")) {
            return new ArrayList<>(cities);
        }

        //  ignora maiúsculas e minúsculas
        String lowerCaseSearchText = searchText.toLowerCase();
        for (String city : cities) {
            if (city.toLowerCase().startsWith(lowerCaseSearchText) || city.toLowerCase().contains(lowerCaseSearchText)) {
                result.add(city);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(searchCity("Va")); // Deve retornar [Valência, Vancouver]
        System.out.println(searchCity("ape")); // Deve retornar [Budapeste]
        System.out.println(searchCity("*"));   // Deve retornar todas as cidades
        System.out.println(searchCity("S"));   // Deve retornar [Skopje, Sydney]
        System.out.println(searchCity(""));    // Deve retornar []
    }
}

