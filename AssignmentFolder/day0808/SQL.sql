--1. (1 sub쿼리 써서 풀기)
SELECT e.EMPLOYEE_ID   AS "사번",
       d.DEPARTMENT_ID AS "부서번호",
       TRUNC(e.SALARY, 0)        AS "연봉",
       a.AVG_SALARY    AS "평균 연봉"
FROM EMPLOYEES e
         INNER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
         INNER JOIN (SELECT d2.DEPARTMENT_ID      AS DEPT_NUM,
                            ROUND(AVG(e2.SALARY)) AS AVG_SALARY
                     FROM DEPARTMENTS d2
                              INNER JOIN EMPLOYEES e2 ON d2.DEPARTMENT_ID = e2.DEPARTMENT_ID
                     GROUP BY d2.DEPARTMENT_ID) a ON d.DEPARTMENT_ID = a.DEPT_NUM
WHERE e.SALARY > a.AVG_SALARY
ORDER BY a.AVG_SALARY DESC;

--1. (2 with 써서 풀기)
WITH AVG_SALARY_DATA AS (SELECT d2.DEPARTMENT_ID      AS DEPT_NUM,
                                ROUND(AVG(e2.SALARY)) AS AVG_SALARY
                         FROM DEPARTMENTS d2
                                  INNER JOIN EMPLOYEES e2 ON d2.DEPARTMENT_ID = e2.DEPARTMENT_ID
                         GROUP BY d2.DEPARTMENT_ID)
SELECT e.EMPLOYEE_ID   AS "사번",
       d.DEPARTMENT_ID AS "부서번호",
       e.SALARY        AS "연봉",
       a.AVG_SALARY    AS "평균 연봉"
FROM EMPLOYEES e
         INNER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
         INNER JOIN AVG_SALARY_DATA a ON e.DEPARTMENT_ID = a.DEPT_NUM
WHERE e.SALARY > a.AVG_SALARY
ORDER BY a.AVG_SALARY DESC;


--2. 1
WITH ALL_RANK AS (SELECT RANK() OVER (ORDER BY SALARY DESC) "RANKING",
                         e.LAST_NAME                        "LAST_NAME",
                         e.FIRST_NAME                       "FIRST_NAME",
                         ROUND(e.SALARY, 0)                 "SALARY"
                  FROM EMPLOYEES E)
SELECT RANKING,
       LAST_NAME,
       FIRST_NAME,
       SALARY
FROM ALL_RANK
WHERE RANKING BETWEEN 6 AND 10;
-- WHERE RANK() OVER (ORDER BY SALARY) BETWEEN 6 and 10;


--3. 1
select *
from JOBS;

WITH HIREYEAR_2005_SALARY_AVG AS (select JOB_ID,
                                         TO_CHAR(HIRE_DATE, 'YYYY') AS "YEAR",
                                         SALARY
                                  from EMPLOYEES
                                  where JOB_ID = 'SA_MAN')
SELECT YEAR,
       AVG(SALARY)
FROM HIREYEAR_2005_SALARY_AVG H
         INNER JOIN JOBS J ON H.JOB_ID = J.JOB_ID
WHERE J.JOB_TITLE = 'Sales Manager'
GROUP BY YEAR
ORDER BY YEAR;

--4. 1
WITH EMPLOYEE_INFO AS (SELECT E.LAST_NAME       "LN",
                              D.DEPARTMENT_NAME "DN",
                              L.CITY,
                              L.LOCATION_ID,
                              E.MANAGER_ID
                       FROM LOCATIONS L
                                INNER JOIN DEPARTMENTS D ON L.LOCATION_ID = D.LOCATION_ID
                                INNER JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
                       WHERE L.CITY = 'Seattle')
SELECT EI.LN                     "사원",
       NVL(EP.LAST_NAME, '<없음>') "매니저이름",
       EI.DN                     "부서이름"
FROM EMPLOYEE_INFO EI
         LEFT OUTER JOIN EMPLOYEES EP ON EI.MANAGER_ID = EP.EMPLOYEE_ID
ORDER BY EI.LN;


