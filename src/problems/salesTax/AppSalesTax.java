package problems.salesTax;

import java.math.BigDecimal;

public class AppSalesTax {

    static double BASIC_SALES_TAX = 10.00;
    static double IMPORT_DUTY = 5.00;

    public static void main(String[] args) {

        Product product = new Product();
        product.price = new BigDecimal(47.50);
        product.name = "Chocolates";
        product.quantity = 1;
        product.isImported = true;
        product.productType = ProductType.OTHERS;

        System.out.println(applyTaxOnProduct(product));
        System.out.println(applyTaxOnProduct(product).add(product.price));
        int i;
    }


    static BigDecimal applyTaxOnProduct(Product product) {
        BigDecimal tax = new BigDecimal(0.0);
      tax.precision();
        if (product.productType == ProductType.OTHERS) {
            tax = tax.add(product.price.multiply(new BigDecimal(BASIC_SALES_TAX / 100)));
        }

        if (product.isImported) {
            tax = tax.add(product.price.multiply(new BigDecimal(IMPORT_DUTY / 100)));
        }

        double d= tax.subtract(new BigDecimal(tax.toBigInteger().intValue())).doubleValue();


        return tax;
    }
}
