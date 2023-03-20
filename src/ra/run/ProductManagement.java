package ra.run;

import ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    public static void main(String[] args) {
        int size = 0;
        List<Product> listProduct = new ArrayList<>();
        int productId = 0;
        String productName = null;
        int choice = 0;
        Scanner input = new Scanner(System.in);
        boolean formInput = false;
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Input the amount of product and product's information");
            System.out.println("2. Show product's information");
            System.out.println("3. Sort products by ascending interest");
            System.out.println("4. Delete products by product ID");
            System.out.println("5. Search products by product name");
            System.out.println("6. Change the product's status by product ID");
            System.out.println("7. Exit");
            System.out.println("Input your choice");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Input the amount of product");
                    size = input.nextInt();
                    for (int i = 0; i < size; i++) {
                        Product product = new Product();
                        listProduct.add(product);
                        listProduct.get(i).inputData();
                    }
                    break;
                case 2:
                    if (listProduct.size() == 0) {
                        System.err.println("There is no product in the list");
                    } else {
                        for (int i = 0; i < listProduct.size(); i++) {
                            listProduct.get(i).displayData();
                        }
                    }
                    break;
                case 3:
                    if (listProduct.size() == 0) {
                        System.err.println("There is no product in the list");
                    } else {
                        Collections.sort(listProduct);
                    }
                    break;
                case 4:
                    boolean checklistProduct = false;
                    System.out.println("Input the product's ID you want to delete");
                    productId = input.nextInt();
                    for (int i = 0; i < listProduct.size(); i++) {
                        if (listProduct.get(i).getProductId() == productId) {
                            listProduct.remove(i);
                            checklistProduct=true;
                        }
                    }
                    if (checklistProduct == false) {
                        System.err.println("Can not fine the matched ID");
                    }
                    break;
                case 5:
                    boolean flag = false;
                    System.out.println("Input the product's name you want to search");
                    input.nextLine();
                    productName = input.nextLine();
                    for (int i = 0; i < listProduct.size(); i++) {
                        if (listProduct.get(i).getProductName().equalsIgnoreCase(productName)) {
                            flag = true;
                            listProduct.get(i).displayData();
                        }
                    }
                    if (flag == false) {
                        System.err.println("Can not find the product");
                    }
                    break;
                case 6:
                    boolean checkProductID =false;
                    System.out.println("Input the product's ID you want change status");
                    productId = input.nextInt();
                    String productStatus = null;
                    for (int i = 0; i < listProduct.size(); i++) {
                        if (listProduct.get(i).getProductId() == productId) {
                            checkProductID = true;
                            System.out.println("Input the status you want to change");
                            input.nextLine();
                            productStatus = input.nextLine();
                            listProduct.get(i).setProductStatus(productStatus.equalsIgnoreCase("stock") ? true : false);
                        }
                    }
                    if (checkProductID == false) {
                        System.err.println("Can not find the product");
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        } while (choice < 7);
    }
}
