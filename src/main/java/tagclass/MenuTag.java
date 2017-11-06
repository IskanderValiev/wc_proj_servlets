package tagclass;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.*;

public class MenuTag extends SimpleTagSupport {
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print("<div id=\"header\">\n" +
                "          <div id=\"menu\">\n" +
                "              <ul class=\"menu\">\n" +
                "                  <li><a href=\"/worldcup/homepage.jsp\">Homepage</a></li>\n" +
                "                  <li><a href=\"/worldcup/matches.jsp\">Matches</a>\n" +
                "                      <ul>\n" +
                "                          <li><a href=\"#\">Group A</a></li>\n" +
                "                          <li><a href=\"#\">Group B</a></li>\n" +
                "                          <li><a href=\"#\">Group C</a></li>\n" +
                "                          <li><a href=\"#\">Group D</a></li>\n" +
                "                          <li><a href=\"#\">Group E</a></li>\n" +
                "                          <li><a href=\"#\">Group F</a></li>\n" +
                "                          <li><a href=\"#\">Group G</a></li>\n" +
                "                          <li><a href=\"#\">Group H</a></li>\n" +
                "                      </ul>\n" +
                "                  </li>\n" +
                "                  <li><a href=\"/worldcup/cities.jsp\">Cities</a>\n" +
                "                      <ul>\n" +
                "                          <li><a href=\"#\">Kazan</a></li>\n" +
                "                          <li><a href=\"#\">Moscow</a></li>\n" +
                "                          <li><a href=\"#\">St. Petersburg</a></li>\n" +
                "                          <li><a href=\"#\">Sochi</a></li>\n" +
                "                          <li><a href=\"#\">Kaliningrad</a></li>\n" +
                "                          <li><a href=\"#\">Saransk</a></li>\n" +
                "                          <li><a href=\"#\">Nizhniy Novgorod</a></li>\n" +
                "                          <li><a href=\"#\">Rostov-On-Don</a></li>\n" +
                "                          <li><a href=\"#\">Volgograd</a></li>\n" +
                "                          <li><a href=\"#\">Ekaterinburg</a></li>\n" +
                "                          <li><a href=\"#\">Samara</a></li>\n" +
                "                      </ul>\n" +
                "                  </li>\n" +
                "                  <li><a href=\"#\">Stadiums</a></li>\n" +
                "                  <li><a href=\"/teams\">Teams</a></li>\n" +
                "                  <li><a href=\"/worldcup/galary.jsp\">Galary</a></li>\n" +
                "                  <li><a href=\"/worldcup/contact.jsp\">Contacts</a></li>\n" +
                "              </ul>\n" +
                "          </div>\n" +
                "          <div id=\"profile-menu\">\n" +
                "              <ul class=\"profile-menu\">\n" +
                "                  <li><a href=\"/profile\">Profile</a></li>\n" +
                "                  <li><a href=\"/exit\">Exit</a></li>\n" +
                "              </ul>\n" +
                "          </div>\n" +
                "      </div>");
    }
}
