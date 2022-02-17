# Kotiln 기반 Toy App

초기에 Zapier Integration을 위한 REST 기반 Web Application이었으나,
해당 프로젝트 종료 후, Kotlin Toy Project로 사용하고자 함

---
## Project 구성
- jdk 11
- RDB - Oracle (Docker Image - oracle11g jaspeen/oracle-xe-11g) // Local
 --- 

## TODO List
> #### 고민사항 
> - 이 프로젝트로 할 수 있는 것(주제) 고민
> - OAuth2 인증 도입
>   - AWS 이관 이후 로그인 정보 REDIS에 보관
> - AWS 이관 이후 API Monitoring ([Pinpoint](https://github.com/pinpoint-apm/pinpoint))
> - AWS 이관 이후 API 부하 테스트 ([ngrinder](https://github.com/naver/ngrinder))
> - Spring batch
> #### 체크사항
> - ~~JPA ``@Entity`` Class에 ``@Column`` Annotation 사용하지 않을 경우 어떤 변화가 있는지 확인~~
> -->  결과 : 각 field명을 Default 컬럼명으로 매핑해서 사용
> #### Code 구현 사항
> - ~~기본 로직 Trigger Controller에서 Service로 분리~~
> - ~~Repository Test 작성~~
> - querydsl 작성 (동적쿼리, 복잡한 쿼리)
--- 