--5.
WITH DEPARTMENT_MIN_SALARY AS (SELECT DEPARTMENT_ID,

                                      TRUNC(MIN(SALARY), 0) "MIN_SALARY"

                               FROM EMPLOYEES
                               WHERE DEPARTMENT_ID is not null
                               GROUP BY DEPARTMENT_ID
                               ORDER BY DEPARTMENT_ID)
SELECT E.LAST_NAME,
       D.DEPARTMENT_NAME,
       DM.MIN_SALARY

FROM DEPARTMENT_MIN_SALARY DM
         INNER JOIN EMPLOYEES E ON DM.MIN_SALARY = E.SALARY AND DM.DEPARTMENT_ID = E.DEPARTMENT_ID
         INNER JOIN DEPARTMENTS D ON DM.DEPARTMENT_ID = D.DEPARTMENT_ID
ORDER BY D.DEPARTMENT_NAME, E.LAST_NAME;

--6.
WITH CITY_SALARY_INFO AS (select CITY,
                                 D.DEPARTMENT_ID,
                                 E.EMPLOYEE_ID "EI",
                                 E.SALARY

                          FROM LOCATIONS L
                                   INNER JOIN DEPARTMENTS D ON L.LOCATION_ID = D.LOCATION_ID
                                   INNER JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID)

SELECT CITY                  "도시이름",
       TRUNC(AVG(SALARY), 0) "평균급여",
       COUNT(EI)             "직원수"
FROM CITY_SALARY_INFO
GROUP BY CITY
HAVING COUNT(EI) < 10
ORDER BY TRUNC(AVG(SALARY), 0);

--7.

WITH PU_SALARY_AVG AS (SELECT DEPARTMENT_ID "DI",
                              AVG(SALARY)   "SALARY_AVG",
                              JOB_ID        "JI"
                       FROM EMPLOYEES
                       WHERE DEPARTMENT_ID = 30
                       GROUP BY DEPARTMENT_ID, JOB_ID)
SELECT J.JOB_TITLE  "직책",
       P.SALARY_AVG "평균 급여"
FROM PU_SALARY_AVG P
         INNER JOIN JOBS J ON P.JI = J.JOB_ID;

--8.

SELECT *
FROM JOB_HISTORY;

WITH AC_HIS AS (SELECT J.JOB_ID,
                       J.JOB_TITLE,
                       JH.EMPLOYEE_ID
                FROM JOBS J
                         INNER JOIN JOB_HISTORY JH ON J.JOB_ID = JH.JOB_ID
                WHERE JOB_TITLE = 'Public Accountant')
SELECT AH.EMPLOYEE_ID                    "사번",
       CONCAT(E.FIRST_NAME, E.LAST_NAME) "이름"
FROM AC_HIS AH
         INNER JOIN EMPLOYEES E ON AH.EMPLOYEE_ID = E.EMPLOYEE_ID;

--//2
--1.
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID IS NULL;

WITH EMPLOYEE_INFO AS (SELECT E.EMPLOYEE_ID                            "EMP_ID",
                              E.FIRST_NAME                             "FST_NAME",
                              E.LAST_NAME                              "LST_NAME",
                              NVL(D.DEPARTMENT_NAME, '<NOT ASSIGNED>') "DEPT_NAME",
                              TO_CHAR(E.HIRE_DATE, 'YYYY')             "HIRE_DAT",
                              E.JOB_ID                                 "JI"
                       FROM EMPLOYEES E
                                Left OUTER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
                       WHERE FIRST_NAME = 'Diana')
SELECT EI.EMP_ID    "EMPLOY_ID",
       EI.FST_NAME  "FIRST_NAME",
       EI.LST_NAME  "LAST_NAME",
       EI.DEPT_NAME "DEPARTMENT_NAME",
       JH.START_DATE

FROM EMPLOYEE_INFO EI
         INNER JOIN JOB_HISTORY JH ON EI.JI = JH.JOB_ID
WHERE TO_CHAR(JH.START_DATE, 'YYYY') = '2001';

SELECT *
FROM EMPLOYEES;

