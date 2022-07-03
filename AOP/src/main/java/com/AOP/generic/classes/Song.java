package com.AOP.generic.classes;

public class Song {

    /*
        Aspect Oriented Programming :
            The Aspect Oriented Programming (AOP) is another approach of thinking about the Program structure. The key
            unit of modularity in OOP is class, whereas in AP{ the unit of modularity is the aspect.

        What is Aspect :
            The literal meaning : A particular part or feature of something.
            An aspect is simply a piece of code that is executed when we call specific methods inside our application.
            An aspect is a common feature that's typically scattered across methods, classes, object hierarchies, or
            even entire object models.

        In AOP, aspects enable modularization of concerns such as transaction management, logging or security that cut
        across multiple types and objects (often termed crosscutting concerns).

        AOP provides the way to dynamically add the crosscutting concerns before, after or around the actual logic
        using simple pluggable configurations.

        AOP helps in separating and maintaining many non-business logics related to logging, security etc. In this way
        we can add additional behaviour to existing code without changing the code itself.
     */

    private final String name;
    private final String artist;

    public Song(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }
}
