package com.example.edz.kotlinapplication.javatest;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


/**
 * @author： zcs
 * @time：2019/11/11 on 17:30
 * @description：java lambda ()
 * kotlin lambda {}
 */
//1 创建操作
//just() — 将一个或多个对象转换成发射这个或这些对象的一个Observable
//fromArray(),
//fromFuture()
//fromIterable(), — 将一个Iterable, 一个Future, 或者一个数组转换成一个Observable
//create() — 使用一个函数从头创建一个Observable
//defer() — 只有当订阅者订阅才创建Observable；为每个订阅创建一个新的Observable
//
//range() — 创建一个发射指定范围的整数序列的Observable
//interval() — 创建一个按照给定的时间间隔发射整数序列的Observable
//timer() — 创建一个在给定的延时之后发射单个数据的Observable
//empty() — 创建一个什么都不做直接通知完成的Observable
//error() — 创建一个什么都不做直接通知错误的Observable
//never() — 创建一个不发射任何数据的Observable

//2 变换操作
//map( ) — 对序列的每一项都应用一个函数来变换Observable发射的数据序列
//flatMap( ), concatMap( ), and flatMapIterable( ) — 将Observable发射的数据集合变换为Observables集合，然后将这些Observable发射的数据平坦化的放进一个单独的Observable
//switchMap( ) — 将Observable发射的数据集合变换为Observables集合，然后只发射这些Observables最近发射的数据
//scan( ) — 对Observable发射的每一项数据应用一个函数，然后按顺序依次发射每一个值
//groupBy( ) — 将Observable分拆为Observable集合，将原始Observable发射的数据按Key分组，每一个Observable发射一组不同的数据
//buffer( ) — 它定期从Observable收集数据到一个集合，然后把这些数据集合打包发射，而不是一次发射一个
//window( ) — 定期将来自Observable的数据分拆成一些Observable窗口，然后发射这些窗口，而不是每次发射一项
//cast( ) — 在发射之前强制将Observable发射的所有数据转换为指定类型

//3 过滤操作
//filter() — 过滤数据
//take() — 只发射开始的N项数据
//takeLast() — 只发射最后的N项数据
//takeWhile() — 只发射满足某种条件的数据
//skip() — 跳过开始的N项数据，发送后面的数据
//skipLast() — 跳过最后的N项数据，发送前面的数据
//skipWhile() — 满足条件的数据，发送剩下的数据
//
//firstElement()  — 只发射第一项数据
//first(default) — 只发射第一项数据，如果Observable为空就发射默认值
//
//lastElement() — 只发射最后的一项数据
//last(default) — 只发射最后的一项数据，如果Observable为空就发射默认值
//
//elementAt(index,default) — 发射第N项数据,如果第N项是空就发射默认值
//
//sample( ) or throttleLast( ) — 定期发射Observable最近的数据
//throttleFirst( ) — 定期发射Observable发射的第一项数据
//throttleWithTimeout( ) or debounce( ) — 只有当Observable在指定的时间后还没有发射数据时，才发射一个数据
//timeout( ) — 如果在一个指定的时间段后还没发射数据，就发射一个异常
//timeInterval()
//distinct( ) — 过滤掉重复数据
//distinctUntilChanged( ) — 过滤掉连续重复的数据
//ofType( ) — 只发射指定类型的数据
//ignoreElements( ) — 丢弃所有的正常数据，只发射错误或完成通知

//4 组合操作
//startWith( ) — 在数据序列的开头增加一项数据
//merge( ) — 将多个Observable合并为一个
//mergeDelayError() — 合并多个Observables，让没有错误的Observable都完成后再发射错误通知
//
//zip( ) — 使用一个函数组合多个Observable发射的数据集合，然后再发射这个结果
//
//combineLatest( ) — 当两个Observables中的任何一个发射了一个数据时，通过一个指定的函数组合每个Observable发射的最新数据（一共两个数据），然后发射这个函数的结果
//join( )and groupJoin( ) — 无论何时，如果一个Observable发射了一个数据项，只要在另一个Observable发射的数据项定义的时间窗口内，就将两个Observable发射的数据合并发射
//switchOnNext( ) — 将一个发射Observables的Observable转换成另一个Observable，后者发射这些Observables最近发射的数据

