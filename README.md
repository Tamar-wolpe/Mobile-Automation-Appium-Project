# Mobile Automation Project - Appium & Java

פרויקט אוטומציה למובייל (Android) המבוסס על **Appium** ו-**Java**. 
הפרויקט נכתב כחלק ממטלת לימודים וכולל בדיקות אוטומטיות על אפליקציות מערכת של אנדרואיד (שעון והגדרות).

## 🚀 מה הפרויקט כולל?

הפרויקט מכיל שתי סוויטות בדיקה עיקריות:
1. **Clock App Test (`ClockTimerTest.java`)**:
   - פתיחת אפליקציית השעון.
   - מעבר לטאב טיימר.
   - הגדרת זמן (10 דקות).
   - הפעלת הטיימר ווידוא שהספירה לאחור עובדת לאחר 30 שניות.

2. **Settings App Test (`SettingsTest.java`)**:
   - פתיחת אפליקציית ההגדרות של המכשיר.
   - ביצוע גלילה (Scroll) עד למציאת תפריט "System".
   - ניווט לדף "About" ווידוא הגעה לדף הנכון באמצעות Assert.

## 🛠 טכנולוגיות בשימוש
- **Java** (JDK 11+)
- **Appium** (Java Client 9.3.0)
- **Selenium WebDriver** (4.23.0)
- **JUnit 5** (Jupiter) - להרצת הטסטים וניהול הבדיקות.
- **Maven** - לניהול תלויות (Dependencies).

## 📋 דרישות קדם (Prerequisites)
כדי להריץ את הפרויקט, ודאו שמותקנים אצלכם:
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (או כל IDE אחר תומך Java).
- [Appium Server](https://appium.io/docs/en/about-appium/getting-started/) רץ על פורט 4723.
- [Android Studio](https://developer.android.com/studio) עם אמולטור מוגדר.

## 🏃 פקודות להרצה
1. בצעו Clone לפרויקט:
   ```bash
   git clone [https://github.com/Tamar-wolpe/Mobile-Automation-Appium-Project.git](https://github.com/Tamar-wolpe/Mobile-Automation-Appium-Project.git)
פתחו את הפרויקט ב-IntelliJ.

תנו ל-Maven לטעון את כל התלויות (Reload Maven Project).

הריצו את שרת האפיום.

הריצו את הטסטים מתוך תיקיית src/test/java.

⚙️ הגדרות Capabilities (Capabilities)
הפרויקט מוגדר כברירת מחדל עבור אמולטור בשם emulator-5554.
אם שם המכשיר או גרסת האנדרואיד שלכם שונים, יש לעדכן אותם בבלוק ה-@BeforeAll בתוך מחלקות הטסט:

Java
options.setDeviceName("שם_המכשיר_שלכם");
options.setPlatformVersion("גרסה");

נכתב על ידי תמר וולפא.
