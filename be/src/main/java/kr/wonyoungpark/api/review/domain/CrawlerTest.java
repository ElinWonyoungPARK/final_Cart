package kr.wonyoungpark.api.review.domain;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class CrawlerTest {
    public static void main(String[] args) {
        String FILE_PATH = "C:\\Users\\User\\WonyoungCode\\finalProject\\be\\src\\main\\resources";
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        String reviewURL = "https://search.naver.com/";
        List<Reviewer> reviews = new ArrayList<>();
        Crawler crawler = new Crawler();

        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=14449717&qvt=0&query=팀랩%3A%20라이프%20(teamLab%3A%20LIFE)%20평점","1"); //팀랩
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=16084077&qvt=0&query=앙리%20마티스%20탄생%20150주년%20기념%20<마티스%20특별전%20%3A%20재즈와%20연극>%20평점","2");      //앙리마티스
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=16918427&qvt=0&query=신의%20예술가%2C%20미켈란젤로%20특별전%20평점","3"); //신의 예술가, 미켈란젤로 특별전 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=16938253&qvt=0&query=무민%20오리지널%20%3A%20무민%2075주년%20특별%20원화전%20평점","4");      //무민 오리지널 : 무민 75주년 특별 원화전
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=16889135&qvt=0&query=추상을%20말해요%2C%20칸딘스키%20평점","5");    //추상을 말해요, 칸딘스키 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=6231399&qvt=0&query=모네%20향기를%20만나다%20평점","6");      //모네 향기를 만나다 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=17979315&qvt=0&query=여행갈까요%20평점","7"); //여행갈까요 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=14334447&qvt=0&query=유미의%20세포들%20특별전%20평점","8");      //유미의 세포들 특별전 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=16934373&qvt=0&query=라스트%20북스토어%20평점","9");       //라스트 북스토어
    	crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=16968052&qvt=0&query=뮤지엄%20오브%20컬러%20평점","10");     //뮤지엄 오브 컬러 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=14337045&qvt=0&query=수퍼%20네이처%20평점","11");      //수퍼 네이처 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=14447334&qvt=0&query=파랑새%20평점","12");     //파랑새
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=17939172&qvt=0&query=도톨%20%3A%20눈부신%20계절%20따스한%20순간%20평점","13");      //도톨 : 눈부신 계절 따스한 순간 평점
    	crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=17961174&qvt=0&query=신경균%20%3A%20Moonlight%20평점","14");   //신경균 : Moonlight 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=17933969&qvt=0&query=필립%20콜버트%20%3A%20넥스트%20아트%20팝%20아트와%20미디어%20아트로의%20예술여행%20평점","15");      //필립 콜버트 : 넥스트 아트 팝 아트와 미디어 아트로의 예술여행 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=17927804&qvt=0&query=STREET%20NOISE%20평점","16");     //STREET NOISE 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=17784552&qvt=0&query=헤르난%20바스%20%3A%20모험%2C%20나의%20선택%20평점","17");      //헤르난 바스 : 모험, 나의 선택 평점
    	crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=17170563&qvt=0&query=아세안%20거리음식%20%3A%20호로록%20찹찹%20오물오물%20평점","18");     //아세안 거리음식 : 호로록 찹찹 오물오물
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=18090901&qvt=0&query=하정우%20%3A%20At%20Home%20평점","19");   //하정우 : At Home 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=17718248&qvt=0&query=ANDY%20WARHOL%20%3A%20BEGINNING%20SEOUL%20평점","20");      //ANDY WARHOL : BEGINNING SEOUL 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=16985509&qvt=0&query=2021%20딜라이트%20서울%20평점","21");      //2021 딜라이트 서울 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=16968052&qvt=0&query=뮤지엄%20오브%20컬러%20평점","22");     //뮤지엄 오브 컬러 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=16934373&qvt=0&query=라스트%20북스토어%20평점","23");     //라스트 북스토어 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=14405323&qvt=0&query=유에민쥔(岳敏君)%20한%20시대를%20웃다!%20평점","25"); //유에민쥔(岳敏君) 한 시대를 웃다! 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=14381336&qvt=0&query=스위트%20팝%20평점","25");    //스위트 팝 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=17743282&qvt=0&query=비너스의%20진화%20평점","26");     //비너스의진화
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=16928211&qvt=0&query=아이뮤지엄%20디지털명화%20%5B색채의%20마술사%20%3A%20앙리%20마티스%5D%20평점","27");     //아이뮤지엄 디지털명화 [색채의 마술사 : 앙리 마티스] 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=16970769&qvt=0&query=아이뮤지엄%20디지털전시%20<미디어%20포레스트>%20-%20여수%20평점","28");   //아이뮤지엄 디지털전시 <미디어 포레스트> - 여수 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=18058567&qvt=0&query=거울%20속의%20거울%20평점","29");      //거울 속의 거울 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=16936963&qvt=0&query=오프라인%20웹툰체험관%20평점","30");     //오프라인 웹툰체험관 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=14285241&qvt=0&query=이영란의%20감성체험%20가루나무모래흙%20서울%20평점","31");     //이영란의 감성체험 가루나무모래흙 서울 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=14287003&qvt=0&query=아이뮤지엄%20%5B로즈페탈%5D%20평점","32");      //아이뮤지엄 [로즈페탈] 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=9832872&qvt=0&query=헬로우%2C심쿵(hello%2C심쿵)展%20평점","33");     //헬로우,심쿵(hello,심쿵)展 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=14451387&qvt=0&query=뮤지엄%20오브%20일루전%20평점","34");      //뮤지엄 오브 일루전 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=14071658&qvt=0&query=빽투더래옹%20평점","35");     //빽투더래옹 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=8231998&qvt=0&query=푸룻푸룻동성로%20%3A%20푸룻토피아%20평점","36");     //푸룻푸룻동성로 : 푸룻토피아 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=13984115&qvt=0&query=그대%2C%20나의%20뮤즈%20%3A%20반%20고흐%20to%20마티스%20평점","37");     //그대, 나의 뮤즈 : 반 고흐 to 마티스 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=18101312&qvt=0&query=최랄라%20%3A%20FEEL%20LOST%20평점","38");     //최랄라 : FEEL LOST 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=18090905&qvt=0&query=봄의%20윤무%20Reigen%20평점","39");     //봄의 윤무 Reigen 평점
    	crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=18088161&qvt=0&query=아르코예술극장%20개관%2040주년%20기념%20전시%20<없는%20극장>%20평점","40");   //아르코예술극장 개관 40주년 기념 전시 <없는 극장> 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=17559630&qvt=0&query=그대%2C%20나의%20뮤즈%20평점","41");     //그대, 나의 뮤즈 평점
    	crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=14381168&qvt=0&query=미니언즈%20제주%20특별전%20평점","42");      //미니언즈 제주 특별전 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=18059025&qvt=0&query=The%20Secret%20Life%20평점","43");      //The Secret Life 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=18009395&qvt=0&query=박종규%20%3A%20~Kreuzen%20평점","44");      //박종규 : ~Kreuzen 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=16127540&qvt=0&query=Koo%20Jeong%20A%20%3A%202020%20평점","45");    //Koo Jeong A : 2020 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=13986378&qvt=0&query=신데렐라%20유니버스%20평점","46");      //신데렐라 유니버스 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=13986417&qvt=0&query=피카부(PEEK-A-BOO)%20평점","47");    //피카부(PEEK-A-BOO) 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=10483426&qvt=0&query=모빌을%20상상하다%20%3A%20알렉산더%20칼더전%20평점","48");     //모빌을 상상하다 : 알렉산더 칼더전 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=9385319&qvt=0&query=디어%20브레인%20평점","49");      //디어 브레인 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"search.naver?where=nexearch&sm=tab_etc&mra=bjBC&pkid=360&os=9728631&qvt=0&query=오즈의%20미술관%20평점","50");     //오즈의 미술관 평점
        crawler.placeAutoUrl(reviews, driver,reviewURL+"11134307","51");     //설악 흔들바위
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8693759","52");      //설악금호리조트
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"21054684","53");     //설악동야영장
        crawler.placeAutoUrl(reviews, driver,reviewURL+"17721245","54");     //설악레저스쿨
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8216362","55");      //설악산 권금성
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8036325","56");	     //설악산 울산바위
        crawler.placeAutoUrl(reviews, driver,reviewURL+"24414762","57");	 //설악산 자생식물원
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8375070","58");      //설악산 탐방안내소
        crawler.placeAutoUrl(reviews, driver,reviewURL+"7944159","59");	     //설악산가족호텔
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"21054684","60");     //설악산국립공원 자동차야영장
        crawler.placeAutoUrl(reviews, driver,reviewURL+"15147983","61");     //설악산국립공원(외설악)
        //예외처리(62)
        crawler.placeAutoUrl(reviews, driver,reviewURL+"26290244","63");     //설악산소공원
        crawler.placeAutoUrl(reviews, driver,reviewURL+"9168616","64");      //설악산파크리조트
        //예외처리(65)
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"10494265","66");     //설악파인리조트
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"7939479","67");      //설악프라자컨트리클럽
        crawler.placeAutoUrl(reviews, driver,reviewURL+"1327493089","68");   //설악힐호텔
        crawler.placeAutoUrl(reviews, driver,reviewURL+"7952590","69");      //속초 등대전망대
        crawler.placeAutoUrl(reviews, driver,reviewURL+"649182629","70");    //속초 바다낚시
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"8376588","71");      //설악해맞이공원
        crawler.placeAutoUrl(reviews, driver,reviewURL+"27351432","72");     //얼라이브 하트(Alive Heart)
        crawler.placeAutoUrl(reviews, driver,reviewURL+"12697671","73");     //엑스포타워
        crawler.placeAutoUrl(reviews, driver,reviewURL+"1970947390","74");   //외옹치 바다향기로
        //예외처리(75)
        //예외처리(76)
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8065637","77");      //속초 조양동 유적
        crawler.placeAutoUrl(reviews, driver,reviewURL+"19304774","78");     //속초 하도문쌈채 마을,
        crawler.placeAutoUrl(reviews, driver,reviewURL+"1970947390","79");   //외옹치 바다향기로
        crawler.placeAutoUrl(reviews, driver,reviewURL+"12797187","80");     //속초관광수산시장
        //예외처리(81)
        crawler.placeAutoUrl(reviews, driver,reviewURL+"7952759","82");      //속초문화원
        crawler.placeAutoUrl(reviews, driver,reviewURL+"10543534","83");     //속초문화회관
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"374570243","84");    //속초비치호스텔
        crawler.placeAutoUrl(reviews, driver,reviewURL+"24751102","85");     //속초스파랜드
        crawler.placeAutoUrl(reviews, driver,reviewURL+"9158247","86");      //속초시립박물관
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"371169740","88");    //속초엑스포유람선
        //예외처리(89)
        //예외처리(90)
        crawler.placeAutoUrl(reviews, driver,reviewURL+"7958898","91");      //속초항
        crawler.placeAutoUrl(reviews, driver,reviewURL+"22099937","92");     //속초해변
        //예외처리(93)
        crawler.placeAutoUrl(reviews, driver,reviewURL+"1311816688","94");   //속초휘테
        crawler.placeAutoUrl(reviews, driver,reviewURL+"19947943","95");     //솔밭가든막국수
        crawler.placeAutoUrl(reviews, driver,reviewURL+"11126744","96");     //송월파크
        crawler.placeAutoUrl(reviews, driver,reviewURL+"797562421","97");    //스머프하우스
        crawler.placeAutoUrl(reviews, driver,reviewURL+"10543253","98");     //시골이모순두부
        crawler.placeAutoUrl(reviews, driver,reviewURL+"10532834","99");     //시골할머니
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"11435044","100");    //시나브로 모텔
        crawler.placeAutoUrl(reviews, driver,reviewURL+"1098447501","101");  //신다신식당
        crawler.placeAutoUrl(reviews, driver,reviewURL+"1098447501","102");  //신다신식당
        crawler.placeAutoUrl(reviews, driver,reviewURL+"7993485","103"); 	 //아남프라자
        crawler.placeAutoUrl(reviews, driver,reviewURL+"11495403","104");    //아바이마을 갯배
        crawler.placeAutoUrl(reviews, driver,reviewURL+"11951680","105");    //아바이마을
        crawler.placeAutoUrl(reviews, driver,reviewURL+"19624242","106");    //아이리스9
        crawler.placeAutoUrl(reviews, driver,reviewURL+"978709031","107");   //양반댁함흥냉면
        crawler.placeAutoUrl(reviews, driver,reviewURL+"7994126","108");     //에이스모텔
        crawler.placeAutoUrl(reviews, driver,reviewURL+"24857116","109");    //연호리조트
        crawler.placeAutoUrl(reviews, driver,reviewURL+"7999903","110");     //영금정
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"8011765","111");     //영랑호 화랑도 체험관광단지
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8008145","112");     //영랑호
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"10650417","113");    //영랑호리조트
        crawler.placeAutoUrl(reviews, driver,reviewURL+"24451703","114");    //옛고을순두부
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"10633799","115");    //오대양횟집
        crawler.placeAutoUrl(reviews, driver,reviewURL+"9267011","116");     //옥돌할머니순두부
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"9293198","117");     //왕건횟집
        crawler.placeAutoUrl(reviews, driver,reviewURL+"632257610","118");   //외옹치마을
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"8021355","119");     //외옹치항
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8016468","120");     //외옹치해변
        crawler.placeAutoUrl(reviews, driver,reviewURL+"9366982","121");     //위너스모텔
        crawler.placeAutoUrl(reviews, driver,reviewURL+"1131080213","122");  //위드유
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"10688023","123");    //육담폭포
        crawler.placeAutoUrl(reviews, driver,reviewURL+"24267521","124");    //일출봉횟집
        crawler.placeAutoUrl(reviews, driver,reviewURL+"13606733","125");    //장사마을
        //에외처리(126)
        crawler.placeAutoUrl(reviews, driver,reviewURL+"10737561","127");    //장사항
        crawler.placeAutoUrl(reviews, driver,reviewURL+"11441632","128");    //장원파크텔
        crawler.placeAutoUrl(reviews, driver,reviewURL+"21345651","129");    //재래식할머니순두부
        //예외처리(130)
        crawler.placeAutoUrl(reviews, driver,reviewURL+"11170136","131");    //전주속풀이해장국
        crawler.placeAutoUrl(reviews, driver,reviewURL+"13320662","132");	  //점봉산산채
        crawler.placeAutoUrl(reviews, driver,reviewURL+"9395122","133");     //조광모텔
        crawler.placeAutoUrl(reviews, driver,reviewURL+"18682831","134");    //족욕공원
        //에외처리(135)
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8086528","136");  	  //진미횟집
        crawler.placeAutoUrl(reviews, driver,reviewURL+"10763109","137");    //진솔할머니순두부
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8086427","138");     //진양횟집
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8092408","139");     //척산온천장
        //예외처리(140)
        crawler.placeAutoUrl(reviews, driver,reviewURL+"12924037","141");    //척산온천휴양촌
        crawler.placeAutoUrl(reviews, driver,reviewURL+"18682831","142");    //척산족욕공원
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"10762824","143");    //천당폭포
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"8091417","144");     //천불동계곡
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"8088618","145");     //청대산
        crawler.placeAutoUrl(reviews, driver,reviewURL+"16106479","146");    //청초비치 모텔
        crawler.placeAutoUrl(reviews, driver,reviewURL+"26602585","147");    //청초수물회
        //예외처리(148)
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8105816","149");	 //청초호
        crawler.placeAutoUrl(reviews, driver,reviewURL+"11247110","150");    //청호해변
        crawler.placeAutoUrl(reviews, driver,reviewURL+"27158330","151");    //청호활어회센터
        crawler.placeAutoUrl(reviews, driver,reviewURL+"10842950","152");    //초당할머니집
        crawler.placeAutoUrl(reviews, driver,reviewURL+"125251387","153");   //초원리조텔
        crawler.placeAutoUrl(reviews, driver,reviewURL+"9511628","154");     //최옥란할머니순두부
        crawler.placeAutoUrl(reviews, driver,reviewURL+"11755111","155");    //카페뮤토
        crawler.placeAutoUrl(reviews, driver,reviewURL+"10493578","156");    //켄싱턴호텔 설악
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8102174","157");     //코리아횟집
        crawler.placeAutoUrl(reviews, driver,reviewURL+"10901906","158");    //텔콘채록지
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"25035970","159");    //토왕성폭포
        crawler.placeAutoUrl(reviews, driver,reviewURL+"11620926","160");    //평강막국수
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8133251","161");     //학무정
        crawler.placeAutoUrl(reviews, driver,reviewURL+"12706186","162");    //학사평 콩꽃마을 순두부촌
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"21510540","163");    //한송정가든
        crawler.placeAutoUrl(reviews, driver,reviewURL+"10482115","164");    //한화리조트 설악 워터피아
        crawler.placeAutoUrl(reviews, driver,reviewURL+"27025531","165");    //한화리조트 설악
        crawler.placeAutoUrl(reviews, driver,reviewURL+"8149034","166");     //해림모텔
        crawler.placeAutoUrl(reviews, driver,reviewURL+"10923704","167");    //해맞이모텔
        crawler.placeAutoUrl(reviews, driver,reviewURL+"26564223","168");    //해파랑길 45코스
        crawler.placeAutoUrl(reviews, driver,reviewURL+"27491575","169");    //해피하우스
        crawler.placeAutoUrl(reviews, driver,reviewURL+"9641200","170");     //헬리오스모텔
        crawler.placeAutoUrl(reviews, driver,reviewURL+"17101514","171");    //현대수리조트
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"761418386","172");   //호텔 느낌
        crawler.placeAutoUrl(reviews, driver,reviewURL+"12868448","173");    //호텔 마레몬스
        crawler.placeAutoUrl(reviews, driver,reviewURL+"25815063","174");    //호텔 아마란스
//양식x	crawler.placeAutoUrl(reviews, driver,reviewURL+"8011765","175");     //화랑도체험관광단지
        crawler.placeAutoUrl(reviews, driver,reviewURL+"345442586","176");   //화이트스테이션 호스텔
        crawler.placeAutoUrl(reviews, driver,reviewURL+"11203702","177");	 //황두막

        MakeCsv.createCSV(reviews, "ReviewerList", FILE_PATH); //csv파일 생성
        driver.close();}
}

