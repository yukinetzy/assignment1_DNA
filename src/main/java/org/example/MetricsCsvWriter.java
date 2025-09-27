package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class MetricsCsvWriter {
    private final String fileName;

    public MetricsCsvWriter(String fileName) {
        this.fileName = fileName;
    }

    public void write(String algoName, int n, Metrics metrics, long timeNanos) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(String.format("%s,%d,%d,%d,%d,%d\n",
                    algoName,
                    n,
                    metrics.getComparisons(),
                    metrics.getAllocations(),
                    metrics.getMaxDepth(),
                    timeNanos
            ));
        } catch (IOException e) {
            throw new RuntimeException("Error writing metrics CSV", e);
        }
    }
}
