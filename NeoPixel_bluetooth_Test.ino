#include <Adafruit_NeoPixel.h>
#include <SoftwareSerial.h>

#define PIN 5
#define LEDNUM 12

Adafruit_NeoPixel pixels = Adafruit_NeoPixel(LEDNUM, PIN, NEO_GRB + NEO_KHZ800);
SoftwareSerial bluetooth(2,3);                        // RX = 2(모듈은TX), TX = 3(모듈은RX) 

void setup()
{
  pixels.begin();                                     // 네오픽셀 사용설정
  for(int i=0;i<LEDNUM;i++) 
  {
    pixels.setPixelColor(i, pixels.Color(0,0,0));     // 네오픽셀 초기설정
  }
  pixels.show();                                      // 네오픽셀 설정사용
  Serial.begin(9600);
  bluetooth.begin(9600);                              // 블루투스 사용설정, 통신속도 9600
}

byte r=0, g=0, b=0;
void loop()
{
   if(bluetooth.available() == 3)                     // 블루투스 데이터 3개 수신받았을 때
   {
     r = bluetooth.read();                            // 첫번째 데이터를 r에 저장 (빨간색)
     g = bluetooth.read();                            // 두번쨰 데이터를 g에 저장 (초록색)
     b = bluetooth.read();                            // 세번쨰 데이터를 b에 저장 (파란색)
     Serial.println(r);
     Serial.println(g);
     Serial.println(b);    
     bluetooth.flush();                               // 통신내용 초기화
     for(int i=0;i<LEDNUM;i++)
     {
      pixels.setPixelColor(i, pixels.Color(r,g,b));   // 수신받은 데이터를 토대로 색상설정
     }
    pixels.show();                                    // 네오픽셀에 적용
   }
 
}
