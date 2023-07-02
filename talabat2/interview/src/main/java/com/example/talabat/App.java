package com.example.talabat;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String[] products = {"abcd", "adbc", "abaa", "acbd"};
        String searchWord = "abad";

        ProductSearch productSearch = new ProductSearch();
        List<List<String>> suggestions = productSearch.suggestedProducts(products, searchWord);

        // Print the suggestions
        for (List<String> suggestion : suggestions) {
            System.out.println(suggestion);
        }
    }
}
