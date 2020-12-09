#codingTest-dongbinna
(공부 내용 정리)
<br>출처 : 이것이 취업을 위한 코딩테스트다 with 파이썬

## 탐색 알고리즘 DFS/BFS

### BFS

**BFS(Breadth First Search)** 알고리즘은 '너비 우선 탐색'이라는 의미를 가진다.
쉽게 말해 가까운 노드 부터 탐색하는 알고리즘이다. DFS가 최대한 멀리 있는 노드를 우선으로 탐색하는 방식으로 동작한다면
BFS는 그 반대다. BFS는 선입선출 방식인 큐 자료구조를 이용하는 것이 정석이다.

#### 알고리즘의 동작 방식
* 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
* 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리를 한다.
* 위 과정을 더 이상 수행할 수 없을 때까지 반복한다.

너비 우선 탐색 알고리즘은 BFS는 큐 자료구조에 기초한다는 점에서 구현이 간단하다.
실제로 구현함에 있어 앞서 언급한 대로 deque 라이브러리를 사용하는 것이 좋으며 
탐색을 수행함에 있어 O(N)의 시간이 소요된다.
일반적인 경우 실제 수행 시간은 DFS보다 좋은 편이라는 점까지만 추가로 기억하자.

```python
5-9 .py BFS 예제

from collection import deque

# BFS 메서드 정리
def bfs(graph, start, visited):
    # 큐(Queue) 구현을 위해 deque 라이브러리 사용
    queue = deque([start])
    # 현재 노드를 방문 처리
    visited[start]= True
    # 큐가 빌 때까지 반복
    while queue:
        # 큐에서 하나의 원소를 뽑아 출력
        v = queue.popleft()
        print(v, end=' ')
        # 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
        for i in graph[v]:
            if  not visited[i]:
                queue.append(i)
                visited[i] = True

# 각 노드가 연결된 정보를 리스트 자료형으로 표현(2차원 리스트)
graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]



# 각 노드가 방문된 정보를 리스트 자료형으로 표현(1차원 리스트)
visited = [False] * 9

# 정의된 BFS 함수 호출
bfs(graph, 1, visited)
```

### DFS / BFS 정리
#### 동작원리
* DFS - 스택
* BFS - 큐

#### 구현 방법
* DFS - 재귀 함수 이용
* BFS - 큐 자료구조 이용

