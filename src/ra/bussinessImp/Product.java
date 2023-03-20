package ra.bussinessImp;

import ra.bussiness.IProduct;

import java.util.Scanner;

public class Product implements IProduct, Comparable<Product>{
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean productStatus;

    public Product() {
    }

    ;

    public Product(int productId, String productName, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the product's ID");
        int productId = Integer.parseInt(input.nextLine());
        setProductId(productId);
        System.out.println("Input the product's name");
        String productName = input.nextLine();
        setProductName(productName);
        System.out.println("Input the product's title");
        String title = input.nextLine();
        setTitle(title);
        System.out.println("Input the product's descriptions");
        String descriptions = input.nextLine();
        setDescriptions(descriptions);
        System.out.println("Input the product's import price");
        float importPrice = Float.parseFloat(input.nextLine());
        setImportPrice(importPrice);
        System.out.println("Input the product's export price");
        float exportPrice = Float.parseFloat(input.nextLine());
        setExportPrice(exportPrice);
        float interest = (exportPrice - importPrice);
        setInterest(interest);
        System.out.println("Input the product's status");
        String productStatus = input.nextLine();
        setProductStatus(productStatus.equalsIgnoreCase("stock")?true:false);
    }

    @Override
    public void displayData() {
        System.out.println("ID: " + getProductId() + "\n"
                + "Product's Name: " + getProductName() + "\n"
                + "Title: " + getTitle() + "\n"
                + "Descriptions: " + getDescriptions() + "\n"
                + "Import price: " + getImportPrice() + "\n"
                + "Export price: " + getExportPrice() + "\n"
                + "Interest: " + getInterest()+ "\n"
                + "Status: " + isProductStatus()+ "\n"
                + "--------------------"
        );
    }

    @Override
    public int compareTo(Product product) {
        return (int) (this.getInterest()-product.getInterest());
    }
}
