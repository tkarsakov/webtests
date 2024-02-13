package com.solvd.webtests.web.entity;

import java.util.HashMap;
import java.util.Map;

public class ExpectedSearchResult {
    private final HashMap<String, Integer> searchResults = new HashMap<>();
    private final String searchTerm;

    public ExpectedSearchResult(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @SafeVarargs
    public final void addSearchResults(Map.Entry<String, Integer>... resultsAndOrders) {
        for (var resultAndOrder : resultsAndOrders) {
            searchResults.put(resultAndOrder.getKey(), resultAndOrder.getValue());
        }
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public HashMap<String, Integer> getSearchResults() {
        return searchResults;
    }
}
