package ma.fstt.trackingl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.fstt.model.Commande;
import ma.fstt.model.CommandeDAO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CommandeController implements Initializable {


    @FXML
    private TextField Date_D;
    @FXML
    private TextField Distance;

    @FXML
    private TextField Date_F;

    @FXML
    private TextField NomClient;

    @FXML
    private TableView<Commande> mytable;


    @FXML
    private TableColumn<Commande, String> col_De;

    @FXML
    private TableColumn<Commande, String> col_F;

   @FXML
    private TableColumn<Commande, String> col_CL;

    @FXML
    private TableColumn<Commande, String> col_Di;

    @FXML
    protected void onSaveButtonClick() {

        // accees a la bdd

        try {
            CommandeDAO CommandeDAO = new CommandeDAO();

            Commande cmd = new Commande(Date_D.getText(),Date_F.getText(),Distance.getText(),NomClient.getText());

            CommandeDAO.save(cmd);


            UpdateTable();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @FXML
    protected void onUpdateButtonClick() {
        Commande selectedCommande = mytable.getSelectionModel().getSelectedItem();
        if (selectedCommande != null) {
            try {
                CommandeDAO cmd = new CommandeDAO();
                //mettre a jour les champs de l'objet livreur selectionne
                selectedCommande.setDate_debut(Date_D.getText());
                selectedCommande.setDate_fin(Date_F.getText());
                selectedCommande.setDate_fin(Distance.getText());
                selectedCommande.setDate_fin(NomClient.getText());
                cmd.update(selectedCommande);
            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
            int selectedIndex = mytable.getSelectionModel().getSelectedIndex();
            mytable.getItems().set(selectedIndex, selectedCommande);
        }
    }
    @FXML
    protected void onDeletButtonClick() {

        // accees a la bdd

        try {
            CommandeDAO CommandeDAO = new CommandeDAO();

            Commande cmd = new Commande(Date_D.getText(),Date_F.getText(),Distance.getText(),NomClient.getText());

            CommandeDAO.delete(cmd);


            UpdateTable();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void UpdateTable() {
        col_De.setCellValueFactory(new PropertyValueFactory<Commande, String>("Date_debut"));
        col_F.setCellValueFactory(new PropertyValueFactory<Commande, String>("Date_fin"));

        col_Di.setCellValueFactory(new PropertyValueFactory<Commande, String>("Distance"));
        col_CL.setCellValueFactory(new PropertyValueFactory<Commande, String>("Nom_client"));


        mytable.setItems(this.getDataCommande());
    }

    public static ObservableList<Commande> getDataCommande() {

        CommandeDAO CommandeDAO = null;

        ObservableList<Commande> listfx = FXCollections.observableArrayList();

        try {
            CommandeDAO = new CommandeDAO();
            for (Commande ettemp : CommandeDAO.getAll())
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