public class rxAndroid {

    public static void hello() {
//        Observable.combineLatest()
//                .switchOnNext()
        String[] names = {"aa", "bb", "cc"};
        Observable.fromArray(names)

                //.timeInterval()
                //.firstElement()
                //.first("default")
                //.elementAt()
                //.cast(Integer.class)
                .subscribe(new Consumer<String>() {

                    @Override
                    public void accept(String s) {
                        System.out.println("Hello " + s + "!");
                    }

                });
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final Handler handler = new Handler(); // bound to this thread
//        Observable.fromArray("one", "two", "three", "four", "five")
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(/* an Observer */);
//                // perform work, ...
//            }
//        }, "custom-thread-1").start();
//
//
//        Observable.timer(2,TimeUnit.SECONDS,Schedulers.newThread())
//                .subscribe(new ) ctrl + p 智能提示
//        Observable.timer(2, TimeUnit.SECONDS)
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("Observer", "error");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d("Observer", "completed");
//                    }
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Long number) {
//                        Log.d("Observer", "hello world");
//                    }
//                });


//        Observable.just(1, 2, 3, 4) // IO 线程，由 subscribeOn() 指定
//                .subscribeOn(Schedulers.io())
//
//                .observeOn(Schedulers.newThread())
//                .map(mapOperator) // 新线程，由 observeOn() 指定
//
//                .observeOn(Schedulers.io())
//                .map(mapOperator2) // IO 线程，由 observeOn() 指定
//
//                .observeOn(AndroidSchedulers.mainThread)
//                .subscribe(subscriber);  // Android 主线程，由 observeOn() 指定


    }

    public static void print() {
//        Flowable.just("Hello world").subscribe(System.out::println);
//        Flowable.just("Ios","Android").subscribe(System.out::println);
//        Flowable.just("Hello world").subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                System.out.println(s);
//            }
//        });

        Flowable.range(1, 10)
                .observeOn(Schedulers.computation())
                .map(v -> v * v)
                .filter(v -> v % 3 == 0)
                .blockingSubscribe(System.out::println);


        Observable.just(1, 4.0, 3, 2.71, 2f, 7)
                // .cast(Integer.class) //发射前转换为该类型
                .ofType(Integer.class) //只发射该类型
                .subscribe((Integer x) -> System.out.print(x + " "));

        Observable.create(emitter -> {
                    emitter.onNext("0");
                    emitter.onNext("1");
                    emitter.onNext("2");
                    emitter.onComplete();
                }
        ).subscribe(System.out::println,
                Throwable::printStackTrace,
                () -> System.out.print("complete")
        );

//        Observable.create(emitter -> {
//            while (!emitter.isDisposed()) {
//                long time = System.currentTimeMillis();
//                emitter.onNext(time);
//                if (time % 2 != 0) {
//                    emitter.onError(new IllegalStateException("Odd millisecond!"));
//                    break;
//                }
//            }
//        }).subscribe(System.out::println, Throwable::printStackTrace);

//        Flowable.fromCallable(() -> {
//            Thread.sleep(1000); //  imitate expensive computation
//            return "Done";
//        })
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.single())
//                .subscribe(System.out::println, Throwable::printStackTrace);
//
//        try {
//            Thread.sleep(2000); // <--- wait for the flow to finish
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        Flowable.range(1, 10)
//                .flatMap(v ->
//                        Flowable.just(v)
//                                .subscribeOn(Schedulers.computation())
//                                .map(w -> w * w)
//                )
//                .blockingSubscribe(System.out::println);

