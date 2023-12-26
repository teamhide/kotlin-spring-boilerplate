# Locly

locly is a location sharing service similar to Zenly

## Architecture overview
![architecture](./architecture.png)

## Stack
- Spring Boot
- Data JPA & QueryDSL
- MySQL & MongoDB
- Kafka

## Test

### Test all

`./gradlew testAll`

### Unit test

`./gradlew testUnit`

### E2E test

`./gradlew teste2e`

## Functional requirements

### User
- [x] 회원가입한다
- [x] 내 상태를 업데이트한다
  - [x] 온라인/오프라인/유령 모드 중 한가지로 업데이트한다
- [x] 다른 유저를 친구로 추가한다
  - [ ] 유저 당 최대 친구 수는 20명이다

### Location
- [x] 내 위치를 업데이트한다
  - [x] 위치 기록을 별도로 저장한다
- [x] 특정 친구의 위치를 조회한다
  - [x] 친구의 위치만 조회할 수 있다
  - [x] 유령 모드인 경우 조회할 수 없다
  - [ ] 반경 Xkm 이내의 친구만 조회한다
- [x] 모든 친구의 위치를 조회한다
  - [ ] 반경 X km에 위치한 친구만 조회한다
  - [ ] 유령 모드인 친구는 조회 대상에서 제외한다
- [x] 실시간으로 친구들의 위치를 조회한다
  - [ ] 반경 X km에 위치한 친구만 조회한다
  - [ ] 반경 X km에 위치하지 않던 친구라도 주기적으로 체크하여 위치 조회 대상에 포함시킨다
  - [ ] 유저가 지도에서 위치를 이동시키면 해당 위치를 기반으로 반경 X km에 위치한 친구를 다시 조회한다
- [ ] 내가 방문한 모든 장소를 이동경로 형태로 표시한다
