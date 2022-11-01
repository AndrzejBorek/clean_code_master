package com.b.simple.design.business.customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.Amount;
import com.b.simple.design.model.customer.AmountImpl;
import com.b.simple.design.model.customer.Currency;
import com.b.simple.design.model.customer.Product;
import com.b.simple.design.model.customer.ProductImpl;
import com.b.simple.design.model.customer.ProductType;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerBOTest {

    private final CustomerBO customerBO = new CustomerBOImpl();


    @Test
    public void Customer_ProductSum_TwoProducts_Same_Currencies()
            throws DifferentCurrenciesException {
        //given
        Amount[] amounts = {
                new AmountImpl(new BigDecimal("5.00"), Currency.EURO),
                new AmountImpl(new BigDecimal("6.00"), Currency.EURO)};
        List<Product> products = createProductsWithAmmounts(amounts);
        //when
        Amount actual = customerBO.getCustomerProductsSum(products);
        AmountImpl expected = new AmountImpl(new BigDecimal("11.00"), Currency.EURO);
        //then
        assertAll(
                () -> assertEquals(expected.getCurrency(), actual.getCurrency()),
                () -> assertEquals(expected.getValue(), actual.getValue()));
    }


    @Test
    public void Customer_ProductSum_TwoProducts_Different_Currencies() throws DifferentCurrenciesException {

        //given
        Amount[] amounts = {
                new AmountImpl(new BigDecimal("5.00"), Currency.INDIAN_RUPEE),
                new AmountImpl(new BigDecimal("6.00"), Currency.EURO)};
        List<Product> products = createProductsWithAmmounts(amounts);
        //when
        Executable executable = () -> customerBO.getCustomerProductsSum(products);
        //then

        assertThrows(DifferentCurrenciesException.class, executable);
    }

    @Test
    public void testCustomerProductSum_On_Empty_Products_List() throws DifferentCurrenciesException {
        //given
        List<Product> products = new ArrayList<>();

        //when
        Amount actual = customerBO.getCustomerProductsSum(products);
        AmountImpl expected = new AmountImpl(BigDecimal.ZERO, Currency.EURO);
        //then
        assertEquals(expected.getCurrency(), actual.getCurrency());
        assertEquals(expected.getValue(), actual.getValue());
    }

    private List<Product> createProductsWithAmmounts(Amount[] amounts) {
        List<Product> products = new ArrayList<>();
        for (Amount amount : amounts) {
            products.add(
                    new ProductImpl(100, "Product 15", ProductType.BANK_GUARANTEE,
                            amount));
        }
        return products;
    }
}