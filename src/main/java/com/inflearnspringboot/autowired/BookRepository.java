package com.inflearnspringboot.autowired;

import org.springframework.stereotype.Repository;

//@Repository // @Component 로 Bean 등록 가능하나, AOP를 위해 더 구체적으로 @Repository를 쓰는 것이 좋다.
//만약 해당 타입의 빈이 여러 개라면?
public interface BookRepository {
}