--아래로 돌려볼 것
SELECT E.EMPLOYEE_ID                            "EMP_ID",
       E.FIRST_NAME                             "FST_NAME",
       E.LAST_NAME                              "LST_NAME",
       NVL(D.DEPARTMENT_NAME, '<NOT ASSIGNED>') "DEPT_NAME",
       TO_CHAR(E.HIRE_DATE, 'YYYY')             "HIRE_DAT",
       E.JOB_ID                                 "JI"
FROM EMPLOYEES E
         Left OUTER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE TO_CHAR(E.HIRE_DATE, 'YYYY') = '1999';

--2
SELECT E.EMPLOYEE_ID    "EMPLOYEE_ID",
       E.FIRST_NAME     "FIRST_NAME",
       E.LAST_NAME      "LAST_NAME",
       E.EMAIL          "EMAIL",
       E.PHONE_NUMBER   "PHONE_NUMBER",
       E.HIRE_DATE      "HIRE_DATE",
       E.JOB_ID         "JOB_ID",
       E.SALARY         "SALARY",
       E.COMMISSION_PCT "COMMISSION_PCT",
       E.MANAGER_ID     "MANAGER_ID",
       E.DEPARTMENT_ID  "DEPARTMENT_ID"
FROM DEPARTMENTS D
         INNER JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
WHERE D.DEPARTMENT_NAME = 'Marketing';

--//3.------------------
--1.
SELECT E.LAST_NAME,
       ROUND(E.SALARY, 0) "SALARY"
FROM EMPLOYEES E
         INNER JOIN EMPLOYEES M ON E.MANAGER_ID = M.EMPLOYEE_ID
WHERE E.SALARY > M.SALARY;


--2.
SELECT E.FIRST_NAME,
       E.LAST_NAME,
       ROUND(E.SALARY, 0) "SALARY"
FROM EMPLOYEES E
         INNER JOIN JOBS J ON E.JOB_ID = J.JOB_ID
WHERE J.JOB_TITLE = 'Sales Representative'
  AND E.SALARY BETWEEN 9000 AND 10000;


--//4
--1.
SELECT J.JOB_TITLE,
       SUM(E.SALARY) "SUM(A.SALARY)"
FROM EMPLOYEES E
         INNER JOIN JOBS J on E.JOB_ID = J.JOB_ID
GROUP BY J.JOB_TITLE
HAVING SUM(E.SALARY) > 30000
ORDER BY "SUM(A.SALARY)" DESC;

--2.
SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       J.JOB_TITLE,
       D.DEPARTMENT_NAME

FROM LOCATIONS L
         INNER JOIN DEPARTMENTS D ON L.LOCATION_ID = D.LOCATION_ID
         INNER JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
         INNER JOIN JOBS J ON E.JOB_ID = J.JOB_ID
WHERE L.CITY = 'Seattle';



--/5.
--1.
SELECT D.DEPARTMENT_NAME       "NAME",
       MIN(E.SALARY)           "MINSAL",
       MAX(E.SALARY)           "MAXSAL",
       ROUND(AVG(E.SALARY), 5) "AVGSAL"
FROM EMPLOYEES E
         INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
GROUP BY D.DEPARTMENT_NAME;

--2.
WITH SAL_AVG_INFO AS (SELECT D.DEPARTMENT_NAME       "NAME",
                             D.DEPARTMENT_ID         "DI",
                             ROUND(AVG(E.SALARY), 0) "AVGSAL",
                             D.DEPARTMENT_NAME       "DN"
                      FROM EMPLOYEES E
                               INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
                      GROUP BY D.DEPARTMENT_NAME, D.DEPARTMENT_ID)
SELECT E2.EMPLOYEE_ID,
       SA.DI               "DEPARTMENT_ID",
       TRUNC(E2.SALARY, 0) "SALARY",
       SA.AVGSAL           "AVG_SALARY"
FROM EMPLOYEES E2
         INNER JOIN SAL_AVG_INFO SA ON E2.DEPARTMENT_ID = SA.DI
WHERE E2.SALARY > SA.AVGSAL;


--//6.
--1
SELECT E.FIRST_NAME,
       E.HIRE_DATE,
       E.EMPLOYEE_ID,
       M.FIRST_NAME
