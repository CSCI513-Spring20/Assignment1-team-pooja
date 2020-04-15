package com.niu;

import java.util.*;

public class StrategicSearch implements Search{

    @Override
    public void runSearch(Integer[][] grid) {
        int cellsSearched = 0;
        List<Element> carrier = new ArrayList<Element>();
        List<Element> submarine = new ArrayList<Element>();
        int gridRows = grid.length;
        int gridColumns = 0;
        if (gridRows > 0){
            gridColumns = grid[0].length;
        }

        int nrows = gridRows;
        int ncolumns = gridColumns;

        int i = 0;

        int evenRow = 0; // starts from the first row
        int oddRow = 1; // starts from the next row

        // process all even rows first
        outerLoop:
        while (evenRow < nrows) {
            if (carrier.size() == 5 && submarine.size() == 3){
                break outerLoop;
            }

            for (i = 0; i < ncolumns; i++) {
                // for evenRow
                if (grid[evenRow][i] == -1 && carrier.size() != 5) {
                    Element element = new Element(evenRow, i);
                    carrier.add(element);
                } else if (grid[evenRow][i] == 1 && submarine.size() != 3) {
                    Element element = new Element(evenRow, i);
                    submarine.add(element);
                } else if (carrier.size() == 5 && submarine.size() == 3) {
                    break outerLoop;
                }
                cellsSearched++;
            }
            // skipping next row so as to get the next evenRow
            evenRow = evenRow + 2;

            // if atleast one part submarine is found, based on found value, determine other parts
            if (0 < submarine.size() && submarine.size() < 3){
                Element el = submarine.get(0);
                int ic = el.getIndexColumn();
                int ir = el.getIndexRow();
                int times = 0;
                if (ir > 0) {
                    if (grid[ir - 1][ic] == 1) {
                        Element element = new Element(ir, ic);
                        carrier.add(element);
                        times++;
                    } else {
                        cellsSearched++;

                    }

                    while (times < 3) {

                        if (ir++ < nrows) {
                            if (grid[ir][ic] == 1) {
                                Element element = new Element(ir, ic);
                                carrier.add(element);
                            } else {
                                cellsSearched++;
                            }
                        }
                        times++;
                    }
                }
            }

            // if atleast one part carrier is found, based on found value, determine other parts
            if (0 < carrier.size() && carrier.size() < 5){
                Element el = carrier.get(0);
                int ic = el.getIndexColumn();
                int ir = el.getIndexRow();
                int times = 0;
                if (ir > 0){
                    if (grid[ir -1][ic] == -1){
                        Element element = new Element(ir-1, ic);
                        carrier.add(element);
                        times++;
                    }else{
                        cellsSearched++;
                    }
                    while (times < 4) {
                        if (ir++ < nrows) {
                            if (grid[ir][ic] == -1){
                                Element element = new Element(ir, ic);
                                carrier.add(element);
                            }else {
                                cellsSearched++;
                            }
                        }
                        times++;
                    }
                }

            }

        }

        // process all the odd rows
        outerLoop2:
        while (oddRow < nrows) {
            if (carrier.size() == 5 && submarine.size() == 3){
                break outerLoop2;
            }
            for (i = ncolumns - 1; i >= 0; i--) {
                // for oddRow
                if (grid[oddRow][i] == -1 && carrier.size() != 5) {
                    Element element = new Element(oddRow, i);
                    carrier.add(element);
                } else if (grid[oddRow][i] == 1 && submarine.size() != 3) {
                    Element element = new Element(oddRow, i);
                    submarine.add(element);
                } else if (carrier.size() == 5 && submarine.size() == 3){
                    break outerLoop2;
                }
                cellsSearched++;
            }
            // Skipping next row so as to get the next oddRow
            oddRow = oddRow + 2;


        }

        Collections.sort(carrier);
        Collections.sort(submarine);

        System.out.println(this.Name());
        System.out.println("Number of cells searched "+(cellsSearched-1));
        System.out.printf("Carrier found: %s to %s ", carrier.get(0).toString(), carrier.get(4).toString());
        System.out.printf("Submarine found: %s to %s\n", submarine.get(0).toString(), submarine.get(2).toString());
    }

    @Override
    public String Name() {
        return "Strategy: StrategicSearch";
    }
}
