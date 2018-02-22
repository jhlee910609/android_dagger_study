# DI(Dependency Injection)
- Dagger lib를 이해하기 위해 선행해야할 개념이 '의존성 주입'입니다. 
- 


### 0. DI의 장점
1. 목적에 따라 동작을 변경하기 쉬움
2. 생성한 객체를 쉽게 재사용 가능
3. 객체를 생성하거나 사용할 때 발생할 수 있는 실수 감소

### 1. DI의 개념
- [`Inversion of Control`](https://ko.wikipedia.org/wiki/%EC%A0%9C%EC%96%B4_%EB%B0%98%EC%A0%84)의 개념이 적용되어 있다.
- class 내부에서 다른 클래스를 인스턴스화할 때, 외부에서 받아오는 개념이다. 즉 어떤 클래스 내부에 `Object obj = new Object()` 코드가 없어진다고 보면 될 것 같다. 따라서 디커플링되며, 클래스간 종속성이 약해지며 고로 테스팅하기가 수월해지는 장점이 있다. 클래스 재사용성 또한 수월해진다. 
- Ideally Java classes should be as independent as possible from other Java classes. This increases the possibility of reusing these classes and to be able to test them independently from other classes.
- 클래스 간의 의존성을 낮춰 테스트 용이 및 유지 보수를 쉽게 할 수 있다.


### 2. Dagger2 (DI 라이브러리 in Android)
- 컴파일 시, DI를 수행하기 때문에 빌드가 완료되었다면 문제가 없다.

##### 2.1. Dagger 1.x
- `Runtime` 시, `Graph`를 구성하여 성능 저하가 사용 요청시 마다 발생하였다.
- `Reflection` :  generated code를 따르기 어렵게 만들고 ProGuard 설정이 용이하지 못했다.
- 보기 힘든 `generated code` : 특히, `Factory`에서 비슷하게 직접 작성한 것과 비교하였을 경우.
- 런타임에 수행되어 예기치 못한 크래쉬가 발생할 수 있따. 

##### 2.2. Dagger 2.x


### 3. Dagger2 필수 개념
![](http://cfile9.uf.tistory.com/image/2539C038564196F439BD76)
##### 3.1. Module
- 필요한 객체 제공하는 역할을 하며, 클래스 단위로 구성되어 있음
```
@Module
class BugerModule {


}
```


##### 3.2. Component

##### 3.3. 













###### 5. 참고할만한 개념
- java reflectioin
- JSR330
- 





