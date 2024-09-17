package Exercicios.FizzBuzzSolver;

import Exercicios.fizzbuzz_solver.FizzBuzzSolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzbuzzTest {
    FizzBuzzSolver
            solver;

    @BeforeEach
    public void setUp() {
        solver = new FizzBuzzSolver();
    };

    @Test
    public void SolveDeveRetornarFizzAoInvesDoNumero_QuandoONumeroForMultiploDe3() {
        FizzBuzzSolver solver = new FizzBuzzSolver();

        int input = 3;

        String output = solver.solve(input);

        assertEquals(output, "Fizz");
    };

    @Test
    public void SolveDeveriaRetornarComoBuzz_QuandoNumeroForMultiploDe5() {

        int input = 5;

        String output = solver.solve(input);

        assertEquals( "Buzz",output);
    };

    @Test
    public void ParaOsMultiplosDeSeisRetorneFizzParaInserirComo6() {

        int input = 6;

        String output = solver.solve(input);

        assertEquals( "Fizz",output);
    }

    @Test
    public void ParaOsMultiplosDeDezRetorneBuzzParaInserirComo10() {
        int input = 10;

        String output = solver.solve(input);

        assertEquals("Buzz",output);
    }

    @Test
    public void paraNumerosMultiplosDeTresECincoRetorneFizzBuzzEmVezDoNumeroQuinze() {

        int input = 15;

        String output = solver.solve(input);

        assertEquals(output, "FizzBuzz");
    };

}
