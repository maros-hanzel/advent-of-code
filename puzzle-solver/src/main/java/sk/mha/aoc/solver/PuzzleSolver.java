package sk.mha.aoc.solver;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sk.mha.aoc.api.PuzzleAPI;
import sk.mha.aoc.solver.util.PuzzleInputLoader;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
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
            String puzzleName = puzzle.getClass().getSimpleName();
            List<String> puzzleInput = puzzleInputLoader.loadInput(puzzle.day());

            Instant start = Instant.now();
            Object answer = puzzle.solve(puzzleInput);
            Duration executionTime = Duration.between(start, Instant.now());

            log.debug("Day-{} puzzle {} solved in {} ms", puzzle.day(), puzzleName, executionTime.toMillis());
            log.info("Day-{} puzzle {} answer is: {}", puzzle.day(), puzzleName, answer);
        }
    }

}
