package com.inflearnspringboot.autowired;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
/*
    //implements InitializingBean { 을 이용하여 Autowired 이후의 부가적인 작업을 할 수도 있다. 단, 지금은
    //잘 안쓰고, @PostConstruct 를 더 많이 쓴다.  [Autowired 동작 원리 이해]
*/

/*
    @Autowired //필드에도 Autowired를 할 수 있다.
    @Qualifier("myBookRepository") //@qualifier로 가져올 빈을 지정할 수도 있으나, @primary가 좀 더 type safe 하다.
    BookRepository bookRepository;
    //만약 동일 클래스 타입을 같은 여러개의 빈이 있다면
    //@Primary를 쓰거나, 모든 같은 타입의 빈을 받거나, @Qualifier를 사용할 수 있다.

*/

/*    //모든 타입의 빈 다 받기
    @Autowired
    List<BookRepository> bookRepository;
*/


    //같은 타입의 다양한 빈에 대한 특이 사항
    @Autowired
    BookRepository myBookRepository;
    //같은 타입의 다양한 빈에 대해서 @Autowired는 이름도 확인해서
    // 이름의 bean의 id (클래스의 소문자 시작 이름)으로 지정하면 @Primary, @Qualified 등이 없어도 되기는 된다.
    // 그러나, 지양된다 (이렇게 되어 있는 프로젝트가 있을 수 있으므로 이해만 해두라고 이야기 한다.)


/*
    @Autowired
    //사실 Spring 5.2(?) 부터 생성자가 bean 으로 등록된 의존성 주입만을 받을 경우, @Autowired를 쓰지 않아도 된다.
    //예제로 보는 Spring boot 간략 정리 참고.
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
*/

/*
    @Autowired(required = false)
    //required = false를 사용하면, Autowired가 Bean 생성 도중 주입이 실패해도 넘어간다 (Bean 등록이 된다)

    // (만약 Bean으로 등록안된 의존성을 주입밭을 때)
    //정상적으로 봤을 때 setter에 @Autowired가 붙는다고 해도 해당 인스턴스는 생성되는 것이 맞다.
    //다만, @Autowired가 Bean 생성 중 의존성 주입을 시도하기에 required = true (default)로 진행하면 error가 난다.
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
*/

    public void printBookRepository() {
        System.out.println(myBookRepository.getClass());

        //모든 타입의 빈 다 받기
        //this.bookRepository.forEach(System.out::println);
        // * System.out::println 알아보기 *
    }

    //@Autowired 동작 원리 보기
    @PostConstruct //Bean Initialization 이후에 작동 (즉, Autowired 이후에 작동 BeanPostProcessor에 의해)
    public void setUp(){
        System.out.println(myBookRepository.getClass());
        //Runner와 다르게 동작 중간에 print 된다. (Runner은 application이 다 작동한 뒤에 작동하므로)
    }
}
