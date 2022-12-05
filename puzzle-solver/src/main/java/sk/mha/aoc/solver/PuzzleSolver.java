package sk.mha.aoc.solver;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.mha.aoc.api.PuzzleAPI;
import sk.mha.aoc.solver.util.PuzzleInputLoader;

import java.io.IOException;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@SpringBootApplication(scanBasePackages = "sk.mha.aoc")
public class PuzzleSolver implements CommandLineRunner {

    private final PuzzleInputLoader puzzleInputLoader;

    private final List<PuzzleAPI<?>> puzzles;

    public static void main(String[] args) {
        SpringApplication.run(PuzzleSolver.class, args);
    }

    @Override
    public void run(String... args) throws IOException {
        log.debug("Autowired {} puzzles", puzzles::size);
        for (PuzzleAPI<?> puzzle : puzzles) {
            List<String> puzzleInput = puzzleInputLoader.loadInput(puzzle.day());
            Object answer = puzzle.solve(puzzleInput);
            log.info("Day-{} puzzle {} answer is: {}", puzzle.day(), puzzle.getClass().getSimpleName(), answer);
        }
    }

}
