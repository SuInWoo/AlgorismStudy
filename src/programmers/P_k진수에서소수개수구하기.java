package programmers;

/**
 * 필요 로직
 * 1. 10진수를 k진수로 변환하기
 * 2. 변환된 숫자를 자르기
 * 3. 소수 판별하기
 **/
class P_k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        String convertedNumber = convertToK(n, k);
        return findPrimeNumbers(convertedNumber);
    }

    private String convertToK(int n, int k) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            result.insert(0, n % k);
            n /= k;
        }
        return result.toString();
    }

    private int findPrimeNumbers(String number) {
        String[] parts = number.split("0");
        int count = 0;
        for (String part : parts) {
            if (!part.isEmpty() && isPrime(Long.parseLong(part))) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
