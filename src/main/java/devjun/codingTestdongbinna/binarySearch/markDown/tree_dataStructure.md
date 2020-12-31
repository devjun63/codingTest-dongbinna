#codingTest-dongbinna
(공부 내용 정리)
<br>출처 : 이것이 취업을 위한 코딩테스트다 with 파이썬

## 트리 자료구조

이진 탐색은 전제 조건이 데이터 정렬이다. 
예를 들어 동작하는 프로그램에서 데이터를 정렬해두는 경우가 많으므로 이진 탐색을 효과적으로 사용할 수 있다.
데이터베이스는 대용량 데이터 처리에 적합한 트리(*Tree*) 자료구조를 이용하여
항상 데이터가 정렬되어 있다. 
따라서 데이터베이스에서의 탐색은 이진 탐색과는 조금 다르지만, 
이진 탐색과 유사한 방법을 이용해 탐색을 항상 빠르게 수행하도록 설계되어 있어서
데이터가 많아도 탐색하는 속도가 빠르다. <br>

그렇다면 트리 자료구조가 무엇인가?
트리 자료구조는 노드와 노드의 연결로 표현하며
여기서는 노드는 정보의 단위로서 어떠한 정보를 가지고 있는 개체로 이해할 수 있다.
트리 자료구조는 그래프 자료구조의 일종으로 데이터베이스 시스템이나 파일 시스템과
같은 곳에서 많은 양의 데이터를 관리하기 위한 목적으로 사용한다.

---
### 트리 구조의 특징

* 트리는 부모 노드와 자식 노드의 관계로 표현한다.
* 트리와 최상단 노드를 루트 노드라고 한다.
* 트리의 최하단 노드를 단말 노드라고 한다.
* 트리에서 일부를 떼어내도 트리 구조이며 이를 서브 트리라고 한다.
* 트리는 파일 시스템과 같이 계층적이고 정렬된 데이터를 다루기에 적합하다.

정리하면 큰 데이터를 처리하는 소프트웨어는 대부분 데이터를 트리 자료구조로 저장해서
이진 탐색과 같은 탐색 기법을 이용해 빠르게 탐색이 가능하다.
