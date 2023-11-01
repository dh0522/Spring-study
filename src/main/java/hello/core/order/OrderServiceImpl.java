package hello.core.order;

import hello.core.discount.DiscountPolicy;

import hello.core.member.Member;
import hello.core.member.MemberRepository;


public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository ;
    private DiscountPolicy discountPolicy; // 인터페이스(추상화)에만 의존!!


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인정책에 넘김 => 단일정책 good~!

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
