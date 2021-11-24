package com.sheikhimtiaz;

import java.util.concurrent.*;

public class FuturePractice {
    public static void run(){
        try {
            testFutures();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private static void testFutures() throws ExecutionException, InterruptedException, TimeoutException {
        Future<Integer> future = new SquareCalculator().calculate(10);

        while(!future.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(300);
        }

        Integer result = future.get();

        Integer resultWithParam = future.get(500, TimeUnit.MILLISECONDS);

        Future<Integer> futureCanceled = new SquareCalculator().calculate(4);

        boolean canceled = future.cancel(true);

        SquareCalculator squareCalculator = new SquareCalculator();

        Future<Integer> future1 = squareCalculator.calculate(10);
        Future<Integer> future2 = squareCalculator.calculate(100);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            future1.isDone() ? "done" : "not done",
                            future2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }

        Integer result1 = future1.get();
        Integer result2 = future2.get();

        System.out.println(result1 + " and " + result2);

//          ask apu about the baeldang future tutorial, what could be the implementation of shutdown()
//        squareCalculator.shutdown();

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        FactorialSquareCalculator calculator = new FactorialSquareCalculator(10);

        forkJoinPool.execute(calculator);

    }

}
