package study.querydsl.repository;

import study.querydsl.repository.support.Querydsl4RepositorySupport;

public class MemberTestRepository extends Querydsl4RepositorySupport {

    public MemberTestRepository(Class<?> domainClass) {
        super(domainClass);
    }

}
