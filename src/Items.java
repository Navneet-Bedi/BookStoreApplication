
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sanaali
 */
public class Items implements Serializable{
 private String itemId;
 private String itemName;
 private String itemPrice;
 public Items(){}
 
 public Items(String ItemId, String ItemName, String ItemPrice)
 {
     itemId= ItemId;
     itemName = ItemName;
     itemPrice = ItemPrice;
 }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    
}
