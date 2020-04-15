package com.niu;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BattleshipSearch {
    Integer[][] grid;
    int rows;
    int columns;
    private Search search;

    BattleshipSearch(Integer[][] grid){
        this.grid = grid;
        this.rows = grid.length;
        if (this.rows > 0) {
            this.columns = grid[0].length;
        }
        this.search = new StrategicSearch(); // sets default strategy
    }

    BattleshipSearch(Search search, Integer[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        if (this.rows > 0) {
            this.columns = grid[0].length;
        }
        this.search = search;
    }

    public void doSearch() {
        search.runSearch(this.grid);
    }


    //Creates a Grid
    private static Integer[][] Grid(int rows, int columns) {
        Integer[][] grid = new Integer[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                grid[row][column] = 0;
            }
        }
        return grid;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public static void main(String[] args) {
        String inputFile = "input.txt";
        if (args.length > 0) {
            if (!args[0].equals("")) {
                inputFile = args[0];
            }
        }

        List<Search> searches = new ArrayList<>();
        searches.add(new HorizontalSearch());
        searches.add(new RandomSearch());
        searches.add(new StrategicSearch());

        File f = new File(inputFile);
        try {
            Scanner scanner = new Scanner(f);
            int gameNumber = 1;
            while (scanner.hasNextLine()) {
                Integer[][] grid = Grid(25, 25);
                String line = scanner.nextLine();
                // process the line
                StringTokenizer st = new StringTokenizer(line, "()");
                int i = 0;
                while (st.hasMoreTokens()) {
                    String[] values = st.nextToken().split(",");
                    int row = Integer.parseInt(values[0]);
                    int column = Integer.parseInt(values[1]);
                    if (i < 5) {
                        // for carrier use -1
                        grid[row][column] = -1;
                    } else {
                        // for submarine use 1
                        grid[row][column] = 1;
                    }
                    i++;
                }

                // starting the search

                System.out.println("Game: " + gameNumber);
                BattleshipSearch bs = new BattleshipSearch(grid);

                for (Search value : searches) {
                    bs.setSearch(value);
                    bs.doSearch();
                    System.out.println();
                }

                gameNumber++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found; doing nothing");
        }

    }
}