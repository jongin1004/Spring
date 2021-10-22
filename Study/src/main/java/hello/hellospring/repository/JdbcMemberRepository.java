package hello.hellospring.repository;

import javax.sql.DataSource;

public class JdbcMemberRepository implements MemberRepository {

    //DB와 연결하기 위해서 DataSource가 필요
    private final DataSource dataSource;

}
