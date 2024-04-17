import java.util.ArrayList;

class PrimeCalculator {
    private static final int MAX_SIZE = 1000005;

    int nth(int nth) {
        if (nth <= 0)
            throw new IllegalArgumentException();

        boolean[] isPrime = new boolean[MAX_SIZE];
        ArrayList<Integer> primes = new ArrayList<>();

        initializeAllNumbersInIsPrimeAsTrue(isPrime);

        primeSieve(isPrime);

        addPrimesToList(isPrime, primes);

        return primes.get(nth-1);
    }

    private void initializeAllNumbersInIsPrimeAsTrue(boolean[] isPrime) {
        for (int index = 0; index < MAX_SIZE; index++)
            isPrime[index] = true;
    }

    private void addPrimesToList(boolean[] isPrime, ArrayList<Integer> primes) {
        for (int i = 2; i < MAX_SIZE; i++){
            if (isPrime[i])
                primes.add(i);
        }
    }

    private void primeSieve(boolean[] isPrime) {
        for (int i = 2; i * i <= MAX_SIZE; i++) {
            if (isPrime[i]){
                for (int j = i * i; j < MAX_SIZE; j += i){
                    isPrime[j] = false;
                }
            }
        }
    }

}
