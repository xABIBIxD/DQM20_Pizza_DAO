package pizza;

import javax.swing.*;

public class PizzaComponent {
    private JPanel rootPanel;
    private JTextField textFieldId;
    private JTextField textFieldBezeichnung;
    private JTextArea textAreaBeschreibung;
    private JButton suchenButton;
    private JButton speichernButton;
    private JButton ändernButton;
    private JButton löschenButton;

    private PizzaDAO dao;

    public PizzaComponent() {
        this.dao = new PizzaDAO();


        this.löschenButton.addActionListener(e -> delete());
        this.speichernButton.addActionListener(e -> save());
        this.suchenButton.addActionListener(e -> suchen());
        this.ändernButton.addActionListener(e -> change());
    }

    private void change() {
        // Pizza-Objekt mit de Daten der GUi basteln und an die DAO schicken
        int id = Integer.parseInt(textFieldId.getText());
        String name = textFieldBezeichnung.getText();
        String beschreibung = textAreaBeschreibung.getText();
        Pizza toChange = new Pizza(id, name, beschreibung);
        dao.update(toChange);
    }

    private void suchen() {
        int id = Integer.parseInt(textFieldId.getText());

        Pizza gesuchtePizza = dao.findById(id);

        textFieldBezeichnung.setText(gesuchtePizza.getName());
        textAreaBeschreibung.setText(gesuchtePizza.getBeschreibung());
    }

    private void save() {
        String name = textFieldBezeichnung.getText();
        String beschreibung = textAreaBeschreibung.getText();
        Pizza toSave = new Pizza(0, name, beschreibung);
        dao.save(toSave);
    }

    private void delete() {
        int id = Integer.parseInt(textFieldId.getText());
        dao.delete(id);
        textFieldBezeichnung.setText("");
        textAreaBeschreibung.setText("");
        textFieldId.setText("");

    }


    public JPanel getRootPanel() {
        return this.rootPanel;
    }
}
