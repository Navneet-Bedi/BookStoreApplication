import java.util.ArrayList;
import java.util.List;

public class Cart {

public static List<BookBean> items=new ArrayList<BookBean>();

public Cart(){
    items = new ArrayList<BookBean>();
}

public void add(BookBean item) {
    items.add(item);
}

public void remove(BookBean item) {
    items.remove(item);
}

public int getTotalItems() {
    return items.size();
}

public Boolean doesContain(String itemName) {
    return items.contains(itemName);
}

public int totalPrice() {
    int total = 0;
    for(BookBean book: items){
        total=total+book.getPrice();
    }
    return total;
}   
//
}