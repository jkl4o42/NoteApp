package jkl4o4.noteapp.main.presentation

interface NavigationCommunication {

    interface Observe : Communication.Observe<NavigationStrategy>
    interface Mutate : Communication.Mutate<NavigationStrategy>
    interface Mutable : Observe, Mutate

    class Base : Communication.SingleUi<NavigationStrategy>(), Mutable
}