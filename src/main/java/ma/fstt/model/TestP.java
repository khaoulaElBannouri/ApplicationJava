package ma.fstt.model;

import java.sql.SQLException;
import java.util.List;

public class TestP {
    public static void main(String[] args) {

// trait bloc try catch
        try {


            ProduitDAO ProduitDAO = new ProduitDAO();
            //  Livreur liv = new Livreur(0l , "liv3" , "200000000");

            //livreurDAO.save(liv);

            //Livreur liv2 = new Livreur(0l , "liv2" , "100000000");


            // livreurDAO.save(liv2);


            List<Produit> liproduit =  ProduitDAO.getAll();

            for (Produit pr :liproduit) {

                System.out.println(pr.toString());

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