FROM EMPLOYEES E
         LEFT OUTER JOIN EMPLOYEES M ON E.MANAGER_ID = M.EMPLOYEE_ID
WHERE TO_CHAR(E.HIRE_DATE, 'YYYY') LIKE '20_3';

--2
SELECT AVG(E.SALARY)
FROM EMPLOYEES E
         INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE D.DEPARTMENT_ID = 100;

WITH SALES_SAL_INFO AS (SELECT E.FIRST_NAME,
                               TRUNC(E.SALARY, 0) "SAL",
                               D.DEPARTMENT_NAME  "DN",
                               D.DEPARTMENT_ID    "DI"
                        FROM EMPLOYEES E
                                 INNER JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
                        WHERE D.DEPARTMENT_NAME IN 'Sales')
SELECT SSI.FIRST_NAME,
       SSI.SAL,
       SSI.DN
FROM SALES_SAL_INFO SSI
         INNER JOIN (SELECT AVG(E.SALARY) "AVG_SAL"
                     FROM EMPLOYEES E
                     WHERE E.DEPARTMENT_ID = 100
                     GROUP BY DEPARTMENT_ID) HUN_AVG ON SSI.SAL < HUN_AVG.AVG_SAL;

--//7.
--1.
SELECT CONCAT(TO_CHAR(E.HIRE_DATE, 'MM'), '월') "월",
       COUNT(E.EMPLOYEE_ID)                    "직원수"
FROM EMPLOYEES E
GROUP BY TO_CHAR(E.HIRE_DATE, 'MM')
ORDER BY 월;

--2.
SELECT MAX.DNAME,
       E.FIRST_NAME,
       MAX.MS
FROM EMPLOYEES E
         INNER JOIN (WITH MAX_DI_INFO AS (SELECT DEPARTMENT_ID "DI",
                                                 MAX(SALARY)   "MAX_SAL"
                                          FROM EMPLOYEES
                                          GROUP BY DEPARTMENT_ID)
                     SELECT D.DEPARTMENT_NAME "DNAME",
                            MDI.DI            "HDI",
                            MDI.MAX_SAL       "MS"
                     FROM MAX_DI_INFO MDI
                              INNER JOIN DEPARTMENTS D ON MDI.DI = D.DEPARTMENT_ID) "MAX" ON E.DEPARTMENT_ID = MAX.HDI
WHERE E.SALARY = MAX.MS;

--3.
WITH SAL_INFO AS (SELECT DEPARTMENT_ID         "DI",
                         MAX(SALARY)           "MXS",
                         MIN(SALARY)           "MNS",
                         TRUNC(AVG(SALARY), 0) "AGS"
                  FROM EMPLOYEES
                  GROUP BY DEPARTMENT_ID)
SELECT D.DEPARTMENT_NAME,
       SI.MXS "최대급여",
       SI.MNS "최소급여",
       SI.AGS "평균급여"
FROM SAL_INFO SI
         INNER JOIN DEPARTMENTS D ON SI.DI = D.DEPARTMENT_ID;

--4.
WITH DEPT_EMP_CNT AS (SELECT DEPARTMENT_ID      "DID",
                             COUNT(EMPLOYEE_ID) "CNT"
                      FROM EMPLOYEES
                      GROUP BY DEPARTMENT_ID
                      HAVING COUNT(EMPLOYEE_ID) = 1)
SELECT NVL(D.DEPARTMENT_NAME, '<신생부서>') "DEPT_NAME",
       DC.CNT
FROM DEPT_EMP_CNT "DC"
         LEFT OUTER JOIN DEPARTMENTS D ON DC.DID = D.DEPARTMENT_ID
ORDER BY DEPT_NAME DESC;

--//7-2
--1.
WITH DEPT_HIRE AS (SELECT E.DEPARTMENT_ID,
                          TO_CHAR(E.HIRE_DATE, 'MM')        "HM",
                          COUNT(TO_CHAR(E.HIRE_DATE, 'MM')) "HM_CNT"
                   FROM EMPLOYEES E
                   GROUP BY E.DEPARTMENT_ID, E.HIRE_DATE)
