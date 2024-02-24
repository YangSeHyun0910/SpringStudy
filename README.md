##1. git init  #.git 파일을 생성한다.

##2. git remote add origin 레파짓주소(https://github.com/YangSeHyun0910/SpringStudy.git) #origin이라는 이름에 레자핏주소를 저장한다. origin = 변수 개념

##3. git branch -M main #main이라는 브런치 생성

##4. git config --global user.name "Your Name"

##5. git config --global user.email you@example.com

##6. git add . #모든 파일을 선택하는 느낌

##7. git commit -m "커밋설명" # 4번 에서 모든 파일을 선택하고, 그 중에 변경된 사항이 있는 파일들만 커밋한다. 커밋설명을 남길 수 잇다

##8. git push origin main #origin(변수. 저장되어있는 레파짓주소에) main 브런치에 5번 커밋내용을 푸시한다.


##// 잘못 작성한 파일을 가장 최신 버전으로 초기화 시킨다.

##git checkout -- 파일위치 ex) src/test(폴더명)/Test.java(파일명)
