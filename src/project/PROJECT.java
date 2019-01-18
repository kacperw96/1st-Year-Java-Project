package project;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class PROJECT {
    
    private static final String FILENAME = "C:\\Users\\Kacper\\Desktop\\DATABASE.txt"; //path to the place where records will be saved. You need to change username Kacper for yours username
    public static int global_i = 0;
   
    

    public static void main(String[] args) {
        Product new_product[] = new Product[100];
            for (int i = 0; i < new_product.length; i++) {
                new_product[i] = new Product(); }
            
    option(new_product);

    }//end main

    
    public static void option(Product[] new_product) {
    
    Object[] options = {"Add product", "Edit product", "Find product", "Delete product", "EXIT"};
          int option = JOptionPane.showOptionDialog(null, "                                                                     SELECT OPTION", "Product database",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[4]);

        if (option == 0) { add_product(new_product);  }
        
        if (option == 1) { edit_product(new_product); }
        
        if (option == 2) { find_product(new_product); }
        
        if (option == 3) { delete_product(new_product); }
        
        if (option == 4) { exit(new_product); }
        
    }//end option method
    
    
    public static void add_product(Product[] new_product) {
        int i = global_i;

        JPanel myPanel = new JPanel(null);
        JFrame myFrame = new JFrame("Add new product");
        myFrame.setSize(320, 320);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        myFrame.add(myPanel);
//----------------------------------------------------------

        JLabel NameLabel = new JLabel("Product name");
        NameLabel.setBounds(23, 10, 100, 15);
        myPanel.add(NameLabel);

        JTextField NameField = new JTextField();
        NameField.setBounds(15, 26, 255, 20);
        myPanel.add(NameField);
//----------------------------------------------------------

        JLabel SupplierLabel = new JLabel("Supplier name");
        SupplierLabel.setBounds(23, 55, 100, 15);
        myPanel.add(SupplierLabel);

        JTextField SupplierField = new JTextField();
        SupplierField.setBounds(15, 71, 255, 20);
        myPanel.add(SupplierField);
//----------------------------------------------------------

        JLabel ID_Label = new JLabel("Product ID");
        ID_Label.setBounds(23, 100, 100, 15);
        myPanel.add(ID_Label);

        JTextField ID_Field = new JTextField();
        ID_Field.setBounds(15, 116, 255, 20);
        myPanel.add(ID_Field);
//----------------------------------------------------------

        JLabel Stock_Label = new JLabel("Added quantity");
        Stock_Label.setBounds(23, 145, 100, 15);
        myPanel.add(Stock_Label);

        JTextField Stock_Field = new JTextField();
        Stock_Field.setBounds(15, 161, 255, 20);
        myPanel.add(Stock_Field);
//----------------------------------------------------------  

        JLabel Price_Label = new JLabel("Price per unit");
        Price_Label.setBounds(23, 190, 100, 15);
        myPanel.add(Price_Label);

        JTextField Price_Field = new JTextField();
        Price_Field.setBounds(15, 206, 255, 20);
        myPanel.add(Price_Field);
//----------------------------------------------------------         
        
        JButton back_button = new JButton("BACK");
        back_button.setBounds(150, 235, 70, 30);
        myPanel.add(back_button);
//----------------------------------------------------------         
        
        JButton add_button = new JButton("ADD");
        add_button.setBounds(70, 235, 60, 30);
        myPanel.add(add_button);

        myFrame.setVisible(true);
        
//=================== ADD BUTTON ============================== 


        add_button.addActionListener((ActionEvent e) -> {
            if (e.getSource() == add_button) {
                myFrame.dispose();

                String getName = NameField.getText();
                String getSupplier = SupplierField.getText();
                String getID = ID_Field.getText();
                String getStock = Stock_Field.getText();
                String getPrice = Price_Field.getText();

                int _getID = Integer.parseInt(getID);
                int _getStock = Integer.parseInt(getStock);
                double _getPrice = Double.parseDouble(getPrice);
                
                
                new_product[i] = new Product(getName, getSupplier, _getID, _getStock, _getPrice);
                global_i++;
                
                
                
               if (_getStock < 0 ){
                   JOptionPane.showMessageDialog(null,"You enterd wrong stock amount!");
                   global_i = global_i - 1;
                   add_product(new_product);
                }       
               
                if (_getStock >= 0) {

                    int choice = JOptionPane.showOptionDialog(null, "Do you want add another product?", "Add product",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                    if (choice == JOptionPane.YES_OPTION) {
                        add_product(new_product);
                    } else {
                        option(new_product);
                    }

                }

        }});//end add_button.addActionListener
        
        //=================    BACK BUTTON   ============================  


        back_button.addActionListener((ActionEvent e) -> {
            if (e.getSource() == back_button) {
                myFrame.dispose();
                option(new_product);
            }}); // end back_button.addActionListener

        
    } //end add_product()


    public static void edit_product(Product[] new_product) {
        
        JPanel myPanel = new JPanel(null);
        JFrame myFrame = new JFrame("Edit Product");
        myFrame.setSize(370, 150);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        myFrame.add(myPanel);
//----------------------------------------------------------

        JLabel Label1 = new JLabel("Enter ID number of product which you want to edit");
        Label1.setBounds(18, 10, 300, 15);
        myPanel.add(Label1);

        JTextField ID_Field = new JTextField();
        ID_Field.setBounds(15, 26, 315, 20);
        myPanel.add(ID_Field);
//----------------------------------------------------------

        JLabel Label2 = new JLabel("If you do not know ID press FIND ID button");
        Label2.setBounds(95, 46, 300, 15);
        myPanel.add(Label2);

        JButton edit = new JButton("EDIT");
        edit.setBounds(70, 70, 80, 30);
        myPanel.add(edit);
//----------------------------------------------------------

        JButton find = new JButton("FIND ID");
        find.setBounds(190, 70, 80, 30);
        myPanel.add(find);
        
        myFrame.setVisible(true);
//==========================================================
    find.addActionListener((ActionEvent e) -> {
        if (e.getSource() == find) {
            myFrame.dispose();
            find_product(new_product);
        }});
        
    edit.addActionListener((ActionEvent e) -> {
        if (e.getSource() == edit) {
                String ID_txt = ID_Field.getText();
                
        for (int i = 0; new_product.length > i; i++) {
            if (new_product[i].id_to_string().equalsIgnoreCase(ID_txt)) {
                    myFrame.dispose();
                    edit_product_add_new_details(new_product, i, ID_txt);
                }
            }
        }
    });

}//end edit_product
    
    
    public static void edit_product_add_new_details(Product[] new_product, int number, String ID_txt) {

        JPanel myPanel = new JPanel(null);
        JFrame myFrame = new JFrame("Edit ID: " + ID_txt);
        myFrame.setSize(320, 320);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        myFrame.add(myPanel);
//----------------------------------------------------------

        JLabel NameLabel = new JLabel("Product name");
        NameLabel.setBounds(23, 10, 100, 15);
        myPanel.add(NameLabel);

        JTextField NameField = new JTextField(new_product[number].product_name);
        NameField.setBounds(15, 26, 255, 20);
        myPanel.add(NameField);
//----------------------------------------------------------

        JLabel SupplierLabel = new JLabel("Supplier name");
        SupplierLabel.setBounds(23, 55, 100, 15);
        myPanel.add(SupplierLabel);

        JTextField SupplierField = new JTextField(new_product[number].supplier);
        SupplierField.setBounds(15, 71, 255, 20);
        myPanel.add(SupplierField);
//----------------------------------------------------------

        JLabel ID_Label = new JLabel("Product ID");
        ID_Label.setBounds(23, 100, 100, 15);
        myPanel.add(ID_Label);

        JTextField ID_Field = new JTextField(ID_txt);
        ID_Field.setBounds(15, 116, 255, 20);
        myPanel.add(ID_Field);
//----------------------------------------------------------

        JLabel Stock_Label = new JLabel("Added quantity");
        Stock_Label.setBounds(23, 145, 100, 15);
        myPanel.add(Stock_Label);
        
            int c1 = new_product[number].stock_quantity;
            String c2 = String.valueOf(c1);
                
        JTextField Stock_Field = new JTextField(c2);
        Stock_Field.setBounds(15, 161, 255, 20);
        myPanel.add(Stock_Field);
//----------------------------------------------------------  

        JLabel Price_Label = new JLabel("Price per unit");
        Price_Label.setBounds(23, 190, 100, 15);
        myPanel.add(Price_Label);

            double convert = new_product[number].price;
            String converted = String.valueOf(convert);
        
        JTextField Price_Field = new JTextField(converted);
        Price_Field.setBounds(15, 206, 255, 20);
        myPanel.add(Price_Field);
        
//----------------------------------------------------------        
        JButton add_button = new JButton("UPDATE");
        add_button.setBounds(50, 235, 80, 30);
        myPanel.add(add_button);
        
//---------------------------------------------------------- 
        JButton back_button = new JButton("BACK");
        back_button.setBounds(150, 235, 80, 30);
        myPanel.add(back_button);

        myFrame.setVisible(true);        
        
//=============================================================
    add_button.addActionListener((ActionEvent e) -> {
            if (e.getSource() == add_button) {
                myFrame.dispose();

                String getName = NameField.getText();
                String getSupplier = SupplierField.getText();
                String getID = ID_Field.getText();
                String getStock = Stock_Field.getText();
                String getPrice = Price_Field.getText();

                int _getID = Integer.parseInt(getID);
                int _getStock = Integer.parseInt(getStock);
                double _getPrice = Double.parseDouble(getPrice);

                new_product[number] = new Product(getName, getSupplier, _getID, _getStock, _getPrice);

                int choice = JOptionPane.showOptionDialog(null, "Do you want edit another product?", "Edit product",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (choice == JOptionPane.YES_OPTION) {
                    edit_product(new_product);}
                    else {
                    option(new_product);}
            }}); //end ActionListener
    
//=============================================================  
    back_button.addActionListener((ActionEvent e) -> {
            if (e.getSource() == back_button) {
                myFrame.dispose();
                option(new_product);
            }}); //end ActionListener
    }//end edit_product_add_new_details
    

    public static void find_product(Product[] new_product) {

        int counter = 1;
        while (counter != 0) {
            Object[] find = {"Product name", "Supplier", "ID", "MENU"};
            int option = JOptionPane.showOptionDialog(null, "Find the product by", "FIND PRODUCT",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, find, find[3]);

            if (option == 0) {  find_product_name(new_product); }//end option 0

            if (option == 1) {  find_supplier(new_product); }//end option 1

            if (option == 2) {  find_id(new_product); }

            if (option == 3) {
                counter = 0;
                option(new_product);
            } //end option 3
        }//end while  
    }//end find_product       
    

    public static void find_product_name(Product[] new_product) {

        String pr_n = JOptionPane.showInputDialog("Enter product name, which you are looking for");
        for (int i = 0; new_product.length > i; i++) {
            if (new_product[i].product_name.equalsIgnoreCase(pr_n)) {
                new_product[i].print_all();
            }
        }
    }
    

    public static void find_supplier(Product[] new_product) {
        String sup = JOptionPane.showInputDialog("Enter supplier name, which you are looking for");
        for (int i = 0; new_product.length > i; i++) {
            if (new_product[i].supplier.equalsIgnoreCase(sup)) {
                new_product[i].print_all();
            }
        }
    }
    

    public static void find_id(Product[] new_product) {
        String ID = JOptionPane.showInputDialog("Enter product ID, which you are looking for");
        for (int i = 0; new_product.length > i; i++) {
            if (new_product[i].id_to_string().equalsIgnoreCase(ID)) {
                new_product[i].print_all();
            }
        }
    }
    

    public static void delete_product(Product[] new_product) {
        
        JPanel myPanel = new JPanel(null);
        JFrame myFrame = new JFrame("Delete Product");
        myFrame.setSize(370, 135);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        myFrame.add(myPanel);
//----------------------------------------------------------

        JLabel Label = new JLabel("Enter product ID which you want to delete");
        Label.setBounds(18, 10, 300, 15);
        myPanel.add(Label);

        JTextField tField = new JTextField();
        tField.setBounds(15, 26, 315, 20);
        myPanel.add(tField);
//----------------------------------------------------------
        
        JButton DELETE = new JButton("DELETE");
        DELETE.setBounds(70, 55, 80, 30);
        myPanel.add(DELETE) ;
//----------------------------------------------------------
        
        JButton BACK = new JButton("BACK");
        BACK.setBounds(190, 55, 80, 30);
        myPanel.add(BACK) ;
        myFrame.setVisible(true); 
//==========================================================

    DELETE.addActionListener((ActionEvent e) -> {
        if (e.getSource() == DELETE) {
            String id = tField.getText();
                for (int i = 0; new_product.length > i ; i++){
                    if (new_product[i].id_to_string().equalsIgnoreCase(id)) {
                        myFrame.dispose();
                        delete(new_product, i);
                    }//end if (new_product[i].id_to_string().equalsIgnoreCase(id))
                }//end for
        }// end if (e.getSource() == DELETE)
    });
        
    BACK.addActionListener((ActionEvent ev) -> {
        if (ev.getSource() == BACK) {
                myFrame.dispose();
                option(new_product);
        }
    });
}//end delete_product
    
    
    public static void delete(Product[] new_product, int number){
        
      Object[] options = {"DELETE", "BACK" };

        int option = JOptionPane.showOptionDialog(null, "Do you want delete following record \n \n" +
                "Product name: " + new_product[number].product_name + "\n" +
                "Product supplier: " + new_product[number].supplier +"\n" +
                "Product ID: " + new_product[number].product_id +"\n" +
                "Stock Quantity: " + new_product[number].stock_quantity  +"\n" + 
                "Price per unit: " + new_product[number].price , "Confirm",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);

        if (option == 0) {
            new_product[number] = new Product();
            JOptionPane.showMessageDialog(null, "Product deleted");
            option(new_product);
        }
        
        if (option == 1) { delete_product(new_product); }  
}//end delete
    
    
    public static void exit(Product[] new_product) {
int choice = JOptionPane.showOptionDialog(null, "Do you want exit the program?", "EXIT",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        if (choice == JOptionPane.YES_OPTION) {

            String content[] = new String[new_product.length];
            BufferedWriter bw = null;
            FileWriter fw = null;

            try {

                for (int i = 0; i < new_product.length; i++) {

                    content[i] = "Product name:  " + new_product[i].product_name + "    Supplier:  " + new_product[i].supplier + "      Product ID:  " + new_product[i].product_id + "      Stock quantity:  " + new_product[i].stock_quantity
                            + "     Price:  " + new_product[i].price;
                }

                fw = new FileWriter(FILENAME);
                bw = new BufferedWriter(fw);

                for (int x = 0; x < new_product.length; x++) {
                    bw.write(content[x]);
                    bw.newLine();
                    bw.write("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    bw.newLine();
                }

                System.out.println("Done");

            } catch (IOException e) {

                e.printStackTrace();

            } finally {

                try {

                    if (bw != null) {
                        bw.close();
                    }

                    if (fw != null) {
                        fw.close();
                    }

                } catch (IOException ex) {

                    ex.printStackTrace();

                }

            }
            System.exit(0);
        } else {
            option(new_product);
        }
    }//end exit
}//end class projcet


class Product {
    String product_name, supplier;
    int product_id, stock_quantity;
    double price;

    public Product() {
        product_name = "PRODUCT";
        supplier = "SUPPLIER";
        product_id = 0000;
        stock_quantity = 0;
        price = 0.0;
    }//end default

    public Product(String _product, String _supplier, int _id, int _quantity, double _price) {
        product_name = _product;
        supplier = _supplier;
        product_id = _id;
        stock_quantity = _quantity;
        price = _price;
    }

    public String id_to_string() {
        String id = Integer.toString(product_id);
        return id;
    }

    public void print_all() {
        JOptionPane.showMessageDialog(null, "Product name:    " + product_name + " \nSupplier:    " + supplier + " \nProduct ID:    " + product_id + " \nStock quantity:    " + stock_quantity
                + " \nPrice:    " + price);
        
    }
}//end class Product2

