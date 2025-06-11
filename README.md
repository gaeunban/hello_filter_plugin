# hello_plugin

## 1) 소개
플러그인의 구조를 확인하기 위해 만들어본 단어 뒤에 hello 를 붙이는 플러그인이다.  
elasticsearch는 8.13.0 버전으로 만들어졌다.  

- elasticsearch : 8.13.0  
- java : 19.0.2  
- gradle : 8.10.2

#### plugin 구조  
1) hello_filter (filter)  
   ex) world -> world hello


## 2) Build 및 설치
#### 1. build 하고 플러그인 zip파일 생성하기
1.1 build 진행
```
./gradlew clean buildPluginZip
```
\hello_plugin\lib\build\distributions\hello_plugin-8.13.0.zip 경로로 zip파일 생성  

- zip 파일 구조  
![화면 캡처 2025-06-11 113814](https://github.com/user-attachments/assets/ef341540-b6d2-4664-8a5a-7849eef46b3a)  
! plugin-descriptor.properties를 읽고 plugin이 설치된다.
<br />

1.2 build 취소
```
.\gradlew build clean
```

#### 2. elasticsearch plugin 설치하기
2-1. 서버에 zip파일 넣고 install 하기.
```
elasticsearch-8.13.0/bin/elasticsearch-plugin install file:경로h/hello_plugin-8.13.0.zip
```
<br />

2-2. elasticsearch 재기동
플러그인 설치 후 재기동해줘야 사용할 수 있다.

#### 3) filter 사용하기
3.1 /_analyzer 실행하기  
![화면 캡처 2025-06-11 114851](https://github.com/user-attachments/assets/86a5845e-25e4-4afd-8d20-f8dc7995252b)  

3.2 result  
![화면 캡처 2025-06-11 114901](https://github.com/user-attachments/assets/5794ad59-c901-4608-af95-f772c73f6d71)  

