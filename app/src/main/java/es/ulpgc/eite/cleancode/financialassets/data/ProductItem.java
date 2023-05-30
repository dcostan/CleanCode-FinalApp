package es.ulpgc.eite.cleancode.financialassets.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class ProductItem {

  @PrimaryKey
  public final int id;
  public final String content;
  public final String picture;
  public final String type;
  public final String isin;
  public final String currency;
  public final Double max_spread;
  public final Double value;
  public final boolean favourite;

  public ProductItem(int id, String content, String picture, String type, String isin, String currency, Double max_spread, Double value, boolean favourite) {
    this.id = id;
    this.content = content;
    this.picture = picture;
    this.type = type;
    this.isin = isin;
    this.currency = currency;
    this.max_spread = max_spread;
    this.value = value;
    this.favourite = favourite;
  }

  @Override
  public String toString() {
    return content;
  }
}