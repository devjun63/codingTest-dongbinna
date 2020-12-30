#codingTest-dongbinna
(공부 내용 정리)
<br>출처 : 이것이 취업을 위한 코딩테스트다 with 파이썬

## 이진 탐색 : 반으로 쪼개면서 탐색하기

이진 탐색(*Binary Search*)은 배열 내부에 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘이다.
데이터가 무작위일 때는 사용할 수 없지만, 이미 정렬되어 있다면 매우 빠르게 데이터를 찾을 수 있다는 특징
---
이진 탐색은 위치를 나타내는 변수 3개를 사용하는데 탐색하고자 하는 범위와 시작점, 끝점 그리고 중간점이다.<br>
찾으려는 데이터와 중간점(*Middle*) 위치에 있는 데이터를 반복적으로 비교해서 원하는 데이터를 찾는게 이진 탐색 과정이다.<br>
절반씩 데이터를 줄어들도록 만든다는 점이 퀵 정렬과 공통점이 있고,
시간 복잡도는 O(logN)이다. <br>
이진 탐색을 구현하는 방법에는 재귀 함수를 이용하는 방법과 반복문을 이용하는 방법, 두 가지 방법이 있다.
---

#### 재귀 함수

```python
7-2.py 재귀 함수로 구현한 이진 탐색 소스코드
# 이진 탐색 소스코드 구현(재귀 함수)
def binary_search(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    # 찾은 경우 중간점 인덱스 반환
    if array[mid] == target:
        return mid
    # 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    # 중간점의 값 보다 찾고자 하는 값이 큰 경우 오른쪽 확인
    else:
        return binary_search(array, target, mid + 1, end)

# n(원소의 개수)과 target(찾고자 하는 문자열)을 입력받기
n, target = list(map(int, input().split())
# 전체 원소 입력받기
array = list(map(int, input().split())

# 이진 탐색 수행 결과 출력
result = binary_search(array, target, 0, n - 1)
if result == None
    print("원소가 존재하지 않습니다")
else:
    print(result + 1)
```
#### 반복문
```python
7-3.py 반복문으로 구현한 이진 탐색 소스코드
#이진 탐색 소스코드 구현(반복문)
def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        # 찾은 경우 중간점 인덱스 반환
        if array[mid] == target:
            return mid
        # 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        elif array[mid] > target:
            end = mid - 1
        # 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else:
            start = end + 1
        return None

# n(원소의 개수)과 target(찾고자 하는 문자열)을 입력받기
n, target = list(map(int, input().split())
# 전체 원소 입력받기
array = list(map(int, input().split())

# 이진 탐색 수행 결과 출력
result = binary_search(array, target, 0, n - 1)
if result == None
    print("원소가 존재하지 않습니다")
else:
    print(result + 1)
```
---
### 코딩 테스트에서의 이진 탐색
생각하는 프로그래밍의 저자인 존 벤틀리의 말에 따르면 제대로 
이진 탐색 코드를 작성한 프로그래머는 10% 내외라 할 정도로 실제 구현은 까다롭다.
다른 알고리즘과 함께 사용해야 하는 경우가 있고, 코드가 짧으니 그냥 외워버리자. <br>
탐색 범위가 2,000만을 넘어가면 이진 탐색으로 문제에 접근해보자.
처리해야 할 데이터의 개수나 값이 1,000만을 넘어가면 O(logN)의 
속도를 내야하는 알고리즘을 떠올리는 연습이 필요하다.