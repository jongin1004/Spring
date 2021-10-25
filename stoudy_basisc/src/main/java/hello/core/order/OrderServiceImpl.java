package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl  implements  OrderService{

    private MemberRepository memberRepository; //회원 찾기용
    private DiscountPolicy discountPolicy; //할인 정책
    //OrderServiceImpl은 추상 인터페이스인 DiscountPolicy에도 의존하고 있지만, 구체(구현) 클래스인 FixDiscount/ RateDiscount에도 의존하고 있음
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //고정 할인 정책
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return this.memberRepository;
    }
}
