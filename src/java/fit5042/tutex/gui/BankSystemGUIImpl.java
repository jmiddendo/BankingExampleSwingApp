/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui;

import fit5042.tutex.repository.entities.Address;
import fit5042.tutex.repository.entities.BankUser;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author jmid3
 */
public class BankSystemGUIImpl extends JFrame implements BankSystemGUI {
    
    private static final String[] TABLE_COLUMNS = {"ID", "First Name", "Last Name", "Phone Number", "Type", "Address", "Email"};
    
    private final JButton closeButton;
    private final JButton addButton;
    private final JButton viewButton;
    private final JButton searchButton;
    private final JButton updateButton;
    private final JButton deleteButton;
    private final JButton testTestButton;
    
    private final JPanel inputPanel;
    private final JPanel buttonPanel;
    
    private final JLabel bankUserIdLabel;
    private final JLabel bankUserFirstNameLabel;
    private final JLabel bankUserLastNameLabel;
    private final JLabel bankUserPhoneNumberLabel;
    private final JLabel bankUserTypeLabel;
    private final JLabel bankUserEmail;
    private final JLabel bankUserPassword;
    private final JLabel streetNumberLabel;
    private final JLabel streetAddressLabel;
    private final JLabel suburbLabel;
    private final JLabel postcodeLabel;
    private final JLabel stateLabel;

    private final JTextField bankUserIdText;
    private final JTextField bankUserFirstNameText;
    private final JTextField bankUserLastNameText;
    private final JTextField bankUserPhoneNumberText;
    private final JTextField bankUserEmailText;
    private final JTextField streetNumberText;
    private final JTextField streetAddressText;
    private final JTextField suburbText;
    private final JTextField postcodeText;
    
    private final JPasswordField bankUserPasswordText;
    
    private final JTable userTable;
    
    private final JComboBox cboState;
    private final JComboBox cboType;

