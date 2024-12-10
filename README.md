# 🌉 다리 건너기
## 3 - 20 개의 다리를 만들어서 플레이어가 다리 끝까지 건너는 게임

# 🗒️ 미션 요구사항

### 다리 만들기
- [X] 다리 길이 입력받기
  - 3~20 사이의 숫자
  - 공백 불가
  - 그 외 숫자 불가
  - 글자 불가

- [X] 랜덤한 값으로 다리 만들기
  - `bridge.BridgeRandomNumberGenerator` 의 `generate()` 사용해 랜덤 값 추출
  - `0`일 경우 아래 칸에서 건널 수 있음
  - `1`일 경우 위 칸에서 건널 수 있음

### 다리 건너기
- [X] 플레이어가 이동할 칸을 입력받기
  - U(위 칸)
  - D(아래 칸)
  - 그 외 입력 불가

- [X] 다리 건너기
  - 이동한 칸을 건널 수 있다면 O로 표시
  - 이동한 칸을 건널 수 없다면 X로 표시

### 게임 재시작
- [X] 이동한 칸을 건널 수 없을 경우 재시작 여부를 받기(재시작해도 기존 다리 재사용)
  - R(Retry)
  - Q(Quit)
  - 그 외 입력 불가

### 게임 종료 
- [ ] 게임 종료 시 결과 출력
  ```kotlin
    최종 게임 결과
    [ O |   |   ]
    [   | O | O ]

    게임 성공 여부: 성공
    총 시도한 횟수: 2
    ```
  ```kotlin
    최종 게임 결과
    [ O |   ]
    [   | X ]

    게임 성공 여부: 실패
    총 시도한 횟수: 1
    ```

  - retry 카운트도 세기