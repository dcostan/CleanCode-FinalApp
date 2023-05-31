package es.ulpgc.eite.cleancode.financialassets.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.ulpgc.eite.cleancode.financialassets.data.ProductItem;
import es.ulpgc.eite.cleancode.financialassets.data.UserItem;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(UserItem user);

    @Delete
    void removeUser(UserItem user);

    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    UserItem loadUser(String username);

}