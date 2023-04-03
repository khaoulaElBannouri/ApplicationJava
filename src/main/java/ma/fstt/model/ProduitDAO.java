
package ma.fstt.model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO extends BaseDAO<Produit>{
    public ProduitDAO() throws SQLException {

        super();
    }

    @Override
    public void save(Produit object) throws SQLException {

        String request = "insert into produit (nom , description) values (? , ?)";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getNom());

        this.preparedStatement.setString(2 , object.getDescription());


        this.preparedStatement.execute();
    }

    public void update(Produit object) throws SQLException {

            String request= "UPDATE produit SET  nom=? , description=? WHERE id_produit=?" ;
            this.preparedStatement = this.connection.prepareStatement(request);


            this.preparedStatement.setLong(3,object.getId_produit());
            this.preparedStatement.setString(1, object.getNom());
            this.preparedStatement.setString(2, object.getDescription());



            this.preparedStatement.execute();

        }



    @Override
    public void delete(Produit object) throws SQLException {

        {

            String request= "delete  from  produit where nom =?";

            this.preparedStatement = this.connection.prepareStatement(request);

            this.preparedStatement.setString(1, object.getNom());

            this.preparedStatement.execute();





        }

    }

    @Override
    public  List<Produit> getAll()  throws SQLException {

        List<Produit> mylist = new ArrayList<>();

        String request = "select * from produit ";

        this.statement = this.connection.createStatement();

        this.resultSet = this.statement.executeQuery(request);

// parcours de la table
        // mapping table objet
        while (this.resultSet.next()) mylist.add(new Produit(this.resultSet.getLong(1),
                this.resultSet.getString(2), this.resultSet.getString(3)));


        return mylist;
    }



    @Override
    public Produit getOne(Long id) throws SQLException {
        return null;
    }
}




