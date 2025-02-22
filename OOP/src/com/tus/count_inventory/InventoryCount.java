package com.tus.count_inventory;

public interface InventoryCount {

    public long getCount();

    public void addItems(long count);

    public void removeItems(long count);
}
