package pl.edu.pjwstk.jaz.Zadanie2;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class UserSession {
    public boolean isLoggedin() {
        return false;
    }
    //tutaj jakas zmienna informacja
    // która pozwoli okreslic czy uzytkownik jest zalogowany

    //metody do zarzadzania
}
