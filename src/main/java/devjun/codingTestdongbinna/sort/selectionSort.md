#codingTest-dongbinna
(공부 내용 정리)
<br>출처 : 이것이 취업을 위한 코딩테스트다 with 파이썬

### 선택 정렬

데이터가 무작위로 여러 개 있을 때, 
이 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고, 그 다음 작은 데이터를 선택해 앞
에서 두 번째 데이터와 바꾸는 과정을 반복하는 것
즉 매번 '가장 작은 것을 선택'한다는 의미에서 **선택 정렬(Selection Sort)** 알고리즘이라고 함


```python
6-1 .py 선택 정렬 소스코드
array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_index = i # 가장 작은 원소의 인덱스
    for j in range(i + 1, len(array)):
        if array[min_index] > array[j]:
            min_index = j
    array[i], array[min_index] = array[min_index], array[i] # 스와프

print(array) 
```
