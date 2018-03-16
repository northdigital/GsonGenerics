import java.util.List;

public class DataLine extends Line {
  DataLine(List<Element> elements) {
    this.elements = elements;
  }

  List<Element> elements;
}
