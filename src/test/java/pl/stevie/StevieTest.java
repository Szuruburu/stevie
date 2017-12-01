package pl.stevie;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import lombok.SneakyThrows;
import org.junit.Test;

public class StevieTest {

  @Test
  public void shouldConvertTreeToJson(){

    Branch podlaczWtyczne = new Leaf("Podlacz wtyczke!");
    Branch pomocTechniczna = new Leaf("Skontaktuj sie z pomoca techniczna");

    Branch czyPodlaczylesDoPradu = new YesNoBranch("Czy podlaczyles do pradu", pomocTechniczna, podlaczWtyczne);

    Branch zamknijKlape = new Leaf("Zamknij tę klape!!");
    Branch czyZamknalesKlape = new YesNoBranch("Czy zamknałes klape", czyPodlaczylesDoPradu, zamknijKlape);

    DecissionTree zepsutaPralkaTree = new DecissionTree(czyZamknalesKlape);

    String decissionTreeInJson = zepsutaPralkaTree.toJson();

    System.out.println("Decision tree json:" + decissionTreeInJson);

    //Wystarczy teraz stringa decissionTreeInJson zapisać do pliku
    //Files.write(Paths.get("decissionTree.json"), decissionTreeInJson.getBytes());

  }


  @Test
  @SneakyThrows(IOException.class)
  public void shouldLoadTreeFromJson(){

    String treeInJson = new String(Files.readAllBytes(Paths.get("src/test/resources/exampleTree.json")));

    DecissionTree decissionTree = DecissionTree.fromJson(treeInJson);

    System.out.println("Decision tree object:" + decissionTree);
  }

}
