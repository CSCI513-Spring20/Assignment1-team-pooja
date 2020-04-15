package com.niu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSearch implements Search{

    @Override
    public void runSearch(Integer[][] grid) {
        int cellsSearched = 0;
        int gridRows = grid.length;
        int gridColumns = 0;
        if (gridRows > 0){
            gridColumns = grid[0].length;
        }
        List<Element> carrier = new ArrayList<Element>(); // creates ArrayList carrier of Element type
        List<Element> submarine = new ArrayList<Element>(); // creates an ArrayList submarine of Element type
        boolean[][] visited = new boolean[gridRows][gridColumns];

        // create instance of Random class
        Random rand = new Random(-1);
        int row;
        int column;

        // label for continue
        outerLoop:
        while (true){
            // Generate random integers in range 0 to 24
            row = rand.nextInt(gridRows);
            column = rand.nextInt(gridColumns);
            if (!visited[row][column]){
                visited[row][column] = true;
            }else{
                continue;
            }

            if (grid[row][column] == -1 && carrier.size() != 5) {
                Element element = new Element(row, column);
                for (Element el : carrier)
                    if (el.equals(element)){
                        continue outerLoop;
                    }

                carrier.add(element);
            } else if (grid[row][column] == 1 && submarine.size() != 3) {
                Element element = new Element(row, column);
                for (Element el : submarine)
                    if (el.equals(element)){
                        continue outerLoop;
                    }
                submarine.add(element);
            } else if (carrier.size() == 5 && submarine.size() == 3){
                break;
            }

            cellsSearched++;
        }
        Collections.sort(carrier); // sorts the elements of carrier
        Collections.sort(submarine); //sorts the elements of submarine

        System.out.println(this.Name());
        System.out.println("Number of cells searched "+cellsSearched);
        System.out.printf("Carrier found: %s to %s ", carrier.get(0).toString(), carrier.get(4).toString());
        System.out.printf("Submarine found: %s to %s\n", submarine.get(0).toString(), submarine.get(2).toString());
    }

    @Override
    public String Name() {
        return "Strategy: RandomSearch";
    }
}
