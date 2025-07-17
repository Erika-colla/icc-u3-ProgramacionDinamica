import java.util.HashMap;
import java.util.Map;

public class EjercicioPD {

    public long getFibonacci(int n) {
        if (n <= 1) return n;
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    public long getFibonacciPD(int n) {
        Map<Integer, Long> cache = new HashMap<>();
        return getFibonacciMemo(n, cache);
    }

    private long getFibonacciMemo(int n, Map<Integer, Long> cache) {
        if (cache.containsKey(n)) return cache.get(n);
        if (n <= 1) return n;
        long res = getFibonacciMemo(n - 1, cache) + getFibonacciMemo(n - 2, cache);
        cache.put(n, res);
        return res;
    }
}
