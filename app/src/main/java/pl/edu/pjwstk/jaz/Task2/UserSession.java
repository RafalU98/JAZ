package pl.edu.pjwstk.jaz.Zadanie2;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

// session = stan w czasie (pomiędzy requestami) który się zaczyna i po wyłączeniu sesji kończy np. 15min
// po to aby przechować informacje o tym czy użytkownik jest uwierzetylniony dla tej "sesji"

// proxymode = wstrzykiwanie do filtra działa jednorazowo i przez to że potrzebujemy
// żeby sie tworzył za każdym razem i do tego jest proxyMode,
// wstrzykiwanie pomiędzy kontextami - proxymode
// wstrykiwanie przez requesty - nie trzeba proxymode
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component  // częśc kontenera bez tego by nie dało się wstrzyknąć obiektu
public class UserSession {

    private boolean isLogged = false;

    public void logIn() {
        // ustawia że true

    }

    public boolean isLoggedin() {
        return isLogged;
    }
    //tutaj jakas zmienna informacja
    // która pozwoli okreslic czy uzytkownik jest zalogowany

    //metody do zarzadzania
}
