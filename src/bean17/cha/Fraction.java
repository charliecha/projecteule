package bean17.cha;

import java.math.BigInteger;

/**
 * class of Fraction: including fields numerator and denominator
 * @author bean17.cha@gmail.com
 */
class Fraction {
    public Fraction(BigInteger numerator, BigInteger denominator) {
        super();
        this.numerator = numerator;
        this.denominator = denominator;
    }

    BigInteger numerator;
    BigInteger denominator;

    Fraction add(long n) {
        // numerator += denominator * n;
        numerator = numerator.add(denominator.multiply(BigInteger
                .valueOf(n)));
        return this;
    }

    Fraction mutiply(long n) {
        // numerator *= n;
        numerator = numerator.multiply(BigInteger.valueOf(n));
        return this;
    }

    Fraction reverse() {
        BigInteger t = numerator;
        numerator = denominator;
        denominator = t;
        return this;
    }

    @Override
    public String toString() {
        return "Fraction [numerator=" + numerator + ", denominator="
                + denominator + "]";
    }
}
