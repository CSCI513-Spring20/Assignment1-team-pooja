package com.niu;


public interface Search {
    public String Name(); // Name() represents the name of the strategy
    public void runSearch(Integer[][] grid); // runSearch implements the search strategy
}