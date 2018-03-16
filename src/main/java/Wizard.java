import java.util.List;

public class Wizard {
  Wizard(String title, List<Page> pages) {
    this.title = title;
    this.pages = pages;
  }

  public String title;
  public List<Page> pages;
}
