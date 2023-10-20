package hello.core.order;
// 최종 오더 결과를 반환
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
