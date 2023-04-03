package ma.fstt.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO extends BaseDAO<Commande>{
    public CommandeDAO() throws SQLException {

        super();
    }

    @Override
    public void save(Commande object) throws SQLException {

        String request = "insert into commande (Date_debut,Date_fin,Distance,Nom_client ) values (? , ?, ? , ?)";

        // mapping objet table

        this.preparedStatement = this.connection.prepareStatement(request);
        // mapping
        this.preparedStatement.setString(1 , object.getDate_debut());

        this.preparedStatement.setString(2 , object.getDate_fin());
        this.preparedStatement.setString(3 , object.getDistance());
        this.preparedStatement.setString(4 , object.getNom_client());



        this.preparedStatement.execute();
    }

    public void update(Commande object) throws SQLException {
        String request= "UPDATE produit SET  Date_debut=? , Date_fin=? , Distance=? WHERE Nom_client=?" ;
        this.preparedStatement = this.connection.prepareStatement(request);


        this.preparedStatement.setString(1,object.getDate_debut());
        this.preparedStatement.setString(2, object.getDate_fin());
        this.preparedStatement.setString(3, object.getDistance());
        this.preparedStatement.setString(4, object.getNom_client());



        this.preparedStatement.execute();

    }

    @Override
    public void delete(Commande object) throws SQLException {



            String request= "delete  from  commande where Nom_client =?";

            this.preparedStatement = this.connection.prepareStatement(request);

            this.preparedStatement.setString(1, object.getNom_client());

            this.preparedStatement.execute();





        }



    @Override
    public List<Commande> getAll()  throws SQLException {

        List<Commande> mylist = new ArrayList<>();

        String request = "select * from commande ";

        this.statement = this.connection.createStatement();

        this.resultSet = this.statement.executeQuery(request);

// parcours de la table
        // mapping table objet
        while (this.resultSet.next()) mylist.add(new Commande(this.resultSet.getString(1),
                this.resultSet.getString(2), this.resultSet.getString(3),this.resultSet.getString(4)));


        return mylist;
    }



    @Override
    public Commande getOne(Long id) throws SQLException {
        return null;
    }
}



