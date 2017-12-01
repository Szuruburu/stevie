package pl.stevie;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DecissionTree {

  private Branch rootNode;

  public static DecissionTree fromJson(final String treeInJson) {
    return Jsons.GSON.fromJson(treeInJson, DecissionTree.class);
  }

  public String toJson() {
    return Jsons.GSON.toJson(this);
  }

}
