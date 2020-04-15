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
    }

    public int getIndexRow() {
        return indexRow;
    }

    @Override
    public String toString() {
        return "("+indexRow+","+indexColumn+")";
    }

    @Override
    public boolean equals(Object obj) {
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
    public int compareTo(Object obj) {
        Element el = (Element) obj;
        if (this.indexRow == el.indexRow){
            return this.indexColumn - el.indexColumn;
        }
        return this.indexRow - el.indexRow;
    }
}
