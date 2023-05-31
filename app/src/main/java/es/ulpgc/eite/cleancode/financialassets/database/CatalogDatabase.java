package es.ulpgc.eite.cleancode.financialassets.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import es.ulpgc.eite.cleancode.financialassets.data.ProductItem;
import es.ulpgc.eite.cleancode.financialassets.data.UserItem;

@Database(entities = {ProductItem.class, UserItem.class}, version = 1)
public abstract class CatalogDatabase extends RoomDatabase {

    public abstract ProductDao productDao();
    public abstract UserDao userDao();

}