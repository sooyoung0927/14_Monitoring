package com.wanted.actuator.payment;

import com.wanted.actuator.metric.ShopMetrics;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final ShopMetrics shopMetrics;

    public PaymentService(ShopMetrics shopMetrics) {
        this.shopMetrics = shopMetrics;
    }

    public void pay() {

        // 타이머 동작 시작
        Timer.Sample sample = shopMetrics.startTimer();

        try {
            Thread.sleep(500);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("결제 처리가 중단되었습니다.", exception);
        }finally {
            // 타이머 멈춤
            shopMetrics.stopPaymentTimer(sample);
        }
    }
}
