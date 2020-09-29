package com.bigb.vassal.formuled.element;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */
public class Documentation extends BaseElement {
    public static final String NAME = MODULE + "Documentation";
    private static final String PREFIX = MODULE + "documentation.";

    @JacksonXmlProperty(localName = PREFIX + "AboutScreen")
    private final About about = new About("Splash.jpg", "About Module");

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = PREFIX + "BrowserHelpFile")
    private final List<Help> helpFiles = Arrays.asList(new Help("http://bggames01.blogspot.com/", "BGGames01"),
            new Help("http://bggames01.blogspot.com/2013/02/formula-de-module.html", "Get More Circuits"));

    private final class About extends MenuElement {
        @JacksonXmlProperty(isAttribute = true)
        private final String fileName;

        public About(String fileName, String title) {
            super(title);
            this.fileName = fileName;
        }
    }

    private final class Help extends MenuElement {
        @JacksonXmlProperty(isAttribute = true)
        private final String startingPage;

        public Help(String startingPage, String title) {
            super(title);
            this.startingPage = startingPage;
        }
    }
}