    BankUser bankUser;
    
    
    public BankSystemGUIImpl (String title, ActionListener actionListener, ListSelectionListener listSelectionListener) {
        
        super(title);
        
        // create buttons
        this.closeButton = new JButton("Close");
        this.viewButton = new JButton("View All");
        this.searchButton = new JButton("Search");
        this.addButton = new JButton("Add");
        this.updateButton = new JButton("Update");
        this.deleteButton = new JButton("Delete");
        this.testTestButton = new JButton("Test Rest Service");

        // create container
        Container container = this.getContentPane();
        
        // create labels
        this.bankUserIdLabel = new JLabel("Bank User ID:");
        this.bankUserFirstNameLabel = new JLabel("First Name:");
        this.bankUserLastNameLabel = new JLabel("Last Name:");
        this.bankUserPhoneNumberLabel = new JLabel("Phone number:");
        this.bankUserTypeLabel = new JLabel("Type:");
        this.bankUserEmail = new JLabel("Email:");
        this.bankUserPassword = new JLabel("Password:");
        this.streetNumberLabel = new JLabel("Street Number:");
        this.streetAddressLabel = new JLabel("Street Address:");
        this.suburbLabel = new JLabel("Suburb:");
        this.postcodeLabel = new JLabel("Postcode:");
        this.stateLabel = new JLabel("State:");       
        
        // create text fields
        this.bankUserIdText = new JTextField();
        this.bankUserFirstNameText = new JTextField();
        this.bankUserLastNameText = new JTextField();
        this.bankUserPhoneNumberText = new JTextField();
        this.bankUserEmailText = new JTextField();
        this.streetNumberText = new JTextField();
        this.streetAddressText = new JTextField();
        this.suburbText = new JTextField();
        this.postcodeText = new JTextField();
        
        this.bankUserPasswordText = new JPasswordField();
        
        // create table
        this.userTable = new JTable(new DefaultTableModel(TABLE_COLUMNS, 0));
        this.userTable.getSelectionModel().addListSelectionListener(listSelectionListener);       
        this.userTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        TableColumnModel propertyTableColumnModel = this.userTable.getColumnModel();
        propertyTableColumnModel.getColumn(0).setPreferredWidth(50);
        propertyTableColumnModel.getColumn(1).setPreferredWidth(100);
        propertyTableColumnModel.getColumn(2).setPreferredWidth(100);
        propertyTableColumnModel.getColumn(3).setPreferredWidth(100);
        propertyTableColumnModel.getColumn(4).setPreferredWidth(100);
        propertyTableColumnModel.getColumn(5).setPreferredWidth(300);
        propertyTableColumnModel.getColumn(6).setPreferredWidth(100);
        
        //create combobox
        this.cboType = new JComboBox();
        this.cboState = new JComboBox();
        
        cboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Public", "Worker" }));
        cboState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACT", 
                                                                                "NSW", 
                                                                                "NT", 
                                                                                "QLD",
                                                                                "SA",
                                                                                "TAS",
                                                                                "VIC",
                                                                                "WA"}));
        
        // create panels
        this.inputPanel = new JPanel();
        this.buttonPanel = new JPanel();
        
        // set layout manager
        container.setLayout(new BorderLayout());
        this.inputPanel.setLayout(new GridLayout(12,2));
        this.buttonPanel.setLayout(new GridLayout(1,6));
        
        // add action listeners
        this.closeButton.addActionListener(actionListener);
        this.addButton.addActionListener(actionListener);
        this.viewButton.addActionListener(actionListener);
        this.searchButton.addActionListener(actionListener);
        this.updateButton.addActionListener(actionListener);
        this.deleteButton.addActionListener(actionListener);
        this.testTestButton.addActionListener(actionListener);
        
        // add components
        this.inputPanel.add(this.bankUserIdLabel);
        this.inputPanel.add(this.bankUserIdText);

        this.inputPanel.add(this.bankUserFirstNameLabel);
        this.inputPanel.add(this.bankUserFirstNameText);
        
        this.inputPanel.add(this.bankUserLastNameLabel);
        this.inputPanel.add(this.bankUserLastNameText);
        
        this.inputPanel.add(this.bankUserPhoneNumberLabel);
        this.inputPanel.add(this.bankUserPhoneNumberText);
        
        this.inputPanel.add(this.bankUserTypeLabel);
        this.inputPanel.add(this.cboType);
        
        this.inputPanel.add(this.bankUserEmail);
        this.inputPanel.add(this.bankUserEmailText);
        
        this.inputPanel.add(this.bankUserPassword);
        this.inputPanel.add(this.bankUserPasswordText);
        
        this.inputPanel.add(this.streetNumberLabel);
        this.inputPanel.add(this.streetNumberText);
        
        this.inputPanel.add(this.streetAddressLabel);
        this.inputPanel.add(this.streetAddressText);
        
        this.inputPanel.add(this.suburbLabel);
        this.inputPanel.add(this.suburbText);
        
        this.inputPanel.add(this.stateLabel);
        this.inputPanel.add(this.cboState);       

        this.inputPanel.add(this.postcodeLabel);
        this.inputPanel.add(this.postcodeText);
        
        // add buttons to panel
        this.buttonPanel.add(this.addButton);
        this.buttonPanel.add(this.updateButton);
        this.buttonPanel.add(this.deleteButton);
        this.buttonPanel.add(this.searchButton);
        this.buttonPanel.add(this.viewButton);
        this.buttonPanel.add(this.testTestButton);
        this.buttonPanel.add(this.closeButton);
        
        
        // add panels to content pane
        container.add(inputPanel,BorderLayout.NORTH);
        container.add(new JScrollPane(this.userTable), BorderLayout.CENTER);
        container.add(buttonPanel,BorderLayout.SOUTH);
       
        // change the default behaviour of the close button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(750, 570);       
        this.setVisible(true);
        
    }

    @Override
    public void clearInput() {
        this.clearTextFields();
        this.clearComboBoxes();
    }

    @Override
    public void clearTextFields() {
        
        this.bankUserIdText.setText("");
        this.bankUserFirstNameText.setText("");
        this.bankUserLastNameText.setText("");
        this.bankUserPhoneNumberText.setText("");
        this.bankUserEmailText.setText("");
        this.bankUserPasswordText.setText("");
        this.streetNumberText.setText("");
        this.streetAddressText.setText("");
        this.suburbText.setText("");
        this.postcodeText.setText("");
        
    }

    @Override
    public void clearComboBoxes() {
        if (this.cboType.getItemCount() > 0) {
            this.cboType.setSelectedIndex(0);
        }
        if (this.cboState.getItemCount() > 0) {
            this.cboState.setSelectedIndex(0);
        }
    }

    @Override
    public void clearUserTable() {
        int numberOfRow = this.userTable.getModel().getRowCount();
        
        if (numberOfRow > 0) {
            DefaultTableModel tableModel = (DefaultTableModel) this.userTable.getModel();
            for (int index = (numberOfRow - 1); index >= 0; index --) {
                tableModel.removeRow(index);
            }            
        }
        
    }

    @Override
    public void displayMessageInDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void displayUserDetails(BankUser bankUser) {
        this.clearUserTable();
        this.clearInput();
        
        ((DefaultTableModel)this.userTable.getModel()).addRow(new Object[]{bankUser.getBankUserId(),
                                                                           bankUser.getFirstName(),
                                                                           bankUser.getLastName(),
                                                                           bankUser.getPhoneNumber(),
                                                                           bankUser.getType(),
                                                                           bankUser.getAddress(),
                                                                           bankUser.getEmail()});
    }

    @Override
    public void displaySelectedUserDetails(BankUser bankUser) {
        
        Address address = bankUser.getAddress();
        
        this.bankUserIdText.setText(String.valueOf(bankUser.getBankUserId()));
        this.bankUserFirstNameText.setText(String.valueOf(bankUser.getFirstName()));
        this.bankUserLastNameText.setText(String.valueOf(bankUser.getLastName()));
        this.bankUserPhoneNumberText.setText(String.valueOf(bankUser.getPhoneNumber()));
        this.bankUserEmailText.setText(String.valueOf(bankUser.getEmail()));
        this.bankUserPasswordText.setText(String.valueOf(bankUser.getPassword()));
        this.streetNumberText.setText(String.valueOf(address.getStreetNumber()));
        this.streetAddressText.setText(String.valueOf(address.getStreetAddress()));
        this.suburbText.setText(String.valueOf(address.getSuburb()));
        this.postcodeText.setText(String.valueOf(address.getPostcode()));
        
        this.cboType.setSelectedItem(bankUser.getType());
        this.cboState.setSelectedItem(address.getState());
         
    }

    @Override
    public void displayUserDetails(List<BankUser> bankUser) {
        this.clearUserTable();
        this.clearInput();
        
        for (BankUser bu : bankUser) {
            ((DefaultTableModel)this.userTable.getModel()).addRow(new Object[]{bu.getBankUserId(),
                                                                               bu.getFirstName(),
                                                                               bu.getLastName(),
                                                                               bu.getPhoneNumber(),
                                                                               bu.getType(),
                                                                               bu.getAddress(),
                                                                               bu.getEmail()});
        }
    }

    @Override
    public void displayUserDetails(Set<BankUser> bankUser) {
        this.clearUserTable();
        this.clearInput();
        
        for (BankUser bu : bankUser) {
            ((DefaultTableModel)this.userTable.getModel()).addRow(new Object[]{bu.getBankUserId(),
                                                                               bu.getFirstName(),
                                                                               bu.getLastName(),
                                                                               bu.getPhoneNumber(),
                                                                               bu.getType(),
                                                                               bu.getAddress(),
                                                                               bu.getEmail()});
        }
    }

    @Override
    public int getSelectedBankUserId() throws Exception {
        int selectedRowIndex = this.userTable.getSelectedRow();
        
        String userId = this.userTable.getValueAt(selectedRowIndex, 0).toString();
        return Integer.parseInt(userId);
    }

    @Override
    public JButton getAddButton() {
        return this.addButton;
    }

    @Override
    public JButton getCloseButton() {
        return this.closeButton;
    }

    @Override
    public JButton getSearchButton() {
        return this.searchButton;
    }

    @Override
    public JButton getViewButton() {
        return this.viewButton;
    }

    @Override
    public JButton getUpdateButton() {
        return this.updateButton;
    }

    @Override
    public JButton getDeleteButton() {
        return this.deleteButton;
    }
    
    public JButton getTestbutton(){
        return this.testTestButton;
    }

    @Override
    public JTable getUserTable() {
        return this.userTable;
    }

    @Override
    public BankUser getUserDetails() {
        
        Integer newId = null;
        String id = this.bankUserIdText.getText();
        if (!id.trim().isEmpty()) {
            newId = Integer.parseInt(id);
        } else {
            newId = 0;
        }
        
        return new BankUser(newId,
                            this.bankUserFirstNameText.getText(),
                            this.bankUserLastNameText.getText(),
                            this.bankUserEmailText.getText(),
                            this.bankUserPasswordText.getText(),
                            this.cboType.getSelectedItem().toString(),
                            new Address(this.streetNumberText.getText(),this.streetAddressText.getText(),this.suburbText.getText(),this.postcodeText.getText(),this.cboState.getSelectedItem().toString()),
                            this.bankUserPhoneNumberText.getText());
    }

    @Override
    public int getUserId() {       
        String id = this.bankUserIdText.getText();
        return id == null || id.isEmpty() ? null : Integer.parseInt(id);
    }

    @Override
    public String getFirstName() {
        String name = this.bankUserFirstNameText.getText();
        return name == null || name.isEmpty() ? null : name;
    }

    @Override
    public String getLastName() {
        String name = this.bankUserLastNameText.getText();
        return name == null || name.isEmpty() ? null : name;
    }

    @Override
    public String getUserType() {
        String type = this.cboType.getSelectedItem().toString();
        return type == null || type.isEmpty() ? null : type;
    }

    @Override
    public String getEmail() {
        String email = this.bankUserEmailText.getText();
        return email == null || email.isEmpty() ? null : email;
    }

    @Override
    public boolean isUserSelected() {
        return (this.userTable.getSelectedRow() >= 0);
    }
    
}
