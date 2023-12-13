package org.example.model.Interface;

import org.example.model.Abstract.Product;

public interface VendingMatchine {

    public void addCurrency(int amount);
    public int getBalance();
    public Product request(int id);
    public String getDescription(int id);
    public String[] getProducts();


}
