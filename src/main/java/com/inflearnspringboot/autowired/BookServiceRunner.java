package com.inflearnspringboot.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class BookServiceRunner implements ApplicationRunner {
    //runner의 개념은 다른 강좌에서 나온다 (궁금하면 추가적으로 공부!)
    @Autowired //@Auotwired는 Bean으로 등록된 객체 내에서만 사용 가능하다.
    BookService bookService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        bookService.printBookRepository();
    }
}
