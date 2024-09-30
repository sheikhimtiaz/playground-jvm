package com.sheikhimtiaz.concurrent;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.*;

public class FuturePractice {
    public static void run(){
        try {
            testFutures();

            tryCompletableFuture();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private static void tryCompletableFuture() throws ExecutionException, InterruptedException {
        /*
        runAsync()
        If we want to run some tasks in a new thread, without any arguments or return values,
        we can use runAsync(). It takes Runnable as an argument.
         */
        CompletableFuture<Void> userFuture = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In child thread");
        });

        userFuture.join();

        /*
        supplyAsync()
        We use supplyAsync when we expect a return value from the tasks.
        It takes a Supplier as an argument.
         */

        CompletableFuture<User> userFuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In child thread");
            return new User("Robin", "robin@gmail.com");
        });

        User user = userFuture2.join();
        System.out.println("Name : " + user.getName());
        System.out.println("Email : " + user.getEmail());

        /*
        thenAcceptAsync()
        Suppose we want to do some processing over the previous future value taking it as an argument,
        but we do not want to return anything, in such cases we can use thenAcceptAsync().

        It takes an object of the Consumer Class and returns nothing.
         */

        CompletableFuture<User> userFuture3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In child thread");
            return new User("Robin", "robin@gmail.com");
        });

        userFuture3.thenAcceptAsync((item) -> {
            System.out.println("Name: "+ item.getName());
            System.out.println("Email: "+ item.getEmail());
        }).join();

        /*
        thenRunAsync()
        We use this method to execute some task which does not require any argument over the value of the previous future.

        This method also returns nothing. It takes a Runnable object as an argument.
         */

        CompletableFuture<User> userFuture4 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In child thread");
            return new User("Robin", "robin@gmail.com");
        });

        userFuture4.thenRunAsync(() -> System.out.print("Task Successfully Executed")).join();

        /*
        thenApplyAsync()
        This is used when we need to apply a transformation on a value returned from the previous future.

        This method takes a function as an argument. It will then return a CompletableFuture of transformed type.
         */

        CompletableFuture<User> userFuture5 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In child thread : supplyAsync");
            return new User("Robin", "robin@gmail.com");
        });

        CompletableFuture<String> finalFuture = userFuture5.thenApplyAsync((user1) -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In child thread : thenApplyAsync");
            return user1.getName().toUpperCase();
        });

        String upperCaseName = finalFuture.get();
        System.out.print("Name in upper case : " + upperCaseName);

        /*
        thenCombineAsync()
        This method is used to combine two independent futures.

        It takes a BiFunction as an argument. This will finally return a CompletableFuture object that can be used further.
         */

        CompletableFuture<User> userFuture6 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In child thread 1 : supplyAsync");
            return new User("Robin", "robin@gmail.com");
        });

        CompletableFuture<String> companyFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In child thread 2 : supplyAsync");
            return "Google";
        });

        CompletableFuture<String> finalFuture2 = userFuture6.thenCombineAsync(companyFuture, (user2, company) -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In child thread : thenCombineAsync");
            return String.format("%s : %s : %s",user2.getName(), user2.getEmail(), company);
        });

        String finalResponse = finalFuture2.join();
        System.out.println(finalResponse);

        /*
        thenComposeAsync()
        We use this method to combine or chain two dependent futures.
        If we have a use case, where we need sequential execution of some of our futures,
        we can use thenComposeAsync().

        It takes Function as an argument and then it returns a CompletableFuture object which can be used further.
         */

        CompletableFuture<User> userFuture7 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In child thread : supplyAsync");
            return new User("Robin", "robin@gmail.com");
        });

        CompletableFuture<String> finalFuture3 = userFuture7.thenComposeAsync(user3 -> {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("In child thread : thenComposeAsync");
                return "Task1 : " + user3.getName();
            });
        });

        String finalResponse2 = finalFuture3.join();
        System.out.println(finalResponse2);
    }

    @Data
    @AllArgsConstructor
    public static class User {
        private String name;
        private String email;
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
