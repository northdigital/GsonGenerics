import java.util.List;

public class RadioGroup extends Element {
  RadioGroup(List<RadioButton> radioButtons) {
    this.radioButtons = radioButtons;
  }

  public List<RadioButton> radioButtons;
}
