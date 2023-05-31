package es.ulpgc.eite.cleancode.financialassets.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class UserItem {

  @PrimaryKey
  public final String username;
  public final String password;

  public UserItem(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public String toString() {
    return username;
  }
}