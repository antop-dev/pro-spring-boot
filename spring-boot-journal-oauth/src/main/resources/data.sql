-- USERS  IN JOURNAL
INSERT INTO ACCOUNT (account_name, password)
values ('springboot', '{bcrypt}$2y$12$ApTnZ/PxcWJB2iSlUwGJ/O5je8V8UKLZdo6dAn.xwsE2Nf81N9pQi');
INSERT INTO ACCOUNT (account_name, password)
values ('springsecurity', '{bcrypt}$2y$12$784reZDFhk.Q2n6TrSBTg.jk678W7mKDzRcMP6aMi7KfPD7qgbvIS');

-- JOURNAL DATA
INSERT INTO ENTRY(title, summary, created)
VALUES ('스프링 부트 입문', '오늘부터 스프링 부트를 배웠다', '2016-01-02');
INSERT INTO ENTRY(title, summary, created)
VALUES ('간단한 스프링 부트 프로젝트', '스프링 부트 프로젝트를 처음 만들어 보았다', '2016-01-03');
INSERT INTO ENTRY(title, summary, created)
VALUES ('스프링 부트 해부', '스프링 부트를 자세히 살펴보았다', '2016-02-02');
INSERT INTO ENTRY(title, summary, created)
VALUES ('스프링 부트 클라우드', '클라우드 파운드리를 응용한 스프링 부트를 공부했다', '2016-02-05');
