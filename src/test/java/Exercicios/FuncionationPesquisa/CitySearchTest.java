package Exercicios.FuncionationPesquisa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CitySearchTest {
        @Test
        public void testSearchWithLessThanTwoCharacters() {
            //  menos de dois caracteres (deve retornar lista vazia)
            List<String> result = CitySearch.searchCity("A");
            Assertions.assertTrue(result.isEmpty());
        }
        @Test
        public void testSearchWithTwoOrMoreCharacters() {
            // Teste de busca com dois ou mais caracteres
            List<String> result = CitySearch.searchCity("Va");
            Assertions.assertEquals(2, result.size());
            Assertions.assertTrue(result.contains("Valência"));
            Assertions.assertTrue(result.contains("Vancouver"));
        }
        @Test
        public void testSearchCaseInsensitive() {
            // Teste de busca maiúsculas/minúsculas
            List<String> result = CitySearch.searchCity("va");
            Assertions.assertEquals(2, result.size());
            Assertions.assertTrue(result.contains("Valência"));
            Assertions.assertTrue(result.contains("Vancouver"));
        }
        @Test
        public void testSearchSubstringInCityName() {
            // Teste de busca quando o texto de busca é parte do nome da cidade
            List<String> result = CitySearch.searchCity("ape");
            Assertions.assertEquals(1, result.size());
            Assertions.assertTrue(result.contains("Budapeste"));
        }
        @Test
        public void testSearchWithAsteriskReturnsAllCities() {
            // Teste de busca com asterisco (deve retornar todas as cidades)
            List<String> result = CitySearch.searchCity("*");
            Assertions.assertEquals(16, result.size());
            Assertions.assertTrue(result.contains("Paris"));
            Assertions.assertTrue(result.contains("Budapeste"));
            Assertions.assertTrue(result.contains("Nova York"));
        }
        @Test
        public void testSearchWithEmptyStringReturnsNoResults() {
            // Teste de busca com string vazia (deve retornar lista vazia)
            List<String> result = CitySearch.searchCity("");
            Assertions.assertTrue(result.isEmpty());
        }
        @Test
        public void testSearchWithNoMatches() {
            // Teste de busca onde nenhuma cidade corresponde
            List<String> result = CitySearch.searchCity("ZZ");
            Assertions.assertTrue(result.isEmpty());
        }
    }