        Flowable.range(1, 10)
                .parallel()
                .runOn(Schedulers.computation())
                .map(v -> v * v)
                .sequential()
                .blockingSubscribe(System.out::println);


    }

    private static void createObserver() {
        //创建观察者 2 种方法
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onSubscribe(Disposable d) {
//                if(!d.isDisposed()){
//                    d.dispose();
//                }

            }

        };

        // Subscriber 继承 Observer ，对Observer类做了扩展
        Subscriber<String> subscriber = new Subscriber<String>() {

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onSubscribe(Subscription s) {

                // s.cancel();
            }

        };

    }

    public static void createObservable() {
        //create方式
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("aa");
                emitter.onNext("bb");
                emitter.onNext("cc");
                emitter.onComplete();
            }
        });

        //just方式  最多支持10个数据
        Observable<String> observable1 = Observable.just("aa", "bb", "cc");
        // 将会依次调用：
        // onNext("aa");
        // onNext("bb");
        // onNext("cc");
        // onCompleted();

        //from方式
        //1:集合
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        Observable<String> observable2 = Observable.fromIterable(list);

        //2：数组
        String[] words = {"aa", "bb", "cc"};
        Observable<String> observable3 = Observable.fromArray(words);

        observable.subscribe();
    }

    public static void operate() {
        //1、merge操作符，合并观察对象
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1.add("1");
        list1.add("2");
        list1.add("3");

        list2.add("a");
        list2.add("b");
        list2.add("c");

        Observable observable1 = Observable.fromIterable(list1);
        Observable observable2 = Observable.fromIterable(list2);


        //Observable.mergeDelayError()
        //merge合并数据  先发送observable2的全部数据，然后发送 observable1的全部数据
        //abc123
//        Observable.merge(observable2, observable1)
//                .subscribe(System.out::print);
//        //同上
//        observable2.mergeWith(observable1)
//                .subscribe(System.out::print);


        // 2、zip操作符，合并多个观察对象的数据。然后发送合并后的结果
//        Observable.zip(observable1, observable2, new BiFunction<String, String, String>() {
//            @Override
//            public String apply(String s1, String s2) {
//                return s1 + s2;
//            }
//        }).subscribe(System.out::println);
        //zip-- 1a
        //zip-- 2b
        //zip-- 3c

//        Observable.combineLatest(observable1, observable2, new BiFunction<String, String, String>() {
//            @Override
//            public String apply(String s1, String s2) {
//                return s1 + s2;
//            }
//        }).subscribe(System.out::println);
        //3a
        //3b
        //3c


        //输出[0,1,2,3]序列
//        Observable<Integer> ob = Observable.create(subscriber -> {
//            for (int i = 0; i < 4; i++) {
//                subscriber.onNext(i);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        Observable.just("a", "b")
                .join(Observable.create(emitter -> {
                            for (int i = 0; i < 4; i++) {
                                System.out.println("onNext:-------" + i);
                                emitter.onNext(i);
                                Thread.sleep(1000);
                            }

                        }),
                        s -> {
                            System.out.println("left:----" + s);//a,b
                            //使Observable延迟3000毫秒执行
                            return Observable.timer(3000, TimeUnit.MILLISECONDS);
                        },
                        integer -> {
                            //[0,1,2,3]序列
                            System.out.println("right:---" + integer);
                            //使Observable延迟2000毫秒执行
                            return Observable.timer(2000, TimeUnit.MILLISECONDS);
                        },
                        //结合上面发射的数据
                        (s, integer) -> s +  integer

                ).subscribe(o -> System.out.println("join===========" + o));

//        Observable.just("a", "b")
//                //.groupJoin()
//                .join(ob, s -> {
//                            System.out.println("left:-------" + s);//a,b
//                            //使Observable延迟3000毫秒执行
//                            return Observable.timer(3000, TimeUnit.MILLISECONDS);
//                        },
//                        integer -> {
//                            //[0,1,2,3]序列
//                            System.out.println("right:-------" + integer);
//                            //使Observable延迟2000毫秒执行
//                            return Observable.timer(2000, TimeUnit.MILLISECONDS);
//                        },
//                        //结合上面发射的数据
//                        (s, integer) -> s + "-" + integer)
//                .subscribe(o -> System.out.println("accept===========" + o));


        //原文链接：https://blog.csdn.net/hjjdehao/article/details/73322592


        //3、scan累加器操作符的使用
//        Observable.just(1, 2, 3, 4, 5)
//                .scan(new BiFunction<Integer, Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer sum, Integer itemFromIndex1) {
//                        return sum + itemFromIndex1;
//                    }
//                })
//                .subscribe(System.out::println);


//        List<String> list = new ArrayList<>();
//        for (int i = 1; i < 10; i++) {
//            list.add("" + i);
//        }//1 - 9
//        Observable<String> observable = Observable.fromIterable(list);


//        observable.buffer(2)  //把每两个数据为一组打成一个包，然后发送。
//                .subscribe(new Consumer<List<String>>() {
//                    @Override
//                    public void accept(List<String> strings) {
//
//                        System.out.println("buffer11---------------"+strings.toString());
//                        Observable.fromIterable(strings).subscribe(new Consumer<String>() {
//                            @Override
//                            public void accept(String s) {
//                                System.out.println("buffer11 data --" + s);
//                            }
//                        });
//                    }
//                });

//        buffer11---------------[1, 2]
//        buffer11 data --1
//        buffer11 data --2
//        buffer11---------------[3, 4]
//        buffer11 data --3
//        buffer11 data --4
//        buffer11---------------[5, 6]
//        buffer11 data --5
//        buffer11 data --6
//        buffer11---------------[7, 8]
//        buffer11 data --7
//        buffer11 data --8
//        buffer11---------------[9]
//        buffer11 data --9


        //第1、2 个数据打成一个数据包，跳过第三个数据 ； 第4、5个数据打成一个包，跳过第6个数据
//        observable.buffer(4, 2)  //把每两个数据为一组打成一个包，然后发送。第三个数据跳过去
//                .subscribe(new Consumer<List<String>>() {
//                    @Override
//                    public void accept(List<String> strings) {
//
//                        System.out.println("buffer22---------------"+strings.toString());
////                        Observable.fromIterable(strings).subscribe(new Consumer<String>() {
////                            @Override
////                            public void accept(String s) {
////                                System.out.println("buffer22 data --" + s);
////                            }
////                        });
//                    }
//                });
//        buffer22---------------[1, 2]
//        buffer22---------------[4, 5]
//        buffer22---------------[7, 8]

//        Observable.range(1, 9)
//                .buffer(2,4)
//                .subscribe(new Consumer<List<Integer>>() {
//                    @Override
//                    public void accept(List<Integer> strings) throws Exception {
//                        System.out.println("buffer----"+strings.toString());
//                    }
//                });

//事件数量：9 ，count ： 4,skip ： 3
//发送次数 3
//        buffer----[1, 2, 3, 4]
//        buffer----[4, 5, 6, 7]
//        buffer----[7, 8, 9]

//事件数量：9 ，count ：4,skip ： 2
//发送次数 5
//        buffer----[1, 2, 3, 4]
//        buffer----[3, 4, 5, 6]
//        buffer----[5, 6, 7, 8]
//        buffer----[7, 8, 9]
//        buffer----[9]

//事件数量：9 ，count ：5,skip ： 2
//发送次数 5
//        buffer----[1, 2, 3, 4, 5]
//        buffer----[3, 4, 5, 6, 7]
//        buffer----[5, 6, 7, 8, 9]
//        buffer----[7, 8, 9]
//        buffer----[9]


//事件数量：9 ，count ：2,skip ： 4
//发送次数 3
//        buffer----[1, 2]
//        buffer----[5, 6]
//        buffer----[9]


//        在一段时间内，只取第一个事件，然后其他事件都丢弃。
//        使用场景：1、button按钮防抖操作，防连续点击
//                 2、百度关键词联想，在一段时间内只联想一次，防止频繁请求服务器
        Observable.interval(1, TimeUnit.SECONDS)
                .throttleFirst(3, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) {
                        System.out.println("throttleFirst--" + aLong);
                    }
                });


//        Observable
//                .just("123")
//                .compose(RxUtil.compose())
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) {
//                        System.out.println(s);
//                    }
//                });


    }

    public static void actionFlatMapIterable() {
        List<Integer> list = Arrays.asList(1, 2, 3);

        Observable.fromIterable(list)
                .flatMapIterable(new Function<Integer, Iterable<String>>() {
                    @Override
                    public Iterable<String> apply(Integer integer) throws Exception {
                        return Arrays.asList(String.valueOf("a" + integer), String.valueOf("b" + integer), String.valueOf("c" + integer));
                    }
                }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                //log("accept="+s);
            }
        });
    }


    public static void main(String... args) {
        //print();
        //hello();
        operate();
    }


}

