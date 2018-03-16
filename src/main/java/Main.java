import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
  public static void main(String[] args) {

    RuntimeTypeAdapterFactory<Line> lineAdapterFactory = RuntimeTypeAdapterFactory
      .of(Line.class, "type")
      .registerSubtype(Seperator.class, Seperator.class.getName())
      .registerSubtype(DataLine.class, DataLine.class.getName());

    RuntimeTypeAdapterFactory<Element> elementAdapterFactory = RuntimeTypeAdapterFactory
      .of(Element.class)
      .registerSubtype(Text.class, Text.class.getName())
      .registerSubtype(CheckBox.class, CheckBox.class.getName())
      .registerSubtype(RadioGroup.class, RadioGroup.class.getName());

    Gson gson = new GsonBuilder()
      .registerTypeAdapterFactory(lineAdapterFactory)
      .registerTypeAdapterFactory(elementAdapterFactory)
      .create();

    Wizard wizard =
      new Wizard("wizard title", Arrays.asList(
        new Page("page 1", "description 1", Arrays.asList(
          new DataLine(Arrays.asList(
            new CheckBox("checkbox 1"),
            new CheckBox("checkbox 2")
          )),
          new Seperator(),
          new DataLine(Arrays.asList(
            new CheckBox("checkbox 3"),
            new CheckBox("checkbox 4")
          ))
        )),
        new Page("page 2", "description 2", Arrays.asList(
          new DataLine(Arrays.asList(
            new CheckBox("checkbox 5"),
            new CheckBox("checkbox 6")
          )),
          new Seperator(),
          new DataLine(Arrays.asList(
            new CheckBox("checkbox 7"),
            new CheckBox("checkbox 8"),
            new RadioGroup(Arrays.asList(
              new RadioButton("radio 1", "r1"),
              new RadioButton("radio 2", "r2"),
              new RadioButton("radio 3", "r3")
            ))
          ))
        ))
      ));

    String json = gson.toJson(wizard);
    System.out.println(json);
    Wizard fromJson = gson.fromJson(json, Wizard.class);
  }
}
