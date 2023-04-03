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

public class produitController implements Initializable {


    @FXML
    private TextField nom ;


    @FXML
    private TextField description ;


    @FXML
    private TableView<Produit> mytable ;


    @FXML
    private TableColumn<Produit ,Long> col_id ;

    @FXML
    private TableColumn <Produit ,String> col_nom ;

    @FXML
    private TableColumn <Produit ,String> col_description ;


    @FXML
    protected void SaveButton() {

        // accees a la bdd

        try {
            ProduitDAO ProduitDAO = new ProduitDAO();

            Produit Prd= new Produit(0l, nom.getText(), description.getText());
            ProduitDAO.save(Prd);


            UpdateTable();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @FXML
    protected void onDeleteButtonClick(){
        try {
            ProduitDAO ProduitDAO = new ProduitDAO();

            Produit prd = new Produit(0l, nom.getText(), description.getText());

            ProduitDAO.delete(prd);
            UpdateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    protected void onUpdateButtonClick() {
        Produit selectedProduit = mytable.getSelectionModel().getSelectedItem();
        if (selectedProduit != null) {
            try {
                ProduitDAO liv = new ProduitDAO();
                //mettre a jour les champs de l'objet livreur selectionne
                selectedProduit.setNom(nom.getText());
                selectedProduit.setDescription(description.getText());
                liv.update(selectedProduit);
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
            //mettre a jour la ligne selectionnee dans la table
            int selectedIndex = mytable.getSelectionModel().getSelectedIndex();
            mytable.getItems().set(selectedIndex, selectedProduit);
        }
    }


    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Produit,Long>("id_produit"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom"));

        col_description.setCellValueFactory(new PropertyValueFactory<Produit,String>("description"));



        mytable.setItems(this.getDataProduit());
    }

    public static ObservableList<Produit> getDataProduit(){

        ProduitDAO ProduitDAO = null;

        ObservableList<Produit> listfx = FXCollections.observableArrayList();

        try {
            ProduitDAO = new ProduitDAO();
            for (Produit ettemp : ProduitDAO.getAll())
                listfx.add(ettemp);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();

    }
}