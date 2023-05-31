package es.ulpgc.eite.cleancode.financialassets.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserItem {

  @PrimaryKey
  @NonNull
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