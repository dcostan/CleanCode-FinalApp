package es.ulpgc.eite.cleancode.financialassets.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.ulpgc.eite.cleancode.financialassets.data.ProductItem;
import es.ulpgc.eite.cleancode.financialassets.data.UserProductJoin;

@Dao
public interface UserProductJoinDao {

    @Insert
    void insert(UserProductJoin userProductJoin);

    @Delete
    void delete(UserProductJoin userProductJoin);

    @Query("SELECT * FROM products INNER JOIN user_product_join ON products.id=user_product_join.productId WHERE user_product_join.userId=:userId")
    List<ProductItem> getFavouriteForUser(final String userId);

    @Query("SELECT * FROM products INNER JOIN user_product_join ON products.id=user_product_join.productId WHERE user_product_join.userId=:userId AND user_product_join.productId = :prodId")
    List<ProductItem> checkFavourite(final String userId, final int prodId);

}