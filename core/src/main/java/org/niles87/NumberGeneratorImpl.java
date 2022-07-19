package org.niles87;

import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {

    // fields
    @Getter(AccessLevel.NONE)
    private final Random random = new Random();

    private final int maxNumber;

    private final int minNumber;

    @Autowired
    public NumberGeneratorImpl(@MinNumber int minNumber, @MaxNumber int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    @Override
    public int next() {
        return random.nextInt(minNumber, maxNumber);
    }
}
