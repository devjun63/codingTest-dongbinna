#codingTest-dongbinna
(공부 내용 정리)
<br>출처 : 이것이 취업을 위한 코딩테스트다 with 파이썬

### 자바 내장 정렬 라이브러리
####종류 
- Arrays.sort()
- Collections.sort()
- Collections.reverse()
---
Arrays.sort()<br>
Primitive Type & Object Type의 Array 정렬시 사용<br>

---
Collections.sort()<br>
Collection의 List를 정렬할 때 사용<br>
Collections.reverse()는 내림차순이 아닌, 리스트의 구성을 반대로 뒤집는 것이다.
---
Arrays.sort() & Collections.sort() 공통사항<br>
Comparator를 통한 Customize Sort 지원<br>
오름차순 정렬<br>
인자로서 Array or List 넣으면 인자로 넘겨진 객체의 내용 자체가 바뀜<br>
static method이므로 Arrays나 Collections 객체를 생성하는 것이 아니라 바로 호출한다.
---

- Primitive Type - Dual-pivot quick sort <br>
시간 복잡도 : O(N^2)
- Reference Type - tim sort (Insertion Sort + Merge Sort) <br>
시간 복잡도 : O(NlogN)


### 참고 자료
https://defacto-standard.tistory.com/18