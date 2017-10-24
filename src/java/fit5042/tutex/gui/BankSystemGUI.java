/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui;

import fit5042.tutex.repository.entities.BankUser;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author jmid3
 */
public interface BankSystemGUI {
    
    /**
     * Clear all the inputs in the GUI
     */
    void clearInput();

    /**
     * Clear all the text fields in the GUI
     */
    void clearTextFields();
    
    /**
     * Clear all the combo boxes in the GUI
     */
    void clearComboBoxes();
    
    /**
     * Clear all records in the table
     */
    void clearUserTable();

    /**
     * Display a message in a dialog box
     *
     * @param message - the message to display
     */
    void displayMessageInDialog(String message);
    
    /**
     * Display the details of the bank user
     *
     * @param bankUser - the details of the bank user to display
     */
    void displayUserDetails(BankUser bankUser);
    
    /**
     * Display the details of the selected bank user
     *
     * @param bankUser - the details of the selected bank user to display
     */
    void displaySelectedUserDetails(BankUser bankUser);
    
    /**
     * Display the details of the Bank user
     *
     * @param bankUser - the details of the bank user to display
     */
    void displayUserDetails(List<BankUser> bankUser);
    
    /**
     * Display the details of the bank user
     *
     * @param bankUser - the details of the bank user to display
     */
    void displayUserDetails(Set<BankUser> bankUser);
    
    /**
     * Return the ID of the bank user selected in table
     *
     * @return the ID of the selected bank user
     */
    int getSelectedBankUserId() throws Exception;
    
    /**
     * Return the Add BankUser button
     *
     * @return the attribute addButton
     */
    JButton getAddButton();

    /**
     * Return the Close Window button
     *
     * @return the attribute closeButton
     */
    JButton getCloseButton();
    
    /**
     * Return the Search BankUser by ID button
     *
     * @return the attribute searchButton
     */
    JButton getSearchButton();

    /**
     * Return the Display All BankUser button
     *
     * @return the attribute viewButton
     */
    JButton getViewButton(); 
    
    /**
     * Return the Update BankUser Details button
     *
     * @return the attribute updateButton
     */
    public JButton getUpdateButton();

    /**
     * Return the Delete BankUser Details button
     *
     * @return the attribute deleteButton
     */
    public JButton getDeleteButton();

    /**
     * Return the BankUser Details table
     *
     * @return the attribute userTable
     */
    public JTable getUserTable();

    /**
     * Return the details of the bank user to add to the database
     *
     * @return a BankUser object that contains all the details
     */
    public BankUser getUserDetails();

    /**
     * Return the id of the bank user to search the database for
     *
     * @return the id of the database to search the database for
     */
    public int getUserId();
    
    /**
     * Return the first name of the bank user
     * 
     * @return String the first name
     */
    public String getFirstName();
    
    /**
     * Return the last name of the bank user
     * 
     * @return String the last name
     */
    public String getLastName();
    
    /**
     * Return the type of the bank user
     * 
     * @return String the user type
     */
    public String getUserType();
    
    /**
     * Return the email of the bank user
     * 
     * @return String the user email
     */
    public String getEmail();
    
    /**
     * Indicate whether any bank user is selected
     *
     * @return true if a bank user is selected, or false otherwise
     */
    public boolean isUserSelected();
}
