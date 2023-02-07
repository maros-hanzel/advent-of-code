package sk.mha.aoc.day8.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sk.mha.aoc.day8.TreetopTreehousePuzzle;

import java.util.Arrays;
import java.util.List;

@Component
@Order(81)
public class TreesSeenFromOutside extends TreetopTreehousePuzzle {
    @Override
    public Integer solve(List<String> input) {
        int[][] treeHeights = new int[input.size()][];
        boolean[][] visibleFromTopLeft = new boolean[input.size()][];

        {
            int[] maxInColumn = new int[input.size()];
            Arrays.fill(maxInColumn, -1);
            for (int i = 0; i < input.size(); i++) {
                String[] split = input.get(i).split("");
                treeHeights[i] = new int[split.length];
                visibleFromTopLeft[i] = new boolean[split.length];

                int maxInRow = -1;
                for (int j = 0; j < split.length; j++) {
                    int treeHeight = Integer.parseInt(split[j]);
                    treeHeights[i][j] = treeHeight;

                    visibleFromTopLeft[i][j] = treeHeight > maxInRow || treeHeight > maxInColumn[j];
                    maxInRow = Math.max(maxInRow, treeHeight);
                    maxInColumn[j] = Math.max(maxInColumn[j], treeHeight);
                }
            }
        }

        int visibleTrees = 0;
        {
            int[] maxInColumn = new int[input.size()];
            Arrays.fill(maxInColumn, -1);
            for (int i = treeHeights.length - 1; i >= 0; i--) {
                int maxInRow = -1;
                for (int j = treeHeights[i].length - 1; j >= 0; j--) {
                    int treeHeight = treeHeights[i][j];

                    if (treeHeight > maxInRow || treeHeight > maxInColumn[j]
                        || visibleFromTopLeft[i][j]) {
                        visibleTrees++;
                    }
                    maxInRow = Math.max(maxInRow, treeHeight);
                    maxInColumn[j] = Math.max(maxInColumn[j], treeHeight);
                }
            }
        }

        return visibleTrees;
    }
}
