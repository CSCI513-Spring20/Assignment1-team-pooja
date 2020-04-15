package com.niu;

public class Element implements Comparable {
    private int indexRow;
    private int indexColumn;

    Element(int rowIndex, int columnIndex) {
        this.indexRow = rowIndex;
        this.indexColumn = columnIndex;
    }

    public int getIndexColumn() {
        return indexColumn;
    } // returns the indexColumn

    public int getIndexRow() {
        return indexRow;
    } // returns the indexRow

    @Override
    public String toString() {
        return "("+indexRow+","+indexColumn+")"; // for example, indexRow=0 and indexColumn=1 , then it returns (0,1)
    }

    @Override
    public boolean equals(Object obj) { //checks if two objects are equal
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Element el = (Element) obj;
        return indexRow == el.indexRow &&
                indexColumn == el.indexColumn;
    }

    @Override
    public int compareTo(Object obj) { //overrides the compareTo method in comparable interface
        Element el = (Element) obj;   // use case: Collections.sort(List<Element>) helps to sort based on this method.
        if (this.indexRow == el.indexRow){
            return this.indexColumn - el.indexColumn;
        }
        return this.indexRow - el.indexRow;
    }
}
