package coursework;

import java.util.Comparator;

// class for sorting the list into descending by stock

public class StockSorter implements Comparator<Product> {
	//comparator compares the stock numbers of products, and orders them into descending order
    @Override
    public int compare(Product p1, Product p2) {
            if(p1.getStockNum() < p2.getStockNum()) 
               return 1;
            else if (p1.getStockNum() == p2.getStockNum()) {
               return 0;
            }
            else {
               return -1;
            }
     }
}
