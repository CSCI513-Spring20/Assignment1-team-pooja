package com.niu;

import java.util.ArrayList;
import java.util.List;

public class HorizontalSearch implements Search {

    @Override
    public void runSearch(Integer[][] grid) {
        int cellsSearched = 0;
        int gridRows = grid.length;
        int gridColumns = 0;
        if (gridRows > 0){
            gridColumns = grid[0].length;
        }
        List<Element> carrier = new ArrayList<Element>();
        List<Element> submarine = new ArrayList<Element>();


        for (int row=0; row < gridRows; row++){
            if (carrier.size() == 5 && submarine.size() == 3){
                break;
            }
            for (int column=0; column < gridColumns; column++){
                if (grid[row][column] == -1) {
                    carrier.add(new Element(row, column));
                } else if (grid[row][column] == 1) {
                    submarine.add(new Element(row, column));
                }
                if (carrier.size() == 5 && submarine.size() == 3){
                    break;
                }
                cellsSearched++;
            }
        }

        System.out.println(this.Name());
        System.out.println("Number of cells searched "+cellsSearched);
        System.out.printf("Carrier found: %s to %s ", carrier.get(0).toString(), carrier.get(4).toString());
        System.out.printf("Submarine found: %s to %s\n", submarine.get(0).toString(), submarine.get(2).toString());
    }

    @Override
    public String Name() {
        return "Strategy: HorizontalSweepSearch";
    }
}
