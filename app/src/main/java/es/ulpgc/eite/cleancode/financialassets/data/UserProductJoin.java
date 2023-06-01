package es.ulpgc.eite.cleancode.financialassets.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_product_join",
        primaryKeys = { "userId", "productId" },
        foreignKeys = {
                @ForeignKey(entity = UserItem.class,
                        parentColumns = "username",
                        childColumns = "userId"),
                @ForeignKey(entity = ProductItem.class,
                        parentColumns = "id",
                        childColumns = "productId")})
public class UserProductJoin {
  @NonNull
  public final String userId;
  public final int productId;

  public UserProductJoin(String userId, int productId) {
    this.userId = userId;
    this.productId = productId;
  }
}