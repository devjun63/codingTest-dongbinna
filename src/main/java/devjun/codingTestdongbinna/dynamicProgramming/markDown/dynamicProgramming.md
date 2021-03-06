# codingTest-dongbinna
(공부 내용 정리)
<br>출처 : 이것이 취업을 위한 코딩테스트다 with 파이썬

# 08 다이나믹 프로그래밍

## 한 번 계산한 문제는 다시 계산하지 않도록 하는 알고리즘

### <1> 다이나믹 프로그래밍

#### 중복되는 연산을 줄이자

컴퓨터를 활용해도 시간이 매우 많이 필요하거나 메모리 공간이 매우 많이 필요한 문제 등은 해결하기 어렵다.
연산속도나 메모리 공간을 사용할 수 있는 데이터의 개수도 한정적이기 때문이다. <br>
고로 연산 속도와 메모리 공간을 최대한으로 활용할 수 있는 효율적인 알고리즘을 작성해야 한다.<br>
다만 메모리 공간을 약간 더 사용하면 연산속도를 비약적으로 증가시킬 수 있는 방법이 있다.
그 대표적인 방법이 바로 다이나믹 프로그래밍 **(DynamicProgramming)** 기법으로 동적 계획법이라고 표현하기도 한다.
먼저 다이나믹 프로그래밍의 기본적인 아이디어를 알아 본 후 2가지 방식 (탑다운과 보텀업)을 알아보자.
특히 다이나믹 프로그래밍을 위해 자주 사용되는 메모이제이션 기법까지 알아보자.

-동적 할당(Dynamic Allocation)과 동적 계획법의 동적은 다른 의미를 가진다.-

---

#### 기본적인 아이디어

피보나치 수열이 기존 알고리즘으로 해결하기 어려운 문제 중에서 다이나믹 프로그래밍으로 해결할 수 있는 문제이다.
피보나치 수열은 이전 두 항의 합을 현재의 항으로 설정하는 특징이 있는 수열이다.
수학자들은 인접한 항들 사이의 관계식인 점화식을 사용해 수열의 항이 이어지는 형태를 간결하게 표현한다.
프로그래밍에서는 이러한 수열을 배열이나 리스트로 표현할 수 있다. 수열 자체가 여러 개의 수가 규칙에 따라서
배열된 형태를 의미하는 것이기 때문이다. 파이썬에서는 리스트 자료형이 이를 처리하고, C/C++와 자바에서는
배열을 이용해 이를 처리한다. 리스트나 배열 모두 '연속된 많은 데이터'를 처리한다는 점은 동일하다.

```$python
8-1.py 피보나치 함수 소스코드
# 피보나치 함수(Fibonacci Function)를 재귀 함수로 구현
def fibo(x):
    if x == 1 or x == 2:
        return 1
    return fibo(x - 1) + fibo(x - 2)

print(fibo(4))
``` 
이러한 피보나치 수열 함수 코드는 f(n) 함수에서 n값이 커지면 커질수록 수행시간이 기하급수적으로
늘어나기 때문에 심각한 문제가 생길 수 있다. <br> 
이 코드의 시간 복잡도는 O(2^N)으로 N = 30이면 10억 가량의 연산을 수행해야 한다.

피보나치 수열의 점화식을 재귀 함수를 사용해 만들 수는 있지만, 단순히 매번 계산하도록 하면 문제를 효율적으로
해결할 수 없다. 이러한 문제는 다이나믹 프로그래밍을 사용하면 효율적으로 해결할 수 있는데 다만 항상
다이나믹 프로그래밍을 사용할 수 는 없고, 다음 조건을 만족할 때 사용할 수 있다.

1. 큰 문제를 작은 문제로 나눌 수 있다.
2. 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일하다.

 피보나치 수열은 이러한 조건을 만족하는 대표 문제이다. 이 문제를 메모이제이션 *(Memoization)* 기법을
사용해서 해결해보자. 메모이제이션은 다이나믹 프로그래밍을 구현하는 방법 중 한 종류로, 한 번 구한 결과를
메모리 공간에 메모해두고 같은 식을 다시 호출하면 메모한 결과를 그대로 가져오는 기법을 의미한다.
메모이제이션은 값을 저장하는 방법이므로 캐싱 *(Caching)*이라고도 한다. <br>

 메모이제이션을 구현하는 방법은 무엇인가? 바로 한 번 구한 정보를 리스트에 저장하는 것이다.
