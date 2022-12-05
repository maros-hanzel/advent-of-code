package sk.mha.aoc.solver.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class PuzzleInputLoader {

    private final ResourceLoader resourceLoader;

    public List<String> loadInput(int day) throws IOException {
        String inputFileName = String.format("day-%d.input", day);
        log.debug("Loading resource: {}", () -> inputFileName);
        InputStream inputStream = resourceLoader.getResource(inputFileName).getInputStream();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines().toList();
        }
    }

}
