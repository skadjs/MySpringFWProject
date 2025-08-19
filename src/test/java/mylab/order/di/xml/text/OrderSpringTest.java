package mylab.order.di.xml.text;

import mylab.order.di.xml.OrderService;
import mylab.order.di.xml.ShoppingCart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {

 @Autowired
 private ShoppingCart shoppingCart;

 @Autowired
 private OrderService orderService;

 @Test
 @DisplayName("ShoppingCart Bean 테스트")
 void testShoppingCartBean() {
     // 1. shoppingCart 객체가 Null이 아닌지 검증
     assertNotNull(shoppingCart, "ShoppingCart Bean이 주입되지 않았습니다.");

     // 2. shoppingCart에 상품이 2개 있는지 검증
     assertEquals(2, shoppingCart.getProducts().size(), "상품 목록의 크기가 2가 아닙니다.");

     // 3. 첫 번째 상품의 이름이 "노트북"인지 검증
     assertEquals("노트북", shoppingCart.getProducts().get(0).getName(), "첫 번째 상품명이 일치하지 않습니다.");

     // 4. 두 번째 상품의 이름이 "스마트폰"인지 검증
     assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName(), "두 번째 상품명이 일치하지 않습니다.");
     
     System.out.println("ShoppingCart 테스트 통과!");
     System.out.println(shoppingCart.getProducts());
 }

 @Test
 @DisplayName("OrderService Bean 테스트")
 void testOrderServiceBean() {
     // 1. orderService 객체가 Null이 아닌지 검증
     assertNotNull(orderService, "OrderService Bean이 주입되지 않았습니다.");
     
     // 2. orderService에 shoppingCart가 올바르게 주입되었는지 검증
     assertNotNull(orderService.getShoppingCart(), "OrderService에 ShoppingCart가 주입되지 않았습니다.");

     // 3. 주입된 shoppingCart 객체가 동일한 객체인지 검증
     assertSame(shoppingCart, orderService.getShoppingCart(), "주입된 ShoppingCart 인스턴스가 다릅니다.");
     
     System.out.println("OrderService 테스트 통과!");
 }
}
