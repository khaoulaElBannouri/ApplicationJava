package ma.fstt.trackingl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.fstt.model.Produit;
import ma.fstt.model.ProduitDAO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Hello2Controller implements Initializable {


    @FXML
    private TextField nom;


    @FXML
    private TextField description;


    @FXML
    private TableView<Produit> mytable;


    @FXML
    private TableColumn<Produit, Long> col_id;

    @FXML
    private TableColumn<Produit, String> col_nom;

    @FXML
    private TableColumn<Produit, String> col_description;


    @FXML
    protected void onSaveButton() {

        // accees a la bdd

        try {
            ProduitDAO ProduitDAO = new ProduitDAO();

            Produit liv = new Produit(0l, nom.getText(), description.getText());

            ProduitDAO.save(liv);


            UpdateTable();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void UpdateTable() {
        col_id.setCellValueFactory(new PropertyValueFactory<Produit, Long>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom"));

        col_description.setCellValueFactory(new PropertyValueFactory<Produit, String>("Description"));


        mytable.setItems(this.getDataProduit());
    }

    public static ObservableList<Produit> getDataProduit() {

        ProduitDAO ProduitDAO = null;

        ObservableList<Produit> listfx = FXCollections.observableArrayList();

        try {
            ProduitDAO= new ProduitDAO();
            for (Produit ettemp : ProduitDAO.getAll())
                listfx.add(ettemp);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();

    }


}