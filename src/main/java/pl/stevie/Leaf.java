package pl.stevie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Leaf implements Branch {

  private String answer;

  @Override
  public boolean isLeaf() {
    return true;
  }
}
