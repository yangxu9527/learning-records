package com.siping.并发.并发编程实战.chapter3.使用final;


import java.math.BigInteger;

/**
 * @author Xu.Yang
 * @date 2019/3/27 17 02
 * @desc:   通过增加一个不可变的缓存类来达到稍弱的原子性。
 *        对于访问和更新多个相关变量时出现的竞态条件问题，可以通过将这些变量全部保存在一个不可变的对象中来消除。由于该对象是不可变对象，当线程获得了
 *        该对象的引用后，就不用担心另一个线程会修改对象的状态。如果要更新这些变量，那么可以创建一个新的容器对象，使其他使用原有对象的线程仍然会看到
 *        对象处于一直的状态。
 *
 *          任何线程都可以在不需要额外同步的情况下安全的访问不可变对象，即使在发布这些对象时没有使用同步。
 *        备注：
 *          在旧的Java内存模型中 ，最严重的一个缺陷就是线程可能看到final域的值会改变。比如，一个线程当前看到一个整形final域的值为0（还未初始化之前
 *        的默认值），过一段时间之后这个线程再去读这个final域的值时，却发现值变为了1（被某个线程初始化之后的值）。最常见的例子就是在旧的Java内存
 *        模型中，String的值可能会改变（参考文献2中有一个具体的例子，感兴趣的读者可以自行参考，这里就不赘述了）。
 *          为了修补这个漏洞，JSR-133专家组增强了final的语义。通过为final域增加写和读重排序规则，可以为java程序员提供初始化安全保证：只要对象
 *        是正确构造的（被构造对象的引用在构造函数中没有“逸出”），那么不需要使用同步（指lock和volatile的使用），就可以保证任意线程都能看到这个
 *        final域在构造函数中被初始化之后的值。
 *
 *        要安全的发布一个对象，对象的引用以及对象的状态必须同时对其他线程可见。一个正确构造的对象可以通过以下方式来安全的发布：
 *        1.在静态初始化函数中初始化一个对象引用
 *        2.将对象的引用保存到volatile类型的域或者AtomicReferance对象中
 *        3.将对象的引用保存到某个正确构造对象的final类型域中
 *        4.将对象的引用保存到一个由锁保护的域中
 *
 *        通常，发布一个静态构造的对象，最简单和最安全的方式是使用静态的初始化容器：
 *        public static Holder holder = new Holder(42);
 *
 *
 */
public class OneValueCache {

    private final BigInteger lastNumber;

    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger lastNumber, BigInteger[] lastFactors) {
        this.lastNumber = lastNumber;
        this.lastFactors = lastFactors.clone();
    }

    public BigInteger[] getLastFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return this.lastFactors.clone();
        }
    }
}
