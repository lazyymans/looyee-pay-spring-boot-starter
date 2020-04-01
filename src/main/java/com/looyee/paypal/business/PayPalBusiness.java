package com.looyee.paypal.business;

import com.looyee.paypal.common.PayPalPaymentIntent;
import com.looyee.paypal.common.PayPalPaymentMethod;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@ConditionalOnBean(APIContext.class)
@Component
public class PayPalBusiness {

    @Autowired
    private APIContext apiContext;

    public Payment createPayment(BigDecimal total, String currency, String description,
                                 PayPalPaymentMethod method, PayPalPaymentIntent intent,
                                 String cancelUrl, String successUrl) throws PayPalRESTException {

        Amount amount = new Amount();
        amount.setTotal(total.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
        amount.setCurrency(currency);

        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(method.toString());

        Payment payment = new Payment();
        payment.setIntent(intent.toString());
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);
        return payment.create(apiContext);
    }

    public Payment executeBusiness(String paymentId, String payerId) throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecute = new PaymentExecution();
        paymentExecute.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecute);
    }

}
