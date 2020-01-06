
import com.controller.LoginController;
import com.controller.ProfileController;
import com.controller.UtilisateurBean;
import com.models.UtilisateurFacade;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZORE
 */
public class tess {
    
    
    
    public static void main(String[] args) {
       // UtilisateurBean b=new UtilisateurBean();
        UtilisateurBean b = new UtilisateurBean();
        UtilisateurFacade f=new UtilisateurFacade();
        //b.liste();
        //ProfileController b=new ProfileController();
        
        System.out.println(f.findAll().get(0).toString());
       // for (int i = 0; i < b.liste().size(); i++) {
        //    System.out.println(b.liste().get(i).toString());
            
       // }  
       /* LoginController loginController=new LoginController();
        loginController.setLogin("zormad");
        loginController.setPasswd("zormad");
        System.out.println(loginController.loging()); */
    }
}
