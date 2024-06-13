package entity;

import com.sirkaue.entity.Financing;
import factory.FinancingFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FinancingTests {

    @Test
    public void financigShouldCreateObjectWhenValidatedData() {

        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 80;

        Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

        Assertions.assertEquals(totalAmount, financing.getTotalAmount());
        Assertions.assertEquals(income, financing.getIncome());
        Assertions.assertEquals(months, financing.getMonths());
    }

    @Test
    public void constructorShouldThrowIllegalArgumentExceptionWhenInvalidatedData() {

        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 20;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);
        });
    }

    @Test
    public void setTotalAmountShouldUpdateWhenValidatedData() {

        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 80;

        Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

        financing.setTotalAmount(90000.0);
        Assertions.assertEquals(90000.0,financing.getTotalAmount());
    }
}