다이나믹 프로그래밍을 재귀적으로 수행하다가 같은 정보가 필요할 때는 이미 구한 정답을 그대로 리스트에서
가져오면 된다. 이를 소스코드로 나타내면 다음과 같다.

```$python
8-2.py 피보나치 수열 소스코드(재귀적)
# 한 번 계산된 결과를 메모이제이션(Memoization)하기 위한 리스트 초기화
d = [0] * 100

# 피보나치 수열(Fibonacci Function)를 재귀함수로 구현 (탑다운 다이나믹 프로그래밍)
def fibo(x):
    # 종료 조건 (1 혹은 2일 때 1을 반환)
    if x == 1 or x == 2:
        return 1
    # 이미 계산한 적 있는 문제라면 그대로 반환
    if d[x] != 0:
        return d[x]
    # 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
    d[x] = fibo(x - 1) * fibo(x - 2)
    return d[x]

print(fibo(99))
```

**다이나믹 프로그래밍이란 큰 문제를 작게 나누고, 같은 문제라면 한 번씩만 풀어 문제를 효율적으로
해결하는 알고리즘 기법이다.** 사실 큰 문제를 작게 나누는 방법은 퀵 정렬에서도 소개된 적이 있다.
퀵 정렬은 정렬을 수행할 때 정렬할 리스트를 분할하며 전체적으로 정렬이 될 수 있또록 한다. 이는 분할 정복
*(Divide and Conquer)* 알고리즘으로 분류된다. 다이나믹 프로그래밍과 분할 정복의 차이점은
다이나믹 프로그래밍은 문제들이 서로 영향을 미치고 있다는 점이다.
다이나믹 프로그래밍 코드 작성시 재귀 함수 사용시 오버헤드가 발생할 수 있으므로 
재귀 함수 대신에 반복문을 사용하여 오버헤드를 줄일 수 있다. 일반적으로 반복문을 이용한 다이나믹 프로그래밍이
더 성능이 좋기 때문이다.
그렇다면 다이나믹 프로그래밍을 적용시 피보나치 수열 알고리즘의 시간 복잡도는 어떻게 될까?
바로 O(N)이다. 왜냐하면 f(1)을 구한 다음 그 값이 f(2)를 푸는데 사용되고, f(2)의 값이
f(3)을 푸는 데 사용되는 방식으로 이어지기 때문이다. 한번 구한 결과는 다시 구해지지 않는다.

다음 코드로 호출되는 함수를 확인해 보자.
```$python
8-3.py 호출되는 함수 확인
d = [0] * 100

def pibo(x):
    print('f(' + str(x) + ')', end=' ')
    if x == 1 or x == 2:
        return 1
    if d[x] != 0:
        return d[x]
    d[x] = pibo(x - 1) + pibo(x - 2)
        return d[x]

print(6)
```

재귀 함수를 이용하여 큰 문제를 해결하기 위해 작은 문제를 호출한다고 하여 탑다운 *(Top-down)*이라 하고
반복문을 이용, 작은 문제부터 차근차근 답을 도출한다고 하여 보텀업 *(Bottom-up)* 방식이라 한다.


```$python
8-4.py 피보나치 수열 소스코드(반복적)

# 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
d = [0] * 100

# 첫 번째 피보나치 수와 두 번째 피보나치 수는 1
d[1] = 1
d[2] = 1
n = 99

# 피보나치 함수(Fibonacci Function) 반복문으로 구현(보텀업 다이나믹 프로그래밍)
for i in range(3, n + 1):
    d[i] = d[i - 1] + d[i - 2]

print(d[n])

```

탑다운(메모이제이션) 방식은 '하향식'이라고도 하며, 보텀업 방식은 '상향식'이라고도 한다.
다이나믹 프로그래밍의 전형적인 형태는 보텀업 방식이다. 보텀업 방식에서 사용되는 결과 저장용 리스트는
'DP 테이블'이라고 부르며, 메모이제이션은 탑다운 방식에 국한되어 사용되는 표현이다.