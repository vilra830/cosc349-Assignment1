
import dao.ProductDBManager;
import gui.ProductAdministration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author villa
 */
public class Administration {
        /**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
            
                ProductDBManager dao = new ProductDBManager();
                ProductAdministration mainMenu = new ProductAdministration(dao);
                mainMenu.setLocationRelativeTo(null);
                mainMenu.setVisible(true);
                


	}
}

    
















