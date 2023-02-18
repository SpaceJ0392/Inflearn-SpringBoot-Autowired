package com.inflearnspringboot.autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
//@Primary //@Primary를 통해 동일한 타입에 대해 우선적으로 선택될 Bean으로 등록 가능.
public class MyBookRepository implements BookRepository{
}
