#codingTest-dongbinna
(공부 내용 정리)
<br>출처 : 이것이 취업을 위한 코딩테스트다 with 파이썬

## 퀵 정렬

퀵 정렬은 지금까지 배운 정렬 알고리즘 중에 가장 많이 사용되는 알고리즘이다.
이와 비견할만한 정렬 알고리즘은 **병합 정렬(Merge Sort)** 가 있다.
이 두 알고리즘은 대부분의 프로그래밍 언에에서 정렬 라이브러리의 근간이 되는 알고리즘이다.

---

#### 퀵 정렬의 정의
**'기준 데이터를 설정하고 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸면 어떨까?'**

---

#### 퀵 정렬의 동작 원리
퀵 정렬은 기준을 설정한 다음 큰 수와 작은 수를 교환한 후 리스트를 반으로 나누는 방식으로 동작한다.
퀵 정렬은 피벗(*pivot*)이 사용된다. 큰 숫자와 작은 숫자를 교환할 떄, 교환하기 위한 '기준'을 바로 피벗이라고 표현한다.
퀵 정렬을 수행하기 전에는 피벗을 어떻게 설정할 것인지 미리 명시해야 한다.
피벗을 설정하고 리스트를 분할하는 방법에 따라서 여러 가지 방식으로 퀵 정렬을 구분하는데,
가장 대표적인 분할 방식인 **호어 분할(*Hoare Partition*)** 방식을 기준으로 퀵 정렬을 설명하겠다. <br>
호어 분할 방식은 다음과 같은 규칙에 따라서 피벗을 설정한다.

- 리스트에서 첫 번째 데이터를 피벗으로 정한다.
---

```python
6-4 .py 퀵 정렬 소스코드
array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array, start, end):
    if start >= end: # 원소가 1개인 경우 종료
        return
    pivot = start # 피벗은 첫 번째 원소
    left = start + 1
    right = end
    while left <= right:
        # 피벗보다 큰 데이터를 찾을 때까지 반복
        while left <= end and array[left] <= array[pivot]:
            right -= 1
        # 피벗보다 작은 데이터를 찾을 때까지 반복
        while right > start and array[right] >= array[pivot]:
            right -= 1
        if left > right: # 엇갈렸다면 작은 데이터와 피벗을 교체
            array[right], array[pivot] = array[pivot], array[right]
        else: 엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
            array[left], array[right] = array[right], array[left]
    # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬 수행
    quick_sort(array, start, right - 1)
    quick_sort(array, right + 1, end)

quick_sort(array, 0, len(array) - 1)
print(array)

```

---

```python
6-5 .py 파이썬의 장점을 살린 퀵 정렬 소스코드

array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array):
    # 리스트가 하나 이하의 원소만을 담고 있다면 종료
    if len(array) <= 1:
        return array

    pivot = array[0] # 피벗은 첫 번째 원소
    tail = array[1:] # 피벗을 제외한 리스트

    left_side = [x for x in tail if x <= pivot] # 분할된 왼쪽 부분
    right_side = [x for x in tail if x > pivot] # 분할된 오른쪽 부분

    # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각각 정렬을 수행하고, 전체 리스트를 반환
    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

print(quick_sort(array))

```
---

### 퀵 정렬의 시간 복잡도
퀵 정렬의 평균 시간복잡도는 O(NlogN)이다.

|데이터의 개수(N)|N^2(선택 정렬, 삽입 정렬)|NlogN(퀵 정렬)|
|:---:|:---:|:---:|
|N = 1,000|= 1,000,000|= 10,000|
|N = 1,000,000|= 1,000,000,000,000|= 20,000,000|

평균 시간복잡도는 O(NlogN)이지만 최악의 시간복잡도는 O(N^2)<br>
이미 정렬되어 있는 경우에 매우 느리게 동작한다.
다만 기본 정렬 라이브러리를 사용할 경우 O(NlogN)을 보장해 주기 때문에 기본 정렬 라이브러리를 사용하자!
