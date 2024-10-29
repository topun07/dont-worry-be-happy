package com.lendingcatalog.model;

public interface CatalogItem {
    String getId();
    void setId(String id);
    boolean matchesName(String searchStr);
    boolean matchesCreator(String searchStr);
    boolean matchesYear(int searchYear);
    void registerItem();

}
