package es.ulpgc.eite.cleancode.financialassets.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.ulpgc.eite.cleancode.financialassets.data.ProductItem;

@Dao
public interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(ProductItem product);

    @Update
    void updateProduct(ProductItem product);

    @Delete
    void deleteProduct(ProductItem product);

    @Query("SELECT * FROM products")
    List<ProductItem> loadProducts();

    @Query("SELECT * FROM products WHERE favourite = 1")
    List<ProductItem> loadFavourites();

    @Query("SELECT * FROM products WHERE id = :id LIMIT 1")
    ProductItem loadProduct(int id);

    @Query("UPDATE products SET favourite = :favourite WHERE id = :id")
    int setFavourite(int id, boolean favourite);

}