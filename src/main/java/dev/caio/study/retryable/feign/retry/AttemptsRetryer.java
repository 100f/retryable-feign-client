package dev.caio.study.retryable.feign.retry;

import feign.RetryableException;
import feign.Retryer;
public class AttemptsRetryer implements Retryer {
    private final Integer maxAttempts;
    private final Integer backoff;
    private Integer currentAttempt;

    public AttemptsRetryer() {
        this(3, 1000);
    }
    public AttemptsRetryer(Integer maxAttempts, Integer backoff) {
        this.maxAttempts = maxAttempts;
        this.backoff = backoff;
        this.currentAttempt = 1;
    }

    @Override
    public void continueOrPropagate(RetryableException e) {
        System.out.println(String.format("Executando retentativa %d por causa do erro %s", currentAttempt, e.getMessage()));

        if ((currentAttempt++).equals(maxAttempts)) {
            throw e;
        }
        try {
            Thread.sleep(backoff);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Retryer clone() {
        return new AttemptsRetryer(maxAttempts, backoff);
    }
}
