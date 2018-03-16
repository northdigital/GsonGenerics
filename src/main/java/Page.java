import java.util.List;

public class Page {
  Page(String title, String description, List<Line> lines) {
    this.title = title;
    this.description = description;
    this.lines = lines;
  }

  public String title;
  public String description;
  public List<Line> lines;
}