SELECT D.DEPARTMENT_NAME "부서명",
       DH.HM "입사월",
       DH.HM_CNT "직원수"
FROM DEPT_HIRE "DH"
         INNER JOIN DEPARTMENTS D ON DH.DEPARTMENT_ID = D.DEPARTMENT_ID
ORDER BY D.DEPARTMENT_NAME;


--2. <>
SELECT NVL(C.COUNTRY_NAME, '부서없음'),
       NVL(L.CITY, '부서없음'),
       COUNT(EMPLOYEE_ID)
FROM COUNTRIES C
         LEFT OUTER JOIN LOCATIONS L ON C.COUNTRY_ID = L.COUNTRY_ID
         LEFT OUTER JOIN DEPARTMENTS D ON L.LOCATION_ID = D.LOCATION_ID
         LEFT OUTER JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
GROUP BY C.COUNTRY_NAME, L.CITY
HAVING COUNT(EMPLOYEE_ID) != 0
ORDER BY COUNTRY_NAME DESC;


--3.
SELECT E.EMPLOYEE_ID,
       E.FIRST_NAME,
       MAX.DNAME,
       MAX.MS,
       MAX.MA
FROM EMPLOYEES E
         INNER JOIN (WITH MAX_DI_INFO AS (SELECT DEPARTMENT_ID         "DI",
                                                 MAX(SALARY)           "MAX_SAL",
                                                 TRUNC(AVG(SALARY), 2) "AVG_SAL"
                                          FROM EMPLOYEES
                                          GROUP BY DEPARTMENT_ID)
                     SELECT D.DEPARTMENT_NAME "DNAME",
                            MDI.DI            "HDI",
                            MDI.MAX_SAL       "MS",
                            MDI.AVG_SAL       "MA"
                     FROM MAX_DI_INFO MDI
                              INNER JOIN DEPARTMENTS D ON MDI.DI = D.DEPARTMENT_ID) "MAX" ON E.DEPARTMENT_ID = MAX.HDI
WHERE E.SALARY = MAX.MS
ORDER BY E.EMPLOYEE_ID;

--4.
CREATE TABLE SALGRADE
(
    GRADE NUMBER(2) PRIMARY KEY,
    LOSAL NUMBER(5) NOT NULL,
    HISAL NUMBER(5) NOT NULL
);

SELECT *FROM SALGRADE;

INSERT INTO SALGRADE
VALUES (1, 1000, 5000);

INSERT INTO SALGRADE
VALUES (2, 5001, 10000);

INSERT INTO SALGRADE
VALUES (3, 10001, 20000);

INSERT INTO SALGRADE
VALUES (4, 20001, 30000);

SELECT
    CONCAT(S.GRADE, '등급') "급여등급",
    COUNT(E.SALARY) "직원수"
FROM EMPLOYEES E INNER JOIN SALGRADE S ON E.SALARY BETWEEN S.LOSAL AND S.HISAL
GROUP BY S.GRADE;



--//7.3
-- 1.
SELECT
    NVL(TO_CHAR(TRUNC(COMMISSION_PCT, 1) * 10), '<커미션 없음>') "커미션",
    COUNT(EMPLOYEE_ID) "직원수"
FROM EMPLOYEES
GROUP BY TRUNC(COMMISSION_PCT, 1);

--2.
WITH FOUR_COM AS (SELECT
                      DEPARTMENT_ID "DI",
                      FIRST_NAME "FN",
                      TRUNC(SALARY, 0) "SL",
                      COMMISSION_PCT "CP",
                      RANK() OVER (ORDER BY COMMISSION_PCT DESC) "CP_RANK"
                  FROM EMPLOYEES
                  WHERE COMMISSION_PCT IS NOT NULL)
SELECT
    D.DEPARTMENT_NAME,
    FC.FN,
    FC.SL,
    TO_CHAR(FC.CP)
FROM FOUR_COM FC INNER JOIN DEPARTMENTS D ON FC.DI = D.DEPARTMENT_ID
WHERE FC.CP_RANK IN (1, 2, 3, 4)
ORDER BY FC.CP_RANK;

