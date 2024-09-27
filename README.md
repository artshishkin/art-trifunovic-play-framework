![Play Framework][play_framework]
![Project licence][licence]

# Play Framework Web Development For Beginners

## [Tutorial on Play Framework from Stefan Trifunovic (Udemy)](https://www.udemy.com/course/play-framework2)

---

### Section 1: Introduction

---

### Section 2: Getting Ready

---

### Section 3: My First WebApp

#### 6. Create Play Project from Template

- `sbt new playframework/play-java-seed.g8`

#### 7. Import Play Project in IntelliJ

- install Scala plugin
- import project/module
- start app: `sbt run`
- verify app is running: http://localhost:9000

#### 10. How To Debug?

- `sbt -jvm-debug 9999 run` - debug on port 9999
- Add Configuration:
    - Remote JVM Debug
    - Name: `debug-first-app`
    - Port: 9999
    - Use module classpath: `01-my-first-web-app`
    - Apply, Ok
- Run `debug-first-app` configuration
- Set breakpoint to `controllers.HomeController.index()`
- Visit http://localhost:9000
- App should be paused in the breakpoint

#### 11. Navigate From Error Page Into Source Code

Error Navigation

1. Option 1
    - Open application.conf -> add play.editor="http://localhost:63342/api/file/?file=%s&line=%s"
    - Note: (For me not working! But there is an alternative)
2. Option 2
    - Open build.sbt ->
    - fork := true // required for "sbt run" to pick up javaOptions
    - javaOptions += "-Dplay.editor=http://localhost:63342/api/file/?file=%s&line=%s"

---

### Section 4: SBT Basics

---

### Section 5: Twirl Templates

---

### Section 6: Forms

---

### Section 7: Database

#### 24. Configure h2

1. Configure connection in [application.conf](01-my-first-web-app/conf/application.conf)
2. Start h2 console:
    - in the module folder run bash command
    - `sbt`
    - `h2-browser`
    - default browser should be opened automatically with the `h2-console`
    - check and update `JDBC URL:`, `User Name:`
    - enter password
    - press `Test connection`
    - in case of error:
        - similar
          to `Database "C:/Users/.../01-my-first-web-app/db_file" not found, either pre-create it or allow remote database creation (not recommended in secure environments) [90149-232] 90149/90149 `
        - follow step 3
    - if `Test connection` is successful press `Connect`
3. Pre-create database file (Optional - in case of failure in step 2)
    - into the module/project folder copy
      - h2 jar file from local Maven repository  
        - Ex.: from `~/.m2/repository/com/h2database/h2/2.2.224/h2-2.2.224.jar`
      - **or** 
      - download JAR from the [official website](https://www.h2database.com/html/download.html)
    - in the terminal run command `java -cp .\h2-2.3.232.jar org.h2.tools.Shell` (modify according to your version)
    - provide URL: `jdbc:h2:./db_file` (it will create file `db_file.db.mv` in the current directory)
    - enter Name, the desired Password and the password confirmation
    - it will open sql cli
    - file `db_file.db.mv` will be created in the current directory
    - exit
    - follow the Step 2

[licence]: https://img.shields.io/github/license/artshishkin/art-trifunovic-play-framework.svg

[play_framework]: https://img.shields.io/static/v1?label=&message=Play%20Framework&labelColor=white&color=white&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAjCAYAAACU9ioYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAEnQAABJ0Ad5mH3gAAAOwSURBVEhLlZXZTxNRFMbnH0FBjT64JL7ogyLQokZBxBg17uK+Iy6YuILbg7gEULAoAauC0URDNFE0qFFjRIiKqEgXSrHSIotgsVAQP++5vRTGWWq/5AvNzHw/ztxz7h0JQm2+Brz8no1y90G8ay+B/7dP3AlPHGj98QwmiwFFLiMK7LG41hKPUvtq9PT/5A+FI6m91wFTfRwu1ccg+300cmqi+d8ilwF3Han4gwHx6P9Jetx0CkVfDUHYcBd/M4LuhyPplnUTTNZYBYyc+4EqNaLSXSweDy3pZXMerjYbVSskX/g4A1ca41DXXi4i+pJ8/R0orE9kTWFVqkHZtfy6GN40l7dGxLTFu9zYVclf++KnGUogM1VvssWiyJqEzt5vPKil4BxWt5Tw9cph66YFpVcvsa1iM9otUkoFgaSHzkwUM6jWetJ1mogyxx6RUEoG7B/wo9SawivRgpJpnCq+nhYpuWRAUmevC4WWubik1STmwDgZUOW5LlJDUgBJjq5XfAtqNYlM9y43xMHS8USkAlIFkt54zHw91WDcrPr8LzEosMTD3f1JpHSApAfOI7zzek0qoHGyJOOn38MzusD+gR6U2lbzkBqQTNBCpwE3WTOpqbpAkqOjijcot1YdSCao2ROP9623QwO9Xi+O34/VrZJMTbxjTw0N/N7qwYrMCbyrNC5qMDK99kNnRmjg1bKzSNgeiczyKchjh4QajE4kAjb/qtUHVn6owLzUKBhTIrD98kS2lkpg8Mz0BM5MTWCT24pFeycgcUck4tdGYMWJccj7rATSNnziyhIpDaDX14X1GTFI2hWFOVtGYtaGEVi4fzTv5mC36TdVdq8xXaQCUgUeyF6O+btHcRh59sYRmJ8WhXNV0/h6Dc7eLfsG9LFZHS4F8OLNw0jeMwQbBFK1Z99MYxUG9rDZugjdfW0iNSQZsOxpMa9s7tYh2CCQ/sn56ul83ug0avXZRUquIPDt5+dI3BmJhG2RMhh55voILD40hn+7TdY4OLuqRUopDnS1NGBJ+iQO/BdGNq6JwMac8TC7jajr0P/6Sf6+Hmw6Zgx2VM00NicqpqKms0TEtCXdrSjEgn3yJgw3rd+yzLF4ZD8jIvqSDuWu5LtBDUZOYuOSdWOLeDy0pHPmvbKZC3rzSHY9CmlZyej1y2dNT5Kt6SOvkA6A4UBa03VHo9HpVc6anniXH7wo5QAygWnmlu6fzPazjT8UjoJzWGt5jYz8FGw+yb4hN9LR0uYSd8IR8BfKO9uyHINpnAAAAABJRU5ErkJggg==

