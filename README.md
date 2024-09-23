![Play Framework][play_framework]
![Project licence][licence]

# Play Framework Web Development For Beginners

## [Tutorial on Play Framework from Stefan Trifunovic (Udemy)](https://www.udemy.com/course/play-framework2)

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

[licence]: https://img.shields.io/github/license/artshishkin/art-trifunovic-play-framework.svg

[play_framework]: https://img.shields.io/static/v1?label=&message=Play%20Framework&labelColor=white&color=white&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAjCAYAAACU9ioYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAEnQAABJ0Ad5mH3gAAAOwSURBVEhLlZXZTxNRFMbnH0FBjT64JL7ogyLQokZBxBg17uK+Iy6YuILbg7gEULAoAauC0URDNFE0qFFjRIiKqEgXSrHSIotgsVAQP++5vRTGWWq/5AvNzHw/ztxz7h0JQm2+Brz8no1y90G8ay+B/7dP3AlPHGj98QwmiwFFLiMK7LG41hKPUvtq9PT/5A+FI6m91wFTfRwu1ccg+300cmqi+d8ilwF3Han4gwHx6P9Jetx0CkVfDUHYcBd/M4LuhyPplnUTTNZYBYyc+4EqNaLSXSweDy3pZXMerjYbVSskX/g4A1ca41DXXi4i+pJ8/R0orE9kTWFVqkHZtfy6GN40l7dGxLTFu9zYVclf++KnGUogM1VvssWiyJqEzt5vPKil4BxWt5Tw9cph66YFpVcvsa1iM9otUkoFgaSHzkwUM6jWetJ1mogyxx6RUEoG7B/wo9SawivRgpJpnCq+nhYpuWRAUmevC4WWubik1STmwDgZUOW5LlJDUgBJjq5XfAtqNYlM9y43xMHS8USkAlIFkt54zHw91WDcrPr8LzEosMTD3f1JpHSApAfOI7zzek0qoHGyJOOn38MzusD+gR6U2lbzkBqQTNBCpwE3WTOpqbpAkqOjijcot1YdSCao2ROP9623QwO9Xi+O34/VrZJMTbxjTw0N/N7qwYrMCbyrNC5qMDK99kNnRmjg1bKzSNgeiczyKchjh4QajE4kAjb/qtUHVn6owLzUKBhTIrD98kS2lkpg8Mz0BM5MTWCT24pFeycgcUck4tdGYMWJccj7rATSNnziyhIpDaDX14X1GTFI2hWFOVtGYtaGEVi4fzTv5mC36TdVdq8xXaQCUgUeyF6O+btHcRh59sYRmJ8WhXNV0/h6Dc7eLfsG9LFZHS4F8OLNw0jeMwQbBFK1Z99MYxUG9rDZugjdfW0iNSQZsOxpMa9s7tYh2CCQ/sn56ul83ug0avXZRUquIPDt5+dI3BmJhG2RMhh55voILD40hn+7TdY4OLuqRUopDnS1NGBJ+iQO/BdGNq6JwMac8TC7jajr0P/6Sf6+Hmw6Zgx2VM00NicqpqKms0TEtCXdrSjEgn3yJgw3rd+yzLF4ZD8jIvqSDuWu5LtBDUZOYuOSdWOLeDy0pHPmvbKZC3rzSHY9CmlZyej1y2dNT5Kt6SOvkA6A4UBa03VHo9HpVc6anniXH7wo5QAygWnmlu6fzPazjT8UjoJzWGt5jYz8FGw+yb4hN9LR0uYSd8IR8BfKO9uyHINpnAAAAABJRU5ErkJggg==

