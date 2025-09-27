package org.example;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MetricsCsvTest {
    @Test
    void testWriteCsv() throws Exception {
        Metrics m = new Metrics();
        m.incComparisons();
        m.incAllocations();
        m.enterRecursion();
        m.exitRecursion();

        String file = "test_metrics.csv";
        MetricsCsvWriter writer = new MetricsCsvWriter(file);
        writer.write("TestAlgo", 10, m, 12345);

        String content = Files.readString(Path.of(file));
        assertTrue(content.contains("TestAlgo"));
        Files.deleteIfExists(Path.of(file));
    }
}
