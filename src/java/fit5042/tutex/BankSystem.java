/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex;

import fit5042.tutex.gui.*;
import fit5042.tutex.repository.BankUserRepository;
import fit5042.tutex.repository.entities.BankUser;
import fit5042.tutex.repository.WebServiceConsumptionRepository;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author jmid3
 */
public class BankSystem implements ActionListener, ListSelectionListener {
    
    @EJB
    private static BankUserRepository repo;
    
    @EJB
    private static WebServiceConsumptionRepository ws;
    
    private BankSystemGUIImpl gui;
    private String name;
    
    /**
     * Constructor to set the name.
     * @param newName 
     */
    public BankSystem(String newName) {
        name = newName;
    }
    
    public void init(){
        gui = new BankSystemGUIImpl(name, this, this);
        this.displayAllUsers();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        
        if (event.getSource() == gui.getViewButton()) {
            this.displayAllUsers();
        } else if (event.getSource() == gui.getAddButton()) {
            this.addUser();
            this.displayAllUsers();
        } else if (event.getSource() == gui.getSearchButton()) {
            this.searchUser();
        } else if (event.getSource() == gui.getUpdateButton()) {
            this.updateUser();
        } else if (event.getSource() == gui.getDeleteButton()) {
            this.deleteUser();
        } else if (event.getSource() == gui.getTestbutton()) {
            String id = Integer.toString(this.gui.getUserId());
            String results = ws.searchTransactionByTransactionType(id);
            this.gui.displayMessageInDialog(results);
        } else {
            System.exit(0);
        }
        
    }
    
    public void addUser(){
        
        BankUser bankUser = gui.getUserDetails();

        try {
            bankUser.setPassword(this.hashPassword(bankUser.getPassword()));
            repo.addBankUser(bankUser);
            this.displayAllUsers();
            this.gui.clearInput();
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to add bank user: " + ex.getMessage());
        } finally {
            this.gui.clearInput();
        }
        
    }
    public void deleteUser(){
        
        try {
            int userId = this.gui.getSelectedBankUserId();
            repo.removeBankUser(userId);
            this.displayAllUsers();
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to delete bank user: " + ex.getMessage());
        }  finally {
            this.gui.clearInput();
        }
        
    }
    
    public void updateUser(){
        
        try {
            BankUser bankUser = this.gui.getUserDetails();
            
            repo.editBankUser(bankUser);
            this.displayAllUsers();
            this.gui.clearInput();
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to update bank user: " + ex.getMessage());
        }
        
    }
    public void searchUser(){
        
        
        BankUser searchUser = this.gui.getUserDetails();

        try {
            
            this.gui.displayUserDetails(repo.searchBankUserByCombination(searchUser));
            
        } catch (Exception e) {
            gui.displayMessageInDialog("Failed to retrieve users: " + e.getMessage());
        }
        
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if ((event.getSource() == this.gui.getUserTable().getSelectionModel())
            && (! event.getValueIsAdjusting()))
        {
            try
            {
                if (this.gui.isUserSelected()) {
                    int userId = this.gui.getSelectedBankUserId();
                
                    BankUser bankUser = repo.searchBankUserById(userId);
                    this.gui.displaySelectedUserDetails(bankUser);
                }               
            }
            catch (Exception e)
            {
                gui.displayMessageInDialog(e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            final BankSystem bank;
            bank = new BankSystem("Average Aussie Banking System");
            bank.init();
        } catch(Exception e) {
            System.out.println("Failed to run application: " + e.getMessage());
        }
    }

    public void displayAllUsers() {
        try {
            List<BankUser> bankUsers = repo.getAllBankUsers();
            
            if (bankUsers != null) {
                this.gui.displayUserDetails(bankUsers);
            }
            
        } catch (Exception ex) {
            this.gui.displayMessageInDialog("Failed to retrieve bank users: " + ex.getMessage());
        }
    }
    
    public BankUserRepository getRepo() {
        return repo;
    }

    public BankSystemGUIImpl getGui() {
        return gui;
    }

    public void setGui(BankSystemGUIImpl gui) {
        this.gui = gui;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * This method hashes the password.  It was provided mkyong.
     * https://www.mkyong.com/java/java-sha-hashing-example/
     * 
     * @param password The password to be hashed.
     * @return String The hashed password.
     */
    public String hashPassword(String password) {
        
        try {
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());

            byte byteData[] = md.digest();
            
            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }

            //System.out.println("Hex format : " + sb.toString());

            //convert the byte to hex format method 2
            StringBuffer hexString = new StringBuffer();
            for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
            }
    	//System.out.println("Hex format : " + hexString.toString());
        
            return hexString.toString();
            
        } catch (Exception e) {
            return password;
        }
        
    }
    
}
