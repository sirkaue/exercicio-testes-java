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
        Assertions.assertEquals(90000.0, financing.getTotalAmount());
    }

    @Test
    public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidatedData() {

        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 80;


        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

            financing.setTotalAmount(110000.0);
        });
    }

    @Test
    public void setIncomeShouldUpdateWhenValidatedData() {

        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 80;

        Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

        financing.setIncome(5000.0);
        Assertions.assertEquals(5000.00, financing.getIncome());
    }

    @Test
    public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidatedData() {

        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 80;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

            financing.setIncome(1900.0);
        });
    }

    @Test
    public void setMonthsShouldUpdateWhenValidatedData() {

        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 80;

        Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

        financing.setMonths(81);

        Assertions.assertEquals(81, financing.getMonths());
    }

    @Test
    public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidatedData() {
        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 80;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

            financing.setMonths(79);
        });
    }

    @Test
    public void entryShouldCalculateEntryCorrectly() {

        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 80;

        Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

        Assertions.assertEquals(20000.0, financing.entry());
    }

    @Test
    public void quotaShouldCalculateQuotaCorrectly() {

        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 80;

        Financing financing = FinancingFactory.createFinancing(totalAmount, income, months);

        Assertions.assertEquals(1000.0, financing.quota());
    }
}
